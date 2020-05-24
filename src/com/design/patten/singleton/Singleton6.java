package com.design.patten.singleton;

/**
 * 双重检查
 */
public class Singleton6 {
    private Singleton6(){}

    //使用volatile关键字会强制将修改的值立即写入主存；
    private static volatile Singleton6 instance;

    public static synchronized Singleton6 getInstance(){//同步方法
        if(instance == null){
            synchronized(Singleton6.class){//同步代码块
                if(instance == null){
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
