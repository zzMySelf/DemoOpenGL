package com.dxmpay.wallet.core.beans;

public class BeanErrorContent {

    /* renamed from: ad  reason: collision with root package name */
    public int f4256ad;

    /* renamed from: de  reason: collision with root package name */
    public String f4257de;

    /* renamed from: fe  reason: collision with root package name */
    public Object f4258fe;
    public int qw;

    public BeanErrorContent(int i2, int i3, String str, Object obj) {
        this.qw = i2;
        this.f4256ad = i3;
        this.f4257de = str;
        this.f4258fe = obj;
    }

    public int getBeanId() {
        return this.qw;
    }

    public Object getErrContent() {
        return this.f4258fe;
    }

    public String getMsg() {
        return this.f4257de;
    }

    public int getRet() {
        return this.f4256ad;
    }
}
