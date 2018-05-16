package com.bartoszujazdowski.astroweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherFragment extends Fragment implements UpdateI{

    private TextView cityTV ;
    private TextView temperatureTV;
    private TextView pressureTV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.weather_fragment, container, false);

        this.cityTV = (TextView) view.findViewById(R.id.cityTextView);
        this.temperatureTV = (TextView) view.findViewById(R.id.temperatureTextView);
        this.pressureTV = (TextView) view.findViewById(R.id.pressureTextView);

        return view;
    }

    @Override
    public void update() {

    }
}
