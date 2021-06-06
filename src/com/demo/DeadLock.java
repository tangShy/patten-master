package com.demo;

import java.util.concurrent.TimeUnit;

public class DeadLock {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public void deadLock() {
        Thread threadA = new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "获取 lockA 成功");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获取 lockB");
                    synchronized (lockB) {
                        System.out.println(Thread.currentThread().getName() +"获取 lockB 成功");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获取 lockB 成功");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "尝试获取 lockA");
                    synchronized (lockA) {
                        System.out.println(Thread.currentThread().getName() +"获取 lockA 成功");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.deadLock();
    }
}
