package com.bartoszujazdowski.astroweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Bartosz Ujazdowski on 30.04.2018.
 */

public class SunFragment extends Fragment {

    public static final String TAG = "Sun Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_sun, container, false);

        return view;
    }
}
