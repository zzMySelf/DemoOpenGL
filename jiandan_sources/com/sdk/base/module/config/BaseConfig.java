package com.sdk.base.module.config;

import com.sdk.f.c;
import com.sdk.l.a;

public class BaseConfig implements c {
    public static String apk = "com.cucc.sdk.api_key";
    public static int c = 54;
    public static String cm = "CUCC";
    public static String n = "SDKFactory";
    public static String v = "安卓4.0.4.1开放版o20220829";
    public long r = System.currentTimeMillis();

    public String getApiKey() {
        return apk;
    }

    public String getCM() {
        return cm;
    }

    public String toJsonString() {
        return a.a(this);
    }
}
