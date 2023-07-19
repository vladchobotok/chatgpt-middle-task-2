package com.example.middletask2.service;

import com.example.middletask2.api.WeatherApiClient;
import com.example.middletask2.api.WeatherData;
import com.example.middletask2.entity.Weather;
import com.example.middletask2.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final WeatherApiClient weatherApiClient;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, WeatherApiClient weatherApiClient) {
        this.weatherRepository = weatherRepository;
        this.weatherApiClient = weatherApiClient;
    }
    public void saveWeather(Weather weather) {
        weatherRepository.save(weather);
    }
    public List<Weather> getAllWeather() {
        return weatherRepository.findAll();
    }
    public Weather getWeatherByCity(String city) {
        Weather weather = weatherRepository.findByCity(city);
        if (weather == null) {
            weather = fetchAndSaveWeatherData(city);
        }
        return weather;
    }

    public Weather getWeatherByZipCode(String zipCode) {
        Weather weather = weatherRepository.findByZipCode(zipCode);
        if (weather == null) {
            weather = fetchAndSaveWeatherData(zipCode);
        }
        return weather;
    }

    public Weather fetchAndSaveWeatherData(String location) {
        WeatherData weatherData = weatherApiClient.getWeatherData(location, "862ba7d72aaefd479914b21f5910044c");
        if (weatherData != null) {
            Weather weather = new Weather();
            // Map weather data attributes to Weather entity
            weather.setCity(weatherData.getCity());
            weather.setZipCode(weatherData.getZipCode());
            weather.setTemperature(weatherData.getTemperature());
            // Set other attributes as needed
            weatherRepository.save(weather);
            return weather;
        } else {
            return null; // or throw an exception based on your requirements
        }
    }
}

