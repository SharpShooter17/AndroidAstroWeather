package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Astronomy extends RealmObject {
    public static final String SUNRISE = "sunrise";
    public static final String SUNSET = "sunset";

    @SerializedName("sunrise")
    private String sunrise;
    @SerializedName("sunset")
    private String sunset;

    public Astronomy(){ }

    public Astronomy setSunrise(String sunrise){
        this.sunrise = sunrise;
        return this;
    }
    public String getSunrise(){
        return this.sunrise;
    }
    public Astronomy setSunset(String sunset){
        this.sunset = sunset;
        return this;
    }
    public String getSunset(){
        return this.sunset;
    }
}

