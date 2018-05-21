package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Units extends RealmObject {
    public static final String DISTANCE = "distance";
    public static final String PRESSURE = "pressure";
    public static final String SPEED = "speed";
    public static final String TEMPERATURE = "temperature";

    @SerializedName("distance")
    private String distance;
    @SerializedName("pressure")
    private String pressure;
    @SerializedName("speed")
    private String speed;
    @SerializedName("temperature")
    private String temperature;

    public Units(){ }

    public Units setDistance(String distance){
        this.distance = distance;
        return this;
    }
    public String getDistance(){
        return this.distance;
    }
    public Units setPressure(String pressure){
        this.pressure = pressure;
        return this;
    }
    public String getPressure(){
        return this.pressure;
    }
    public Units setSpeed(String speed){
        this.speed = speed;
        return this;
    }
    public String getSpeed(){
        return this.speed;
    }
    public Units setTemperature(String temperature){
        this.temperature = temperature;
        return this;
    }
    public String getTemperature(){
        return this.temperature;
    }
}

