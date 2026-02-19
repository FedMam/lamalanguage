package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.ref.Ref;

@SuppressWarnings("FieldMayBeFinal")
public final class IfStmtNode extends LamaNode {
    @Child
    private LamaNode condition;
    @Child
    private LamaNode mainBranch;
    @Child
    private LamaNode altBranch;

    public IfStmtNode (LamaNode condition, LamaNode mainBranch, LamaNode altBranch) {
        this.condition = condition;
        this.mainBranch = mainBranch;
        this.altBranch = altBranch;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        int condEval = condition.executeInt(frame);
        if (condEval != 0) {
            return mainBranch.executeGeneric(frame);
        } else {
            return altBranch.executeGeneric(frame);
        }
    }

    @Override
    public Ref executeRef(VirtualFrame frame) throws UnexpectedResultException {
        int condEval = condition.executeInt(frame);
        if (condEval != 0) {
            return mainBranch.executeRef(frame);
        } else {
            return altBranch.executeRef(frame);
        }
    }
}
