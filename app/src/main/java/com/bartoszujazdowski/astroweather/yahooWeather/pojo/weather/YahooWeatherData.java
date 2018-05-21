
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class YahooWeatherData {

    private Query query;

    /**
     * No args constructor for use in serialization
     * 
     */
    public YahooWeatherData() {
    }

    /**
     * 
     * @param query
     */
    public YahooWeatherData(Query query) {
        super();
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("query", query).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(query).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof YahooWeatherData) == false) {
            return false;
        }
        YahooWeatherData rhs = ((YahooWeatherData) other);
        return new EqualsBuilder().append(query, rhs.query).isEquals();
    }

}
