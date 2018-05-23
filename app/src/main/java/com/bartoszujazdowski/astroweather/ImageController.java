package com.bartoszujazdowski.astroweather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherImage;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherImageService;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutionException;

import io.realm.Realm;
import lombok.Getter;

public class ImageController {
    public static Bitmap getImage(Integer code){
        Realm realm = Realm.getDefaultInstance();
        Bitmap result = null;

        YahooWeatherImage yahooWeatherImage = realm.where(YahooWeatherImage.class).equalTo("code", code).findFirst();

        if ( (yahooWeatherImage == null) && AndroidUtils.isOnline()){
            yahooWeatherImage = new YahooWeatherImage();
            yahooWeatherImage.setCode(code);
            try {
                result = new YahooWeatherImageService().execute(code).get();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                result.compress(Bitmap.CompressFormat.PNG, 100, stream);
                yahooWeatherImage.setBitmap(stream.toByteArray());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            realm.beginTransaction();
            yahooWeatherImage = realm.copyToRealm(yahooWeatherImage);
            realm.commitTransaction();
        } else {
            result = BitmapFactory.decodeByteArray(yahooWeatherImage.getBitmap(), 0, yahooWeatherImage.getBitmap().length);
        }

        return result;
    }
}
