package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Location extends RealmObject {
    public static final String CITY = "city";
    public static final String COUNTRY = "country";
    public static final String REGION = "region";

    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("region")
    private String region;

    public Location(){ }

    public Location setCity(String city){
        this.city = city;
        return this;
    }
    public String getCity(){
        return this.city;
    }
    public Location setCountry(String country){
        this.country = country;
        return this;
    }
    public String getCountry(){
        return this.country;
    }
    public Location setRegion(String region){
        this.region = region;
        return this;
    }
    public String getRegion(){
        return this.region;
    }
}

