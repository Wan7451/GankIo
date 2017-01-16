package com.yztc.gankio.ui.classify;

import android.content.Context;

import com.yztc.gankio.net.BaseReslut;
import com.yztc.gankio.net.ExceptionHandle;
import com.yztc.gankio.net.IApi;
import com.yztc.gankio.net.MySubscribe;
import com.yztc.gankio.net.NetHelper;
import com.yztc.gankio.net.NetResponse;
import com.yztc.gankio.net.NetUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by wanggang on 2017/1/16.
 */

public class ClassifyModelImpl implements ClassifyConstraint.IClassifyModel {

    @Override
    public void loadData(Context context, String type, int page, final NetResponse callback) {

        IApi api = NetUtils.getInstance().getApi();
        Observable<BaseReslut<List<ClassifyBean>>> observable =
                api.listAllRx(type, page);
        observable
                .compose(NetHelper.schedulersTransformer())
                .compose(NetHelper.transformer())
                .subscribe(new MySubscribe<List<ClassifyBean>>(context) {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {
                        if (callback != null) {
                            callback.onError(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(List<ClassifyBean> classifyBeen) {
                        super.onNext(classifyBeen);
                        if (callback != null) {
                            callback.onResponse(classifyBeen);
                        }
                    }
                });
    }


}
