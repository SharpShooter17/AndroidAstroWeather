package com.bartoszujazdowski.astroweather;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.astrocalculator.AstroCalculator;
import com.bartoszujazdowski.astroweather.Helpers.AstroUtils;
import com.bartoszujazdowski.astroweather.Helpers.FavouriteLocation;
import com.bartoszujazdowski.astroweather.Helpers.MutableNumber;
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
        Realm.init(Menu.getContext());
        RealmConfiguration realmConfiguration =new RealmConfiguration.Builder().
                deleteRealmIfMigrationNeeded().
                initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        FavouriteLocation favouriteLocation = realm.createObject(FavouriteLocation.class);
                        favouriteLocation.setCountry("en");
                        favouriteLocation.setCity("London");
                        YahooWeatherDataAndWoeid yahooWeatherDataAndWoeid = realm.createObject(YahooWeatherDataAndWoeid.class);
                        YahooWeatherImage yahooWeatherImage = realm.createObject(YahooWeatherImage.class);
                        yahooWeatherImage.setCode(null);
                        yahooWeatherImage.setBitmap(null);
                    }
                }).build();

        Realm.setDefaultConfiguration(realmConfiguration);
        Realm realm = Realm.getDefaultInstance();

        this.favouriteLocations = new ArrayList<>(realm.where(FavouriteLocation.class).findAll());

        this.units = UNITS.Celsius;
        this.refreshFrequency = new Integer(60);

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
