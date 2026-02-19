package com.oracle.truffle.lama.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.lama.types.ref.*;

@SuppressWarnings("FieldMayBeFinal")
public final class AssignmentNode extends LamaNode {
    @Child
    private LamaNode refNode;
    @Child
    private LamaNode assnExprNode;

    public AssignmentNode(LamaNode refNode, LamaNode assnExprNode) {
        this.refNode = refNode;
        this.assnExprNode = assnExprNode;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) throws UnexpectedResultException {
        Ref r = refNode.executeRef(frame);
        var v = assnExprNode.executeGeneric(frame);
        r.setAt(currentLanguageContext(), frame, v);
        return v;
    }
}
