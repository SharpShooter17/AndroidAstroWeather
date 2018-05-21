package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class PlaceTypeName extends RealmObject {
    public static final String CODE = "code";
    public static final String CONTENT = "content";

    @SerializedName("code")
    private String code;
    @SerializedName("content")
    private String content;

    public PlaceTypeName(){ }

    public PlaceTypeName setCode(String code){
        this.code = code;
        return this;
    }
    public String getCode(){
        return this.code;
    }
    public PlaceTypeName setContent(String content){
        this.content = content;
        return this;
    }
    public String getContent(){
        return this.content;
    }
}

