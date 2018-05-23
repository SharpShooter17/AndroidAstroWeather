package com.bartoszujazdowski.astroweather.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.Helpers.Updater;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;


public class AstroTablet extends FragmentActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro);

        Updater.getInstance().removeAll();
        Updater.getInstance().add(SettingsSingleton.getInstance().getWeatherController());

        for (Fragment f : this.getSupportFragmentManager().getFragments()){
            Updater.getInstance().add((UpdateI) f);
        }

        Updater.getInstance().start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Updater.getInstance().removeAll();
        Updater.getInstance().stop();
    }
}
