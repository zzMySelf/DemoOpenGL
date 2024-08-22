package com.alipay.sdk.m.x;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;

public abstract class c extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    public static final String f2595c = "v1";

    /* renamed from: d  reason: collision with root package name */
    public static final String f2596d = "v2";

    /* renamed from: a  reason: collision with root package name */
    public Activity f2597a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2598b;

    public c(Activity activity, String str) {
        super(activity);
        this.f2597a = activity;
        this.f2598b = str;
    }

    public abstract void a(String str);

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            CookieSyncManager.createInstance(this.f2597a.getApplicationContext()).sync();
            CookieManager.getInstance().setCookie(str, str2);
            CookieSyncManager.getInstance().sync();
        }
    }

    public abstract boolean b();

    public abstract void c();

    public boolean a() {
        return "v1".equals(this.f2598b);
    }

    public static void a(WebView webView) {
        if (webView != null) {
            try {
                webView.resumeTimers();
            } catch (Throwable th2) {
            }
        }
    }
}
