package com.baidu.searchbox.ugc.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LocalAlbumBean implements Serializable {
    public static final String TYPE_PHOTO = "photo";
    public static final String TYPE_VIDEO = "video";
    @SerializedName("cover")
    public String cover;
    @SerializedName("duration")
    public long duration;
    @SerializedName("height")
    public int height;
    @SerializedName("orientation")
    public int orientation;
    @SerializedName("path")
    public String path;
    @SerializedName("type")
    public String type;
    @SerializedName("width")
    public int width;

    public LocalAlbumBean(String path2) {
        this.type = "photo";
        this.path = path2;
    }

    public LocalAlbumBean(String path2, String cover2, long duration2) {
        this.type = "video";
        this.path = path2;
        this.cover = cover2;
        this.duration = duration2;
    }
}
