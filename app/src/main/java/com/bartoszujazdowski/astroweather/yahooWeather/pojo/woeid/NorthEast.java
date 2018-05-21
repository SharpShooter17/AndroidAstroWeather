package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class NorthEast extends RealmObject {
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";

    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public NorthEast(){ }

    public NorthEast setLatitude(String latitude){
        this.latitude = latitude;
        return this;
    }
    public String getLatitude(){
        return this.latitude;
    }
    public NorthEast setLongitude(String longitude){
        this.longitude = longitude;
        return this;
    }
    public String getLongitude(){
        return this.longitude;
    }
}

