package com.bartoszujazdowski.astroweather;

import com.astrocalculator.AstroCalculator;
import com.bartoszujazdowski.astroweather.Helpers.AstroUtils;
import com.bartoszujazdowski.astroweather.Helpers.FavouriteLocation;
import com.bartoszujazdowski.astroweather.Helpers.MutableNumber;
import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Woeid;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bartosz Ujazdowski on 20.04.2018.
 */

public class SettingsSingleton {

    @Setter
    @Getter
    private MutableNumber<Integer> refreshFrequency;

    private static SettingsSingleton instance;

    @Getter
    private AstroCalculator astroCalculator;

    @Getter
    private WeatherController weatherController;

    @Getter
    private List<FavouriteLocation> favouriteLocations;

    @Getter @Setter
    private UNITS units;

    private SettingsSingleton(){
        this.units = UNITS.Celsius;
        this.refreshFrequency = new MutableNumber<>(new Integer(60));

        this.weatherController = new WeatherController();

        this.astroCalculator = new AstroCalculator(
                AstroUtils.getCurrentAstroDateTime(),
                new AstroCalculator.Location(0, 0));

        this.favouriteLocations = new ArrayList<>();
    }

    public void update(){
        Woeid woeid = getWeatherController().getYahooWeatherService().getWoeid();

        if (woeid == null){
            return;
        }

        this.astroCalculator.setDateTime(AstroUtils.getCurrentAstroDateTime());
        this.astroCalculator.setLocation(new AstroCalculator.Location(Double.parseDouble(woeid.getQuery().getResults().getPlace().getCentroid().getLatitude()),
                Double.parseDouble(getWeatherController().getYahooWeatherService().getWoeid().getQuery().getResults().getPlace().getCentroid().getLongitude())));
    }

    static public SettingsSingleton getInstance(){
        if ( !(SettingsSingleton.instance instanceof SettingsSingleton) ){
            SettingsSingleton.instance = new SettingsSingleton();
        }

        return SettingsSingleton.instance;
    }
}
