package com.bartoszujazdowski.astroweather;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by Bartosz Ujazdowski on 20.04.2018.
 */

public class Settings extends Activity {
    private EditText latitudeInput;
    private EditText longitudeInput;
    private EditText refreshFrequencyInpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        this.latitudeInput = (EditText) findViewById(R.id.latitudeInput);
        this.longitudeInput = (EditText) findViewById(R.id.longitudeInput);
        this.refreshFrequencyInpt = (EditText) findViewById(R.id.refreshFrequencyInput);

        this.latitudeInput.setText( SettingsSingleton.getInstance().getLatitude().toString() );
        this.longitudeInput.setText( SettingsSingleton.getInstance().getLongitude().toString() );
        this.refreshFrequencyInpt.setText( SettingsSingleton.getInstance().getRefreshFrequency().toString() );

        this.latitudeInput.addTextChangedListener(new CustomTextWatcher<>(SettingsSingleton.getInstance().getLatitude()) );
        this.longitudeInput.addTextChangedListener( new CustomTextWatcher<>( SettingsSingleton.getInstance().getLongitude() ) );
        this.refreshFrequencyInpt.addTextChangedListener( new CustomTextWatcher<>( SettingsSingleton.getInstance().getRefreshFrequency() ) );
    }
}
