
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Timezone implements Serializable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("woeid")
    @Expose
    private String woeid;
    @SerializedName("content")
    @Expose
    private String content;
    private final static long serialVersionUID = -2139356786948947339L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("type", type).append("woeid", woeid).append("content", content).toString();
    }

}
