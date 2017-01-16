package com.yztc.gankio.net;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by wanggang on 2017/1/15.
 */

public class NetHelper {

    public static Observable.Transformer schedulersTransformer() {
        return new Observable.Transformer() {

            @Override
            public Object call(Object observable) {
                return ((Observable) observable)
                        .subscribeOn(Schedulers.io()) //工作线程执行
                        .unsubscribeOn(Schedulers.io())//操作完成后取消订阅
                        .observeOn(AndroidSchedulers.mainThread());//主线程执行
            }
        };
    }

    public static <T> Observable.Transformer transformer() {

        return new Observable.Transformer() {

            @Override
            public Object call(Object observable) {
                return ((Observable) observable)
                        .map(new HandleFuc<T>())//数据类型转换，取出真正的业务数据
                        .onErrorResumeNext(new HttpResponseFunc<T>());
                //在错误或异常发生时返回一个Observable
                // 处理异常
            }
        };
    }

    public static class HttpResponseFunc<T> implements Func1<Throwable, Observable<T>> {
        @Override
        public Observable<T> call(Throwable t) {
            //发错错误的 Observable
            return Observable.error(ExceptionHandle.handleException(t));
        }
    }

    public static class HandleFuc<T> implements Func1<BaseReslut<T>, T> {
        @Override
        public T call(BaseReslut<T> response) {
            //当前业务操作是否成功
            if (response.isError())
                throw new RuntimeException(response.getMsg());//抛出异常
            return response.getResults();
        }
    }
}
