package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class YahooWeatherData {
    public static final String QUERY = "query";

    @SerializedName("query")
    private Query query;

    public YahooWeatherData(){ }

    public YahooWeatherData setQuery(Query query){
        this.query = query;
        return this;
    }
    public Query getQuery(){
        return this.query;
    }
}

