
package com.bartoszujazdowski.astroweather.yahooWeather.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Guid implements Serializable
{

    @SerializedName("isPermaLink")
    @Expose
    private String isPermaLink;
    private final static long serialVersionUID = 647066481444028700L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Guid() {
    }

    /**
     * 
     * @param isPermaLink
     */
    public Guid(String isPermaLink) {
        super();
        this.isPermaLink = isPermaLink;
    }

    public String getIsPermaLink() {
        return isPermaLink;
    }

    public void setIsPermaLink(String isPermaLink) {
        this.isPermaLink = isPermaLink;
    }

    public Guid withIsPermaLink(String isPermaLink) {
        this.isPermaLink = isPermaLink;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("isPermaLink", isPermaLink).toString();
    }

}
