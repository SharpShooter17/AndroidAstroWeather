package com.bartoszujazdowski.astroweather.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.bartoszujazdowski.astroweather.Helpers.Updater;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;

public class AstroTablet extends FragmentActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro);
        Updater.getInstance().add(SettingsSingleton.getInstance().getWeatherController());
        Updater.getInstance().start();
    }

    @Override
    protected void onDestroy() {
        Updater.getInstance().remove(SettingsSingleton.getInstance().getWeatherController());
        Updater.getInstance().stop();
        super.onDestroy();
    }
}
