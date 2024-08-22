package com.baidu.wallet.lightapp.ability.datamodle;

import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;

public class NativeAbilityContactSelectModelBase64 implements NoProguard {
    public String cnt;
    public int result;

    public String toJson() {
        return JsonUtils.toJson(this);
    }
}
