package com.baidu.wallet.lightapp.ability.datamodle;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;

public class NativeAbilityUserAgentModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public String data = "";
    }

    public NativeAbilityUserAgentModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public NativeAbilityUserAgentModel(int i2) {
        this();
        this.result = i2;
    }
}
