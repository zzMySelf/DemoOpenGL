package com.unionpay.a;

import java.net.URL;
import java.util.HashMap;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private int f6086a = 1;

    /* renamed from: b  reason: collision with root package name */
    private String f6087b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f6088c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f6089d;

    /* renamed from: e  reason: collision with root package name */
    private String f6090e;

    public d(String str) {
        this.f6087b = str;
        this.f6088c = null;
        this.f6089d = null;
    }

    public final URL a() {
        try {
            return new URL(this.f6087b);
        } catch (Exception e2) {
            return null;
        }
    }

    public final void a(String str) {
        if (str != null) {
            this.f6089d = str.getBytes();
            this.f6090e = str;
        }
    }

    public final String b() {
        return this.f6086a == 1 ? "POST" : "GET";
    }

    public final String c() {
        return this.f6090e;
    }

    public final HashMap d() {
        return this.f6088c;
    }
}
