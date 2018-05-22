package com.bartoszujazdowski.astroweather.fagments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.bartoszujazdowski.astroweather.AndroidUtils;
import com.bartoszujazdowski.astroweather.Helpers.AstroUtils;
import com.bartoszujazdowski.astroweather.Helpers.FavouriteLocation;
import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.Helpers.Updater;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.activities.Astro;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherService;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.woeid.Place;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InfoFragment extends Fragment implements UpdateI{

    private TextView latitudeInfoText;
    private TextView longitudeInfoText;
    private TextView timeInfoText;
    private Spinner locationSpinner;
    private ArrayAdapter<FavouriteLocation> spinnerArrayAdapter;
    private Button refreshButton;
    private TextView modeTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        this.latitudeInfoText = (TextView) view.findViewById(R.id.latitudeInfoText);
        this.longitudeInfoText = (TextView) view.findViewById(R.id.longitudeInfoText);
        this.timeInfoText = (TextView) view.findViewById(R.id.timeInfo);
        this.locationSpinner = (Spinner) view.findViewById(R.id.loationSpinner);
        this.refreshButton = (Button) view.findViewById(R.id.refreshButton);
        this.modeTextView = (TextView) view.findViewById(R.id.modeTextView);

        this.spinnerArrayAdapter = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, SettingsSingleton.getInstance().getFavouriteLocations());
        this.locationSpinner.setAdapter(this.spinnerArrayAdapter);

        this.refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Updater.getInstance().updateNow();
            }
        });

        this.locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SettingsSingleton.getInstance().getWeatherController().setLocation(spinnerArrayAdapter.getItem(position));
                Updater.getInstance().updateNow();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Updater.getInstance().add(this);

        return view;
    }

    @Override
    public void update(){
        this.modeTextView.setText(AndroidUtils.isOnline() ? "OnLine" : "OffLine");

        try {
            YahooWeatherService yahooWeatherService = SettingsSingleton.getInstance().getWeatherController().getYahooWeatherService();
            Place place = yahooWeatherService.getYahooWeatherDataAndWoeid().getWoeid();
            this.latitudeInfoText.setText( place.getCentroid().getLatitude() );
            this.longitudeInfoText.setText( place.getCentroid().getLongitude() );
            this.timeInfoText.setText(new Date().toString());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        Updater.getInstance().remove(this);
        super.onDestroy();
    }
}