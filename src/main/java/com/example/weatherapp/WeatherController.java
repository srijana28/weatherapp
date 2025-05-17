package com.example.weatherapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WeatherController {

    @GetMapping("/weather")
    public ResponseEntity<?> getWeather(@RequestParam(required = false) String city) {
        if (city == null || city.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "City parameter is required"));
        }

        if (!city.equalsIgnoreCase("London")) {
            return ResponseEntity.status(404).body(Map.of("error", "City not found"));
        }

        Map<String, Object> weather = new HashMap<>();
        weather.put("temperature", "15°C");
        weather.put("condition", "Cloudy");
        weather.put("humidity", "70%");
        weather.put("wind_speed", "12 km/h");

        return ResponseEntity.ok(weather);
    }
}
