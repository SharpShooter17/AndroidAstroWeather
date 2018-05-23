package com.bartoszujazdowski.astroweather.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.bartoszujazdowski.astroweather.AndroidUtils;
import com.bartoszujazdowski.astroweather.R;

import io.realm.Realm;
import lombok.Getter;

public class Menu extends AppCompatActivity {

    private Button startButton;
    private Button settingsButton;

    @Getter
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.context = getApplicationContext();

        startButton = (Button) findViewById(R.id.startButton);
        settingsButton = (Button) findViewById(R.id.settingsButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, AndroidUtils.getSizeOfScreen(Menu.getContext()) >= Configuration.SCREENLAYOUT_SIZE_LARGE ? AstroTablet.class :  Astro.class);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Settings.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (!Realm.getDefaultInstance().isClosed()) {
            Realm.getDefaultInstance().close();
        }
        super.onDestroy();
    }
}
