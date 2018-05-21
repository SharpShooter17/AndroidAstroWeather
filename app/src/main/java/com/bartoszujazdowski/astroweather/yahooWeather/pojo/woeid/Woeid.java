
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Woeid {

    private Query query;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Woeid() {
    }

    /**
     * 
     * @param query
     */
    public Woeid(Query query) {
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
        if ((other instanceof Woeid) == false) {
            return false;
        }
        Woeid rhs = ((Woeid) other);
        return new EqualsBuilder().append(query, rhs.query).isEquals();
    }

}
