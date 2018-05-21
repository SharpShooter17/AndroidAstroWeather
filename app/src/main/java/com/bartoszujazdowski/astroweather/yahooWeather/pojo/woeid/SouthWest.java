
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SouthWest {

    private String latitude;
    private String longitude;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SouthWest() {
    }

    /**
     * 
     * @param longitude
     * @param latitude
     */
    public SouthWest(String latitude, String longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("latitude", latitude).append("longitude", longitude).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(longitude).append(latitude).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SouthWest) == false) {
            return false;
        }
        SouthWest rhs = ((SouthWest) other);
        return new EqualsBuilder().append(longitude, rhs.longitude).append(latitude, rhs.latitude).isEquals();
    }

}
