package com.design.patten.singleton;

/**
 * 饿汉式（静态代码块）
 */
public class Singleton2 {
    //1.构造器私有化
    private Singleton2() {
    }

    //2.类的内部创建对象实例
    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    //3.提供静态公共方法，返回实例对象
    public static Singleton2 getInstance() {
        return instance;
    }

}
