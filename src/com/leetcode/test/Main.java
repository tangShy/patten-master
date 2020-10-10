package com.leetcode.test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Runtime runtime = Runtime.getRuntime();
//        System.out.println(runtime.freeMemory());
//        System.out.println(runtime.totalMemory());
//        System.out.println(runtime.maxMemory());
        int[] a = new int[]{5,4,1,2,3};
        System.out.println(Arrays.toString(a));

        int[] b = a;
        System.out.println(b.length);
        System.out.println(Arrays.toString(b));
    }
}
