package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Results {
    public static final String CHANNEL = "channel";

    @SerializedName("channel")
    private Channel channel;

    public Results(){ }

    public Results setChannel(Channel channel){
        this.channel = channel;
        return this;
    }
    public Channel getChannel(){
        return this.channel;
    }
}

