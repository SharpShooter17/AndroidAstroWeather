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

    private TextView latitudeInfoText;
    private TextView longitudeInfoText;
    private TextView timeInfoText;

    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astro);

        astroStatePageAdapter = new AstroStatePageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(viewPager);

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        this.latitudeInfoText = (TextView) findViewById(R.id.latitudeInfoText);
        this.longitudeInfoText = (TextView) findViewById(R.id.longitudeInfoText);
        this.timeInfoText = (TextView) findViewById(R.id.timeInfo);

        SettingsSingleton.getInstance().update();
        updateInfo();

        this.runnable = new Runnable() {
            @Override
            public void run() {
                updateInfo();
                handler.postDelayed(this, 1000);
            }
        };

        this.handler.postDelayed(this.runnable, 1000);
    }

    private void setupViewPager(ViewPager viewPager){
        AstroStatePageAdapter adapter = new AstroStatePageAdapter(getSupportFragmentManager());
        adapter.addFragment(new SunFragment(), "Sun");
        adapter.addFragment(new MoonFragment(), "Moon");
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

    public void updateInfo(){
        this.latitudeInfoText.setText(SettingsSingleton.getInstance().getLatitude().toString());
        this.longitudeInfoText.setText(SettingsSingleton.getInstance().getLongitude().toString());
        this.timeInfoText.setText(new Date().toString());
    }

}
