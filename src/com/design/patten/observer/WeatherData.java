package com.design.patten.observer;

/**
 * 核心类
 * 1、包含最新的天气情况
 * 2、含有 CurrentConditions 对象
 * 3、当数据有更新时 ，就主动的调用 CurrentConditions 对象 update 方法（含display），这样接入方就可以看到最新的天气情况
 */
public class WeatherData {
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
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
        currentConditions.update(getTemperature(), getPressure(), getHumidity());//违反了ocp原则
    }

    //当数据有更新时，就调用 setData
    public void setData(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange，将最新的信息推送给接入方 currentConditions
        dataChange();
    }
}
