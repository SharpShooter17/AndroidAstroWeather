
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Results implements Serializable
{

    @SerializedName("channel")
    @Expose
    private Channel channel;
    private final static long serialVersionUID = 940254204933340267L;

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

    public Results withChannel(Channel channel) {
        this.channel = channel;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("channel", channel).toString();
    }

}
