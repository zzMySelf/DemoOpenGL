package com.sdk.a;

public final class h<T> {
    public int a;
    public T b;
    public final boolean c;

    public h(int i2, T t, boolean z) {
        this.a = i2;
        this.b = t;
        this.c = z;
    }

    public int a() {
        return this.a;
    }

    public T b() {
        return this.b;
    }

    public String toString() {
        return "{code:" + this.a + ", response:" + this.b + ", resultFormCache:" + this.c + "}";
    }
}
