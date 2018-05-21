
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Item {

    private String title;
    private String lat;
    private String _long;
    private String link;
    private String pubDate;
    private Condition condition;
    private List<Forecast> forecast = null;
    private String description;
    private Guid guid;

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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("lat", lat).append("_long", _long).append("link", link).append("pubDate", pubDate).append("condition", condition).append("forecast", forecast).append("description", description).append("guid", guid).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(guid).append(pubDate).append(title).append(_long).append(forecast).append(condition).append(description).append(link).append(lat).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(guid, rhs.guid).append(pubDate, rhs.pubDate).append(title, rhs.title).append(_long, rhs._long).append(forecast, rhs.forecast).append(condition, rhs.condition).append(description, rhs.description).append(link, rhs.link).append(lat, rhs.lat).isEquals();
    }

}
