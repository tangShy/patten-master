package com.design.patten.mediator.smarthouse;

public class CoffeeMachine extends Colleague {
    public CoffeeMachine(Mediator mediator, String name) {
        super(mediator, name);
        mediator.Register(name,this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().GetMessage(stateChange, this.name);
    }

    public void startCoffee(){
        System.out.println("It's time to startCoffee");
    }

    public void finishCoffee(){
        System.out.println("After 5 minutes!");
        System.out.println("Coffee is OK!");
        sendMessage(0);
    }
}
