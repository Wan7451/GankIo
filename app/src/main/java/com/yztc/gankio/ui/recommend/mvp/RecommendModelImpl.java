package com.yztc.gankio.ui.recommend.mvp;

import com.yztc.gankio.net.BaseReslut;
import com.yztc.gankio.net.NetResponse;
import com.yztc.gankio.net.NetUtils;
import com.yztc.gankio.ui.recommend.RecommendTabBean;
import com.yztc.gankio.ui.recommend.RecommendTypeBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wanggang on 2017/1/20.
 */

public class RecommendModelImpl implements RecommendConstraint.RecommendModel {

    @Override
    public void loadTab(int size, final NetResponse netresponse) {

        Call<BaseReslut<List<RecommendTabBean>>> call =
                NetUtils.getInstance().getApi().getTab(size);

        call.enqueue(new Callback<BaseReslut<List<RecommendTabBean>>>() {
            @Override
            public void onResponse(Call<BaseReslut<List<RecommendTabBean>>> call, Response<BaseReslut<List<RecommendTabBean>>> response) {
                BaseReslut<List<RecommendTabBean>> reslut = response.body();
                if (!reslut.isError()) {
                    List<RecommendTabBean> tabBeans = reslut.getResults();
                    if (netresponse != null) {
                        netresponse.onResponse(tabBeans);
                    }
                } else {
                    if (netresponse != null) {
                        netresponse.onError(reslut.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseReslut<List<RecommendTabBean>>> call, Throwable t) {
                if (netresponse != null) {
                    netresponse.onError(t.getMessage());
                }
            }
        });

    }

    @Override
    public void loadContent(String date, final NetResponse netresponse) {
        Call<BaseReslut<RecommendTypeBean>> call =
                NetUtils.getInstance().getApi().getRecommend(date);

        call.enqueue(new Callback<BaseReslut<RecommendTypeBean>>() {
            @Override
            public void onResponse(Call<BaseReslut<RecommendTypeBean>> call, Response<BaseReslut<RecommendTypeBean>> response) {
                BaseReslut<RecommendTypeBean> reslut = response.body();
                if (!reslut.isError()) {
                    if (netresponse != null) {
                        netresponse.onResponse(reslut.getResults());
                    }
                } else {
                    if (netresponse != null) {
                        netresponse.onError(reslut.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseReslut<RecommendTypeBean>> call, Throwable t) {
                if (netresponse != null) {
                    netresponse.onError(t.getMessage());
                }
            }
        });
    }
}
