package com.bartoszujazdowski.astroweather;

import android.app.Application;

import com.astrocalculator.AstroCalculator;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bartosz Ujazdowski on 20.04.2018.
 */

public class SettingsSingleton {

    /** Szerokość geograficzna */
    @Setter
    @Getter
    private MutableNumber<Float> latitude;

    /** Długość geograficzna */
    @Setter
    @Getter
    private MutableNumber<Float> longitude;

    @Setter
    @Getter
    private MutableNumber<Integer> refreshFrequency;

    @Getter
    private static SettingsSingleton instance = new SettingsSingleton();

    @Getter
    private AstroCalculator astroCalculator;

    private SettingsSingleton(){
        AstroCalculator.Location location = AstroUtils.getCurrentAstroLocation(Menu.getContext());

        this.latitude = new MutableNumber<>(new Float(location.getLatitude()));
        this.longitude =  new MutableNumber<>(new Float(location.getLongitude()));
        this.refreshFrequency = new MutableNumber<>(new Integer(60));

        this.astroCalculator = new AstroCalculator(AstroUtils.getCurrentAstroDateTime(), new AstroCalculator.Location(latitude.getValue(), longitude.getValue()));
    }

    public void update(){
        this.astroCalculator.setDateTime(AstroUtils.getCurrentAstroDateTime());
        this.astroCalculator.setLocation(new AstroCalculator.Location(this.latitude.getValue().doubleValue(), this.longitude.getValue().doubleValue()));
    }
}
