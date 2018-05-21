package com.bartoszujazdowski.astroweather.Helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteLocation {
    private String city;
    private String country;

    @Override
    public String toString(){
        return this.city + "," + this.country;
    }
}
