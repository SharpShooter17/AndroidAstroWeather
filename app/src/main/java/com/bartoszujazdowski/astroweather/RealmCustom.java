package com.bartoszujazdowski.astroweather;

import com.bartoszujazdowski.astroweather.Helpers.FavouriteLocation;
import com.bartoszujazdowski.astroweather.activities.Menu;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherImage;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.YahooWeatherDataAndWoeid;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmCustom {
    private static RealmCustom instance;

    public static void initRealm(){
        if ( !(instance instanceof RealmCustom) ) {
            RealmCustom.instance = new RealmCustom();
        }
    }

    public static void closeRealm(){
        if ( instance instanceof RealmCustom ) {
            Realm.getDefaultInstance().close();
        }
    }

    private RealmCustom() {
        Realm.init(Menu.getContext());
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().
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
    }
}
