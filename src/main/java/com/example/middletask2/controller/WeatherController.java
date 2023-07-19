package com.example.middletask2.controller;

import com.example.middletask2.entity.Weather;
import com.example.middletask2.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/byZipCode/{zipCode}")
    public ResponseEntity<Weather> getWeatherByZipCode(@PathVariable String zipCode) {
        Weather weather = weatherService.getWeatherByZipCode(zipCode);
        if (weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/byCity/{city}")
    public ResponseEntity<Weather> getWeatherByCity(@PathVariable String city) {
        Weather weather = weatherService.getWeatherByCity(city);
        if (weather != null) {
            return new ResponseEntity<>(weather, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

