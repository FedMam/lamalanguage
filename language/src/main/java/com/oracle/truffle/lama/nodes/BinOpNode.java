package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.error.LamaLanguageException;

// Note: this node only supports == operation on ints.
// In fact, for the == operation, another node will always be used

@SuppressWarnings("FieldMayBeFinal")
public final class BinOpNode extends LamaNode {
    @Child
    private LamaNode lArg;
    @Child
    private LamaNode rArg;

    private final BinOp op;

    public BinOpNode(LamaNode lArg, BinOp op, LamaNode rArg) {
        this.lArg = lArg;
        this.rArg = rArg;
        this.op = op;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        return executeInt(frame);
    }

    @Override
    public int executeInt(VirtualFrame frame) throws UnexpectedResultException {
        int l = lArg.executeInt(frame);
        int r = rArg.executeInt(frame);

        switch (op) {
            case ADD:
                return l + r;
            case SUB:
                return l - r;
            case MUL:
                return l * r;
            case DIV:
                if (r == 0)
                    throw new LamaLanguageException("division by zero");
                return l / r;
            case REM:
                if (r == 0)
                    throw new LamaLanguageException("division by zero");
                return l % r;
            case LT:
                return (l < r) ? 1 : 0;
            case LE:
                return (l <= r) ? 1 : 0;
            case GT:
                return (l > r) ? 1 : 0;
            case GE:
                return (l >= r) ? 1 : 0;
            case EQ:
                return (l == r) ? 1 : 0;
            case NE:
                return (l != r) ? 1 : 0;
            case AND:
                return ((l != 0) && (r != 0)) ? 1 : 0;
            case OR:
                return ((l != 0) || (r != 0)) ? 1 : 0;
            default: // this should not happen
                throw new LamaLanguageException("unsupported operation: " + op.toString());
        }
    }
}