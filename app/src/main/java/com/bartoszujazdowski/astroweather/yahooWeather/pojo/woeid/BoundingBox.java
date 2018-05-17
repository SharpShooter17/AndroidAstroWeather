
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class BoundingBox implements Serializable
{

    @SerializedName("southWest")
    @Expose
    private SouthWest southWest;
    @SerializedName("northEast")
    @Expose
    private NorthEast northEast;
    private final static long serialVersionUID = -8250147860757737928L;

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

}
