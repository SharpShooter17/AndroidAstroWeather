
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Location {

    private String city;
    private String country;
    private String region;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param region
     * @param country
     * @param city
     */
    public Location(String city, String country, String region) {
        super();
        this.city = city;
        this.country = country;
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("city", city).append("country", country).append("region", region).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(region).append(country).append(city).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Location) == false) {
            return false;
        }
        Location rhs = ((Location) other);
        return new EqualsBuilder().append(region, rhs.region).append(country, rhs.country).append(city, rhs.city).isEquals();
    }

}
