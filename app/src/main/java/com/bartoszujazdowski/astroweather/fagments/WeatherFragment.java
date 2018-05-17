package com.bartoszujazdowski.astroweather.fagments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.Channel;

public class WeatherFragment extends Fragment implements UpdateI {

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

        this.update();

        return view;
    }

    @Override
    public void update() {
        Channel channel = SettingsSingleton.getInstance().getWeatherController().getChannel();

        if (channel == null) {
            return;
        }
        try {
            this.cityTV.setText(channel.getLocation().getCity());
            this.temperatureTV.setText(channel.getItem().getCondition().getTemp() + channel.getUnits().getTemperature());
            this.pressureTV.setText(channel.getAtmosphere().getPressure() + channel.getUnits().getPressure());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
