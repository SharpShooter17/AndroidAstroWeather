
package com.bartoszujazdowski.astroweather.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Units implements Serializable
{

    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("temperature")
    @Expose
    private String temperature;
    private final static long serialVersionUID = 8865232948330997767L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Units() {
    }

    /**
     * 
     * @param distance
     * @param pressure
     * @param speed
     * @param temperature
     */
    public Units(String distance, String pressure, String speed, String temperature) {
        super();
        this.distance = distance;
        this.pressure = pressure;
        this.speed = speed;
        this.temperature = temperature;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Units withDistance(String distance) {
        this.distance = distance;
        return this;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public Units withPressure(String pressure) {
        this.pressure = pressure;
        return this;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Units withSpeed(String speed) {
        this.speed = speed;
        return this;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Units withTemperature(String temperature) {
        this.temperature = temperature;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("distance", distance).append("pressure", pressure).append("speed", speed).append("temperature", temperature).toString();
    }

}
