package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;
import com.oracle.truffle.lama.types.pattern.Pattern;
import com.oracle.truffle.lama.types.ref.Ref;

@SuppressWarnings("FieldMayBeFinal")
public final class CaseStmtNode extends LamaNode {
    public final Pattern[] patterns;
    public final int line;
    public final int column;

    @Child
    public LamaNode tested;

    @Children
    public LamaNode[] outcomes;

    public CaseStmtNode(LamaNode tested, Pattern[] patterns, LamaNode[] outcomes, int line, int column) {
        this.tested = tested;
        this.patterns = patterns;
        this.outcomes = outcomes;
        this.line = line;
        this.column = line;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Object testedValue = tested.executeGeneric(frame);

        for (int i = 0; i < patterns.length; i++) {
            if (patterns[i].match(testedValue, frame)) {
                Object outcome = outcomes[i].executeGeneric(frame);
                return outcome;
            }
        }

        throw new LamaLanguageException("match failure at line " + line + ", char " + column + ": " + testedValue);
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        Object testedValue = tested.executeGeneric(frame);

        for (int i = 0; i < patterns.length; i++) {
            if (patterns[i].match(testedValue, frame)) {
                Ref outcome = outcomes[i].executeRef(frame);
                return outcome;
            }
        }

        throw new LamaLanguageException("match failure at line " + line + ", char " + column + ": " + testedValue);
    }
}
