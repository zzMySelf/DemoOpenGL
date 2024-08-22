package com.baidu.ubc;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import com.baidu.ubc.constants.EnumConstants$RunTime;
import fe.fe.mmm.c;
import fe.fe.mmm.i;
import fe.fe.mmm.m;
import fe.fe.mmm.qqq;
import fe.fe.mmm.th;
import fe.fe.mmm.tt;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

public class UBCUploadTimingManager {

    /* renamed from: if  reason: not valid java name */
    public static final boolean f17if = tt.vvv();

    /* renamed from: switch  reason: not valid java name */
    public static volatile UBCUploadTimingManager f18switch;

    /* renamed from: ad  reason: collision with root package name */
    public long f1115ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public UploadTimingCallback f1116de;

    /* renamed from: fe  reason: collision with root package name */
    public Application f1117fe;

    /* renamed from: i  reason: collision with root package name */
    public int f1118i = 0;

    /* renamed from: o  reason: collision with root package name */
    public long f1119o = 0;

    /* renamed from: pf  reason: collision with root package name */
    public long f1120pf = 0;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public qqq f1121rg;

    /* renamed from: th  reason: collision with root package name */
    public int f1122th = 0;

    /* renamed from: uk  reason: collision with root package name */
    public int f1123uk = 100;

    /* renamed from: yj  reason: collision with root package name */
    public int f1124yj = 0;

    public interface UploadTimingCallback {
        void ad();

        void de();

        void fe();

        void qw();
    }

