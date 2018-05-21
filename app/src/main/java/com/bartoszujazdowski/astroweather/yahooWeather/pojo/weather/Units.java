
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Units {

    private String distance;
    private String pressure;
    private String speed;
    private String temperature;

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

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("distance", distance).append("pressure", pressure).append("speed", speed).append("temperature", temperature).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(distance).append(pressure).append(speed).append(temperature).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Units) == false) {
            return false;
        }
        Units rhs = ((Units) other);
        return new EqualsBuilder().append(distance, rhs.distance).append(pressure, rhs.pressure).append(speed, rhs.speed).append(temperature, rhs.temperature).isEquals();
    }

}
