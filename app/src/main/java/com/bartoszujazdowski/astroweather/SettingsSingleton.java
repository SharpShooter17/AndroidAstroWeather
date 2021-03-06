package com.bartoszujazdowski.astroweather;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.astrocalculator.AstroCalculator;
import com.bartoszujazdowski.astroweather.Helpers.AstroUtils;
import com.bartoszujazdowski.astroweather.Helpers.FavouriteLocation;
import com.bartoszujazdowski.astroweather.Helpers.MutableNumber;
import com.bartoszujazdowski.astroweather.Helpers.Updater;
import com.bartoszujazdowski.astroweather.activities.Menu;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherImage;
import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.YahooWeatherDataAndWoeid;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Place;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Woeid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bartosz Ujazdowski on 20.04.2018.
 */

public class SettingsSingleton {

    @Setter
    @Getter
    private Integer refreshFrequency;

    private static SettingsSingleton instance;

    @Getter
    private AstroCalculator astroCalculator;

    @Getter
    private WeatherController weatherController;

    private List<FavouriteLocation> favouriteLocations;

    @Getter @Setter
    private UNITS units;

    private SettingsSingleton(){
        Realm realm = Realm.getDefaultInstance();

        this.favouriteLocations = new ArrayList<>(realm.where(FavouriteLocation.class).findAll());

        SharedPreferences sharedPref = Menu.getContext().getSharedPreferences( Menu.getContext().getString(R.string.units), Context.MODE_PRIVATE);
        String unitsStr = sharedPref.getString(Menu.getContext().getString(R.string.units), "true");

        this.units = unitsStr.compareTo("true") == 0 ? UNITS.Celsius : UNITS.Fahrenheit;

        SharedPreferences sharedPrefFreq = Menu.getContext().getSharedPreferences( Menu.getContext().getString(R.string.refresh_frequency), Context.MODE_PRIVATE);
        String freqStr = sharedPrefFreq.getString(Menu.getContext().getString(R.string.refresh_frequency), "60");

        this.refreshFrequency = Integer.parseInt(freqStr);
        Updater.getInstance().setInterval(this.refreshFrequency * 1000);
        this.weatherController = new WeatherController();

        this.astroCalculator = new AstroCalculator(
                AstroUtils.getCurrentAstroDateTime(),
                new AstroCalculator.Location(0, 0));
    }

    public void update(){

        if ( getWeatherController().getYahooWeatherService().getYahooWeatherDataAndWoeid() == null ){
            return;
        }

        Place place = getWeatherController().getYahooWeatherService().getYahooWeatherDataAndWoeid().getWoeid();

        if (place == null){
            return;
        }

        this.astroCalculator.setDateTime(AstroUtils.getCurrentAstroDateTime());
        this.astroCalculator.setLocation(new AstroCalculator.Location(Double.parseDouble(place.getCentroid().getLatitude()),
                Double.parseDouble(place.getCentroid().getLongitude())));
    }

    static public SettingsSingleton getInstance(){
        if ( !(SettingsSingleton.instance instanceof SettingsSingleton) ){
            SettingsSingleton.instance = new SettingsSingleton();
        }

        return SettingsSingleton.instance;
    }

    public final List<FavouriteLocation> getFavouriteLocations(){
        if (this.favouriteLocations == null){
            List<FavouriteLocation> fa =  new ArrayList<>();
            fa.add(new FavouriteLocation("Warsaw", "PL"));
            return fa;
        }
        return this.favouriteLocations;
    }

    public void addFavouriteLocation(String city, String code){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        FavouriteLocation favouriteLocation = realm.createObject(FavouriteLocation.class);
        favouriteLocation.setCity(city);
        favouriteLocation.setCountry(code);
        realm.insert( favouriteLocation );

        realm.commitTransaction();

        this.favouriteLocations.add(favouriteLocation);
    }
}
