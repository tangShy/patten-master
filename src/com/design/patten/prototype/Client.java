package com.design.patten.prototype;

public class Client {
    public static void main(String[] args) {
        System.out.println("原型模式完成对象的创建克隆");
        Sheep sheep = new Sheep( "tom",1, "white");

        Sheep sheep1 = (Sheep)sheep.clone();
        Sheep sheep2 = (Sheep)sheep.clone();
        Sheep sheep3 = (Sheep)sheep.clone();
        Sheep sheep4 = (Sheep)sheep.clone();

        System.out.println(sheep);
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
    }
}
