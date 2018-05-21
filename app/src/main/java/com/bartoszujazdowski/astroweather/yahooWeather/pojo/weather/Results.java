
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Results {

    private Channel channel;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Results() {
    }

    /**
     * 
     * @param channel
     */
    public Results(Channel channel) {
        super();
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("channel", channel).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(channel).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Results) == false) {
            return false;
        }
        Results rhs = ((Results) other);
        return new EqualsBuilder().append(channel, rhs.channel).isEquals();
    }

}
