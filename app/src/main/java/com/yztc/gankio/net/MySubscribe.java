package com.yztc.gankio.net;

import android.content.Context;

import rx.Subscriber;

/**
 * Created by wanggang on 2017/1/13.
 */

public abstract class MySubscribe<T> extends Subscriber<T> {


    public MySubscribe(Context context) {
        this.context = context;
    }

    private Context context;
//    private LoadingDialog dialog;

    @Override
    public void onStart() {
        super.onStart();
//        dialog = new LoadingDialog(context);
//        dialog.show();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        //统一处理异常
        if (e instanceof ExceptionHandle.ResponeThrowable) {
            //逻辑异常  回调给Activity
            onError((ExceptionHandle.ResponeThrowable) e);
        } else {
            //网路异常  其他异常
            onError(ExceptionHandle.handleException(e));
        }
    }

    @Override
    public void onNext(T t) {
//        dialog.dismiss();
    }

    //统一处理异常  出现错误直接调用 自定义的 onError
    public abstract void onError(ExceptionHandle.ResponeThrowable e);

}
