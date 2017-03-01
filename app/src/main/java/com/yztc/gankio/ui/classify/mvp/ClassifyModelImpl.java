package com.yztc.gankio.ui.classify.mvp;

import android.content.Context;

import com.yztc.gankio.net.BaseReslut;
import com.yztc.gankio.net.IApi;
import com.yztc.gankio.net.NetUtils;
import com.yztc.gankio.ui.classify.ClassifyBean;

import java.util.List;

import rx.Observable;

/**
 * Created by wanggang on 2017/1/16.
 */

public class ClassifyModelImpl implements ClassifyConstraint.IClassifyModel {

    @Override
    public Observable<BaseReslut<List<ClassifyBean>>> loadData(Context context, String type, int page) {
        IApi api = NetUtils.getInstance().getApi();
        return api.listAllRx(type, page);

    }


}
