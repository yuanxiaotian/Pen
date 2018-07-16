package com.xuliucar.car.bean;

public class SortListBean {

    private String time;
    private String imgUrl;
    private String videoImgUrl;
    private String content;
    private int type;//0:表示文本，1:表示图片，2:表示视频
    private boolean isCollect;//是否收藏
    private boolean isDelete;//是否删除

    public SortListBean(String time, String imgUrl, String videoImgUrl, String content, int type, boolean isCollect,boolean isDelete) {
        this.time = time;
        this.imgUrl = imgUrl;
        this.videoImgUrl = videoImgUrl;
        this.content = content;
        this.type=type;
        this.isCollect=isCollect;
        this.isDelete=isDelete;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoImgUrl() {
        return videoImgUrl;
    }

    public void setVideoImgUrl(String videoImgUrl) {
        this.videoImgUrl = videoImgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
