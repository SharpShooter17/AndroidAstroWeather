package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Condition extends RealmObject {
    public static final String CODE = "code";
    public static final String DATE = "date";
    public static final String TEMP = "temp";
    public static final String TEXT = "text";

    @SerializedName("code")
    private String code;
    @SerializedName("date")
    private String date;
    @SerializedName("temp")
    private String temp;
    @SerializedName("text")
    private String text;

    public Condition(){ }

    public Condition setCode(String code){
        this.code = code;
        return this;
    }
    public String getCode(){
        return this.code;
    }
    public Condition setDate(String date){
        this.date = date;
        return this;
    }
    public String getDate(){
        return this.date;
    }
    public Condition setTemp(String temp){
        this.temp = temp;
        return this;
    }
    public String getTemp(){
        return this.temp;
    }
    public Condition setText(String text){
        this.text = text;
        return this;
    }
    public String getText(){
        return this.text;
    }
}

