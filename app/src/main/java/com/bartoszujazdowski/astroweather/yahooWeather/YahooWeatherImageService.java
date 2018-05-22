package com.bartoszujazdowski.astroweather.yahooWeather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class YahooWeatherImageService extends AsyncTask<Integer, Void, Bitmap> {
    private static final String base_URL = "https://s.yimg.com/zz/combo?a/i/us/nws/weather/gr/";
    private static final String night = "n.png";
    private static final String day = "d.png";

    @Override
    protected Bitmap doInBackground(Integer... codes) {
        Bitmap result = null;

        try {
            URL url = new URL( base_URL + codes[0] + day );
            URLConnection urlConnection = url.openConnection();
            return BitmapFactory.decodeStream( urlConnection.getInputStream() );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
