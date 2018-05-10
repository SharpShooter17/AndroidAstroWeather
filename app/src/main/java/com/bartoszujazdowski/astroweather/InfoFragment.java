package com.bartoszujazdowski.astroweather;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        SettingsSingleton.getInstance().update();

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
        this.latitudeInfoText.setText(SettingsSingleton.getInstance().getLatitude().toString());
        this.longitudeInfoText.setText(SettingsSingleton.getInstance().getLongitude().toString());
        this.timeInfoText.setText( AstroUtils.converAstroDateTimeToDate( AstroUtils.getCurrentAstroDateTime() ).toString() );
    }

}
