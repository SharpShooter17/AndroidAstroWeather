package com.bartoszujazdowski.astroweather;

import com.astrocalculator.AstroCalculator;
import com.bartoszujazdowski.astroweather.Helpers.AstroUtils;
import com.bartoszujazdowski.astroweather.Helpers.MutableNumber;
import com.bartoszujazdowski.astroweather.yahooWeather.enums.UNITS;

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

    @Getter
    private WeatherController weatherController;

    @Getter @Setter
    private UNITS units;

    private SettingsSingleton(){
        this.units = UNITS.Celsius;
        this.latitude = new MutableNumber<>(new Float(0));
        this.longitude =  new MutableNumber<>(new Float(0));
        this.refreshFrequency = new MutableNumber<>(new Integer(60));

        this.astroCalculator = new AstroCalculator(AstroUtils.getCurrentAstroDateTime(), new AstroCalculator.Location(latitude.getValue(), longitude.getValue()));

        this.weatherController = new WeatherController();
    }

    public void update(){
        this.astroCalculator.setDateTime(AstroUtils.getCurrentAstroDateTime());
        this.astroCalculator.setLocation(new AstroCalculator.Location(((Number)this.latitude.getValue()).doubleValue(), ((Number)this.longitude.getValue()).doubleValue()));
    }
}
