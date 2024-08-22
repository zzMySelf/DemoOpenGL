package com.baidu.wallet.lightapp.business.datamodel;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;

public class LightAppCallIDPhotoModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public String back = "";
        public String des = "";
        public String errCode = "";
        public String front = "";
    }

    public LightAppCallIDPhotoModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppCallIDPhotoModel(int i2) {
        this();
        this.result = i2;
    }
}
