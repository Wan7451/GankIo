package com.yztc.gankio.helper;

import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.signature.StringSignature;
import com.yztc.gankio.ui.classify.ClassifyBean;

import java.util.Collections;
import java.util.List;

/**
 * Created by wanggang on 2017/1/6.
 */

public class MyPreloadModleProvider implements ListPreloader.PreloadModelProvider<ClassifyBean> {

    private List<ClassifyBean> mData;
    private RequestManager mRequestManager;

    public MyPreloadModleProvider(RequestManager requestManager, List<ClassifyBean> data) {
        this.mData = data;
        this.mRequestManager = requestManager;
    }


    //预加载的数据
    @Override
    public List<ClassifyBean> getPreloadItems(int position) {
        return Collections.singletonList(mData.get(position));
    }

    //进行加载
    @Override
    public GenericRequestBuilder getPreloadRequestBuilder(ClassifyBean item) {

        List<String> images = item.getImages();
        if (images != null && images.size() > 0) {
            StringSignature signature = new StringSignature(images.get(0));
            return mRequestManager.load(images.get(0)).signature(signature);
        }
        return null;
    }
}
