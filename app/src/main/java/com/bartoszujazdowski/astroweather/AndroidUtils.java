package com.bartoszujazdowski.astroweather;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bartoszujazdowski.astroweather.activities.Menu;

public class AndroidUtils {
    static public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) Menu.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
