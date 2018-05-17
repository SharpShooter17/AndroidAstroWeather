
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Woeid implements Serializable
{

    @SerializedName("query")
    @Expose
    private Query query;
    private final static long serialVersionUID = 663476699955794874L;

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

}
