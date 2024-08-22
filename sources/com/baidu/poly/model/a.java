package com.baidu.poly.model;

import android.app.Activity;

/* compiled from: SearchBox */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f16973b = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f16974a;

    public static a a() {
        return f16973b;
    }

    public int b() {
        return this.f16974a;
    }

    public void a(Activity activity) {
        this.f16974a = activity.getTaskId();
    }
}
