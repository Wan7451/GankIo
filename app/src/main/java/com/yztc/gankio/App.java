package com.yztc.gankio;

import android.app.Application;
import android.content.Context;

/**
 * Created by wanggang on 2017/1/18.
 */

public class App extends Application {

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //集成三方服务
        InitService.start(this);
        context = this;
    }
}
