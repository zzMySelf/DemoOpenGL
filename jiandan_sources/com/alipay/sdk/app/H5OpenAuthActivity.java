package com.alipay.sdk.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.s.a;
import com.baidu.android.common.others.lang.StringUtil;

public class H5OpenAuthActivity extends H5PayActivity {

    /* renamed from: i  reason: collision with root package name */
    public boolean f653i = false;

    public void a() {
    }

    public void onDestroy() {
        if (this.f653i) {
            try {
                a a = a.C0016a.a(getIntent());
                if (a != null) {
                    com.alipay.sdk.m.k.a.b((Context) this, a, "", a.d);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    public void startActivity(Intent intent) {
        try {
            a a = a.C0016a.a(intent);
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data != null && data.toString().startsWith("alipays://platformapi/startapp")) {
                    finish();
                }
            } catch (Throwable th2) {
                String uri = (intent == null || intent.getData() == null) ? StringUtil.NULL_STRING : intent.getData().toString();
                if (a != null) {
                    com.alipay.sdk.m.k.a.a(a, b.l, b.p0, th2, uri);
                }
                this.f653i = true;
                throw th2;
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
