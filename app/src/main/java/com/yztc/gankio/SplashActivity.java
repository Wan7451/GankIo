package com.yztc.gankio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.yztc.gankio.event.Event;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        EventBus.getDefault().register(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent();
                i.setClass(SplashActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();

            }
        }, 4000);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Event event) {
        switch (event.getCode()) {
            case Event.CODE_INIT_FINISH:

                Intent i = new Intent();
                i.setClass(SplashActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();

                break;
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
