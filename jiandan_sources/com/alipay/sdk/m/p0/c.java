package com.alipay.sdk.m.p0;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.recyclerview.widget.ItemTouchHelper;

public class c {
    public static String A = null;
    public static volatile c B = null;
    public static volatile b C = null;
    public static final String a = "VMS_IDLG_SDK_Client";
    public static final String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    public static final String c = "persist.sys.identifierid.supported";
    public static final String d = "appid";
    public static final String e = "type";
    public static final String f = "OAID";
    public static final String g = "VAID";
    public static final String h = "AAID";

    /* renamed from: i  reason: collision with root package name */
    public static final int f676i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 4;
    public static final int m = 11;
    public static final int n = 2000;

    /* renamed from: o  reason: collision with root package name */
    public static Context f677o = null;
    public static boolean p = false;
    public static d q;
    public static d r;
    public static d s;
    public static Object t = new Object();
    public static HandlerThread u;
    public static Handler v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 11) {
                String unused = c.w = c.C.a(message.getData().getInt("type"), message.getData().getString("appid"));
                synchronized (c.t) {
                    c.t.notify();
                }
            }
        }
    }

    public static c a(Context context) {
        Class<c> cls = c.class;
        if (B == null) {
            synchronized (cls) {
                f677o = context.getApplicationContext();
                B = new c();
            }
        }
        if (C == null) {
            synchronized (cls) {
                f677o = context.getApplicationContext();
                g();
                C = new b(f677o);
                f();
            }
        }
        return B;
    }

    public static void f() {
        p = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    public static void g() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        u = handlerThread;
        handlerThread.start();
        v = new a(u.getLooper());
    }

    public String b(String str) {
        if (!c()) {
            return null;
        }
        String str2 = y;
        if (str2 != null) {
            return str2;
        }
        a(1, str);
        if (r == null && y != null) {
            a(f677o, 1, str);
        }
        return y;
    }

    public boolean c() {
        return p;
    }

    public String b() {
        if (!c()) {
            return null;
        }
        a(4, (String) null);
        return A;
    }

    private void b(int i2, String str) {
        Message obtainMessage = v.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        v.sendMessage(obtainMessage);
    }

    public String a() {
        if (!c()) {
            return null;
        }
        String str = x;
        if (str != null) {
            return str;
        }
        a(0, (String) null);
        if (q == null) {
            a(f677o, 0, (String) null);
        }
        return x;
    }

    public String a(String str) {
        if (!c()) {
            return null;
        }
        String str2 = z;
        if (str2 != null) {
            return str2;
        }
        a(2, str);
        if (s == null && z != null) {
            a(f677o, 2, str);
        }
        return z;
    }

    public void a(int i2, String str) {
        synchronized (t) {
            b(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                t.wait(ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                if (i2 == 0) {
                    x = w;
                    w = null;
                } else if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                        }
                    } else if (w != null) {
                        z = w;
                        w = null;
                    }
                    A = w;
                    w = null;
                } else if (w != null) {
                    y = w;
                    w = null;
                }
            }
        }
    }

    public static String a(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, "unknown"});
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
        }
        return str2;
    }

    public static void a(Context context, int i2, String str) {
        if (i2 == 0) {
            q = new d(B, 0, (String) null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q);
        } else if (i2 == 1) {
            r = new d(B, 1, str);
            ContentResolver contentResolver = context.getContentResolver();
            contentResolver.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, r);
        } else if (i2 == 2) {
            s = new d(B, 2, str);
            ContentResolver contentResolver2 = context.getContentResolver();
            contentResolver2.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, s);
        }
    }
}
