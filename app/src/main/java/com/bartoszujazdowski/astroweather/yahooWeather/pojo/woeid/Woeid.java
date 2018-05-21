package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Woeid {
    public static final String QUERY = "query";

    @SerializedName("query")
    private Query query;

    public Woeid(){ }

    public Woeid setQuery(Query query){
        this.query = query;
        return this;
    }
    public Query getQuery(){
        return this.query;
    }
}

