package edu.iu.habahram.weathermonitoring.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class StatisticsDisplay implements Observer, DisplayElement {
    ArrayList<Float> temperatures = new ArrayList<>();
    private Subject weatherData;
    private float avgTemperature;
    private float minTemperature;
    private float maxTemperature;

    public StatisticsDisplay(Subject weatherData){
        this.weatherData = weatherData;
    }
    @Override
    public void update(float temperature, float humidity, float pressure) {
        if(temperature < minTemperature || minTemperature == 0){
            minTemperature = temperature;
        }
        if(temperature > maxTemperature){
            maxTemperature = temperature;
        }
        temperatures.add(temperature);
        for(float i : temperatures){
            avgTemperature += i;
        }
        avgTemperature /= temperatures.size();
    }

    @Override
    public String name() {
        return "Weather Statistics";
    }

    @Override
    public String id() {
        return "weather-statistics";
    }

    @Override
    public String display() {
        String html = "";
        html += String.format("<div style=\"background-image: " +
                "url(/images/sky.webp); " +
                "height: 400px; " +
                "width: 647.2px;" +
                "display:flex;flex-wrap:wrap;justify-content:center;align-content:center;" +
                "\">");
        html += "<section>";
        html += String.format("<label>Average Temperature: %s</label><br />", avgTemperature);
        html += String.format("<label>Minimum Temperature: %s</label><br />", minTemperature);
        html += String.format("<label>Maximum Temperature: %s</label>", maxTemperature);
        html += "</section>";
        html += "</div>";
        return html;
    }

    public void subscribe() {
        weatherData.registerObserver(this);
    }

    public void unsubscribe() {
        weatherData.removeObserver(this);
    }
}
