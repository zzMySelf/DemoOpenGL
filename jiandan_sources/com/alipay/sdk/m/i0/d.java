package com.alipay.sdk.m.i0;

import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class d {
    public String a;
    public int b;
    public long c = (System.currentTimeMillis() + 86400000);

    public d(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    public String toString() {
        return "ValueData{value='" + this.a + ExtendedMessageFormat.QUOTE + ", code=" + this.b + ", expired=" + this.c + ExtendedMessageFormat.END_FE;
    }
}
