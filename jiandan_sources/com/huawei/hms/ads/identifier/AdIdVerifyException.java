package com.huawei.hms.ads.identifier;

import androidx.annotation.Keep;

@Keep
public class AdIdVerifyException extends Exception {
    @Keep
    public AdIdVerifyException(String str) {
        super(str);
    }
}
