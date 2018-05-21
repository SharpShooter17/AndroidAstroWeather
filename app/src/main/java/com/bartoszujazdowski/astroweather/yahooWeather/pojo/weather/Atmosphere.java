
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Atmosphere {

    private String humidity;
    private String pressure;
    private String rising;
    private String visibility;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Atmosphere() {
    }

    /**
     * 
     * @param rising
     * @param humidity
     * @param pressure
     * @param visibility
     */
    public Atmosphere(String humidity, String pressure, String rising, String visibility) {
        super();
        this.humidity = humidity;
        this.pressure = pressure;
        this.rising = rising;
        this.visibility = visibility;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("humidity", humidity).append("pressure", pressure).append("rising", rising).append("visibility", visibility).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rising).append(humidity).append(pressure).append(visibility).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Atmosphere) == false) {
            return false;
        }
        Atmosphere rhs = ((Atmosphere) other);
        return new EqualsBuilder().append(rising, rhs.rising).append(humidity, rhs.humidity).append(pressure, rhs.pressure).append(visibility, rhs.visibility).isEquals();
    }

}
