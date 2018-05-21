package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Image extends RealmObject {
    public static final String TITLE = "title";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String LINK = "link";
    public static final String URL = "url";

    @SerializedName("title")
    private String title;
    @SerializedName("width")
    private String width;
    @SerializedName("height")
    private String height;
    @SerializedName("link")
    private String link;
    @SerializedName("url")
    private String url;

    public Image(){ }

    public Image setTitle(String title){
        this.title = title;
        return this;
    }
    public String getTitle(){
        return this.title;
    }
    public Image setWidth(String width){
        this.width = width;
        return this;
    }
    public String getWidth(){
        return this.width;
    }
    public Image setHeight(String height){
        this.height = height;
        return this;
    }
    public String getHeight(){
        return this.height;
    }
    public Image setLink(String link){
        this.link = link;
        return this;
    }
    public String getLink(){
        return this.link;
    }
    public Image setUrl(String url){
        this.url = url;
        return this;
    }
    public String getUrl(){
        return this.url;
    }
}

