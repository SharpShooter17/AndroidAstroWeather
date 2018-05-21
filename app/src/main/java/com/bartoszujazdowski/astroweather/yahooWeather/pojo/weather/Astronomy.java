
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Astronomy {

    private String sunrise;
    private String sunset;

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

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("sunrise", sunrise).append("sunset", sunset).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sunset).append(sunrise).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Astronomy) == false) {
            return false;
        }
        Astronomy rhs = ((Astronomy) other);
        return new EqualsBuilder().append(sunset, rhs.sunset).append(sunrise, rhs.sunrise).isEquals();
    }

}
