
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Place {

    private String lang;
    private String xmlns;
    private String yahoo;
    private String uri;
    private String woeid;
    private PlaceTypeName placeTypeName;
    private String name;
    private Country country;
    private Admin1 admin1;
    private Admin2 admin2;
    private Object admin3;
    private Locality1 locality1;
    private Object locality2;
    private Postal postal;
    private Centroid centroid;
    private BoundingBox boundingBox;
    private String areaRank;
    private String popRank;
    private Timezone timezone;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Place() {
    }

    /**
     * 
     * @param locality2
     * @param locality1
     * @param postal
     * @param woeid
     * @param placeTypeName
     * @param xmlns
     * @param lang
     * @param uri
     * @param centroid
     * @param country
     * @param timezone
     * @param boundingBox
     * @param admin3
     * @param admin2
     * @param admin1
     * @param name
     * @param popRank
     * @param areaRank
     * @param yahoo
     */
    public Place(String lang, String xmlns, String yahoo, String uri, String woeid, PlaceTypeName placeTypeName, String name, Country country, Admin1 admin1, Admin2 admin2, Object admin3, Locality1 locality1, Object locality2, Postal postal, Centroid centroid, BoundingBox boundingBox, String areaRank, String popRank, Timezone timezone) {
        super();
        this.lang = lang;
        this.xmlns = xmlns;
        this.yahoo = yahoo;
        this.uri = uri;
        this.woeid = woeid;
        this.placeTypeName = placeTypeName;
        this.name = name;
        this.country = country;
        this.admin1 = admin1;
        this.admin2 = admin2;
        this.admin3 = admin3;
        this.locality1 = locality1;
        this.locality2 = locality2;
        this.postal = postal;
        this.centroid = centroid;
        this.boundingBox = boundingBox;
        this.areaRank = areaRank;
        this.popRank = popRank;
        this.timezone = timezone;
    }

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

    public Postal getPostal() {
        return postal;
    }

    public void setPostal(Postal postal) {
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(locality2).append(locality1).append(postal).append(woeid).append(placeTypeName).append(xmlns).append(uri).append(lang).append(centroid).append(country).append(timezone).append(boundingBox).append(admin3).append(admin2).append(admin1).append(name).append(popRank).append(areaRank).append(yahoo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Place) == false) {
            return false;
        }
        Place rhs = ((Place) other);
        return new EqualsBuilder().append(locality2, rhs.locality2).append(locality1, rhs.locality1).append(postal, rhs.postal).append(woeid, rhs.woeid).append(placeTypeName, rhs.placeTypeName).append(xmlns, rhs.xmlns).append(uri, rhs.uri).append(lang, rhs.lang).append(centroid, rhs.centroid).append(country, rhs.country).append(timezone, rhs.timezone).append(boundingBox, rhs.boundingBox).append(admin3, rhs.admin3).append(admin2, rhs.admin2).append(admin1, rhs.admin1).append(name, rhs.name).append(popRank, rhs.popRank).append(areaRank, rhs.areaRank).append(yahoo, rhs.yahoo).isEquals();
    }

}
