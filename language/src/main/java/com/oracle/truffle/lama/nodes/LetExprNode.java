package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.types.pattern.Pattern;
import com.oracle.truffle.lama.types.ref.Ref;

@SuppressWarnings("FieldMayBeFinal")
public final class LetExprNode extends LamaNode {
    public final Pattern pattern;
    public final int line;
    public final int column;

    @Child
    public LamaNode tested;

    @Child
    public LamaNode outcome;

    public LetExprNode(Pattern pattern, LamaNode tested, LamaNode outcome, int line, int column) {
        this.pattern = pattern;
        this.tested = tested;
        this.outcome = outcome;
        this.line = line;
        this.column = line;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object testedValue = tested.executeGeneric(frame);
        
        if (pattern.match(testedValue, frame)) {
            return outcome.executeGeneric(frame);
        }

        throw new LamaLanguageException("match failure at line " + line + ", char " + column + ": " + testedValue);
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        Object testedValue = tested.executeGeneric(frame);

        if (pattern.match(testedValue, frame)) {
            return outcome.executeRef(frame);
        }

        throw new LamaLanguageException("match failure at line " + line + ", char " + column + ": " + testedValue);
    }
}
