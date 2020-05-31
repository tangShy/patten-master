package com.design.patten.observer.improve;

import java.util.ArrayList;

/**
 * 核心类
 * 1、包含最新的天气情况
 * 2、含有 CurrentConditions 对象
 * 3、当数据有更新时 ，就主动的调用 CurrentConditions 对象 update 方法（含display），这样接入方就可以看到最新的天气情况
 */
public class WeatherData implements Subject {
    private float temperature;
    private float pressure;
    private float humidity;

    //观察者集合
    private ArrayList<Observer> observerArrayList;

    //加入新的第三方
    public WeatherData() {
        observerArrayList = new ArrayList<>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void dataChange(){
        //调用接入方的 update
       notifyObserver();
    }

    //当数据有更新时，就调用 setData
    public void setData(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange，将最新的信息推送给接入方 currentConditions
        dataChange();
    }

    //注册一个观察者
    @Override
    public void registerObserver(Observer o) {
        observerArrayList.add(o);
    }

    //移除一个观察者
    @Override
    public void removeObserver(Observer o) {
        if(observerArrayList.contains(o)){
            observerArrayList.remove(o);
        }
    }

    //遍历所有观察者,并通知
    @Override
    public void notifyObserver() {
        for (int i=0; i<observerArrayList.size(); i++) {
            observerArrayList.get(i).update(this.temperature, this.pressure, this.humidity);
        }
    }
}
