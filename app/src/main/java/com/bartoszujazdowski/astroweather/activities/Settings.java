package com.bartoszujazdowski.astroweather.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.bartoszujazdowski.astroweather.Helpers.CustomTextWatcher;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;

/**
 * Created by Bartosz Ujazdowski on 20.04.2018.
 */

public class Settings extends Activity {
    private EditText latitudeInput;
    private EditText longitudeInput;
    private EditText refreshFrequencyInpt;
    private Switch unitsSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        this.refreshFrequencyInpt = (EditText) findViewById(R.id.refreshFrequencyInput);
        this.unitsSwitch = (Switch) findViewById(R.id.unitsSwitch);

        this.refreshFrequencyInpt.setText( SettingsSingleton.getInstance().getRefreshFrequency().toString() );

        this.refreshFrequencyInpt.addTextChangedListener( new CustomTextWatcher<>( SettingsSingleton.getInstance().getRefreshFrequency() ) );

        this.unitsSwitch.setChecked( UNITS.Celsius == SettingsSingleton.getInstance().getUnits() ? true : false );

        this.unitsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SettingsSingleton.getInstance().setUnits( isChecked ? UNITS.Celsius : UNITS.Fahrenheit );
            }
        });

    }
}
