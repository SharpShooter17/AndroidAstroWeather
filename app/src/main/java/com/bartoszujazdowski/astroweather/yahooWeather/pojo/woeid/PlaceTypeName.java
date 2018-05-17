
package com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PlaceTypeName implements Serializable
{

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("content")
    @Expose
    private String content;
    private final static long serialVersionUID = -5627359245265242827L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("code", code).append("content", content).toString();
    }

}
