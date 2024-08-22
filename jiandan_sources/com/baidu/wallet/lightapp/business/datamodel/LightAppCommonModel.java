package com.baidu.wallet.lightapp.business.datamodel;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;

public class LightAppCommonModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public Object data;
        public String des = "";
        public String errCode = "";
    }

    public LightAppCommonModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppCommonModel(int i2) {
        this();
        this.result = i2;
    }
}
