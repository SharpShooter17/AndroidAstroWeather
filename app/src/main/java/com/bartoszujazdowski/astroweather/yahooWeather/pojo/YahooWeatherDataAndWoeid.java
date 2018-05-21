package com.bartoszujazdowski.astroweather.yahooWeather.pojo;

import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.YahooWeatherData;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Place;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Woeid;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@RealmClass
public class YahooWeatherDataAndWoeid extends RealmObject{
    @Getter @Setter
    private Place woeid;
    @Getter @Setter
    private Channel yahooWeatherData;
}
