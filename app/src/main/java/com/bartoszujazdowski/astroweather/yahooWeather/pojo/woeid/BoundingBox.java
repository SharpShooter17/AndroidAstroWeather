
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BoundingBox {

    private SouthWest southWest;
    private NorthEast northEast;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BoundingBox() {
    }

    /**
     * 
     * @param southWest
     * @param northEast
     */
    public BoundingBox(SouthWest southWest, NorthEast northEast) {
        super();
        this.southWest = southWest;
        this.northEast = northEast;
    }

    public SouthWest getSouthWest() {
        return southWest;
    }

    public void setSouthWest(SouthWest southWest) {
        this.southWest = southWest;
    }

    public NorthEast getNorthEast() {
        return northEast;
    }

    public void setNorthEast(NorthEast northEast) {
        this.northEast = northEast;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("southWest", southWest).append("northEast", northEast).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(southWest).append(northEast).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BoundingBox) == false) {
            return false;
        }
        BoundingBox rhs = ((BoundingBox) other);
        return new EqualsBuilder().append(southWest, rhs.southWest).append(northEast, rhs.northEast).isEquals();
    }

}
