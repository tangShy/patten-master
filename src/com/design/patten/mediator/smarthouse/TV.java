package com.design.patten.mediator.smarthouse;

public class TV extends Colleague{
    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.Register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        //调用中介者对象的 getMessage
        this.getMediator().GetMessage(stateChange, this.name);
    }

    public void startTV(){
        System.out.println("TV start!");
    }

    public void stopTV(){
        System.out.println("It's time to StopTV!");
    }
}
