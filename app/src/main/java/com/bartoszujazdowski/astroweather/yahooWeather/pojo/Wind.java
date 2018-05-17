
package com.bartoszujazdowski.astroweather.yahooWeather.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Wind implements Serializable
{

    @SerializedName("chill")
    @Expose
    private String chill;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("speed")
    @Expose
    private String speed;
    private final static long serialVersionUID = 1558783989287028062L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Wind() {
    }

    /**
     * 
     * @param speed
     * @param direction
     * @param chill
     */
    public Wind(String chill, String direction, String speed) {
        super();
        this.chill = chill;
        this.direction = direction;
        this.speed = speed;
    }

    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public Wind withChill(String chill) {
        this.chill = chill;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Wind withDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Wind withSpeed(String speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("chill", chill).append("direction", direction).append("speed", speed).toString();
    }

}
