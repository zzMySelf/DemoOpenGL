package com.baidu.crashpad;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import com.baidu.crashpad.ZeusLogUploader;

public final class DumperService extends Service implements ZeusLogUploader.OnFinishedListener {

    /* renamed from: ad  reason: collision with root package name */
    public int f747ad;

    /* renamed from: i  reason: collision with root package name */
    public ZeusLogUploader f748i;

    /* renamed from: o  reason: collision with root package name */
    public boolean f749o = true;

    /* renamed from: pf  reason: collision with root package name */
    public String f750pf = "";

    /* renamed from: th  reason: collision with root package name */
    public long f751th;

    /* renamed from: uk  reason: collision with root package name */
    public String f752uk;

    /* renamed from: yj  reason: collision with root package name */
    public String f753yj;

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Cannot bind to DumperService.");
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFinished(java.lang.String r10, int r11, java.lang.String r12) {
        /*
            r9 = this;
            android.content.Context r1 = r9.getApplicationContext()
            java.lang.String r0 = r9.f752uk
            if (r0 == 0) goto L_0x0023
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = r9.f752uk
            java.lang.String r2 = "0"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = r9.f752uk     // Catch:{ all -> 0x0023 }
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0023 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ all -> 0x0023 }
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            boolean r2 = r9.f749o
            if (r2 == 0) goto L_0x0039
            r2 = 3
            if (r11 != r2) goto L_0x0039
            com.baidu.crashpad.ZeusLogUploader r2 = r9.f748i
            if (r2 == 0) goto L_0x0039
            r3 = 1
            int r2 = r2.i(r10, r3)
            r3 = 6
            if (r2 == r3) goto L_0x0039
            java.lang.String r12 = "Failed to encrypt file."
        L_0x0039:
            r8 = r12
            if (r0 == 0) goto L_0x0049
            com.baidu.crashpad.CrashCallback r0 = (com.baidu.crashpad.CrashCallback) r0
            java.lang.String r2 = r9.f753yj
            int r3 = r9.f747ad
            long r4 = r9.f751th
            r6 = r10
            r7 = r11
            r0.onCrash(r1, r2, r3, r4, r6, r7, r8)
        L_0x0049:
            r9.stopSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crashpad.DumperService.onFinished(java.lang.String, int, java.lang.String):void");
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            stopSelf();
        }
        String stringExtra = intent.getStringExtra("LOG_TYPE");
        String stringExtra2 = intent.getStringExtra("CRASH_FILE");
        boolean booleanExtra = intent.getBooleanExtra("HTTPS", true);
        this.f747ad = intent.getIntExtra("CRASH_SIGNAL", -1);
        this.f751th = intent.getLongExtra("CRASH_TIME", -1);
        this.f752uk = intent.getStringExtra("CRASH_CALLBACK");
        this.f749o = intent.getBooleanExtra("CRASHLOGENCRYPT", true);
        this.f750pf = intent.getStringExtra("ENCRYPTKEY");
        ZeusLogUploader zeusLogUploader = new ZeusLogUploader(stringExtra, (String) null, booleanExtra);
        this.f748i = zeusLogUploader;
        if (zeusLogUploader != null) {
            ZeusLogUploader.m12if(this.f750pf);
            ZeusLogUploader.m13switch(this.f749o);
        }
        ZwDebugExtra.init(this);
        String str = this.f753yj;
        if (str == null) {
            str = "0";
        }
        this.f753yj = str;
        if (!qw(getApplicationContext())) {
            onFinished(stringExtra2, 3, "doUpload Failed, Network is not connected.");
            return 3;
        } else if (!booleanExtra) {
            onFinished(stringExtra2, 3, "doUpload Failed, HTTP is never supported!");
            stopSelf();
            return 0;
        } else {
            ZeusLogUploader zeusLogUploader2 = this.f748i;
            if (zeusLogUploader2 != null) {
                zeusLogUploader2.ggg(stringExtra2, true, this);
            } else {
                onFinished(stringExtra2, 3, "doUpload Failed, logUploader is null.");
            }
            return 3;
        }
    }

    public final boolean qw(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }
}
