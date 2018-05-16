package com.bartoszujazdowski.astroweather;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by Bartosz Ujazdowski on 30.04.2018.
 */

public class CustomTextWatcher<N extends MutableNumber> implements TextWatcher {

    private N number;

    public CustomTextWatcher(N number) {
        this.number = number;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        try {
            this.number.setValue(NumberUtils.createNumber(charSequence.toString()));
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        } catch (Exception ex) {
            Toast toast = Toast.makeText(Menu.getContext(), ex.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
    }
}
