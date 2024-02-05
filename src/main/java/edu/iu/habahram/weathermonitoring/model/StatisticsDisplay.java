package edu.iu.habahram.weathermonitoring.model;

public class StatisticsDisplay implements Observer, DisplayElement {

    private Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;

    public StatisticsDisplay(Subject weatherData){
        this.weatherData = weatherData;
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {

    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String id() {
        return null;
    }

    @Override
    public String display() {
        return null;
    }
}
