
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Forecast {

    private String code;
    private String date;
    private String day;
    private String high;
    private String low;
    private String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Forecast() {
    }

    /**
     * 
     * @param text
     * @param high
     * @param day
     * @param code
     * @param low
     * @param date
     */
    public Forecast(String code, String date, String day, String high, String low, String text) {
        super();
        this.code = code;
        this.date = date;
        this.day = day;
        this.high = high;
        this.low = low;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("date", date).append("day", day).append("high", high).append("low", low).append("text", text).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(high).append(day).append(code).append(low).append(date).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Forecast) == false) {
            return false;
        }
        Forecast rhs = ((Forecast) other);
        return new EqualsBuilder().append(text, rhs.text).append(high, rhs.high).append(day, rhs.day).append(code, rhs.code).append(low, rhs.low).append(date, rhs.date).isEquals();
    }

}
