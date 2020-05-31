package com.design.patten.mediator.smarthouse;

/**
 * 中介者模式：解决智能家居问题
 */
public class Client {
    public static void main(String[] args) {
        //创建一个中介者
        Mediator mediator = new ConcreteMediator();

        //创建Alarm\CoffeeMachine\Curtains\TV 分别加入到 ConcreteMediator 对象的 HashMap 中
        Alarm alarm = new Alarm(mediator, "alarm");
        CoffeeMachine coffeeMachine = new CoffeeMachine(mediator, "coffeeMachine");
        Curtains curtains = new Curtains(mediator, "curtains");
        TV tv = new TV(mediator, "tv");

        //让闹钟发出消息
        alarm.sendAlarm(0);
        coffeeMachine.finishCoffee();
        alarm.sendAlarm(1);

    }
}
