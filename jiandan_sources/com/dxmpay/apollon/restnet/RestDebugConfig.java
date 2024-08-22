package com.dxmpay.apollon.restnet;

import com.dxmpay.apollon.ApollonConstants;

public final class RestDebugConfig {

    /* renamed from: ad  reason: collision with root package name */
    public static RestDebugConfig f4005ad;
    public boolean qw = false;

    public static synchronized RestDebugConfig getInstance() {
        RestDebugConfig restDebugConfig;
        synchronized (RestDebugConfig.class) {
            if (f4005ad == null) {
                f4005ad = new RestDebugConfig();
            }
            restDebugConfig = f4005ad;
        }
        return restDebugConfig;
    }

    public boolean isQAEnv() {
        return this.qw;
    }

    public void setDebugOn(boolean z) {
        ApollonConstants.DEBUG = z;
    }

    public void setQAEnv(boolean z) {
        this.qw = z;
    }
}
