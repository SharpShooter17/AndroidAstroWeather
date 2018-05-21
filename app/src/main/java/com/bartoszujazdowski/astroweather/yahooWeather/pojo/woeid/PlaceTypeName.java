
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PlaceTypeName {

    private String code;
    private String content;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlaceTypeName() {
    }

    /**
     * 
     * @param content
     * @param code
     */
    public PlaceTypeName(String code, String content) {
        super();
        this.code = code;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("content", content).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(content).append(code).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlaceTypeName) == false) {
            return false;
        }
        PlaceTypeName rhs = ((PlaceTypeName) other);
        return new EqualsBuilder().append(content, rhs.content).append(code, rhs.code).isEquals();
    }

}
