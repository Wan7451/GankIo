package com.yztc.gankio.ui.classify.mvp;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yztc.gankio.dickcache.DiskCache;
import com.yztc.gankio.net.BaseReslut;
import com.yztc.gankio.net.ExceptionHandle;
import com.yztc.gankio.net.MySubscribe;
import com.yztc.gankio.net.NetHelper;
import com.yztc.gankio.ui.classify.ClassifyBean;

import java.lang.reflect.Type;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by wanggang on 2017/1/16.
 */

public class ClassifyPresenterImpl implements ClassifyConstraint.IClassifyPresenter {


    private static final String CACHE_KEY = ClassifyPresenterImpl.class.getName();
    private final DiskCache diskCache;

    private ClassifyConstraint.IClassifyView view;
    private ClassifyConstraint.IClassifyModel model;
    private String type;
    private Context context;

    private int page;

    public ClassifyPresenterImpl(Context context,
                                 ClassifyConstraint.IClassifyView view,
                                 String type) {
        this.view = view;
        this.context = context;
        this.type = type;
        this.model = new ClassifyModelImpl();
        diskCache = DiskCache.getInstance();
    }

    @Override
    public void pull() {
        page = 1;

        //从缓存中取数据
        List<ClassifyBean> data = getCache();
        if (data != null) {
            view.onPull(data);
            view.loadFinish();
        }
        //判断是否超时
        if (data != null && !isTimeOut()) {
            return;
        }

        Observable<BaseReslut<List<ClassifyBean>>> observable
                = model.loadData(context, type, page);

        observable
                .compose(NetHelper.schedulersTransformer())
                .compose(NetHelper.transformer())
                //缓存保存到本地
                .map(new ClassifyPresenterImpl.DiskCacheFunc(getCacheKey()))
                .subscribe(new MySubscribe<List<ClassifyBean>>(context) {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {
                        view.loadError(e.message);
                    }

                    @Override
                    public void onNext(List<ClassifyBean> data) {
                        super.onNext(data);
                        view.onPull(data);
                        view.loadFinish();
                    }
                });

    }

    @Override
    public void push() {
        page++;

        List<ClassifyBean> data = getCache();
        if (data != null) {
            view.onPush(data);
            view.loadFinish();
        }

        if (data != null && !isTimeOut()) {
            return;
        }

        Observable<BaseReslut<List<ClassifyBean>>> observable
                = model.loadData(context, type, page);

        observable
                .compose(NetHelper.schedulersTransformer())
                .compose(NetHelper.transformer())
                .map(new ClassifyPresenterImpl.DiskCacheFunc(getCacheKey()))
                .subscribe(new MySubscribe<List<ClassifyBean>>(context) {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {
                        view.loadError(e.message);
                    }

                    @Override
                    public void onNext(List<ClassifyBean> data) {
                        super.onNext(data);
                        view.onPush(data);
                        view.loadFinish();
                    }
                });

    }

    //缓存数据的key
    private String getCacheKey() {
        return CACHE_KEY + page + type;
    }


    private boolean isTimeOut() {
        return diskCache.isTimeOut(getCacheKey());
    }

    private List<ClassifyBean> getCache() {
        //key   url 地址
        String cache = DiskCache.getInstance().getString(getCacheKey());
        if (!TextUtils.isEmpty(cache)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<ClassifyBean>>() {
            }.getType();
            return gson.fromJson(cache, type);
        }
        return null;
    }

    private static class DiskCacheFunc implements Func1<List<ClassifyBean>, List<ClassifyBean>> {

        private String key;

        DiskCacheFunc(String key) {
            this.key = key;
        }

        @Override
        public List<ClassifyBean> call(List<ClassifyBean> s) {
            //将Bean 转换成JSON
            Gson gson = new Gson();
            String data = gson.toJson(s);
            DiskCache.getInstance().putString(key, data);
            return s;
        }
    }
}
