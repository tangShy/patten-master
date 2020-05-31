package com.design.patten.mediator.smarthouse;

import java.util.HashMap;

//具体的中介者类
public class ConcreteMediator extends Mediator {
    //集合，放入所有的同事对象
    private HashMap<String, Colleague> colleagueHashMap;
    private HashMap<String, String> interMap;

    public ConcreteMediator() {
        colleagueHashMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    public void Register(String colleagueName, Colleague colleague) {
        colleagueHashMap.put(colleagueName, colleague);

        if(colleague instanceof Alarm){
            interMap.put("Alarm", colleagueName);
        }else if(colleague instanceof CoffeeMachine){
            interMap.put("CoffeeMachine", colleagueName);
        }else if(colleague instanceof TV){
            interMap.put("TV", colleagueName);
        }else if(colleague instanceof Curtains){
            interMap.put("Curtains", colleagueName);
        }
    }

    /**
     * 具体中介者的核心方法
     * 1.根据得到消息，完成对应任务
     * 2、中介者在这个方法，协调各个具体的同事对象，完成任务
     */
    @Override
    public void GetMessage(int stateChange, String colleagueName) {
        //处理闹钟发出的声音
        if(colleagueHashMap.get(colleagueName) instanceof Alarm){
            if (stateChange == 0){
                ((CoffeeMachine)colleagueHashMap.get(interMap.get("CoffeeMachine"))).startCoffee();
                ((TV)colleagueHashMap.get(interMap.get("TV"))).startTV();
            }else if (stateChange == 1) {
                ((TV)colleagueHashMap.get(interMap.get("TV"))).stopTV();
            }
        }else if(colleagueHashMap.get(colleagueName) instanceof CoffeeMachine){
            ((Curtains)colleagueHashMap.get(interMap.get("Curtains"))).upCurtains();
        }else if(colleagueHashMap.get(colleagueName) instanceof TV){
            //.....TV发出消息
        }else if(colleagueHashMap.get(colleagueName) instanceof Curtains){
            //.........窗帘发出消息
        }
    }

    @Override
    public void sendMessage() {

    }
}
