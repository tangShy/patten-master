package com.design.patten.test;

import com.design.patten.singleton.*;

public class Test {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton4 singleton4 = Singleton4.getInstance();
        Singleton5 singleton5 = Singleton5.getInstance();
        Singleton6 singleton6 = Singleton6.getInstance();
        Singleton7 singleton7 = Singleton7.getInstance();
        Singleton8 instance = Singleton8.INSTANCE;
        instance.sayHello();
    }
}
