
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Wind {

    private String chill;
    private String direction;
    private String speed;

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("chill", chill).append("direction", direction).append("speed", speed).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(speed).append(direction).append(chill).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Wind) == false) {
            return false;
        }
        Wind rhs = ((Wind) other);
        return new EqualsBuilder().append(speed, rhs.speed).append(direction, rhs.direction).append(chill, rhs.chill).isEquals();
    }

}
