package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Guid extends RealmObject {
    public static final String IS_PERMA_LINK = "isPermaLink";

    @SerializedName("isPermaLink")
    private String isPermaLink;

    public Guid(){ }

    public Guid setIsPermaLink(String isPermaLink){
        this.isPermaLink = isPermaLink;
        return this;
    }
    public String getIsPermaLink(){
        return this.isPermaLink;
    }
}

