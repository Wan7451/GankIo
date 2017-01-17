package com.yztc.gankio.imageloader;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yztc.gankio.R;
import com.yztc.gankio.utils.DateUtils;

/**
 * Created by wanggang on 2017/1/17.
 */

public class ImageAttr {

    @BindingAdapter("url")
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }

    @BindingAdapter("time")
    public static void loadTime(TextView textView, String time) {
        String date = time.replace('T', ' ').replace('Z', ' ');
        textView.setText(DateUtils.friendlyTime(date));
    }

}
