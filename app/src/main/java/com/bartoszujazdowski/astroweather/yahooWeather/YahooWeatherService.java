package com.bartoszujazdowski.astroweather.yahooWeather;

import android.os.AsyncTask;

import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.YahooWeatherDataAndWoeid;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.YahooWeatherData;

import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Centroid;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Place;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Woeid;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import lombok.Getter;
import lombok.Setter;

public class YahooWeatherService extends AsyncTask<Void, Void, Void> {

    private static final String base_URL = "https://query.yahooapis.com/v1/public/yql?format=json&q=";
    private static final String base_image_URL = "https://s.yimg.com/zz/combo?a/i/us/nws/weather/gr/";

    @Getter
    @Setter
    private YahooWeatherDataAndWoeid yahooWeatherDataAndWoeid = new YahooWeatherDataAndWoeid();

    private String woeidUrl;
    private String weatherUrl;

    private UNITS units;

    private YahooWeatherService(UNITS units){
        this.units = units;
    }

    public YahooWeatherService(UNITS units, String text){
        this(units);
        this.weatherUrl = generateWeatherUrl(text);
        this.woeidUrl = generateWoeidUrl(text);
    }

    public YahooWeatherService(UNITS units, Integer woeid){
        this(units);
        this.woeidUrl = generateWoeidUrl(woeid);
        this.weatherUrl = generateWeatherUrl(woeid);
    }

    private String generateWoeidUrl(String text){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from geo.places(1) where text=\"");
        stringBuilder.append(text);
        stringBuilder.append("\"");
        return base_URL + URLEncoder.encode(stringBuilder.toString());
    }

    private String generateWoeidUrl(Integer woeid){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from geo.places(1) where woeid=");
        stringBuilder.append(woeid);
        return base_URL + URLEncoder.encode(stringBuilder.toString());
    }

    private String generateWeatherUrl(String text){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"");
        stringBuilder.append(text);
        stringBuilder.append("\") and u=\"");
        stringBuilder.append(units);
        stringBuilder.append("\"");
        return base_URL + URLEncoder.encode(stringBuilder.toString());
    }

    private String generateWeatherUrl(Integer woeid ){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from weather.forecast where woeid=");
        stringBuilder.append(woeid);
        stringBuilder.append(" and u=\"");
        stringBuilder.append(units);
        return base_URL + URLEncoder.encode(stringBuilder.toString());
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL( this.weatherUrl );
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(urlConnection.getInputStream() ));
            YahooWeatherData yahooWeatherData = new Gson().fromJson(bufferedReader, YahooWeatherData.class);

            if ( yahooWeatherData.getQuery().getCount() == 0 ){
                this.yahooWeatherDataAndWoeid.setWoeid(null);
                this.yahooWeatherDataAndWoeid.setYahooWeatherData(null);
                return null;
            }

            this.yahooWeatherDataAndWoeid.setYahooWeatherData(yahooWeatherData.getQuery().getResults().getChannel());

            url = new URL( this.woeidUrl );
            urlConnection = url.openConnection();
            bufferedReader = new BufferedReader( new InputStreamReader(urlConnection.getInputStream() ));
            this.yahooWeatherDataAndWoeid.setWoeid(new Gson().fromJson(bufferedReader, Woeid.class).getQuery().getResults().getPlace());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
