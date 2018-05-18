package com.bartoszujazdowski.astroweather.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.bartoszujazdowski.astroweather.Helpers.CustomTextWatcher;
import com.bartoszujazdowski.astroweather.Helpers.FavouriteLocation;
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

        this.refreshFrequencyInpt.addTextChangedListener( new CustomTextWatcher<>( SettingsSingleton.getInstance().getRefreshFrequency() ) );

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
                FavouriteLocation favouriteLocation = new FavouriteLocation(cityInput.getText().toString(), ccInput.getText().toString());
                SettingsSingleton.getInstance().getFavouriteLocations().add(favouriteLocation);

                CharSequence msg = "City has been added to favourites";
                Toast.makeText(Settings.this, msg, Toast.LENGTH_LONG).show();
                cityInput.setText("");
                ccInput.setText("");
            }
        });
    }
}
