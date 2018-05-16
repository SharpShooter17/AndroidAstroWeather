
package com.bartoszujazdowski.astroweather.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Astronomy implements Serializable
{

    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("sunset")
    @Expose
    private String sunset;
    private final static long serialVersionUID = 1183162884409807436L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Astronomy() {
    }

    /**
     * 
     * @param sunset
     * @param sunrise
     */
    public Astronomy(String sunrise, String sunset) {
        super();
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public Astronomy withSunrise(String sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Astronomy withSunset(String sunset) {
        this.sunset = sunset;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sunrise", sunrise).append("sunset", sunset).toString();
    }

}
