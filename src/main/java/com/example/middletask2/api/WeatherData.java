package com.example.middletask2.api;

public class WeatherData {
    private String city;
    private String zipCode;
    private String temperature;
    // Add other weather attributes as needed

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getTemperature() {
        return temperature;
    }
}
