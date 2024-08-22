package com.baidu.searchbox.ugc.model;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;

public class ShowReportBean implements NoProGuard {
    @SerializedName("id")
    public int id;
    @SerializedName("scene")
    public String scene;
    @SerializedName("sign")
    public String sign;

    public ShowReportBean(int id2, String scene2, String sign2) {
        this.id = id2;
        this.scene = scene2;
        this.sign = sign2;
    }
}
