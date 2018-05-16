package com.bartoszujazdowski.astroweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MoreInfoFragment extends Fragment {

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

        return view;
    }

}
