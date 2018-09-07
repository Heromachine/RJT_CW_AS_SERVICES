package com.example.herotruth.rjt_cw_services;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class SplashScreen extends AppCompatActivity {
    private static final String TAG = "FART";


    Animation animFadein;

    //CREATE SPLASH SCREEN WITH MUISC AND MUSIC STOPS WHEN ENTERS MAIN ACTIVITY

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        Log.d(TAG, "onCreate: started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);


        //animFadein.setAnimationListener(this);


        Thread thread = new Thread()
        {
            @Override
            public void run() {
                Log.d(TAG, "run: started");
                try
                {
                    Thread.sleep(5000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                Intent i = new Intent(SplashScreen.this, MainActivity.class);

                Intent i2 = new Intent(SplashScreen.this,MyService.class);
                stopService(i2);

                startActivity(i);
            }
        };

        Thread threadMuisic = new Thread()
        {
            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, MyService.class);
                startService(i);
            }
        };

        thread.start();
        threadMuisic.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();



    }
}
