package com.design.patten.strategy;

/**
 *策略模式：
 */
public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.display();
        wildDuck.fly();

        PekingDuck pekingDuck = new PekingDuck();
        pekingDuck.display();
        pekingDuck.fly();

        ToyDuck toyDuck = new ToyDuck();
        toyDuck.display();
        toyDuck.fly();

        //动态的改变某个对象的行为，北京鸭实际不能飞
        pekingDuck.setFlyBehavior(new NotFlyBehavior());
        pekingDuck.display();
        System.out.print("北京鸭的实际飞翔能力为：");
        pekingDuck.fly();
    }
}
