package com.yztc.gankio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
//        IApi api = NetUtils.getInstance().getApi();
//
//        Observable<BaseReslut<List<GankBean>>> observable = api.listAllRx(IApi.GET_TYPE.福利, 20, 1);
//        observable
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .map(new Func1<BaseReslut<List<GankBean>>, List<GankBean>>() {
//                    @Override
//                    public List<GankBean> call(BaseReslut<List<GankBean>> listBaseReslut) {
//                       if(listBaseReslut.isError()){
//                           //做 ERROR的处理
//                       }
//                       return listBaseReslut.getResults();
//                    }
//                })
//                .subscribe(new MySubscribe<List<GankBean>>(MainActivity.this){
//
//                    @Override
//                    public void onNext(List<GankBean> listBaseReslut) {
//                        super.onNext(listBaseReslut);
//                        Log.i("===========",listBaseReslut.size()+"");
//                        Toast.makeText(MainActivity.this, listBaseReslut.size(), Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        super.onError(e);
//                    }
//                });

//        Call<BaseReslut> call = api.push2Gank("http://www.baidu.com",
//                "测测试试",
//                "10086",
//                IApi.PUSH_TYPE.瞎推荐,
//                true);
//
//        call.enqueue(new Callback<BaseReslut>() {
//            @Override
//            public void onResponse(Call<BaseReslut> call, Response<BaseReslut> response) {
//                String msg = response.body().getMsg();
//                Log.i("============",msg);
//                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<BaseReslut> call, Throwable t) {
//                Log.i("===========", t.getMessage());
//                StackTraceElement[] stackTrace = t.getStackTrace();
//                for (int i = 0; i < stackTrace.length; i++) {
//                    Log.i("===========", stackTrace[i].toString());
//                }
//            }
//        });


//        Call<BaseReslut<List<GankBean>>> call = api.listAll(IApi.GET_TYPE.拓展资源, 20, 1);
//        call.enqueue(new Callback<BaseReslut<List<GankBean>>>() {
//            @Override
//            public void onResponse(Call<BaseReslut<List<GankBean>>> call, Response<BaseReslut<List<GankBean>>> response) {
//                if(response.body()!=null){
//                    Log.i("============",response.body().getResults().size()+"");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseReslut<List<GankBean>>> call, Throwable t) {
//                Log.i("===========", t.getMessage());
//                StackTraceElement[] stackTrace = t.getStackTrace();
//                for (int i = 0; i < stackTrace.length; i++) {
//                    Log.i("===========", stackTrace[i].toString());
//                }
//            }
//        });


    }
}
