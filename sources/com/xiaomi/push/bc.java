package com.xiaomi.push;

public class bc implements be {

    /* renamed from: a  reason: collision with root package name */
    private final String f6745a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6746b;

    public bc(String str, String str2) {
        if (str != null) {
            this.f6745a = str;
            this.f6746b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    public String a() {
        return this.f6745a;
    }

    public String b() {
        return this.f6746b;
    }
}
