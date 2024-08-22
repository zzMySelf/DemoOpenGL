package com.xiaomi.push;

import java.util.Map;

public class hb implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f7093a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static String f7094b = null;

    /* renamed from: a  reason: collision with other field name */
    private int f495a;

    /* renamed from: a  reason: collision with other field name */
    private he f496a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f497a = ha.f480a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f498b = true;

    /* renamed from: c  reason: collision with root package name */
    private String f7095c;

    /* renamed from: d  reason: collision with root package name */
    private String f7096d;

    /* renamed from: e  reason: collision with root package name */
    private String f7097e;

    public static final String a() {
        String str = f7094b;
        if (str != null) {
            return str;
        }
        if (z.a()) {
            return "sandbox.xmpush.xiaomi.com";
        }
        if (z.b()) {
            return "10.38.162.35";
        }
        return "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        if (!z.b()) {
            f7094b = str;
        }
    }

    public hb(Map<String, Integer> map, int i2, String str, he heVar) {
        a(map, i2, str, heVar);
    }

    private void a(Map<String, Integer> map, int i2, String str, he heVar) {
        this.f495a = i2;
        this.f7095c = str;
        this.f496a = heVar;
    }

    public void b(String str) {
        this.f7097e = str;
    }

    public String b() {
        return this.f7097e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m8586a() {
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m8584a() {
        return this.f495a;
    }

    public String c() {
        if (this.f7096d == null) {
            this.f7096d = a();
        }
        return this.f7096d;
    }

    public void c(String str) {
        this.f7096d = str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8585a() {
        return this.f497a;
    }

    public void a(boolean z) {
        this.f497a = z;
    }
}
