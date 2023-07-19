package com.example.middletask2.api;

import com.example.middletask2.entity.Weather;
import com.example.middletask2.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScheduler {
    private final WeatherService weatherService;

    @Autowired
    public WeatherScheduler(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(fixedRate = 3600000) // Run every 1 hour (3600000 milliseconds)
    public void refreshWeatherData() {
        weatherService.getAllWeather().forEach(weather -> {
            Weather updatedWeather = weatherService.fetchAndSaveWeatherData(weather.getCity());
            weather.setTemperature(updatedWeather.getTemperature());
            weatherService.saveWeather(weather);
        });
    }
}

