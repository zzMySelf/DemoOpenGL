package com.baidu.wallet.lightapp.base.datamodel;

import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.core.NoProguard;

public class LightAppInfoModel implements NoProguard {
    public int result;
    public String state;

    public String toJson() {
        return JsonUtils.toJson(this);
    }
}
