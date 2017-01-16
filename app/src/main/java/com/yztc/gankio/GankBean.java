package com.yztc.gankio;

/**
 * Created by wanggang on 2017/1/13.
 */

public class GankBean {


    /**
     * _id : 5877091e421aa93161103df7
     * createdAt : 2017-01-12T12:42:06.839Z
     * desc : 另辟蹊径实现Android多渠道打包
     * publishedAt : 2017-01-13T11:58:16.991Z
     * source : chrome
     * type : Android
     * url : https://yrom.net/blog/2015/05/25/the_other_way_to_package_multi_channel_apks/
     * used : true
     * who : LHF
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
