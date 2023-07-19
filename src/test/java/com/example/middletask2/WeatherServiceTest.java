package com.example.middletask2;

import com.example.middletask2.api.WeatherApiClient;
import com.example.middletask2.api.WeatherData;
import com.example.middletask2.entity.Weather;
import com.example.middletask2.repository.WeatherRepository;
import com.example.middletask2.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {

    @Mock
    private WeatherRepository weatherRepository;

    @Mock
    private WeatherApiClient weatherApiClient;

    @InjectMocks
    private WeatherService weatherService;

    @Test
    public void testFetchAndSaveWeatherData_Success() {
        String location = "New York";
        WeatherData weatherData = new WeatherData();
        weatherData.setCity(location);

        Mockito.when(weatherApiClient.getWeatherData(location, "862ba7d72aaefd479914b21f5910044c")).thenReturn(weatherData);

        Weather weather = weatherService.fetchAndSaveWeatherData(location);

        assertEquals(location, weather.getCity());
        // Additional assertions for other attributes
    }

    @Test
    public void testGetWeatherByCity_Success() {
        String city = "New York";
        Weather weather = new Weather();
        weather.setCity(city);

        Mockito.when(weatherRepository.findByCity(city)).thenReturn(weather);

        Weather result = weatherService.getWeatherByCity(city);
        assertEquals(city, result.getCity());
    }

    @Test
    public void testGetWeatherByCity_NotFound() {
        String city = "Unknown City";

        Mockito.when(weatherRepository.findByCity(city)).thenReturn(null);

        Weather result = weatherService.getWeatherByCity(city);
        assertNull(result);
    }

    @Test
    public void testGetWeatherByZipCode_Success() {
        String zipCode = "12345";
        Weather weather = new Weather();
        weather.setZipCode(zipCode);

        Mockito.when(weatherRepository.findByZipCode(zipCode)).thenReturn(weather);

        Weather result = weatherService.getWeatherByZipCode(zipCode);
        assertEquals(zipCode, result.getZipCode());
    }

    @Test
    public void testGetWeatherByZipCode_NotFound() {
        String zipCode = "54321";

        Mockito.when(weatherRepository.findByZipCode(zipCode)).thenReturn(null);

        Weather result = weatherService.getWeatherByZipCode(zipCode);
        assertNull(result);
    }
}
