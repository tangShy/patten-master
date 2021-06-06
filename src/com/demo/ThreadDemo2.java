package com.demo;

public class ThreadDemo2 {
    private int value;
    public int get(){
        return value;
    }
    public void set(int value){
        this.value = value;
    }

    public static void main(String[] args) {
        new ThreadDemo2.MyThread2("线程1").start();
        new ThreadDemo2.MyThread("线程2").start();
    }

    static class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        public void run() {
            ThreadDemo2 threadDemo2 = new ThreadDemo2();
            System.out.println(this.name + "   " + threadDemo2.get());
        }
    }
    static class MyThread2 extends Thread {
        private String name;

        public MyThread2(String name) {
            this.name = name;
        }

        public void run() {
            ThreadDemo2 threadDemo2 = new ThreadDemo2();
            threadDemo2.set(1);
            System.out.println(this.name);
        }
    }

}
