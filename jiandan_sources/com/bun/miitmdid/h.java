package com.bun.miitmdid;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;

@Keep
public class h {
    @Keep
    public Class<?> a;
    @Keep
    @Nullable
    public Object b;
    @Keep
    public String c;
    @Keep
    public Class<?>[] d;
    @Keep
    public Object[] e;
    @Keep
    @Nullable
    public Class<?> f;
    @Keep
    public boolean g = false;

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        this.a = cls;
        this.b = obj;
        this.c = str;
        this.d = clsArr;
        this.e = objArr;
    }

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr, Class<?> cls2) {
        this.a = cls;
        this.b = obj;
        this.c = str;
        this.d = clsArr;
        this.e = objArr;
        this.f = cls2;
    }

    @Keep
    public native Object a();

    @Nullable
    public Class<?> b() {
        return this.f;
    }

    @Keep
    public native boolean c();
}
