package com.design.patten.factory.simple_factory;

/**
 * 测试类
 */
public class Calculator {
    public static void main(String[] args) {
        Operation operation;
        String operator;
        operator = "-";
        operation = OpreationFactory.createOperate(operator);
        operation.number1 = 10;
        operation.number2 = 8;
        System.out.println(operation.result());
    }
}
