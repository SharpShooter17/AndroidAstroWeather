package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Timezone extends RealmObject {
    public static final String TYPE = "type";
    public static final String WOEID = "woeid";
    public static final String CONTENT = "content";

    @SerializedName("type")
    private String type;
    @SerializedName("woeid")
    private String woeid;
    @SerializedName("content")
    private String content;

    public Timezone(){ }

    public Timezone setType(String type){
        this.type = type;
        return this;
    }
    public String getType(){
        return this.type;
    }
    public Timezone setWoeid(String woeid){
        this.woeid = woeid;
        return this;
    }
    public String getWoeid(){
        return this.woeid;
    }
    public Timezone setContent(String content){
        this.content = content;
        return this;
    }
    public String getContent(){
        return this.content;
    }
}

