package com.design.patten.singleton;

/**
 * 懒汉式（同步代码块）
 */
public class Singleton5 {
    private Singleton5(){}

    private static Singleton5 instance;

    public static Singleton5 getInstance(){
        if(instance == null) {
            synchronized (Singleton5.class) {//同步代码块
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
