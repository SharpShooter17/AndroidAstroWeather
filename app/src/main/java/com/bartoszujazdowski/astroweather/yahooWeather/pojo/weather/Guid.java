
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Guid {

    private String isPermaLink;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("isPermaLink", isPermaLink).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(isPermaLink).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Guid) == false) {
            return false;
        }
        Guid rhs = ((Guid) other);
        return new EqualsBuilder().append(isPermaLink, rhs.isPermaLink).isEquals();
    }

}
