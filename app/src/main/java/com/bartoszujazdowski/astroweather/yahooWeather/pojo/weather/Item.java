package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;

public class Item extends RealmObject {
    public static final String TITLE = "title";
    public static final String LAT = "lat";
    public static final String LONG = "long";
    public static final String LINK = "link";
    public static final String PUB_DATE = "pubDate";
    public static final String CONDITION = "condition";
    public static final String FORECAST = "forecast";
    public static final String DESCRIPTION = "description";
    public static final String GUID = "guid";

    @SerializedName("title")
    private String title;
    @SerializedName("lat")
    private String lat;
    @SerializedName("long")
    private String longitiude;
    @SerializedName("link")
    private String link;
    @SerializedName("pubDate")
    private String pubDate;
    @SerializedName("condition")
    private Condition condition;
    @SerializedName("forecast")
    private RealmList<Forecast> forecast;
    @SerializedName("description")
    private String description;
    @SerializedName("guid")
    private Guid guid;

    public Item(){ }

    public Item setTitle(String title){
        this.title = title;
        return this;
    }
    public String getTitle(){
        return this.title;
    }
    public Item setLat(String lat){
        this.lat = lat;
        return this;
    }
    public String getLat(){
        return this.lat;
    }
    public Item setLong(String longitiude){
        this.longitiude = longitiude;
        return this;
    }
    public String getLong(){
        return this.longitiude;
    }
    public Item setLink(String link){
        this.link = link;
        return this;
    }
    public String getLink(){
        return this.link;
    }
    public Item setPubDate(String pubDate){
        this.pubDate = pubDate;
        return this;
    }
    public String getPubDate(){
        return this.pubDate;
    }
    public Item setCondition(Condition condition){
        this.condition = condition;
        return this;
    }
    public Condition getCondition(){
        return this.condition;
    }
    public Item setForecast(RealmList<Forecast> forecast){
        this.forecast = forecast;
        return this;
    }
    public RealmList<Forecast> getForecast(){
        return this.forecast;
    }
    public Item setDescription(String description){
        this.description = description;
        return this;
    }
    public String getDescription(){
        return this.description;
    }
    public Item setGuid(Guid guid){
        this.guid = guid;
        return this;
    }
    public Guid getGuid(){
        return this.guid;
    }
}

