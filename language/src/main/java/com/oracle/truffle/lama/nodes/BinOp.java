package com.oracle.truffle.lama.nodes;

public enum BinOp {
    ADD, SUB,  // priority add
    MUL, DIV, REM,  // priority mul
    LT, LE, GT, GE, EQ, NE,  // priority cmp
    AND,  // priority and
    OR,  // priority or
}
