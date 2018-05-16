package com.bartoszujazdowski.astroweather;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Bartosz Ujazdowski on 30.04.2018.
 */

public class Astro extends FragmentActivity {

    private AstroStatePageAdapter astroStatePageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro);

        astroStatePageAdapter = new AstroStatePageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(viewPager);

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
    }

    private void setupViewPager(ViewPager viewPager){
        AstroStatePageAdapter adapter = new AstroStatePageAdapter(getSupportFragmentManager());
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
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}
