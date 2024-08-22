package com.baidu.wallet.lightapp.base.datamodel;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;

public class LightAppTakePictureModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public String des = "";
        public String errCode = "";
        public String image = "";
    }

    public LightAppTakePictureModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppTakePictureModel(int i2) {
        this();
        this.result = i2;
    }
}
