package com.bartoszujazdowski.astroweather.fagments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    private LinearLayout forecastLL;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.weather_forecast_fragment, container, false);

        this.forecastLL = view.findViewById(R.id.forecastLinearLayout);

        this.update();

        return view;
    }

    @Override
    public void update() {
        try {
            List<Forecast> forecastList = SettingsSingleton.getInstance().getWeatherController().getChannel().getItem().getForecast();

            this.forecastLL.removeAllViews();

            for (Forecast forecast : forecastList){
                String str = forecast.getDate() + " - " + forecast.getDay() + " - " + forecast.getLow() + " - " + forecast.getHigh() + ", " + forecast.getText();
                TextView textView = new TextView(this.getContext());
                textView.setText(str);
                textView.setTextSize(COMPLEX_UNIT_SP, 18.0f);
                textView.setPadding(16, 16, 16, 16);
                forecastLL.addView(textView);
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
