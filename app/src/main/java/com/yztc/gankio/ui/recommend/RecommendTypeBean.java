package com.yztc.gankio.ui.recommend;

import java.util.List;

/**
 * Created by wanggang on 2017/1/20.
 */

public class RecommendTypeBean {

    private List<RecommmendBean> Android;
    private List<RecommmendBean> iOS;
    private List<RecommmendBean> 休息视频;
    private List<RecommmendBean> 拓展资源;
    private List<RecommmendBean> 瞎推荐;
    private List<RecommmendBean> 福利;
    private List<RecommmendBean> 前端;

    public List<RecommmendBean> getAndroid() {
        return Android;
    }

    public void setAndroid(List<RecommmendBean> Android) {
        this.Android = Android;
    }

    public List<RecommmendBean> getIOS() {
        return iOS;
    }

    public void setIOS(List<RecommmendBean> iOS) {
        this.iOS = iOS;
    }

    public List<RecommmendBean> get休息视频() {
        return 休息视频;
    }

    public void set休息视频(List<RecommmendBean> 休息视频) {
        this.休息视频 = 休息视频;
    }

    public List<RecommmendBean> get拓展资源() {
        return 拓展资源;
    }

    public void set拓展资源(List<RecommmendBean> 拓展资源) {
        this.拓展资源 = 拓展资源;
    }

    public List<RecommmendBean> get瞎推荐() {
        return 瞎推荐;
    }

    public void set瞎推荐(List<RecommmendBean> 瞎推荐) {
        this.瞎推荐 = 瞎推荐;
    }

    public List<RecommmendBean> get福利() {
        return 福利;
    }

    public void set福利(List<RecommmendBean> 福利) {
        this.福利 = 福利;
    }


    public List<RecommmendBean> get前端() {
        return 前端;
    }

    public void set前端(List<RecommmendBean> 前端) {
        this.前端 = 前端;
    }
}
