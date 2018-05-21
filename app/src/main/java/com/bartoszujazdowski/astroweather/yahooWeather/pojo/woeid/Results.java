
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Results {

    private Place place;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Results() {
    }

    /**
     * 
     * @param place
     */
    public Results(Place place) {
        super();
        this.place = place;
    }

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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(place).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Results) == false) {
            return false;
        }
        Results rhs = ((Results) other);
        return new EqualsBuilder().append(place, rhs.place).isEquals();
    }

}
