package com.bartoszujazdowski.astroweather;

import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.YahooWeatherDataAndWoeid;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherService;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Woeid;

import java.util.concurrent.ExecutionException;

import io.realm.Realm;
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

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        YahooWeatherDataAndWoeid yahooWeatherDataAndWoeid = realm.copyToRealm(this.yahooWeatherService.getYahooWeatherDataAndWoeid());

        realm.commitTransaction();

    }
}
