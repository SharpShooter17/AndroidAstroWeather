package com.bartoszujazdowski.astroweather.Helpers;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;

import com.astrocalculator.AstroCalculator;
import com.astrocalculator.AstroDateTime;
import com.google.android.gms.location.LocationServices;

import java.util.Calendar;
import java.util.Date;

public class AstroUtils {

    private static final String directions[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    public static AstroDateTime getCurrentAstroDateTime() {
        Date currentTime = Calendar.getInstance().getTime();

        AstroDateTime astroDateTime = new AstroDateTime();

        astroDateTime.setDay(currentTime.getDate());
        astroDateTime.setMonth(currentTime.getMonth() + 1);
        astroDateTime.setYear(currentTime.getYear() + 1900);
        astroDateTime.setSecond(currentTime.getSeconds());
        astroDateTime.setMinute(currentTime.getMinutes());
        astroDateTime.setHour(currentTime.getHours());
        astroDateTime.setTimezoneOffset( 1 );
        astroDateTime.setDaylightSaving(true);

        return astroDateTime;
    }

    public static Date converAstroDateTimeToDate(AstroDateTime astroDateTime) {
        return new Date(astroDateTime.getYear() - 1900, astroDateTime.getMonth() - 1, astroDateTime.getDay(), astroDateTime.getHour(), astroDateTime.getMinute(), astroDateTime.getSecond());
    }

    public static AstroCalculator.Location getCurrentAstroLocation(Context context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return new AstroCalculator.Location(0,0);
        }
        Location location = LocationServices.getFusedLocationProviderClient(context).getLastLocation().getResult();

        return new AstroCalculator.Location(location.getLatitude(), location.getLongitude());
    }

    public static String getWindDirection(int dir){
        return AstroUtils.directions[ (int)Math.round((  ((double)dir % 360) / 45)) % 8 ];
    }

}
