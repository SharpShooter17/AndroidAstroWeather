package com.bartoszujazdowski.astroweather;

public interface Range<T> {
    void setMinimum(T min);
    void setMaximum(T max);
}
