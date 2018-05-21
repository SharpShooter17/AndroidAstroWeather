package com.bartoszujazdowski.astroweather.Helpers;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.RealmClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RealmClass
public class FavouriteLocation extends RealmObject{
    @Index
    private String city;
    private String country;

    @Override
    public String toString(){
        return this.city + "," + this.country;
    }
}
