package com.example.app7;

public class WeatherInfo {
    private String name;
    private String weather;
    private String temp;
    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return String.format("WeatherInfo [name=%s, weather=%s, temp=%s, info=%s]",
                name, weather, temp, info);
    }
}
