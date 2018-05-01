package com.bartoszujazdowski.astroweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astrocalculator.AstroCalculator;
import com.astrocalculator.AstroDateTime;

public class MoonFragment extends Fragment {

    public static final String TAG = "Moon Fragment";

    private TextView moonAgeText;
    private TextView moonRiseText;
    private TextView moonSetText;
    private TextView moonIlluminationText;
    private TextView nextFullMoonText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_moon, container, false);

        this.moonAgeText = (TextView) view.findViewById(R.id.moonAgeText);
        this.moonRiseText = (TextView) view.findViewById(R.id.moonRiseText);
        this.moonSetText = (TextView) view.findViewById(R.id.moonSetText);
        this.moonIlluminationText = (TextView) view.findViewById(R.id.moonIluminationText);
        this.nextFullMoonText = (TextView) view.findViewById(R.id.nextFullMoonText);

        this.update();

        return view;
    }

    public void update(){
        AstroCalculator.MoonInfo moonInfo = SettingsSingleton.getInstance().getAstroCalculator().getMoonInfo();

        this.moonAgeText.setText( String.valueOf(moonInfo.getAge()) );
        this.moonRiseText.setText( AstroUtils.converAstroDateTimeToDate( moonInfo.getMoonrise() ).toString() );
        this.moonSetText.setText(  AstroUtils.converAstroDateTimeToDate( moonInfo.getMoonset() ).toString() );
        this.moonIlluminationText.setText( String.valueOf(moonInfo.getIllumination()) );
        this.nextFullMoonText.setText(  AstroUtils.converAstroDateTimeToDate( moonInfo.getNextFullMoon() ).toString() );
    }
}
