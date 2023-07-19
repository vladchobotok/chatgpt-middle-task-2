package com.example.middletask2;

import com.example.middletask2.controller.WeatherController;
import com.example.middletask2.entity.Weather;
import com.example.middletask2.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class WeatherControllerTest {

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @Test
    public void testGetWeatherByZipCode_Success() {
        String zipCode = "12345";
        Weather weather = new Weather();
        weather.setZipCode(zipCode);

        Mockito.when(weatherService.getWeatherByZipCode(zipCode)).thenReturn(weather);

        ResponseEntity<Weather> responseEntity = weatherController.getWeatherByZipCode(zipCode);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(weather, responseEntity.getBody());
    }

    @Test
    public void testGetWeatherByZipCode_NotFound() {
        String zipCode = "54321";

        Mockito.when(weatherService.getWeatherByZipCode(zipCode)).thenReturn(null);

        ResponseEntity<Weather> responseEntity = weatherController.getWeatherByZipCode(zipCode);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    public void testGetWeatherByCity_Success() {
        String city = "New York";
        Weather weather = new Weather();
        weather.setCity(city);

        Mockito.when(weatherService.getWeatherByCity(city)).thenReturn(weather);

        ResponseEntity<Weather> responseEntity = weatherController.getWeatherByCity(city);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(weather, responseEntity.getBody());
    }

    @Test
    public void testGetWeatherByCity_NotFound() {
        String city = "Unknown City";

        Mockito.when(weatherService.getWeatherByCity(city)).thenReturn(null);

        ResponseEntity<Weather> responseEntity = weatherController.getWeatherByCity(city);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }
}

