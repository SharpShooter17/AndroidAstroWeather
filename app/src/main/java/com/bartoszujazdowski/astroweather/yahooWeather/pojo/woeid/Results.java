package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Results {
    public static final String PLACE = "place";

    @SerializedName("place")
    private Place place;

    public Results(){ }

    public Results setPlace(Place place){
        this.place = place;
        return this;
    }
    public Place getPlace(){
        return this.place;
    }
}

