
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Timezone {

    private String type;
    private String woeid;
    private String content;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Timezone() {
    }

    /**
     * 
     * @param content
     * @param woeid
     * @param type
     */
    public Timezone(String type, String woeid, String content) {
        super();
        this.type = type;
        this.woeid = woeid;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("woeid", woeid).append("content", content).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(content).append(woeid).append(type).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Timezone) == false) {
            return false;
        }
        Timezone rhs = ((Timezone) other);
        return new EqualsBuilder().append(content, rhs.content).append(woeid, rhs.woeid).append(type, rhs.type).isEquals();
    }

}
