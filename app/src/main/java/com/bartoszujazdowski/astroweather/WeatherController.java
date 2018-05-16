package com.bartoszujazdowski.astroweather;

import com.bartoszujazdowski.astroweather.Helpers.UpdateI;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherController implements UpdateI {

    private static final String baseUrl = "https://query.yahooapis.com/v1/public/yql?q=";

    private WeatherData weatherData;

    @Override
    public void update() {

    }
}
