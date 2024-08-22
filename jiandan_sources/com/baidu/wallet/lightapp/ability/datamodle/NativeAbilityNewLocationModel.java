package com.baidu.wallet.lightapp.ability.datamodle;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;

public class NativeAbilityNewLocationModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public String aesdata = "";
        public String aeskey = "";
        public Loc data = new Loc();
        public String des = "";
        public String errCode = "";
    }

    public static class Loc implements NoProguard {
        public double latitude;
        public double longitude;
    }

    public NativeAbilityNewLocationModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public NativeAbilityNewLocationModel(int i2) {
        this();
        this.result = i2;
    }
}
