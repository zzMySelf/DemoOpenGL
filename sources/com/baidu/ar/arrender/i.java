package com.baidu.ar.arrender;

import com.baidu.ar.ability.c;

public class i extends c {

    /* renamed from: f  reason: collision with root package name */
    private String f9089f;

    /* renamed from: g  reason: collision with root package name */
    private String f9090g;

    /* renamed from: h  reason: collision with root package name */
    private Object f9091h;

    /* renamed from: i  reason: collision with root package name */
    private a f9092i;

    public enum a {
        INT,
        FLOAT,
        FLOAT_ARRAY,
        STRING
    }

    public void a(float f2) {
        this.f9091h = Float.valueOf(f2);
        this.f9092i = a.FLOAT;
    }

    public void a(int i2) {
        this.f9091h = Integer.valueOf(i2);
        this.f9092i = a.INT;
    }

    public void a(float[] fArr) {
        this.f9091h = fArr;
        this.f9092i = a.FLOAT_ARRAY;
    }

    public void b(String str) {
        this.f9090g = str;
    }

    public void c(String str) {
        this.f9091h = str;
        this.f9092i = a.STRING;
    }

    public void d(String str) {
        this.f9089f = str;
    }

    public String f() {
        return this.f9090g;
    }

    public Object g() {
        return this.f9091h;
    }

    public a h() {
        return this.f9092i;
    }

    public String i() {
        return this.f9089f;
    }
}
