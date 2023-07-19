package com.example.middletask2.entity;

import jakarta.persistence.*;


@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_seq")
    @SequenceGenerator(name = "weather_seq", sequenceName = "weather_seq", allocationSize = 1)
    private Long id;

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

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    // Constructors, getters, and setters
}
