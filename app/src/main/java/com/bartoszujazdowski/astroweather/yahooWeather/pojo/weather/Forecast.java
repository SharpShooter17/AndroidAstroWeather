package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Forecast extends RealmObject {
    public static final String CODE = "code";
    public static final String DATE = "date";
    public static final String DAY = "day";
    public static final String HIGH = "high";
    public static final String LOW = "low";
    public static final String TEXT = "text";

    @SerializedName("code")
    private String code;
    @SerializedName("date")
    private String date;
    @SerializedName("day")
    private String day;
    @SerializedName("high")
    private String high;
    @SerializedName("low")
    private String low;
    @SerializedName("text")
    private String text;

    public Forecast(){ }

    public Forecast setCode(String code){
        this.code = code;
        return this;
    }
    public String getCode(){
        return this.code;
    }
    public Forecast setDate(String date){
        this.date = date;
        return this;
    }
    public String getDate(){
        return this.date;
    }
    public Forecast setDay(String day){
        this.day = day;
        return this;
    }
    public String getDay(){
        return this.day;
    }
    public Forecast setHigh(String high){
        this.high = high;
        return this;
    }
    public String getHigh(){
        return this.high;
    }
    public Forecast setLow(String low){
        this.low = low;
        return this;
    }
    public String getLow(){
        return this.low;
    }
    public Forecast setText(String text){
        this.text = text;
        return this;
    }
    public String getText(){
        return this.text;
    }
}

