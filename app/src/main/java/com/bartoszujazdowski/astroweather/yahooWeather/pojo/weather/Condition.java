
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Condition {

    private String code;
    private String date;
    private String temp;
    private String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Condition() {
    }

    /**
     * 
     * @param text
     * @param temp
     * @param code
     * @param date
     */
    public Condition(String code, String date, String temp, String text) {
        super();
        this.code = code;
        this.date = date;
        this.temp = temp;
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

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("date", date).append("temp", temp).append("text", text).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(text).append(temp).append(code).append(date).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Condition) == false) {
            return false;
        }
        Condition rhs = ((Condition) other);
        return new EqualsBuilder().append(text, rhs.text).append(temp, rhs.temp).append(code, rhs.code).append(date, rhs.date).isEquals();
    }

}
