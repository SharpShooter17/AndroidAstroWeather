package com.bartoszujazdowski.astroweather;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MutableNumberWithRange<T extends java.lang.Number> extends MutableNumber<T> implements Range<T> {

    private T min;
    private T max;

    public MutableNumberWithRange(T value) {
        super(value);
    }

    @Override
    public void setMinimum(T min) {
        this.min = min;
    }

    @Override
    public void setMaximum(T max) {
        this.max = max;
    }

    @Override
    public void setValue(T value) throws Exception {

        int minimum = new BigDecimal(String.valueOf(this.min)).compareTo( new BigDecimal(String.valueOf(value)) );
        int maximum = new BigDecimal(String.valueOf(this.max)).compareTo( new BigDecimal(String.valueOf(value)) );

        if ( (minimum == 1 || minimum == 0) && (maximum == -1 || maximum == 0) ){
            super.setValue(value);
        } else {
            throw new Exception("Range exceprion");
        }
    }
}
