package com.design.patten.interpreter;

import java.util.HashMap;
import java.util.Stack;

public class Calculator {
    //定义表达式
    private Expression expression;

    public Calculator(String expStr) { //expStr=a+b
        //安排运算先后顺序
        Stack<Expression> stack = new Stack<>();
        //表达式拆分成字符数组
        char[] charArray = expStr.toCharArray();//[a,+,b]

        Expression left = null;
        Expression right = null;
        //遍历字符数组
        for (int i=0; i<charArray.length; i++){
            switch (charArray[i]){
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left,right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
                case '*':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new MultiExpression(left,right));
                    break;
                default:
                    //如果是一个 变量 就创建给VarExpression，并push到stack
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        //当遍历完整个数组之后，stack 就得到最后Expression
        this.expression = stack.pop();
    }

    public int run(HashMap<String, Integer> var){
        //最后将表达式 a+b 和 var={a=10,b=20}传递给 expression 和 interpreter进行解释执行
        return this.expression.interpreter(var);
    }
}
