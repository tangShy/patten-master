package com.demo;

public class HashTest {
    public static void main(String[] args) {
        Student student1 = new Student("akon", 18);
        Student student2 = new Student("akon", 18);
        System.out.println("两位同学是同一个人吗?" + student1.equals(student2));
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
    }
}
