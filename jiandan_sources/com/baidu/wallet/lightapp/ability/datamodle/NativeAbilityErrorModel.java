package com.baidu.wallet.lightapp.ability.datamodle;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;

public class NativeAbilityErrorModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public String des = "";
        public String errCode = "";
    }

    public NativeAbilityErrorModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public NativeAbilityErrorModel(int i2) {
        this();
        this.result = i2;
    }
}
