package com.baidu.wallet.lightapp.ability.datamodle;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;

public class NativeAbilityCallIDPhotoModel implements NoProguard {
    public Data cnt;
    public int result;

    public static class Data implements NoProguard {
        public String back = "";
        public String des = "";
        public String errCode = "";
        public String front = "";
    }

    public NativeAbilityCallIDPhotoModel() {
        this.cnt = new Data();
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    public NativeAbilityCallIDPhotoModel(int i2) {
        this();
        this.result = i2;
    }
}
