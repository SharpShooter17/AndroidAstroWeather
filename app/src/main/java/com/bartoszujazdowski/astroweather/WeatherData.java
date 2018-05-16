package com.bartoszujazdowski.astroweather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    private String city;
    private String temperature;
    private String pressure;
    private String humidity;
    private String visability;
    private String windForce;
    private String windDirection;
}
