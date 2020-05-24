package com.design.patten.singleton;

/**
 * 懒汉式（线程安全，同步方法）
 */
public class Singleton4 {
    //1.构造器私有化
    private Singleton4(){}

    //2.类的内部创建对象实例
    private static Singleton4 instance;

    //3.提供一个静态的公共方法，加入同步处理的代码，解决线程安全问题
    public static synchronized Singleton4 getInstance(){
        if(instance == null){
            instance = new Singleton4();
        }
        return instance;
    }
}
