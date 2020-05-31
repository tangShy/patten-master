package com.design.patten.observer.improve;

public class BaiduSite implements Observer {
    //温度、气压、湿度
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    //显示
    private void display() {
        System.out.println("======百度网站=======");
        System.out.println("==========百度网站 温度为："+temperature+"==============");
        System.out.println("==========百度网站 气压为："+pressure+"==============");
        System.out.println("==========百度网站 湿度为："+humidity+"==============");
    }
}
