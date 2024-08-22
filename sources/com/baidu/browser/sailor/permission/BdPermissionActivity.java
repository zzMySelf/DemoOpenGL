package com.baidu.browser.sailor.permission;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.baidu.browser.sailor.permission.a;
import com.baidu.browser.sailor.util.b;
import com.baidu.webkit.internal.a.a;

public class BdPermissionActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private int f11147a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f11148b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int a2 = a.a(this);
        super.onCreate(bundle);
        a.a(this, a2);
        Intent intent = getIntent();
        this.f11147a = intent.getIntExtra("request_code", 0);
        this.f11148b = intent.getStringArrayExtra("permissions");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        String[] strArr = this.f11148b;
        if (strArr != null && strArr.length != 0) {
            int i2 = this.f11147a;
            if (b.a()) {
                requestPermissions(strArr, i2);
            } else if (this instanceof a.C0210a) {
                a.C0210a aVar = (a.C0210a) this;
                if (b.a()) {
                    requestPermissions(strArr, i2);
                } else if (!isFinishing()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable(strArr, this, aVar, i2) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ String[] f11149a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ Activity f11150b;

                        /* renamed from: c  reason: collision with root package name */
                        final /* synthetic */ C0210a f11151c;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ int f11152d;

                        {
                            this.f11149a = r1;
                            this.f11150b = r2;
                            this.f11151c = r3;
                            this.f11152d = r4;
                        }

                        public final void run() {
                            int[] iArr = new int[this.f11149a.length];
                            PackageManager packageManager = this.f11150b.getPackageManager();
                            String packageName = this.f11150b.getPackageName();
                            int length = this.f11149a.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                iArr[i2] = packageManager.checkPermission(this.f11149a[i2], packageName);
                            }
                            this.f11151c.onRequestPermissionsResult(this.f11152d, this.f11149a, iArr);
                        }
                    });
                }
            }
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        a.C0210a aVar;
        b a2 = b.a();
        int i3 = this.f11147a;
        if (a2.f11154a == null || !a2.f11154a.containsKey(Integer.valueOf(i3))) {
            aVar = null;
        } else {
            aVar = a2.f11154a.get(Integer.valueOf(i3));
        }
        if (aVar != null) {
            aVar.onRequestPermissionsResult(i2, strArr, iArr);
        }
        finish();
    }
}
