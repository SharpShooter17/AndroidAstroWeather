package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Channel extends RealmObject {
    public static final String UNITS = "units";
    public static final String TITLE = "title";
    public static final String LINK = "link";
    public static final String DESCRIPTION = "description";
    public static final String LANGUAGE = "language";
    public static final String LAST_BUILD_DATE = "lastBuildDate";
    public static final String TTL = "ttl";
    public static final String LOCATION = "location";
    public static final String WIND = "wind";
    public static final String ATMOSPHERE = "atmosphere";
    public static final String ASTRONOMY = "astronomy";
    public static final String IMAGE = "image";
    public static final String ITEM = "item";

    @SerializedName("units")
    private Units units;
    @SerializedName("title")
    private String title;
    @SerializedName("link")
    private String link;
    @SerializedName("description")
    private String description;
    @SerializedName("language")
    private String language;
    @SerializedName("lastBuildDate")
    private String lastBuildDate;
    @SerializedName("ttl")
    private String ttl;
    @SerializedName("location")
    private Location location;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("atmosphere")
    private Atmosphere atmosphere;
    @SerializedName("astronomy")
    private Astronomy astronomy;
    @SerializedName("image")
    private Image image;
    @SerializedName("item")
    private Item item;

    public Channel(){ }

    public Channel setUnits(Units units){
        this.units = units;
        return this;
    }
    public Units getUnits(){
        return this.units;
    }
    public Channel setTitle(String title){
        this.title = title;
        return this;
    }
    public String getTitle(){
        return this.title;
    }
    public Channel setLink(String link){
        this.link = link;
        return this;
    }
    public String getLink(){
        return this.link;
    }
    public Channel setDescription(String description){
        this.description = description;
        return this;
    }
    public String getDescription(){
        return this.description;
    }
    public Channel setLanguage(String language){
        this.language = language;
        return this;
    }
    public String getLanguage(){
        return this.language;
    }
    public Channel setLastBuildDate(String lastBuildDate){
        this.lastBuildDate = lastBuildDate;
        return this;
    }
    public String getLastBuildDate(){
        return this.lastBuildDate;
    }
    public Channel setTtl(String ttl){
        this.ttl = ttl;
        return this;
    }
    public String getTtl(){
        return this.ttl;
    }
    public Channel setLocation(Location location){
        this.location = location;
        return this;
    }
    public Location getLocation(){
        return this.location;
    }
    public Channel setWind(Wind wind){
        this.wind = wind;
        return this;
    }
    public Wind getWind(){
        return this.wind;
    }
    public Channel setAtmosphere(Atmosphere atmosphere){
        this.atmosphere = atmosphere;
        return this;
    }
    public Atmosphere getAtmosphere(){
        return this.atmosphere;
    }
    public Channel setAstronomy(Astronomy astronomy){
        this.astronomy = astronomy;
        return this;
    }
    public Astronomy getAstronomy(){
        return this.astronomy;
    }
    public Channel setImage(Image image){
        this.image = image;
        return this;
    }
    public Image getImage(){
        return this.image;
    }
    public Channel setItem(Item item){
        this.item = item;
        return this;
    }
    public Item getItem(){
        return this.item;
    }
}

