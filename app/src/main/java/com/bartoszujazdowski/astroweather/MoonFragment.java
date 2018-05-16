package com.bartoszujazdowski.astroweather;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.astrocalculator.AstroCalculator;
import com.astrocalculator.AstroDateTime;

public class MoonFragment extends Fragment {

    public static final String TAG = "Moon Fragment";

    private TextView moonRiseText;
    private TextView moonSetText;
    private TextView nextNewMoonText;
    private TextView nextFullMoonText;
    private TextView moonAgeText;
    private TextView moonIlluminationText;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_moon, container, false);

        this.moonRiseText = (TextView) view.findViewById(R.id.moonRiseText);
        this.moonSetText = (TextView) view.findViewById(R.id.moonSetText);
        this.nextNewMoonText = (TextView) view.findViewById(R.id.nextNewMoonText);
        this.nextFullMoonText = (TextView) view.findViewById(R.id.nextFullMoonText);
        this.moonAgeText = (TextView) view.findViewById(R.id.moonAge);
        this.moonIlluminationText = (TextView) view.findViewById(R.id.moonIlluminationText);

        this.update();

        this.runnable = new Runnable() {
            @Override
            public void run() {
                update();
                handler.postDelayed(this, SettingsSingleton.getInstance().getRefreshFrequency().getValue() * 1000);
            }
        };

        this.handler.postDelayed(this.runnable, SettingsSingleton.getInstance().getRefreshFrequency().getValue() * 1000);

        return view;
    }

    public void update(){
        SettingsSingleton.getInstance().update();
        AstroCalculator.MoonInfo moonInfo = SettingsSingleton.getInstance().getAstroCalculator().getMoonInfo();

        this.nextNewMoonText.setText( AstroUtils.converAstroDateTimeToDate(moonInfo.getNextNewMoon()).toString() );
        this.moonRiseText.setText( AstroUtils.converAstroDateTimeToDate( moonInfo.getMoonrise() ).toString() );
        this.moonSetText.setText(  AstroUtils.converAstroDateTimeToDate( moonInfo.getMoonset() ).toString() );
        this.nextFullMoonText.setText(  AstroUtils.converAstroDateTimeToDate( moonInfo.getNextFullMoon() ).toString() );
        this.moonIlluminationText.setText(  String.valueOf( (int)(moonInfo.getIllumination() * 100) ) + "%" );
        this.moonAgeText.setText(  String.valueOf( moonInfo.getAge() ) );

        Toast toast = Toast.makeText(Menu.getContext(), "Update", Toast.LENGTH_SHORT);
        toast.show();
    }
}
