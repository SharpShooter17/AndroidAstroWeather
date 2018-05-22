package com.bartoszujazdowski.astroweather.fagments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astrocalculator.AstroCalculator;
import com.bartoszujazdowski.astroweather.Helpers.AstroUtils;
import com.bartoszujazdowski.astroweather.Helpers.Updater;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.Helpers.UpdateI;

/**
 * Created by Bartosz Ujazdowski on 30.04.2018.
 */

public class SunFragment extends Fragment implements UpdateI {

    public static final String TAG = "Sun Fragment";

    private TextView sunriseText;
    private TextView sunsetText;
    private TextView civilMorningText;
    private TextView civilEveningText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_sun, container, false);

        this.sunriseText = view.findViewById(R.id.sunriseText);
        this.sunsetText = view.findViewById(R.id.sunsetText);
        this.civilMorningText = view.findViewById(R.id.civilMorningText);
        this.civilEveningText = view.findViewById(R.id.civilEveningText);
        Updater.getInstance().add(this);
        return view;
    }

    @Override
    public void onDestroy() {
        Updater.getInstance().remove(this);
        super.onDestroy();
    }

    @Override
    public void update(){
        SettingsSingleton.getInstance().update();
        try {
            AstroCalculator.SunInfo sunInfo = SettingsSingleton.getInstance().getAstroCalculator().getSunInfo();
            this.sunriseText.setText(AstroUtils.converAstroDateTimeToDate(sunInfo.getSunrise()).toString());
            this.sunsetText.setText(AstroUtils.converAstroDateTimeToDate(sunInfo.getSunset()).toString());
            this.civilMorningText.setText(AstroUtils.converAstroDateTimeToDate(sunInfo.getTwilightMorning()).toString());
            this.civilEveningText.setText(AstroUtils.converAstroDateTimeToDate(sunInfo.getTwilightEvening()).toString());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
}
