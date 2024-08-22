package com.heytap.openid.bean;

import androidx.annotation.Keep;

@Keep
public final class OpenIDInfo {
    @Keep
    public static int Type_AAID = 2;
    @Keep
    public static int Type_OAID = 8;
    @Keep
    public static int Type_VAID = 4;
    @Keep
    public final String AAID;
    @Keep
    public final String OAID;
    @Keep
    public final boolean OAIDStatus;
    @Keep
    public final String VAID;

    public OpenIDInfo(String str, boolean z, String str2, String str3) {
        this.OAID = str;
        this.OAIDStatus = z;
        this.VAID = str2;
        this.AAID = str3;
    }

    @Keep
    public native String getAAID();

    @Keep
    public native String getOAID();

    @Keep
    public native boolean getOAIDStatus();

    @Keep
    public native String getVAID();
}
