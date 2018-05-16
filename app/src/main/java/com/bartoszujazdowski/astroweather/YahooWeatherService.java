package com.bartoszujazdowski.astroweather;

import android.os.AsyncTask;

import com.bartoszujazdowski.astroweather.pojo.Channel;
import com.bartoszujazdowski.astroweather.pojo.YahooWeatherData;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class YahooWeatherService extends AsyncTask<String, Void, Channel> {
    @Override
    protected Channel doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
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
