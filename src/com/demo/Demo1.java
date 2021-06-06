package com.demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Demo1 {
    public static void main(String[] args) {
//        Integer a = new Integer("abc");
//        System.out.println(a);

//        Integer a = 1024;
//        Integer b = 1024;
//        System.out.println(a == b);

//        Integer a = 66;
//        Integer b = 66;
//        System.out.println(a == b);

//        test();

//        Arrays.asList("Foo", "Bar").stream()
//                .filter(s -> s.equalsIgnoreCase("foo"))
//                .map(s -> s.toUpperCase())
//                .forEach(System.out::println);
//
//        Arrays.stream(new String[] {"s1", "s2", "s3"})
//                .map(s -> Arrays.asList(s))
//                .flatMap(l -> l.stream())
//                .forEach(System.out::println);

        new MyThread().start();
        try {
            new MyThread().sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new MyThread().start();
        Object a = "aa";
        try {
            a.wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test(){
//        byte b1=1,b2=2,b3,b6,b8;
//        final byte b4=4,b5=5,b7;
//        b3 = b1 + b2;
//        b6 = b4 + b5;
//        b7 = b2 + b5;
//        b8 = b1 + b4;
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new LinkedHashMap<>();
        Map<String, String> map3 = new Hashtable<>();
        map.put(null, "aa");
        System.out.println(map.get(null));
        map2.put(null, "bb");
        System.out.println(map2.get(null));
        map3.put(null, "cc");
        System.out.println(map3.get(null));
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("通过继承 Thread 类实现线程");
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("通过实现 Runnable 方式实现线程");
        }
    }
}
