
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Image {

    private String title;
    private String width;
    private String height;
    private String link;
    private String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param title
     * @param height
     * @param link
     * @param width
     * @param url
     */
    public Image(String title, String width, String height, String link, String url) {
        super();
        this.title = title;
        this.width = width;
        this.height = height;
        this.link = link;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("width", width).append("height", height).append("link", link).append("url", url).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(title).append(height).append(link).append(width).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Image) == false) {
            return false;
        }
        Image rhs = ((Image) other);
        return new EqualsBuilder().append(title, rhs.title).append(height, rhs.height).append(link, rhs.link).append(width, rhs.width).append(url, rhs.url).isEquals();
    }

}
