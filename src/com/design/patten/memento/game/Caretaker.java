package com.design.patten.memento.game;

//守护者对象，保存游戏角色的状态
public class Caretaker {
    //如果只保存一次状态
    private Memento memento;
//    //对游戏角色保存多个状态
//    private List<Memento> mementoList;
//    //对多个游戏角色保存多个状态
//    private HashMap<String, ArrayList<Memento>> rolesMemtos;


    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
