package com.design.patten.observer.improve;

//接口，让 WeatherData 来实现
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
