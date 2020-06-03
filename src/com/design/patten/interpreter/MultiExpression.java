package com.design.patten.interpreter;

import java.util.HashMap;

public class MultiExpression extends SymbolExpression {
    public MultiExpression(Expression left, Expression right) {
        super(left,right);
    }

    //处理相乘
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) * super.right.interpreter(var);
    }
}
