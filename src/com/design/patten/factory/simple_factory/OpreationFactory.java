package com.design.patten.factory.simple_factory;

/**
 * 简单工厂方法模式
 */
public class OpreationFactory {
    public static Operation createOperate(String operate){
        Operation operation = null;
        switch (operate){
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            default:
                System.out.println("您输入的运算符有误!");
        }
        return operation;
    }
}
