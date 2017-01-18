package com.yztc.gankio;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.yztc.gankio.event.Event;

import org.greenrobot.eventbus.EventBus;


public class InitService extends IntentService {

    public InitService() {
        super("InitService");
    }


    public static void start(Context context) {
        Intent i = new Intent();
        i.setClass(context, InitService.class);
        context.startService(i);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //初始化三方库
        Context context = getApplicationContext();

        //工作线程
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        EventBus.getDefault().post(new Event(Event.CODE_INIT_FINISH, null));
    }

}
