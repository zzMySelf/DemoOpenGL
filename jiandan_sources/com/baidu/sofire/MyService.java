package com.baidu.sofire;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.sofire.b.d;
import com.baidu.sofire.b.j;
import com.baidu.sofire.b.l;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.l.w;

public class MyService extends Service {
    public static final /* synthetic */ int b = 0;
    public volatile int a = 0;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Intent b;

        public a(String str, Intent intent) {
            this.a = str;
            this.b = intent;
        }

        public void run() {
            try {
                MyService.this.a++;
                if (MyService.this.getPackageName().equals(this.a)) {
                    l.a(MyService.this.getApplicationContext(), MyService.this.getClassLoader(), this.b);
                    MyService.this.a();
                    return;
                }
                j jVar = j.g;
                if (jVar == null) {
                    MyService.this.a();
                    return;
                }
                ApkInfo b2 = jVar.b(this.a);
                if (b2 == null) {
                    MyService.this.a();
                    return;
                }
                l.a(MyService.this.getApplicationContext(), b2.classLoader, this.b);
                MyService.this.a();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
                MyService myService = MyService.this;
                int i3 = MyService.b;
                myService.a();
            }
        }
    }

    public final void a() {
        try {
            this.a--;
            if (this.a <= 0) {
                this.a = 0;
                stopSelf();
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            return 2;
        }
        try {
            Bundle bundleExtra = intent.getBundleExtra("bundle");
            if (bundleExtra != null) {
                String[] stringArray = bundleExtra.getStringArray(com.alipay.sdk.m.s.a.r);
                int i4 = bundleExtra.getInt("key");
                int i5 = bundleExtra.getInt("delay");
                if (stringArray != null && stringArray.length == 2 && !TextUtils.isEmpty(stringArray[0]) && !TextUtils.isEmpty(stringArray[1])) {
                    d.a(getApplicationContext(), i5, stringArray[0], stringArray[1], i4);
                    return 2;
                }
            }
            String stringExtra = intent.getStringExtra("from_plugin_package");
            if (!TextUtils.isEmpty(stringExtra) || !TextUtils.isEmpty(intent.getAction())) {
                w.a(getApplicationContext()).a((Runnable) new a(stringExtra, intent));
            } else {
                a();
            }
        } catch (Throwable unused) {
            int i6 = com.baidu.sofire.a.a.a;
        }
        return 2;
    }
}
