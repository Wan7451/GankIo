package com.yztc.gankio.ui.classify.mvp;

import android.content.Context;

import com.yztc.gankio.net.NetResponse;
import com.yztc.gankio.ui.classify.ClassifyBean;

import java.util.List;

/**
 * Created by wanggang on 2017/1/16.
 */

public class ClassifyPresenterImpl implements ClassifyConstraint.IClassifyPresenter {

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
    }

    @Override
    public void pull() {
        page = 1;
        model.loadData(context, type, page, new NetResponse() {
            @Override
            public void onResponse(Object data) {
                List<ClassifyBean> list = (List<ClassifyBean>) data;
                view.onPull(list);
                view.loadFinish();
            }

            @Override
            public void onError(String msg) {
                view.loadError(msg);
            }
        });
    }

    @Override
    public void push() {
        page++;
        model.loadData(context, type, page, new NetResponse() {
            @Override
            public void onResponse(Object data) {
                List<ClassifyBean> list = (List<ClassifyBean>) data;
                view.onPush(list);
                view.loadFinish();
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
