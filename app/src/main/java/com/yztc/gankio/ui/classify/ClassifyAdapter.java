package com.yztc.gankio.ui.classify;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.yztc.gankio.R;
import com.yztc.gankio.base.BaseRecycleAdapter;
import com.yztc.gankio.base.BaseViewHolder;
import com.yztc.gankio.databinding.ItemClassifyBinding;
import com.yztc.gankio.databinding.ItemClassifyIconBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanggang on 2016/12/12.
 */

public class ClassifyAdapter extends BaseRecycleAdapter<ClassifyBean> {


    private static final int TYPE_ICON = 0;
    private static final int TYPE_NO_ICON = 1;


    public ClassifyAdapter(Context context, ArrayList<ClassifyBean> data, RequestManager requestManager) {
        super(context, data);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case TYPE_ICON:
                ItemClassifyIconBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_classify_icon, parent, false);
                return new ClassifyIconHolder(binding);
            case TYPE_NO_ICON:
                ItemClassifyBinding binding1 = DataBindingUtil.inflate(inflater, R.layout.item_classify, parent, false);
                return new ClassifyHolder(binding1);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        List<String> images = data.get(position).getImages();
        if (images != null && images.size() > 0) {
            return TYPE_ICON;
        } else {
            return TYPE_NO_ICON;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ClassifyBean clsBean = data.get(position);
        holder.fillData(clsBean);
    }


    static class ClassifyHolder extends BaseViewHolder<ClassifyBean> {

        private ItemClassifyBinding binding;

        ClassifyHolder(ItemClassifyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void fillData(ClassifyBean clsBean) {
            binding.setClassify(clsBean);
            binding.executePendingBindings();
        }
    }

    static class ClassifyIconHolder extends BaseViewHolder<ClassifyBean> {

        private ItemClassifyIconBinding binding;

        ClassifyIconHolder(ItemClassifyIconBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void fillData(ClassifyBean clsBean) {
            binding.setClassify(clsBean);
            binding.executePendingBindings();
        }
    }
}
