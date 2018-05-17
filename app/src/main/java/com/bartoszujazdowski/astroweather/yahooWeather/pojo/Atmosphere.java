
package com.bartoszujazdowski.astroweather.yahooWeather.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Atmosphere implements Serializable
{

    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("rising")
    @Expose
    private String rising;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    private final static long serialVersionUID = -5573105819574844398L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Atmosphere() {
    }

    /**
     * 
     * @param rising
     * @param humidity
     * @param pressure
     * @param visibility
     */
    public Atmosphere(String humidity, String pressure, String rising, String visibility) {
        super();
        this.humidity = humidity;
        this.pressure = pressure;
        this.rising = rising;
        this.visibility = visibility;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Atmosphere withHumidity(String humidity) {
        this.humidity = humidity;
        return this;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public Atmosphere withPressure(String pressure) {
        this.pressure = pressure;
        return this;
    }

    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }

    public Atmosphere withRising(String rising) {
        this.rising = rising;
        return this;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Atmosphere withVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("humidity", humidity).append("pressure", pressure).append("rising", rising).append("visibility", visibility).toString();
    }

}
