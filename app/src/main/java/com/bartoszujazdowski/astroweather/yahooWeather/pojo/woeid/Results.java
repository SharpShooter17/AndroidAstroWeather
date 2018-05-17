
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Results implements Serializable
{

    @SerializedName("place")
    @Expose
    private Place place;
    private final static long serialVersionUID = -3905389061574436443L;

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("place", place).toString();
    }

}
