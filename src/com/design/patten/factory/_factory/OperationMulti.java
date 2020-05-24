package com.design.patten.factory._factory;

/**
 * 乘法类，继承运算类并且重新父类方法
 */
public class OperationMulti extends Operation {
    @Override
    public double result() {
        return number1 * number2;
    }
}
