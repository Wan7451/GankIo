package com.yztc.gankio.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wanggang on 2017/1/15.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 填充数据     将Bean中的数据设置到View上
     *
     * @param data
     */
    public abstract void fillData(T data);
}
