package com.alipay.sdk.m.h;

public final class c extends b {
    public final String f;

    public c(String str) {
        this.f = str;
    }

    public void a() throws Exception {
        this.a = 1;
        byte[] bytes = this.f.getBytes("UTF-8");
        this.c = bytes;
        this.b = (byte) bytes.length;
    }
}
