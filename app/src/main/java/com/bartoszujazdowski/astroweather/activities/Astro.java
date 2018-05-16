package com.bartoszujazdowski.astroweather.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.bartoszujazdowski.astroweather.Helpers.AstroStatePageAdapter;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
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

    private AstroStatePageAdapter astroStatePageAdapter;
    private ViewPager viewPager;

    private Handler handler = new Handler();
    private Runnable runnable;

    private List<UpdateI> updateIList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateIList = new ArrayList<>();

        setContentView(R.layout.activity_astro);

        astroStatePageAdapter = new AstroStatePageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(viewPager);

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        updateIList.add(SettingsSingleton.getInstance().getWeatherController());

        this.runnable = new Runnable() {
            @Override
            public void run() {
                for(UpdateI u : updateIList)
                {
                    u.update();
                }
                handler.postDelayed(this, SettingsSingleton.getInstance().getRefreshFrequency().getValue() * 1000);
            }
        };

        handler.postDelayed(runnable, 0);
    }

    private void setupViewPager(ViewPager viewPager){
        AstroStatePageAdapter adapter = new AstroStatePageAdapter(getSupportFragmentManager());

        SunFragment sunFragment = new SunFragment();
        MoonFragment moonFragment = new MoonFragment();
        WeatherFragment weatherFragment = new WeatherFragment();
        MoreInfoFragment moreInfoFragment = new MoreInfoFragment();
        WeatherForecastFragment weatherForecastFragment = new WeatherForecastFragment();

        adapter.addFragment(sunFragment, "Sun");
        adapter.addFragment(moonFragment, "Moon");
        adapter.addFragment(weatherFragment, "Weather");
        adapter.addFragment(moreInfoFragment, "MoreInfo");
        adapter.addFragment(weatherForecastFragment, "WeatherForecast");

        updateIList.add(sunFragment);
        updateIList.add(moonFragment);
        updateIList.add(weatherFragment);
        updateIList.add(weatherForecastFragment);
        updateIList.add(moreInfoFragment);

        viewPager.setAdapter(adapter);
    }

    private void setViewPager(int fragmentNumber){
        viewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}
