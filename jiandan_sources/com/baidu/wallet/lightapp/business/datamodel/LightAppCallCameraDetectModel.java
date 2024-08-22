package com.baidu.wallet.lightapp.business.datamodel;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;

public class LightAppCallCameraDetectModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public String cardNumber = "";
        public String des = "";
        public String errCode = "";
        public String image = "";
        public String name = "";
    }

    public LightAppCallCameraDetectModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppCallCameraDetectModel(int i2) {
        this();
        this.result = i2;
    }
}
