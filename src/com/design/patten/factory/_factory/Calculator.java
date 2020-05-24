package com.design.patten.factory._factory;

/**
 * 测试类
 */
public class Calculator {
    public static void main(String[] args) {
        Operation operation;
        IFactory factory = new AddFactory();
        operation = factory.createOperation();
        operation.number1 = 1.2;
        operation.number2 = 2.1;
        System.out.println(operation.result());


        IFactory factory2 = new MultiFactory();
        operation = factory2.createOperation();
        operation.number1 = 2;
        operation.number2 = 3;
        System.out.println(operation.result());
    }
}
