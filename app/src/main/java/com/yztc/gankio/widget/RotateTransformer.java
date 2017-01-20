package com.yztc.gankio.widget;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;


/**
 * Created by hujie on 2017/1/17.
 * 首页viewPager滚动翻页动画
 */

public class RotateTransformer implements ViewPager.PageTransformer {
    private static final float ROT_MAX = 20.0f;
    private float mRot;

    public void transformPage(View view, float position) {

        if (position < -1) {
            ViewHelper.setRotation(view, 0);

        } else if (position <= 1) {
            mRot = (ROT_MAX * position);
            ViewHelper.setPivotX(view, view.getMeasuredWidth() * 0.5f);
            ViewHelper.setPivotY(view, view.getMeasuredHeight());
            ViewHelper.setRotation(view, mRot);
        } else {
            ViewHelper.setRotation(view, 0);
        }
    }
}
