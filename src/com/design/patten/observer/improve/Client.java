package com.design.patten.observer.improve;

/**
 * 观察者模式
 */
public class Client {
    public static void main(String[] args) {
        //创建一个 WeatherData
        WeatherData weatherData = new WeatherData();

        //创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();

        //注册到 weatherData
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);

        //测试
        System.out.println("通知各个观察者，看看天气信息");
        weatherData.setData(30,150,45);

        // 移除一个观察者，测试
        weatherData.removeObserver(currentConditions);
        System.out.println();
        System.out.println("通知各个观察者，看看天气信息");
        weatherData.setData(31.3f, 156.3f, 50.1f);
    }

}
