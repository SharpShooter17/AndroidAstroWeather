package com.bartoszujazdowski.astroweather.fagments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartoszujazdowski.astroweather.Helpers.AstroUtils;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.YahooWeatherDataAndWoeid;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.YahooWeatherData;

public class MoreInfoFragment extends Fragment implements UpdateI {

    private TextView windForceTV;
    private TextView windDirectionTV;
    private TextView humidityTV;
    private TextView visabilityTV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.more_info_fragment, container, false);

        this.windForceTV = view.findViewById(R.id.windForceTextView);
        this.windDirectionTV = view.findViewById(R.id.windDirectionTextView);
        this.humidityTV = view.findViewById(R.id.humidityTextView);
        this.visabilityTV = view.findViewById(R.id.visabilityTextView);

        this.update();

        return view;
    }

    @Override
    public void update() {
        try {
            YahooWeatherDataAndWoeid yahooWeatherDataAndWoeid = SettingsSingleton.getInstance().getWeatherController().getYahooWeatherService().getYahooWeatherDataAndWoeid();

            if (yahooWeatherDataAndWoeid.getYahooWeatherData() == null){
                return;
            }

            this.humidityTV.setText(yahooWeatherDataAndWoeid.getYahooWeatherData().getAtmosphere().getHumidity() + "%");
            this.visabilityTV.setText(yahooWeatherDataAndWoeid.getYahooWeatherData().getAtmosphere().getVisibility() + yahooWeatherDataAndWoeid.getYahooWeatherData().getUnits().getDistance());
            this.windDirectionTV.setText(AstroUtils.getWindDirection( Integer.parseInt(yahooWeatherDataAndWoeid.getYahooWeatherData().getWind().getDirection()) ));
            this.windForceTV.setText(yahooWeatherDataAndWoeid.getYahooWeatherData().getWind().getSpeed() + yahooWeatherDataAndWoeid.getYahooWeatherData().getUnits().getSpeed());
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
