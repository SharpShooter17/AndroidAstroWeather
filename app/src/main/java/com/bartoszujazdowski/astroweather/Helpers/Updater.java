package com.bartoszujazdowski.astroweather.Helpers;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import lombok.Setter;

public class Updater {
    private Runnable runnable;
    private Handler handler;
    private List<UpdateI> updateIList = new ArrayList<>();
    @Setter
    private Integer interval = new Integer(60000);

    private static Updater instance;

    public static Updater getInstance() {
        if ( !(instance instanceof Updater) ){
            instance = new Updater();
        }
        return instance;
    }

    public void start(){
        this.runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("Info", "update");
                synchronized (updateIList) {
                    for (UpdateI u : updateIList) {
                        u.update();
                    }
                }
                handler.postDelayed(this, interval);
            }
        };
        this.handler = new Handler();
        this.handler.postDelayed(this.runnable, this.interval );
    }

    public void add(UpdateI updateI){
        synchronized (this.updateIList) {
            this.updateIList.add(updateI);
        }
    }

    public void remove(UpdateI updateI){
        synchronized (this.updateIList) {
            this.updateIList.remove(updateI);
        }
    }

    public void stop(){
        synchronized (this.updateIList) {
            this.handler.removeCallbacks(this.runnable);
        }
    }

    public void removeAll(){
        synchronized (this.updateIList){
            this.updateIList.clear();
        }
    }

    public void updateNow(){
        synchronized (this.updateIList){
            this.handler.postDelayed(this.runnable, 0);
        }
    }
}
