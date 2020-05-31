package com.design.patten.mediator.smarthouse;

public class Curtains extends Colleague {
    public Curtains(Mediator mediator, String name) {
        super(mediator, name);
        mediator.Register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        //调用中介者对象的 getMessage
        this.getMediator().GetMessage(stateChange, this.name);
    }

    public void upCurtains(){
        System.out.println("I'm holding up Curtains!");
    }
}
