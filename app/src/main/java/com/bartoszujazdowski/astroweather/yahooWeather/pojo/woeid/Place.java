package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;

public class Place extends RealmObject {
    public static final String LANG = "lang";
    public static final String XMLNS = "xmlns";
    public static final String YAHOO = "yahoo";
    public static final String URI = "uri";
    public static final String WOEID = "woeid";
    public static final String PLACE_TYPE_NAME = "placeTypeName";
    public static final String NAME = "name";
    public static final String COUNTRY = "country";
    public static final String ADMIN1 = "admin1";
    public static final String ADMIN2 = "admin2";
    public static final String LOCALITY1 = "locality1";
    public static final String POSTAL = "postal";
    public static final String CENTROID = "centroid";
    public static final String BOUNDING_BOX = "boundingBox";
    public static final String AREA_RANK = "areaRank";
    public static final String POP_RANK = "popRank";
    public static final String TIMEZONE = "timezone";

    @SerializedName("lang")
    private String lang;
    @SerializedName("xmlns")
    private String xmlns;
    @SerializedName("yahoo")
    private String yahoo;
    @SerializedName("uri")
    private String uri;
    @SerializedName("woeid")
    private String woeid;
    @SerializedName("placeTypeName")
    private PlaceTypeName placeTypeName;
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private Country country;
    @SerializedName("admin1")
    private Admin1 admin1;
    @SerializedName("admin2")
    private Admin2 admin2;
    @SerializedName("locality1")
    private Locality1 locality1;
    @SerializedName("postal")
    private Postal postal;
    @SerializedName("centroid")
    private Centroid centroid;
    @SerializedName("boundingBox")
    private BoundingBox boundingBox;
    @SerializedName("areaRank")
    private String areaRank;
    @SerializedName("popRank")
    private String popRank;
    @SerializedName("timezone")
    private Timezone timezone;

    public Place(){ }

    public Place setLang(String lang){
        this.lang = lang;
        return this;
    }
    public String getLang(){
        return this.lang;
    }
    public Place setXmlns(String xmlns){
        this.xmlns = xmlns;
        return this;
    }
    public String getXmlns(){
        return this.xmlns;
    }
    public Place setYahoo(String yahoo){
        this.yahoo = yahoo;
        return this;
    }
    public String getYahoo(){
        return this.yahoo;
    }
    public Place setUri(String uri){
        this.uri = uri;
        return this;
    }
    public String getUri(){
        return this.uri;
    }
    public Place setWoeid(String woeid){
        this.woeid = woeid;
        return this;
    }
    public String getWoeid(){
        return this.woeid;
    }
    public Place setPlaceTypeName(PlaceTypeName placeTypeName){
        this.placeTypeName = placeTypeName;
        return this;
    }
    public PlaceTypeName getPlaceTypeName(){
        return this.placeTypeName;
    }
    public Place setName(String name){
        this.name = name;
        return this;
    }
    public String getName(){
        return this.name;
    }
    public Place setCountry(Country country){
        this.country = country;
        return this;
    }
    public Country getCountry(){
        return this.country;
    }
    public Place setAdmin1(Admin1 admin1){
        this.admin1 = admin1;
        return this;
    }
    public Admin1 getAdmin1(){
        return this.admin1;
    }
    public Place setAdmin2(Admin2 admin2){
        this.admin2 = admin2;
        return this;
    }
    public Admin2 getAdmin2(){
        return this.admin2;
    }
    public Place setLocality1(Locality1 locality1){
        this.locality1 = locality1;
        return this;
    }
    public Locality1 getLocality1(){
        return this.locality1;
    }
    public Place setPostal(Postal postal){
        this.postal = postal;
        return this;
    }
    public Postal getPostal(){
        return this.postal;
    }
    public Place setCentroid(Centroid centroid){
        this.centroid = centroid;
        return this;
    }
    public Centroid getCentroid(){
        return this.centroid;
    }
    public Place setBoundingBox(BoundingBox boundingBox){
        this.boundingBox = boundingBox;
        return this;
    }
    public BoundingBox getBoundingBox(){
        return this.boundingBox;
    }
    public Place setAreaRank(String areaRank){
        this.areaRank = areaRank;
        return this;
    }
    public String getAreaRank(){
        return this.areaRank;
    }
    public Place setPopRank(String popRank){
        this.popRank = popRank;
        return this;
    }
    public String getPopRank(){
        return this.popRank;
    }
    public Place setTimezone(Timezone timezone){
        this.timezone = timezone;
        return this;
    }
    public Timezone getTimezone(){
        return this.timezone;
    }
}

