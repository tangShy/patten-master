package com.design.patten.facade;

public class DVDPlayer {
    //使用单例模式（饿汉式）
    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void off() {
        System.out.println("dvd off");
    }

    public void on() {
        System.out.println("dvd on");
    }

    public void pause() {
        System.out.println("dvd pause");
    }

    public void play() {
        System.out.println("dvd play....");
    }
}
