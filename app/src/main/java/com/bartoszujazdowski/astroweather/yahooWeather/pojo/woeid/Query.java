package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Query {
    public static final String COUNT = "count";
    public static final String CREATED = "created";
    public static final String LANG = "lang";
    public static final String RESULTS = "results";

    @SerializedName("count")
    private int count;
    @SerializedName("created")
    private String created;
    @SerializedName("lang")
    private String lang;
    @SerializedName("results")
    private Results results;

    public Query(){ }

    public Query setCount(int count){
        this.count = count;
        return this;
    }
    public int getCount(){
        return this.count;
    }
    public Query setCreated(String created){
        this.created = created;
        return this;
    }
    public String getCreated(){
        return this.created;
    }
    public Query setLang(String lang){
        this.lang = lang;
        return this;
    }
    public String getLang(){
        return this.lang;
    }
    public Query setResults(Results results){
        this.results = results;
        return this;
    }
    public Results getResults(){
        return this.results;
    }
}

