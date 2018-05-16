package com.bartoszujazdowski.astroweather;

import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.pojo.Channel;

import java.util.concurrent.ExecutionException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherController implements UpdateI {

    private static final String baseUrl = "https://query.yahooapis.com/v1/public/yql?q=";
    private static final String query = "select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=\"nome,%20ak\")&format=json";
    private Channel channel;

    @Override
    public void update() {
        try {
            this.channel = new YahooWeatherService().execute(baseUrl + query).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
