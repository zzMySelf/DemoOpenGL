package com.alipay.sdk.m.r0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.alipay.sdk.m.q0.a;

public class b {
    public static String e = "OpenDeviceId library";
    public static boolean f = false;
    public Context a = null;
    public com.alipay.sdk.m.q0.a b;
    public ServiceConnection c;
    public C0015b d = null;

    public class a implements ServiceConnection {
        public a() {
        }

        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.alipay.sdk.m.q0.a unused = b.this.b = a.C0013a.a(iBinder);
            if (b.this.d != null) {
                b.this.d.a("Deviceid Service Connected", b.this);
            }
            b.this.b("Service onServiceConnected");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            com.alipay.sdk.m.q0.a unused = b.this.b = null;
            b.this.b("Service onServiceDisconnected");
        }
    }

    /* renamed from: com.alipay.sdk.m.r0.b$b  reason: collision with other inner class name */
    public interface C0015b<T> {
        void a(T t, b bVar);
    }

    public String b() {
        if (this.a != null) {
            try {
                if (this.b != null) {
                    return this.b.a();
                }
                return null;
            } catch (RemoteException e2) {
                a("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        } else {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public String c() {
        if (this.a != null) {
            try {
                if (this.b != null) {
                    return this.b.b();
                }
                return null;
            } catch (RemoteException e2) {
                a("getUDID error, RemoteException!");
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                a("getUDID error, Exception!");
                e3.printStackTrace();
                return null;
            }
        } else {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public String d() {
        Context context = this.a;
        if (context != null) {
            String packageName = context.getPackageName();
            b("liufeng, getVAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                b("input package is null!");
                return null;
            }
            try {
                if (this.b != null) {
                    return this.b.b(packageName);
                }
                return null;
            } catch (RemoteException e2) {
                a("getVAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        } else {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public boolean e() {
        try {
            if (this.b == null) {
                return false;
            }
            b("Device support opendeviceid");
            return this.b.c();
        } catch (RemoteException unused) {
            a("isSupport error, RemoteException!");
            return false;
        }
    }

    public void f() {
        try {
            this.a.unbindService(this.c);
            b("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            a("unBind Service exception");
        }
        this.b = null;
    }

    public int a(Context context, C0015b<String> bVar) {
        if (context != null) {
            this.a = context;
            this.d = bVar;
            this.c = new a();
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.a.bindService(intent, this.c, 1)) {
                b("bindService Successful!");
                return 1;
            }
            b("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        boolean z = f;
    }

    public String a() {
        Context context = this.a;
        if (context != null) {
            String packageName = context.getPackageName();
            b("liufeng, getAAID package：" + packageName);
            if (packageName == null || packageName.equals("")) {
                b("input package is null!");
                return null;
            }
            try {
                if (this.b == null) {
                    return null;
                }
                String a2 = this.b.a(packageName);
                if ((a2 == null || "".equals(a2)) && this.b.c(packageName)) {
                    return this.b.a(packageName);
                }
                return a2;
            } catch (RemoteException unused) {
                a("getAAID error, RemoteException!");
                return null;
            }
        } else {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
    }

    public void a(boolean z) {
        f = z;
    }

    private void a(String str) {
        boolean z = f;
    }
}
