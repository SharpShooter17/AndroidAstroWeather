package com.bartoszujazdowski.astroweather.fagments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bartoszujazdowski.astroweather.Helpers.Updater;
import com.bartoszujazdowski.astroweather.ImageController;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.Helpers.UpdateI;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherImageService;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;

import java.util.concurrent.ExecutionException;

public class WeatherFragment extends Fragment implements UpdateI {

    private TextView cityTV ;
    private TextView temperatureTV;
    private TextView pressureTV;
    private ImageView weatherIV;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.weather_fragment, container, false);

        this.cityTV = (TextView) view.findViewById(R.id.cityTextView);
        this.temperatureTV = (TextView) view.findViewById(R.id.temperatureTextView);
        this.pressureTV = (TextView) view.findViewById(R.id.pressureTextView);
        this.weatherIV = (ImageView) view.findViewById(R.id.weatherImageView);

        Updater.getInstance().add(this);
        return view;
    }

    @Override
    public void onDestroy() {
        Updater.getInstance().remove(this);
        super.onDestroy();
    }

    @Override
    public void update() {
        try {
            Channel channel = SettingsSingleton.getInstance().getWeatherController().getYahooWeatherService().getYahooWeatherDataAndWoeid().getYahooWeatherData();
            if (channel == null){
                return;
            }
            this.cityTV.setText(channel.getLocation().getCity());
            this.temperatureTV.setText(channel.getItem().getCondition().getTemp() + channel.getUnits().getTemperature());
            this.pressureTV.setText(channel.getAtmosphere().getPressure() + channel.getUnits().getPressure());
            this.weatherIV.setImageBitmap(ImageController.getImage(Integer.parseInt(channel.getItem().getCondition().getCode())));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
