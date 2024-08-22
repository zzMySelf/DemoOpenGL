package com.baidu.wallet.lightapp.ability.datamodle;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;

public class NativeAbilityCommonModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public Object data;
        public String des = "";
        public String errCode = "";
    }

    public NativeAbilityCommonModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public NativeAbilityCommonModel(int i2) {
        this();
        this.result = i2;
    }
}