    public class ad extends BroadcastReceiver {
        public ad() {
        }

        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                        UBCUploadTimingManager.this.xxx();
                    }
                } catch (Exception unused) {
                    boolean yj2 = UBCUploadTimingManager.f17if;
                }
            }
        }
    }

    public class de implements Application.ActivityLifecycleCallbacks {
        public de() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            UBCUploadTimingManager.ad(UBCUploadTimingManager.this);
            if (UBCUploadTimingManager.this.qw == 1) {
                UBCUploadTimingManager.this.m52switch();
            }
        }

        public void onActivityStopped(Activity activity) {
            UBCUploadTimingManager.de(UBCUploadTimingManager.this);
            if (UBCUploadTimingManager.this.qw == 0) {
                UBCUploadTimingManager.this.ggg();
            }
        }
    }

    public static class fe {

        /* renamed from: ad  reason: collision with root package name */
        public int f1126ad;
        public int qw;
    }

    public class rg extends BroadcastReceiver {
        public rg() {
        }

        public void onReceive(Context context, Intent intent) {
            UBCUploadTimingManager.this.aaa(intent.getAction());
        }
    }

    public static /* synthetic */ int ad(UBCUploadTimingManager uBCUploadTimingManager) {
        int i2 = uBCUploadTimingManager.qw;
        uBCUploadTimingManager.qw = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int de(UBCUploadTimingManager uBCUploadTimingManager) {
        int i2 = uBCUploadTimingManager.qw;
        uBCUploadTimingManager.qw = i2 - 1;
        return i2;
    }

    public static UBCUploadTimingManager o() {
        if (f18switch == null) {
            synchronized (UBCUploadTimingManager.class) {
                if (f18switch == null) {
                    f18switch = new UBCUploadTimingManager();
                }
            }
        }
        return f18switch;
    }

    public final void aaa(String str) {
        boolean z = f17if;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = (elapsedRealtime - this.f1120pf) + this.f1119o;
        this.f1119o = System.currentTimeMillis();
        this.f1120pf = elapsedRealtime;
        c.de().nn(str, j, this.f1119o, this.f1120pf);
        m.m128switch("action:" + str + " oldTime:" + j + " newTime:" + this.f1119o + " clockTime:" + this.f1120pf, EnumConstants$RunTime.TIMING_SYSTEM_TIME_CHANGED);
    }

    public void ddd(String str, int i2) {
        if (i2 == -1 && !i.vvv().th(str) && i.vvv().i(str)) {
            if (f17if) {
                "onNewEvent id=" + str + ", currentEventCount=" + this.f1122th;
            }
            i(false, 0, 1);
        }
    }

    public final void eee() {
        i(true, 0, 0);
        if (this.f1118i == 0) {
            boolean z = f17if;
            th.nn().d();
        }
    }

    public final void ggg() {
        boolean z = f17if;
        UploadTimingCallback uploadTimingCallback = this.f1116de;
        if (uploadTimingCallback != null) {
            uploadTimingCallback.qw();
        }
    }

    public final void i(boolean z, int i2, int i3) {
        if (!z) {
            boolean z2 = m51if();
            this.f1124yj += i2;
            this.f1122th += i3;
            if (z2 && !m51if()) {
                vvv();
            }
        } else if (!m51if()) {
            vvv();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m51if() {
        return this.f1122th + this.f1124yj < this.f1123uk;
    }

    public void mmm() {
        this.f1118i++;
    }

    public void nn(String str, int i2) {
        if (i2 > 0 && !i.vvv().th(str) && i.vvv().i(str)) {
            if (f17if) {
                "onNewFlow id=" + str + ", currentFlowCount=" + this.f1124yj;
            }
            i(false, i2, 0);
        }
    }

    public void pf(Context context, qqq qqq, UploadTimingCallback uploadTimingCallback) {
        if (context == null) {
            m.m128switch("context is null", EnumConstants$RunTime.CONTEXT_IS_NULL);
            return;
        }
        if (!(context instanceof Application)) {
            m.m128switch("context is not Application", EnumConstants$RunTime.INIT_MESSAGE);
        }
        Application application = (Application) context;
        this.f1117fe = application;
        application.registerActivityLifecycleCallbacks(new de());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
        this.f1117fe.registerReceiver(new ad(), intentFilter);
        this.f1121rg = qqq;
        this.f1116de = uploadTimingCallback;
        fe mmm = qqq.mmm();
        this.f1122th = Math.max(mmm.qw, 0);
        this.f1124yj = Math.max(mmm.f1126ad, 0);
        this.f1123uk = i.vvv().c();
        try {
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter2.addAction("android.intent.action.TIME_SET");
            this.f1117fe.registerReceiver(new rg(), intentFilter2);
            this.f1119o = System.currentTimeMillis();
            this.f1120pf = SystemClock.elapsedRealtime();
        } catch (Exception unused) {
        }
    }

    public void ppp() {
        boolean z = f17if;
        fe mmm = this.f1121rg.mmm();
        this.f1122th = Math.max(mmm.qw, 0);
        this.f1124yj = Math.max(mmm.f1126ad, 0);
    }

    public void qqq(boolean z) {
        if (f17if) {
            "onUploadFinish isSuccess: " + z;
        }
        this.f1118i = Math.max(this.f1118i - 1, 0);
        if (z) {
            eee();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m52switch() {
        boolean z = f17if;
        UploadTimingCallback uploadTimingCallback = this.f1116de;
        if (uploadTimingCallback != null) {
            uploadTimingCallback.fe();
        }
    }

    public final void vvv() {
        boolean z = f17if;
        UploadTimingCallback uploadTimingCallback = this.f1116de;
        if (uploadTimingCallback != null) {
            uploadTimingCallback.de();
        }
    }

    public void when(int i2, int i3) {
        if (i2 >= 0 && i3 >= 0 && i2 + i3 != 0) {
            if (f17if) {
                "onClearData eventCount=" + i2 + ", flowCount=" + i3;
            }
            this.f1122th = Math.max(this.f1122th - i2, 0);
            this.f1124yj = Math.max(this.f1124yj - i3, 0);
        }
    }

    public final void xxx() {
        boolean z = f17if;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1115ad > 60000) {
            UploadTimingCallback uploadTimingCallback = this.f1116de;
            if (uploadTimingCallback != null) {
                uploadTimingCallback.ad();
            }
            boolean z2 = f17if;
        }
        this.f1115ad = currentTimeMillis;
    }
}
