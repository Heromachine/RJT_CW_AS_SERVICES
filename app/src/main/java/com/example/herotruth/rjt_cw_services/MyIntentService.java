package com.example.herotruth.rjt_cw_services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("mythread");
    }

    String time;

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

       //time =  intent.getExtras().getInt("kyey");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onCreate();
    }

    @Override
    public void onCreate() {
        Toast.makeText(MyIntentService.this, "Service Started", Toast.LENGTH_LONG);
        super.onCreate();
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
