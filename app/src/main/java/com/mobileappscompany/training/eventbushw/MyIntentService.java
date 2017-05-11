package com.mobileappscompany.training.eventbushw;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;


public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        int timeToSleep = intent.getIntExtra("tTSK", 1) * 1000;

        try {
            Thread.sleep(timeToSleep);
            EventBus.getDefault().post(new MyEvent(747, "IntentService done"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
    