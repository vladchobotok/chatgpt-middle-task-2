package com.example.middletask2.api;

import feign.Param;
import feign.RequestLine;

public interface WeatherApiClient {
    @RequestLine("GET /weather?q={location}&appid={apiKey}")
    WeatherData getWeatherData(@Param("location") String location, @Param("apiKey") String apiKey);
}

