
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Place implements Serializable
{

    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("xmlns")
    @Expose
    private String xmlns;
    @SerializedName("yahoo")
    @Expose
    private String yahoo;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("woeid")
    @Expose
    private String woeid;
    @SerializedName("placeTypeName")
    @Expose
    private PlaceTypeName placeTypeName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("admin1")
    @Expose
    private Admin1 admin1;
    @SerializedName("admin2")
    @Expose
    private Admin2 admin2;
    @SerializedName("admin3")
    @Expose
    private Object admin3;
    @SerializedName("locality1")
    @Expose
    private Locality1 locality1;
    @SerializedName("locality2")
    @Expose
    private Object locality2;
    @SerializedName("postal")
    @Expose
    private Object postal;
    @SerializedName("centroid")
    @Expose
    private Centroid centroid;
    @SerializedName("boundingBox")
    @Expose
    private BoundingBox boundingBox;
    @SerializedName("areaRank")
    @Expose
    private String areaRank;
    @SerializedName("popRank")
    @Expose
    private String popRank;
    @SerializedName("timezone")
    @Expose
    private Timezone timezone;
    private final static long serialVersionUID = -346152224799834459L;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getYahoo() {
        return yahoo;
    }

    public void setYahoo(String yahoo) {
        this.yahoo = yahoo;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    public PlaceTypeName getPlaceTypeName() {
        return placeTypeName;
    }

    public void setPlaceTypeName(PlaceTypeName placeTypeName) {
        this.placeTypeName = placeTypeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Admin1 getAdmin1() {
        return admin1;
    }

    public void setAdmin1(Admin1 admin1) {
        this.admin1 = admin1;
    }

    public Admin2 getAdmin2() {
        return admin2;
    }

    public void setAdmin2(Admin2 admin2) {
        this.admin2 = admin2;
    }

    public Object getAdmin3() {
        return admin3;
    }

    public void setAdmin3(Object admin3) {
        this.admin3 = admin3;
    }

    public Locality1 getLocality1() {
        return locality1;
    }

    public void setLocality1(Locality1 locality1) {
        this.locality1 = locality1;
    }

    public Object getLocality2() {
        return locality2;
    }

    public void setLocality2(Object locality2) {
        this.locality2 = locality2;
    }

    public Object getPostal() {
        return postal;
    }

    public void setPostal(Object postal) {
        this.postal = postal;
    }

    public Centroid getCentroid() {
        return centroid;
    }

    public void setCentroid(Centroid centroid) {
        this.centroid = centroid;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public String getAreaRank() {
        return areaRank;
    }

    public void setAreaRank(String areaRank) {
        this.areaRank = areaRank;
    }

    public String getPopRank() {
        return popRank;
    }

    public void setPopRank(String popRank) {
        this.popRank = popRank;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("lang", lang).append("xmlns", xmlns).append("yahoo", yahoo).append("uri", uri).append("woeid", woeid).append("placeTypeName", placeTypeName).append("name", name).append("country", country).append("admin1", admin1).append("admin2", admin2).append("admin3", admin3).append("locality1", locality1).append("locality2", locality2).append("postal", postal).append("centroid", centroid).append("boundingBox", boundingBox).append("areaRank", areaRank).append("popRank", popRank).append("timezone", timezone).toString();
    }

}
