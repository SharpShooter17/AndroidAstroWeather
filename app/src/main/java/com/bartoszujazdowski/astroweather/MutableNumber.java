package com.bartoszujazdowski.astroweather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Bartosz Ujazdowski on 30.04.2018.
 */

@AllArgsConstructor
@NoArgsConstructor
public class MutableNumber<N extends Number> {
    @Getter
    @Setter
    private N value;

    @Override
    public String toString(){
        return String.valueOf( this.value );
    }
}
