package com.design.patten.factory._factory;

public class MultiFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationMulti();
    }
}
