package com.baidu.searchbox.comment.model;

import org.json.JSONObject;

public class CommentImageInfo {
    private int mHeight;
    private String mServerImgURL;
    private String mURL;
    private int mWidth;

    public String getURL() {
        return this.mURL;
    }

    public void setURL(String url) {
        this.mURL = url;
    }

    public String getServerImgURL() {
        return this.mServerImgURL;
    }

    public void setServerImgURL(String serverImgURL) {
        this.mServerImgURL = serverImgURL;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int height) {
        this.mHeight = height;
    }

    public static CommentImageInfo parseImageInfo(JSONObject object) {
        if (object == null) {
            return null;
        }
        CommentImageInfo info = new CommentImageInfo();
        info.setURL(object.optString("url"));
        info.setServerImgURL(object.optString("url"));
        info.setWidth(object.optInt("width"));
        info.setHeight(object.optInt("height"));
        return info;
    }
}
