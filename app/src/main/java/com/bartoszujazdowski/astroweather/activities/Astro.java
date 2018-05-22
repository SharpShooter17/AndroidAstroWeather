package com.bartoszujazdowski.astroweather.activities;

import android.os.Bundle;
import android.os.Handler;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro);
        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        Updater.getInstance().add(SettingsSingleton.getInstance().getWeatherController());
        Updater.getInstance().start();
    }

    @Override
    protected void onDestroy() {
        Updater.getInstance().remove(SettingsSingleton.getInstance().getWeatherController());
        Updater.getInstance().stop();
        super.onDestroy();
    }

    private void setupViewPager(ViewPager viewPager){
        AstroStatePageAdapter adapter = new AstroStatePageAdapter(getSupportFragmentManager());

        adapter.addFragment(new InfoFragment(), "Info");
        adapter.addFragment(new SunFragment(), "Sun");
        adapter.addFragment(new MoonFragment(), "Moon");
        adapter.addFragment(new WeatherFragment(), "Weather");
        adapter.addFragment(new MoreInfoFragment(), "MoreInfo");
        adapter.addFragment(new WeatherForecastFragment(), "WeatherForecast");

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
