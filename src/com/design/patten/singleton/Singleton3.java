package com.design.patten.singleton;

/**
 * 懒汉式（线程不安全）
 */
public class Singleton3 {
    //1.构造器私有化
    private Singleton3(){}

    //2.类的内部创建对象实例
    private static Singleton3 instance;

    //3.提供一个静态的公共方法，当使用到该方法时，才去创建实例（需要了才去行动叫懒汉式）
    public static Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}
