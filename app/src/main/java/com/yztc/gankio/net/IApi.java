package com.yztc.gankio.net;

import com.yztc.gankio.ui.classify.ClassifyBean;
import com.yztc.gankio.ui.recommend.RecommendTabBean;
import com.yztc.gankio.ui.recommend.RecommendTypeBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by wanggang on 2017/1/13.
 */

public interface IApi {


    @GET("data/{type}/20/{page}")
    Observable<BaseReslut<List<ClassifyBean>>> listAllRx(
            @Path("type") String type,
            @Path("page") int page);


    @GET("history/content/{size}/1")
    Call<BaseReslut<List<RecommendTabBean>>> getTab(@Path("size") int size);

    /**
     * @param date 2015/08/07
     * @return
     */
    @GET("day/{date}")
    Call<BaseReslut<RecommendTypeBean>> getRecommend(@Path("date") String date);


    @GET("history/content/{size}/1")
    Observable<BaseReslut<List<RecommendTabBean>>> getTabRx(@Path("size") int size);

    /**
     * @param date 2015/08/07
     * @return
     */
    @GET("day/{date}")
    Observable<BaseReslut<RecommendTypeBean>> getRecommendRx(@Path("date") String date);

}
