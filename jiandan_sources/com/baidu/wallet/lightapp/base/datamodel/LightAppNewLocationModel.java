package com.baidu.wallet.lightapp.base.datamodel;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;

public class LightAppNewLocationModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public Loc data = new Loc();
        public String des = "";
        public String errCode = "";
    }

    public static class Loc implements NoProguard {
        public double latitude;
        public double longitude;
    }

    public LightAppNewLocationModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public LightAppNewLocationModel(int i2) {
        this();
        this.result = i2;
    }
}
