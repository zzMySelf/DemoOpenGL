package com.sdk.mobile.config;

import com.sdk.base.module.config.BaseConfig;
import com.sdk.f.c;
import com.sdk.l.a;

public class MobileConfig implements c {
    public String apk = BaseConfig.apk;
    public int c = 1;
    public String cm = BaseConfig.cm;
    public String n = "ZzxOAuth";
    public long r = System.currentTimeMillis();
    public String v = "1.0";

    public String getApiKey() {
        return this.apk;
    }

    public String getCM() {
        return this.cm;
    }

    public String toJsonString() {
        return a.a(this);
    }
}
