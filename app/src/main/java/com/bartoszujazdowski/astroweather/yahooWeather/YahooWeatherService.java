package com.bartoszujazdowski.astroweather.yahooWeather;

import android.os.AsyncTask;

import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.Channel;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.YahooWeatherData;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;

public class YahooWeatherService extends AsyncTask<String, Void, Channel> {

    private static final String base_URL= "https://query.yahooapis.com/v1/public/yql?format=json&q=";

    private UNITS units;
    private Integer woeid;

    public YahooWeatherService(UNITS units, Integer woeid){
        this.units = units;
        this.woeid = woeid;
    }

    @Override
    protected Channel doInBackground(String... strings) {
        String query = "select * from weather.forecast where woeid=" + this.woeid + " and u=\"" + units + "\"";
        try {
            URL url = new URL( base_URL + URLEncoder.encode(query));
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(urlConnection.getInputStream() ));
            return new Gson().fromJson(bufferedReader, YahooWeatherData.class).getQuery().getResults().getChannel();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
