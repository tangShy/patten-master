package com.design.patten.factory._factory;

/**
 * 减法类，继承运算类并且重新父类方法
 */
public class OperationSub extends Operation {
    @Override
    public double result() {
        return number1 - number2;
    }
}
