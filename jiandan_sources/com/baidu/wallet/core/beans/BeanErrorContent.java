package com.baidu.wallet.core.beans;

public class BeanErrorContent {
    public int a;
    public int b;
    public String c;
    public Object d;

    public BeanErrorContent(int i2, int i3, String str, Object obj) {
        this.a = i2;
        this.b = i3;
        this.c = str;
        this.d = obj;
    }

    public int getBeanId() {
        return this.a;
    }

    public Object getErrContent() {
        return this.d;
    }

    public String getMsg() {
        return this.c;
    }

    public int getRet() {
        return this.b;
    }
}
