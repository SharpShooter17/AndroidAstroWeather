package com.bartoszujazdowski.astroweather;

import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherService;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Woeid;

import java.util.concurrent.ExecutionException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherController implements UpdateI {
    private String city = new String("New York,USA");
    private YahooWeatherService yahooWeatherService = new YahooWeatherService(UNITS.Celsius, this.city);

    @Override
    public void update() {
        try {
            this.yahooWeatherService = new YahooWeatherService(SettingsSingleton.getInstance().getUnits(), this.city);
            this.yahooWeatherService.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
