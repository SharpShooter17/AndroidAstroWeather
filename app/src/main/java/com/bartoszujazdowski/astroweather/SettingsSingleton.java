package com.bartoszujazdowski.astroweather;

import android.app.Application;

import com.astrocalculator.AstroCalculator;
import com.astrocalculator.AstroDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bartosz Ujazdowski on 20.04.2018.
 */

public class SettingsSingleton {

    static {
        SettingsSingleton.instance = new SettingsSingleton();
    }

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
    private static SettingsSingleton instance;

    @Getter
    private AstroCalculator astroCalculator;

    private SettingsSingleton(){
      //  AstroCalculator.Location location = AstroUtils.getCurrentAstroLocation(Menu.getContext());

        this.latitude = new MutableNumber<>(new Float(0));
        this.longitude =  new MutableNumber<>(new Float(0));
        this.refreshFrequency = new MutableNumber<>(new Integer(60));

       /* this.latitude.setMinimum(-180.0f);
        this.latitude.setMaximum(180.0f);

        this.longitude.setMinimum(-90.0f);
        this.longitude.setMaximum(90.0f);*/

        this.astroCalculator = new AstroCalculator(AstroUtils.getCurrentAstroDateTime(), new AstroCalculator.Location(latitude.getValue(), longitude.getValue()));
    }

    public void update(){
        this.astroCalculator.setDateTime(AstroUtils.getCurrentAstroDateTime());
        this.astroCalculator.setLocation(new AstroCalculator.Location(((Number)this.latitude.getValue()).doubleValue(), ((Number)this.longitude.getValue()).doubleValue()));
    }
}
