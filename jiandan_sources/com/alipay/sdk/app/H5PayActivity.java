package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.m.j.b;
import com.alipay.sdk.m.j.d;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.m.x.c;
import java.lang.ref.WeakReference;

public class H5PayActivity extends Activity {
    public c a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public WeakReference<a> h;

    private void b() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (Throwable th2) {
            e.a(th2);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r2 = this;
            java.lang.Object r0 = com.alipay.sdk.app.PayTask.h
            monitor-enter(r0)
            r0.notify()     // Catch:{ Exception -> 0x0009 }
            goto L_0x0009
        L_0x0007:
            r1 = move-exception
            goto L_0x000b
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            return
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.H5PayActivity.a():void");
    }

    public void finish() {
        a();
        super.finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1010) {
            d.a((a) n.a(this.h), i2, i3, intent);
        }
    }

    public void onBackPressed() {
        c cVar = this.a;
        if (cVar == null) {
            finish();
        } else if (cVar.a()) {
            cVar.b();
        } else {
            if (!cVar.b()) {
                super.onBackPressed();
            }
            b.a(b.a());
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            a a2 = a.C0016a.a(getIntent());
            if (a2 == null) {
                finish();
                return;
            }
            this.h = new WeakReference<>(a2);
            if (!com.alipay.sdk.m.m.a.z().v()) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(3);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("url", (String) null);
                this.b = string;
                if (!n.f(string)) {
                    finish();
                    return;
                }
                this.d = extras.getString("cookie", (String) null);
                this.c = extras.getString(com.alipay.sdk.m.p.e.s, (String) null);
                this.e = extras.getString("title", (String) null);
                this.g = extras.getString("version", "v1");
                this.f = extras.getBoolean("backisexit", false);
                try {
                    com.alipay.sdk.m.x.d dVar = new com.alipay.sdk.m.x.d(this, a2, this.g);
                    setContentView(dVar);
                    dVar.a(this.e, this.c, this.f);
                    dVar.a(this.b, this.d);
                    dVar.a(this.b);
                    this.a = dVar;
                } catch (Throwable th2) {
                    com.alipay.sdk.m.k.a.a(a2, com.alipay.sdk.m.k.b.l, "GetInstalledAppEx", th2);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        c cVar = this.a;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void setRequestedOrientation(int i2) {
        try {
            super.setRequestedOrientation(i2);
        } catch (Throwable unused) {
        }
    }
}
