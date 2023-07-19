package com.example.middletask2.repository;

import com.example.middletask2.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Weather findByCity(String city);
    Weather findByZipCode(String zipCode);
}
