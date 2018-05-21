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

import com.bartoszujazdowski.astroweather.Helpers.AstroUtils;
import com.bartoszujazdowski.astroweather.Helpers.FavouriteLocation;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.activities.Astro;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherService;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InfoFragment extends Fragment {

    private TextView latitudeInfoText;
    private TextView longitudeInfoText;
    private TextView timeInfoText;
    private Spinner locationSpinner;
    private ArrayAdapter<FavouriteLocation> spinnerArrayAdapter;
    private Button refreshButton;

    private Handler handler = new Handler();
    private Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        this.latitudeInfoText = (TextView) view.findViewById(R.id.latitudeInfoText);
        this.longitudeInfoText = (TextView) view.findViewById(R.id.longitudeInfoText);
        this.timeInfoText = (TextView) view.findViewById(R.id.timeInfo);
        this.locationSpinner = (Spinner) view.findViewById(R.id.loationSpinner);
        this.refreshButton = (Button) view.findViewById(R.id.refreshButton);

        this.spinnerArrayAdapter = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, SettingsSingleton.getInstance().getFavouriteLocations());
        this.locationSpinner.setAdapter(this.spinnerArrayAdapter);

        this.refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Astro)getActivity()).updateAllNow();
            }
        });

        this.locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SettingsSingleton.getInstance().getWeatherController().setCity(spinnerArrayAdapter.getItem(position).toString());
                ((Astro)getActivity()).updateAllNow();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        this.runnable = new Runnable() {
            @Override
            public void run() {
                updateInfo();
                handler.postDelayed(this, 1000);
            }
        };

        this.handler.postDelayed(this.runnable, 0);

        return view;
    }

    public void updateInfo(){
        try {
            YahooWeatherService yahooWeatherService = SettingsSingleton.getInstance().getWeatherController().getYahooWeatherService();

            this.latitudeInfoText.setText( yahooWeatherService.getYahooWeatherDataAndWoeid().getWoeid().getQuery().getResults().getPlace().getCentroid().getLatitude() );
            this.longitudeInfoText.setText( yahooWeatherService.getYahooWeatherDataAndWoeid().getWoeid().getQuery().getResults().getPlace().getCentroid().getLongitude() );
            this.timeInfoText.setText(new Date().toString());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

}
