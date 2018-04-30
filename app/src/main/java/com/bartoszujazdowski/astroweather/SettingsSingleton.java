package com.bartoszujazdowski.astroweather;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bartosz Ujazdowski on 20.04.2018.
 */

public class SettingsSingleton {

    /** Szerokość geograficzna */
    @Setter
    @Getter
    private MutableNumber<Double> latitude = new MutableNumber<>(new Double(0.0));

    /** Długość geograficzna */
    @Setter
    @Getter
    private MutableNumber<Double> longitude = new MutableNumber<>(new Double(0.0));

    @Setter
    @Getter
    private MutableNumber<Integer> refreshFrequency = new MutableNumber<>(new Integer(60));

    private static SettingsSingleton instance = new SettingsSingleton();

    private SettingsSingleton(){
    }

    public static SettingsSingleton getInstance(){
        return SettingsSingleton.instance;
    }
}
