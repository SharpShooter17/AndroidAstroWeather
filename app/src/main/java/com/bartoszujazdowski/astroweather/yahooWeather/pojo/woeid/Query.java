
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Query implements Serializable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("results")
    @Expose
    private Results results;
    private final static long serialVersionUID = 7653840121602876186L;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("count", count).append("created", created).append("lang", lang).append("results", results).toString();
    }

}
