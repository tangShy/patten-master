package com.design.patten.singleton;

/**
 * 饿汉式（静态常量）
 */
public class Singleton1 {
    //1.构造器私有化
    private Singleton1(){}

    //2.类的内部创建对象实例
    private final static Singleton1 instance = new Singleton1();

    //3.提供静态公共方法，返回实例对象
    public static Singleton1 getInstance(){
        return instance;
    }
}
