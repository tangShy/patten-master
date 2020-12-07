package com.demo;

import java.util.ArrayList;

// JVM,GC回收，OOM异常测试
public class Demo2 {
    byte[] a = new byte[100 * 1024];    //100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Demo2> demo2s = new ArrayList<>();
        while (true) {
            demo2s.add(new Demo2());
            Thread.sleep(10);
        }
    }
}
