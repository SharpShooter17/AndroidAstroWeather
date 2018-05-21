package com.bartoszujazdowski.astroweather;

import com.bartoszujazdowski.astroweather.Helpers.FavouriteLocation;
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
    FavouriteLocation location = new FavouriteLocation("Lodz", "PL");
    private YahooWeatherService yahooWeatherService = new YahooWeatherService(UNITS.Celsius, this.location.toString());

    @Override
    public void update() {
        Realm realm = Realm.getDefaultInstance();

        if ( AndroidUtils.isOnline() ) {
            try {
                this.yahooWeatherService = new YahooWeatherService(SettingsSingleton.getInstance().getUnits(), this.location.toString());
                this.yahooWeatherService.execute().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            realm.beginTransaction();

            YahooWeatherDataAndWoeid yahooWeatherDataAndWoeid = realm.copyToRealm(this.yahooWeatherService.getYahooWeatherDataAndWoeid());

            realm.commitTransaction();
        } else {
            this.yahooWeatherService.setYahooWeatherDataAndWoeid( realm.where(YahooWeatherDataAndWoeid.class).equalTo("woeid.name", this.location.getCity()).findFirst() );
        }
    }
}
