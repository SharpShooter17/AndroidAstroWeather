package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Admin1 extends RealmObject {
    public static final String CODE = "code";
    public static final String TYPE = "type";
    public static final String WOEID = "woeid";
    public static final String CONTENT = "content";

    @SerializedName("code")
    private String code;
    @SerializedName("type")
    private String type;
    @SerializedName("woeid")
    private String woeid;
    @SerializedName("content")
    private String content;

    public Admin1(){ }

    public Admin1 setCode(String code){
        this.code = code;
        return this;
    }
    public String getCode(){
        return this.code;
    }
    public Admin1 setType(String type){
        this.type = type;
        return this;
    }
    public String getType(){
        return this.type;
    }
    public Admin1 setWoeid(String woeid){
        this.woeid = woeid;
        return this;
    }
    public String getWoeid(){
        return this.woeid;
    }
    public Admin1 setContent(String content){
        this.content = content;
        return this;
    }
    public String getContent(){
        return this.content;
    }
}

