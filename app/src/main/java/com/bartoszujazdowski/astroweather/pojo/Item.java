
package com.bartoszujazdowski.astroweather.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Item implements Serializable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("pubDate")
    @Expose
    private String pubDate;
    @SerializedName("condition")
    @Expose
    private Condition condition;
    @SerializedName("forecast")
    @Expose
    private List<Forecast> forecast = new ArrayList<Forecast>();
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("guid")
    @Expose
    private Guid guid;
    private final static long serialVersionUID = -1236160832392931181L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param guid
     * @param pubDate
     * @param title
     * @param _long
     * @param forecast
     * @param condition
     * @param description
     * @param link
     * @param lat
     */
    public Item(String title, String lat, String _long, String link, String pubDate, Condition condition, List<Forecast> forecast, String description, Guid guid) {
        super();
        this.title = title;
        this.lat = lat;
        this._long = _long;
        this.link = link;
        this.pubDate = pubDate;
        this.condition = condition;
        this.forecast = forecast;
        this.description = description;
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Item withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Item withLat(String lat) {
        this.lat = lat;
        return this;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public Item withLong(String _long) {
        this._long = _long;
        return this;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Item withLink(String link) {
        this.link = link;
        return this;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Item withPubDate(String pubDate) {
        this.pubDate = pubDate;
        return this;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Item withCondition(Condition condition) {
        this.condition = condition;
        return this;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public Item withForecast(List<Forecast> forecast) {
        this.forecast = forecast;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item withDescription(String description) {
        this.description = description;
        return this;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public Item withGuid(Guid guid) {
        this.guid = guid;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("lat", lat).append("_long", _long).append("link", link).append("pubDate", pubDate).append("condition", condition).append("forecast", forecast).append("description", description).append("guid", guid).toString();
    }

}
