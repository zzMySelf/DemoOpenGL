package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.mcast.McastConfig;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.d;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.mapsdkplatform.comjni.tools.a;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;

/* compiled from: BMapManagerInternal */
public class b implements PermissionCheck.c {

    /* renamed from: a  reason: collision with root package name */
    private static b f14869a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f14870b = -100;

    /* renamed from: c  reason: collision with root package name */
    private Context f14871c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f14872d;

    /* renamed from: e  reason: collision with root package name */
    private f f14873e;

    /* renamed from: f  reason: collision with root package name */
    private String f14874f;

    /* renamed from: g  reason: collision with root package name */
    private int f14875g;

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        a.a();
    }

    private b() {
    }

    public static b c() {
        if (f14869a == null) {
            f14869a = new b();
        }
        return f14869a;
    }

    private void f() {
        f fVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
        intentFilter.addAction(McastConfig.ACTION_WIFI_STATE_CHANGED);
        Context context = this.f14871c;
        if (context != null && (fVar = this.f14873e) != null) {
            context.registerReceiver(fVar, intentFilter);
        }
    }

    private void g() {
        Context context;
        f fVar = this.f14873e;
        if (fVar != null && (context = this.f14871c) != null) {
            context.unregisterReceiver(fVar);
        }
    }

    public Context b() {
        Context context = this.f14871c;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }

    public void d() {
        if (this.f14875g == 0) {
            if (this.f14871c != null) {
                this.f14873e = new f();
                f();
                SysUpdateObservable.getInstance().updateNetworkInfo(this.f14871c);
            } else {
                throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
        }
        this.f14875g++;
    }

    public boolean e() {
        if (this.f14871c != null) {
            this.f14872d = new a(this);
            h.b(this.f14871c);
            d.a().a(this.f14871c);
            h.r();
            PermissionCheck.init(this.f14871c);
            PermissionCheck.setPermissionCheckResultListener(this);
            PermissionCheck.permissionCheck();
            return true;
        }
        throw new IllegalStateException("BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }

    public void a(Context context) {
        this.f14871c = context;
    }

    public void a() {
        int i2 = this.f14875g - 1;
        this.f14875g = i2;
        if (i2 == 0) {
            g();
            h.q();
        }
    }

    /* access modifiers changed from: private */
    public void a(Message message) {
        Intent intent;
        if (message.what == 2012) {
            if (message.arg1 == 0) {
                intent = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK);
            } else {
                Intent intent2 = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
                intent2.putExtra("error_code", message.arg1);
                intent2.putExtra("error_message", (String) message.obj);
                intent = intent2;
            }
            this.f14871c.sendBroadcast(intent);
            return;
        }
        if (message.arg2 == 3) {
            this.f14871c.sendBroadcast(new Intent("network error"));
        }
        int i2 = message.arg2;
        if (i2 == 2 || i2 == 404 || i2 == 5 || i2 == 8) {
            this.f14871c.sendBroadcast(new Intent("network error"));
        }
    }

    public void a(PermissionCheck.b bVar) {
        int i2;
        if (bVar != null) {
            if (bVar.f15083a == 0) {
                h.D = bVar.f15087e;
                h.a(bVar.f15084b, bVar.f15085c);
            } else {
                Log.e("baidumapsdk", "Authentication Error\n" + bVar.toString());
            }
            int i3 = bVar.f15083a;
            if (!(i3 == PermissionCheck.f15082j || i3 == PermissionCheck.f15081i || i3 == PermissionCheck.k)) {
                d.a().a(bVar.f15088f);
            }
            Handler handler = this.f14872d;
            if (handler != null && (i2 = bVar.f15083a) != f14870b) {
                f14870b = i2;
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.what = 2012;
                obtainMessage.arg1 = bVar.f15083a;
                obtainMessage.obj = bVar.f15086d;
                this.f14872d.sendMessage(obtainMessage);
            }
        }
    }

    public void a(String str) {
        this.f14874f = str;
    }
}
