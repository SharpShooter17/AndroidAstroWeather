package com.bartoszujazdowski.astroweather.fagments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Forecast;

import java.util.List;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

public class WeatherForecastFragment extends Fragment implements UpdateI {

    private RecyclerView forecastRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.weather_forecast_fragment, container, false);
        this.forecastRecyclerView = view.findViewById(R.id.forecastRecycleView);
        this.forecastRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        this.update();
        return view;
    }

    @Override
    public void update() {
        try {
            if (SettingsSingleton.getInstance().getWeatherController().getYahooWeatherService().getYahooWeatherDataAndWoeid().getYahooWeatherData() == null){
                return;
            }
            List<Forecast> forecastList = SettingsSingleton.getInstance().getWeatherController().getYahooWeatherService().getYahooWeatherDataAndWoeid().getYahooWeatherData().getItem().getForecast();

            ForecastRecyclerAdapter adapter = new ForecastRecyclerAdapter( forecastList, this.getContext() );
            this.forecastRecyclerView.setAdapter(adapter);
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
