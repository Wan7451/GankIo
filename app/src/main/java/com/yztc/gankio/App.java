package com.yztc.gankio;

import android.app.Application;

/**
 * Created by wanggang on 2017/1/18.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //集成三方服务
        InitService.start(this);
    }
}
