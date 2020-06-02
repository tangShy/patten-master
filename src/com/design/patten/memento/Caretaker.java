package com.design.patten.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    //在List集合中会有很多的备忘录对象
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    //获取到第 index 个 Originator 的备忘录对象（即保存对象）
    public Memento get(int index){
        return mementoList.get(index);
    }
}
