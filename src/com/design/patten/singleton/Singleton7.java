package com.design.patten.singleton;

/**
 * 静态内部类
 */
public class Singleton7 {
    //构造器私有化
    private Singleton7(){}

    private static volatile Singleton7 instance;

    //静态内部类，该类中有一个静态属性 Singleton1
    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    //提供一个静态的公共方法，直接返回 SingletonInstance.INSTANCE
    public static synchronized Singleton7 getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
