package com.bartoszujazdowski.astroweather.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.bartoszujazdowski.astroweather.Helpers.Updater;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;

/**
 * Created by Bartosz Ujazdowski on 20.04.2018.
 */

public class Settings extends Activity {
    private EditText refreshFrequencyInpt;
    private Switch unitsSwitch;

    private EditText cityInput;
    private EditText ccInput;

    private Button addToFavButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        this.refreshFrequencyInpt = (EditText) findViewById(R.id.refreshFrequencyInput);
        this.unitsSwitch = (Switch) findViewById(R.id.unitsSwitch);
        this.cityInput = (EditText) findViewById(R.id.cityEditText);
        this.ccInput = (EditText) findViewById(R.id.CCEditText);
        this.addToFavButton = (Button) findViewById(R.id.addToFavButton);

        this.refreshFrequencyInpt.setText( SettingsSingleton.getInstance().getRefreshFrequency().toString() );

        this.refreshFrequencyInpt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    SettingsSingleton.getInstance().setRefreshFrequency(Integer.parseInt(s.toString()));
                    Updater.getInstance().setInterval(Integer.parseInt(s.toString()) * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        this.unitsSwitch.setChecked( UNITS.Celsius == SettingsSingleton.getInstance().getUnits() ? true : false );

        this.unitsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SettingsSingleton.getInstance().setUnits( isChecked ? UNITS.Celsius : UNITS.Fahrenheit );
            }
        });

        addToFavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsSingleton.getInstance().addFavouriteLocation(cityInput.getText().toString(), ccInput.getText().toString());

                CharSequence msg = "City has been added to favourites";
                Toast.makeText(Settings.this, msg, Toast.LENGTH_LONG).show();

                cityInput.setText("");
                ccInput.setText("");
            }
        });
    }
}
