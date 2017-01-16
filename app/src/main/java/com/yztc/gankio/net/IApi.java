package com.yztc.gankio.net;

import com.yztc.gankio.ui.classify.ClassifyBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by wanggang on 2017/1/13.
 */

public interface IApi {


    @GET("data/{type}/20/{page}")
    Call<BaseReslut<List<ClassifyBean>>> listAll(
            @Path("type") String type,
            @Path("page") int page);


    @GET("data/{type}/20/{page}")
    Observable<BaseReslut<List<ClassifyBean>>> listAllRx(
            @Path("type") String type,
            @Path("page") int page);


    @FormUrlEncoded
    @POST("add2gank")
    Call<BaseReslut> push2Gank(@Field("url") String url,
                               @Field("desc") String desc,
                               @Field("who") String id,
                               @Field("type") String type,
                               @Field("debug") boolean isDebug);

}
