package com.bartoszujazdowski.astroweather.yahooWeather;

import android.os.AsyncTask;

import com.bartoszujazdowski.astroweather.yahooWeather.enums.LOCATION;
import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.YahooWeatherData;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class YahooWeatherService extends AsyncTask<String, Void, Channel> {

    private static final String base_URL= "https://query.yahooapis.com/v1/public/yql?format=json&q=";

    private UNITS units;
    private String queryLocation;
    private LOCATION location;

    private YahooWeatherService(UNITS units){
        this.units = units;
    }

    public YahooWeatherService(UNITS units, String text){
        this(units);
        this.location = LOCATION.TEXT;
        this.queryLocation = text;
    }

    public YahooWeatherService(UNITS units, Integer woeid){
        this(units);
        this.location = LOCATION.WOEID;
        this.queryLocation = woeid.toString();
    }

    private String generateUrl(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from weather.forecast where woeid");

        if ( location == LOCATION.WOEID ){
            stringBuilder.append("=");
            stringBuilder.append(this.queryLocation);
        } else {
            stringBuilder.append(" in (select woeid from geo.places(1) where text=\"");
            stringBuilder.append(this.queryLocation);
            stringBuilder.append("\")");
        }

        stringBuilder.append(" and u=\"");
        stringBuilder.append(units);
        stringBuilder.append("\"");

        return base_URL + URLEncoder.encode(stringBuilder.toString());
    }

    @Override
    protected Channel doInBackground(String... strings) {
        try {
            URL url = new URL(  this.generateUrl());
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
