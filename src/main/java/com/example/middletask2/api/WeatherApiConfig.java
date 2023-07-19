package com.example.middletask2.api;

import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class WeatherApiConfig {
    @Bean
    public WeatherApiClient weatherApiClient() {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(WeatherApiClient.class, "https://api.openweathermap.org/data/2.5");
    }
}
