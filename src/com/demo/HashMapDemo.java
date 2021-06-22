package com.demo;

import java.lang.reflect.Method;
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) throws Exception {
        // 指定当前HashMap的初始容量为4
        HashMap<Object, Object> map = new HashMap<>(1024);
        for (int i = 0; i < 1024; i++) {
            // 生成随机字符串
            String filename = String.valueOf(Math.random());
            System.out.print("当前map的存储容量值为:" + capacity(map) + ", size为:" + map.size());
            map.put(filename, null);
            System.out.print(", 添加Entry后size为:" + map.size() + ", 此时map的存储容量值为:" + capacity(map));
            System.out.println();
        }
    }

    /**
     * 通过反射获取容量变量capacity,并调用map对象
     */
    public static int capacity(HashMap map) throws Exception {
        Method capacity = map.getClass().getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        Integer realCapacity = (Integer) capacity.invoke(map);
        return realCapacity;
    }
}
