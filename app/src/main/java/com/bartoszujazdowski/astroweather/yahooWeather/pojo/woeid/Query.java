
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Query {

    private Integer count;
    private String created;
    private String lang;
    private Results results;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Query() {
    }

    /**
     * 
     * @param results
     * @param count
     * @param created
     * @param lang
     */
    public Query(Integer count, String created, String lang, Results results) {
        super();
        this.count = count;
        this.created = created;
        this.lang = lang;
        this.results = results;
    }

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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(results).append(count).append(created).append(lang).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Query) == false) {
            return false;
        }
        Query rhs = ((Query) other);
        return new EqualsBuilder().append(results, rhs.results).append(count, rhs.count).append(created, rhs.created).append(lang, rhs.lang).isEquals();
    }

}
