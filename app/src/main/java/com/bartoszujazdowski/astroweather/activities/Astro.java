package com.bartoszujazdowski.astroweather.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.bartoszujazdowski.astroweather.Helpers.AstroStatePageAdapter;
import com.bartoszujazdowski.astroweather.Helpers.Updater;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.fagments.InfoFragment;
import com.bartoszujazdowski.astroweather.fagments.SunFragment;
import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.Helpers.ZoomOutPageTransformer;
import com.bartoszujazdowski.astroweather.fagments.MoonFragment;
import com.bartoszujazdowski.astroweather.fagments.MoreInfoFragment;
import com.bartoszujazdowski.astroweather.fagments.WeatherForecastFragment;
import com.bartoszujazdowski.astroweather.fagments.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartosz Ujazdowski on 30.04.2018.
 */

public class Astro extends FragmentActivity {

    private ViewPager viewPager;
    private InfoFragment infoFragment;
    private MoonFragment moonFragment;
    private MoreInfoFragment moreInfoFragment;
    private SunFragment sunFragment;
    private WeatherForecastFragment weatherForecastFragment;
    private WeatherFragment weatherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro);
        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        Updater.getInstance().removeAll();

        Updater.getInstance().add(this.infoFragment);
        Updater.getInstance().add(this.moonFragment);
        Updater.getInstance().add(this.sunFragment);
        Updater.getInstance().add(this.moreInfoFragment);
        Updater.getInstance().add(this.weatherForecastFragment);
        Updater.getInstance().add(this.weatherFragment);

        Updater.getInstance().add(SettingsSingleton.getInstance().getWeatherController());
        Updater.getInstance().start();
    }

    private void setupViewPager(ViewPager viewPager){
        AstroStatePageAdapter adapter = new AstroStatePageAdapter(getSupportFragmentManager());

        adapter.addFragment(this.infoFragment = new InfoFragment(), "Info");
        adapter.addFragment(this.sunFragment = new SunFragment(), "Sun");
        adapter.addFragment(this.moonFragment = new MoonFragment(), "Moon");
        adapter.addFragment(this.weatherFragment = new WeatherFragment(), "Weather");
        adapter.addFragment(this.moreInfoFragment = new MoreInfoFragment(), "MoreInfo");
        adapter.addFragment(this.weatherForecastFragment = new WeatherForecastFragment(), "WeatherForecast");

        viewPager.setAdapter(adapter);
    }

    private void setViewPager(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}
