package com.bartoszujazdowski.astroweather;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astrocalculator.AstroCalculator;

/**
 * Created by Bartosz Ujazdowski on 30.04.2018.
 */

public class SunFragment extends Fragment {

    public static final String TAG = "Sun Fragment";

    private TextView sunriseText;
    private TextView sunsetText;
    private TextView civilMorningText;
    private TextView civilEveningText;

    private Handler handler = new Handler();
    private Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_sun, container, false);

        this.sunriseText = view.findViewById(R.id.sunriseText);
        this.sunsetText = view.findViewById(R.id.sunsetText);
        this.civilMorningText = view.findViewById(R.id.civilMorningText);
        this.civilEveningText = view.findViewById(R.id.civilEveningText);

        this.updateInfo();

        this.runnable = new Runnable() {
            @Override
            public void run() {
                updateInfo();
                handler.postDelayed(this, SettingsSingleton.getInstance().getRefreshFrequency().getValue() * 1000);
            }
        };

        this.handler.postDelayed(this.runnable, SettingsSingleton.getInstance().getRefreshFrequency().getValue() * 1000);

        return view;
    }

    public void updateInfo(){
        SettingsSingleton.getInstance().update();
        AstroCalculator.SunInfo sunInfo = SettingsSingleton.getInstance().getAstroCalculator().getSunInfo();

        this.sunriseText.setText( AstroUtils.converAstroDateTimeToDate(sunInfo.getSunrise()).toString() );
        this.sunsetText.setText( AstroUtils.converAstroDateTimeToDate(sunInfo.getSunset()).toString() );
        this.civilMorningText.setText( AstroUtils.converAstroDateTimeToDate(sunInfo.getTwilightMorning()).toString());
        this.civilEveningText.setText( AstroUtils.converAstroDateTimeToDate(sunInfo.getTwilightEvening()).toString() );
    }
}
