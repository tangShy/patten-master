package com.design.patten.mediator.smarthouse;

public class Alarm extends Colleague {
    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        //在创建 Alarm 同事对象时，将自己放入到 ConcreteMediator 对象中【集合】
        mediator.Register(name, this);
    }

    public void sendAlarm(int stateChange){
        sendMessage(stateChange);
    }

    @Override
    public void sendMessage(int stateChange) {
        //调用中介者对象的 getMessage
        this.getMediator().GetMessage(stateChange, this.name);
    }
}
