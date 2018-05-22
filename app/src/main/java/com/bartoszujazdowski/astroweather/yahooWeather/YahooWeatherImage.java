package com.bartoszujazdowski.astroweather.yahooWeather;

import android.graphics.Bitmap;

import io.realm.RealmObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YahooWeatherImage extends RealmObject{
    private Integer code;
    private byte[] bitmap;
}
