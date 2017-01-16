package com.yztc.gankio.helper;

import com.bumptech.glide.ListPreloader;
import com.yztc.gankio.ui.classify.ClassifyBean;

/**
 * Created by wanggang on 2017/1/6.
 */

public class MyPreloadViewSize implements ListPreloader.PreloadSizeProvider<ClassifyBean> {
    @Override
    public int[] getPreloadSize(ClassifyBean item, int adapterPosition, int perItemPosition) {
        return new int[]{100, 100};
    }
}
