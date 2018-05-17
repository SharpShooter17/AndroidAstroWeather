package com.bartoszujazdowski.astroweather.fagments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bartoszujazdowski.astroweather.Helpers.AstroUtils;
import com.bartoszujazdowski.astroweather.R;
import com.bartoszujazdowski.astroweather.SettingsSingleton;
import com.bartoszujazdowski.astroweather.yahooWeather.YahooWeatherService;
import com.bartoszujazdowski.astroweather.yahooWeather.pojo.weather.Channel;

import java.util.Date;

public class InfoFragment extends Fragment {

    private TextView latitudeInfoText;
    private TextView longitudeInfoText;
    private TextView timeInfoText;

    private Handler handler = new Handler();
    private Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        this.latitudeInfoText = (TextView) view.findViewById(R.id.latitudeInfoText);
        this.longitudeInfoText = (TextView) view.findViewById(R.id.longitudeInfoText);
        this.timeInfoText = (TextView) view.findViewById(R.id.timeInfo);

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

            this.latitudeInfoText.setText( yahooWeatherService.getWoeid().getQuery().getResults().getPlace().getCentroid().getLatitude() );
            this.longitudeInfoText.setText( yahooWeatherService.getWoeid().getQuery().getResults().getPlace().getCentroid().getLongitude() );
            this.timeInfoText.setText(new Date().toString());
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

}
