
package com.bartoszujazdowski.astroweather.yahooWeather.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class YahooWeatherData implements Serializable
{

    @SerializedName("query")
    @Expose
    private Query query;
    private final static long serialVersionUID = -8016834864484607454L;

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

    public YahooWeatherData withQuery(Query query) {
        this.query = query;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("query", query).toString();
    }

}
