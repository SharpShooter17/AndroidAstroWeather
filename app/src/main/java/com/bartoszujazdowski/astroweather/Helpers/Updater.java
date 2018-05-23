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

    private List<UpdateI> updateIList;

    @Setter
    private Integer interval;

    private static Updater instance;

    private Updater(){
        this.handler = new Handler();

        this.updateIList = new ArrayList<>();

        this.interval = new Integer(60*1000);

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
    }

    public static Updater getInstance() {
        if ( !(instance instanceof Updater) ){
            instance = new Updater();
        }
        return instance;
    }

    public void start(){
        this.updateNow();
    }

    public void add(UpdateI updateI){
        synchronized (this.updateIList) {
            this.updateIList.add(updateI);
        }
    }

    public void addAll(List<UpdateI> list){
        synchronized (this.updateIList){
            this.updateIList.addAll(list);
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
