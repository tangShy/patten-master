package com.design.patten.strategy;

public class ToyDuck extends Duck {
    public ToyDuck() {
        super();
        flyBehavior = new NotFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("========玩具鸭==========");
    }

    @Override
    public void quack() {
        System.out.println("玩具鸭不能叫~~");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不会游泳~~");
    }

}
