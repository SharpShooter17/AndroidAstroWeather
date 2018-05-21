package com.bartoszujazdowski.astroweather.yahooWeather.pojo;

import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.YahooWeatherData;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Woeid;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class YahooWeatherDataAndWoeid {
    @Getter @Setter
    private Woeid woeid;
    @Getter @Setter
    private YahooWeatherData yahooWeatherData;
}
