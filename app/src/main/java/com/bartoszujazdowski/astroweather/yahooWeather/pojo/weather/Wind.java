package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Wind extends RealmObject {
    public static final String CHILL = "chill";
    public static final String DIRECTION = "direction";
    public static final String SPEED = "speed";

    @SerializedName("chill")
    private String chill;
    @SerializedName("direction")
    private String direction;
    @SerializedName("speed")
    private String speed;

    public Wind(){ }

    public Wind setChill(String chill){
        this.chill = chill;
        return this;
    }
    public String getChill(){
        return this.chill;
    }
    public Wind setDirection(String direction){
        this.direction = direction;
        return this;
    }
    public String getDirection(){
        return this.direction;
    }
    public Wind setSpeed(String speed){
        this.speed = speed;
        return this;
    }
    public String getSpeed(){
        return this.speed;
    }
}

