package com.xuliucar.car.bean;

public class MyCollectBean {

    private String time;
    private String imgUrl;
    private String videoImgUrl;
    private String content;
    private int type;//0:表示文本，1:表示图片，2:表示视频

    public MyCollectBean(String time, String imgUrl, String videoImgUrl, String content,int type) {
        this.time = time;
        this.imgUrl = imgUrl;
        this.videoImgUrl = videoImgUrl;
        this.content = content;
        this.type=type;
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
