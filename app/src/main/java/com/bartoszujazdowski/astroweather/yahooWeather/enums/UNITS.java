package com.bartoszujazdowski.astroweather.yahooWeather.enums;

public enum UNITS {
    Fahrenheit("f"),
    Celsius("c");

    String unit;
    UNITS(String unit){
        this.unit = unit;
    }

    @Override
    public String toString() {
        return unit;
    }
}
