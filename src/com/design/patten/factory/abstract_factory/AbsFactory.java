package com.design.patten.factory.abstract_factory;

import com.design.patten.factory.simple_factory.Operation;

/**
 * 一个抽象工厂模式的抽象层（接口）
 */
public interface AbsFactory {
    Operation createOperation();
}
