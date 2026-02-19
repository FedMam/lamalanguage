package com.oracle.truffle.lama.types;

import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.lama.error.LamaLanguageException;

public final class LamaList implements TruffleObject {
    private static final int CHUNK_SIZE = 16;

    // note: in a single chunk, elements lie in tail-to-head order
    private static class LamaListChunk {
        private final Object[] elements = new Object[CHUNK_SIZE];
        private int nElements;
        private final LamaListChunk next;

        public LamaListChunk(Object[] elements, int elementsArrayStartPos, int nElements, LamaListChunk next) {
            System.arraycopy(elements, elementsArrayStartPos, this.elements, 0, nElements);
            
            this.nElements = nElements;
            this.next = next;
        }
    }

    private final LamaListChunk head;
    private final int nHeadElements; // number of elements in head chunk (may be less than head.nElements
                                     // if this list is a prefix of another list)
    private final int size;

    private LamaList(LamaListChunk head, int nHeadElements, int size) {
        this.head = head;
        this.nHeadElements = nHeadElements;
        this.size = size;
    }

    public static LamaList nil() {
        return new LamaList(null, 0, 0);
    }

    // note: requires elements in tail-to-head order
    public static LamaList of(Object[] elements) {
        if (elements.length == 0)
            return nil();

        int nChunks = (elements.length + CHUNK_SIZE - 1) / CHUNK_SIZE;

        LamaListChunk chunkNode = null;
        for (int i = 0; i < nChunks; i++) {
            chunkNode = new LamaListChunk(elements,
                                         i * CHUNK_SIZE,
                                         Math.min(CHUNK_SIZE, elements.length - i * CHUNK_SIZE),
                                         chunkNode);
        }

        return new LamaList(chunkNode, chunkNode.nElements, elements.length);
    }

    public int getSize() {
        return size;
    }

    public boolean isNil() {
        return head == null;
    }

    // note: returns elements in reverse (head-to-tail) order, like in code
    public Object[] takeN(int n) {
        if (n == 0)
            return new Object[0];
        if (head == null)
            throw new LamaLanguageException("list is empty");

        Object[] elems = new Object[n];
        LamaListChunk currChunk = head;
        int currPos = nHeadElements - 1;
        for (int i = 0; i < n; i++) {
            elems[i] = currChunk.elements[currPos];
            currPos--;
            if (currPos < 0 && i < n - 1) {
                currPos = CHUNK_SIZE - 1;
                currChunk = currChunk.next;
                if (currChunk == null)
                    throw new LamaLanguageException("not enough elements in list (expected " + n + ")");
            }
        }

        return elems;
    }

    public Object[] toArray() {
        return takeN(size);
    }

    public LamaList dropN(int n) {
        if (n == 0)
            return this;
        if (n < nHeadElements)
            return new LamaList(head, nHeadElements - n, size - n);
        if (head == null)
            throw new LamaLanguageException("not enough elements in list (expected " + n + ")");
        
        LamaListChunk rightChunk = head.next;
        n -= nHeadElements;
        while (n >= CHUNK_SIZE) {
            if (rightChunk == null)
                throw new LamaLanguageException("not enough elements in list (expected " + n + ")");
            
            n -= CHUNK_SIZE;
            rightChunk = rightChunk.next;
        }

        if (rightChunk == null) {
            if (n > 0)
                throw new LamaLanguageException("not enough elements in list (expected " + n + ")");
            else return nil();
        }
        return new LamaList(rightChunk, CHUNK_SIZE - n, size - n);
    }

    // note: elements in `elements` should be in tail-to-head order
    public LamaList consN(Object[] elements) {
        if (elements.length == 0)
            return this;
        
        int elementsWritten = 0;
        
        // first, we'll add some elements to our head.
        // if our head chunk is full or allows more elements, no problem.
        // if not (i. e. it's shared with some other bigger list),
        // we'll have to fork, meaning create a new chunk and copy elements
        // from our head to it
        LamaListChunk newHead = head;
        int newNHeadElements = nHeadElements;

        if (head == null) {
            // for the loop to not trigger
            newNHeadElements = CHUNK_SIZE;
        } else if (newNHeadElements == CHUNK_SIZE) {
            // we have to add all elements to new chunks
        } else if (head.nElements == newNHeadElements) {
            // we can write straight to head without damaging other lists
        } else {
            // we have to create a new head
            newHead = new LamaListChunk(
                head.elements,
                0,
                newNHeadElements,
                head.next
            );
        }

        while (elementsWritten < elements.length && newNHeadElements < CHUNK_SIZE) {
            newHead.elements[newHead.nElements] = elements[elementsWritten];
            newHead.nElements++;
            elementsWritten++;
            newNHeadElements++;
        }

        while (elementsWritten < elements.length) {
            newHead = new LamaListChunk(
                elements,
                elementsWritten,
                Math.min(CHUNK_SIZE, elements.length - elementsWritten),
                newHead
            );
            elementsWritten = Math.min(elements.length, elementsWritten + CHUNK_SIZE);
            newNHeadElements = newHead.nElements;
        }

        return new LamaList(newHead, newNHeadElements, size + elements.length);
    }
}
