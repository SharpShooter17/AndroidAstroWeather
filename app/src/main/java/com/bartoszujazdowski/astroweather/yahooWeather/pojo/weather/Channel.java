
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Channel {

    private Units units;
    private String title;
    private String link;
    private String description;
    private String language;
    private String lastBuildDate;
    private String ttl;
    private Location location;
    private Wind wind;
    private Atmosphere atmosphere;
    private Astronomy astronomy;
    private Image image;
    private Item item;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Channel() {
    }

    /**
     * 
     * @param wind
     * @param location
     * @param link
     * @param atmosphere
     * @param image
     * @param ttl
     * @param astronomy
     * @param units
     * @param title
     * @param description
     * @param item
     * @param lastBuildDate
     * @param language
     */
    public Channel(Units units, String title, String link, String description, String language, String lastBuildDate, String ttl, Location location, Wind wind, Atmosphere atmosphere, Astronomy astronomy, Image image, Item item) {
        super();
        this.units = units;
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.lastBuildDate = lastBuildDate;
        this.ttl = ttl;
        this.location = location;
        this.wind = wind;
        this.atmosphere = atmosphere;
        this.astronomy = astronomy;
        this.image = image;
        this.item = item;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("units", units).append("title", title).append("link", link).append("description", description).append("language", language).append("lastBuildDate", lastBuildDate).append("ttl", ttl).append("location", location).append("wind", wind).append("atmosphere", atmosphere).append("astronomy", astronomy).append("image", image).append("item", item).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(wind).append(location).append(link).append(image).append(atmosphere).append(ttl).append(astronomy).append(units).append(title).append(description).append(item).append(lastBuildDate).append(language).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Channel) == false) {
            return false;
        }
        Channel rhs = ((Channel) other);
        return new EqualsBuilder().append(wind, rhs.wind).append(location, rhs.location).append(link, rhs.link).append(image, rhs.image).append(atmosphere, rhs.atmosphere).append(ttl, rhs.ttl).append(astronomy, rhs.astronomy).append(units, rhs.units).append(title, rhs.title).append(description, rhs.description).append(item, rhs.item).append(lastBuildDate, rhs.lastBuildDate).append(language, rhs.language).isEquals();
    }

}
