package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Atmosphere extends RealmObject {
    public static final String HUMIDITY = "humidity";
    public static final String PRESSURE = "pressure";
    public static final String RISING = "rising";
    public static final String VISIBILITY = "visibility";

    @SerializedName("humidity")
    private String humidity;
    @SerializedName("pressure")
    private String pressure;
    @SerializedName("rising")
    private String rising;
    @SerializedName("visibility")
    private String visibility;

    public Atmosphere(){ }

    public Atmosphere setHumidity(String humidity){
        this.humidity = humidity;
        return this;
    }
    public String getHumidity(){
        return this.humidity;
    }
    public Atmosphere setPressure(String pressure){
        this.pressure = pressure;
        return this;
    }
    public String getPressure(){
        return this.pressure;
    }
    public Atmosphere setRising(String rising){
        this.rising = rising;
        return this;
    }
    public String getRising(){
        return this.rising;
    }
    public Atmosphere setVisibility(String visibility){
        this.visibility = visibility;
        return this;
    }
    public String getVisibility(){
        return this.visibility;
    }
}

