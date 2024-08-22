package com.dxmpay.wallet.core.beans;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import java.net.URLDecoder;

public abstract class BeanRequestBase {
    public boolean mBelongPaySdk = false;

    public abstract boolean checkRequestValidity();

    public abstract String getRequestId();

    @SuppressLint({"DefaultLocale"})
    public String getSinalParam(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            for (String split : str.split(a.n)) {
                String[] split2 = split.split("=");
                if (split2 != null && !TextUtils.isEmpty(split2[0]) && str2.equals(split2[0].toUpperCase()) && split2.length > 1) {
                    return URLDecoder.decode(split2[1], BeanConstants.ENCODE_GB_18030);
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public void setBelongPaySdk() {
        this.mBelongPaySdk = true;
    }
}
