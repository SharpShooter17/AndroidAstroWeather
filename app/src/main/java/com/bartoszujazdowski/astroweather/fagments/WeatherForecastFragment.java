package com.bartoszujazdowski.astroweather.fagments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.Helpers.UpdateI;

public class WeatherForecastFragment extends Fragment implements UpdateI {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.weather_forecast_fragment, container, false);
        return view;
    }

    @Override
    public void update() {

    }
}
