package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class BoundingBox extends RealmObject {
    public static final String SOUTH_WEST = "southWest";
    public static final String NORTH_EAST = "northEast";

    @SerializedName("southWest")
    private SouthWest southWest;
    @SerializedName("northEast")
    private NorthEast northEast;

    public BoundingBox(){ }

    public BoundingBox setSouthWest(SouthWest southWest){
        this.southWest = southWest;
        return this;
    }
    public SouthWest getSouthWest(){
        return this.southWest;
    }
    public BoundingBox setNorthEast(NorthEast northEast){
        this.northEast = northEast;
        return this;
    }
    public NorthEast getNorthEast(){
        return this.northEast;
    }
}

