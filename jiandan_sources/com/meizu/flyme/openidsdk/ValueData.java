package com.meizu.flyme.openidsdk;

import androidx.annotation.Keep;

@Keep
public class ValueData {
    @Keep
    public int code;
    @Keep
    public long expired = (System.currentTimeMillis() + 86400000);
    @Keep
    public String value;

    public ValueData(String str, int i2) {
        this.value = str;
        this.code = i2;
    }

    @Keep
    public native String toString();
}
