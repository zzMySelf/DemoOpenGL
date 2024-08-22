package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.swan.apps.impl.shortcut.QuickAppShortcutHelperKt;
import com.xiaomi.channel.commonutils.logger.b;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ar implements aq, InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final String[][] f6705a = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};

    /* renamed from: a  reason: collision with other field name */
    private volatile int f145a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile long f146a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f147a;

    /* renamed from: a  reason: collision with other field name */
    private volatile a f148a = null;

    /* renamed from: a  reason: collision with other field name */
    private Class f149a = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f150a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private Method f151a = null;

    /* renamed from: b  reason: collision with root package name */
    private Class f6706b = null;

    /* renamed from: b  reason: collision with other field name */
    private Method f152b = null;

    /* renamed from: c  reason: collision with root package name */
    private Method f6707c = null;

    /* renamed from: d  reason: collision with root package name */
    private Method f6708d = null;

    /* renamed from: e  reason: collision with root package name */
    private Method f6709e = null;

    /* renamed from: f  reason: collision with root package name */
    private Method f6710f = null;

    /* renamed from: g  reason: collision with root package name */
    private Method f6711g = null;

    public ar(Context context) {
        this.f147a = context.getApplicationContext();
        a(context);
        b(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8285a() {
        a(QuickAppShortcutHelperKt.QUICK_APP_IS_SUPPORT_ADD_SHORTCUT);
        return this.f148a != null && Boolean.TRUE.equals(this.f148a.f153a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8284a() {
        a("getOAID");
        if (this.f148a == null) {
            return null;
        }
        return this.f148a.f6713b;
    }

    private void a(Context context) {
        Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i2 = 0;
        while (true) {
            String[][] strArr = f6705a;
            if (i2 >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i2];
            Class<?> a3 = a(context, strArr2[0]);
            Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index " + i2);
                Class<?> cls3 = a3;
                cls2 = a4;
                cls = cls3;
                break;
            }
            i2++;
            Class<?> cls4 = a3;
            cls2 = a4;
            cls = cls4;
        }
        this.f149a = a2;
        this.f151a = a(a2, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.f6706b = cls;
        this.f6707c = a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f6710f = a(cls2, QuickAppShortcutHelperKt.QUICK_APP_IS_SUPPORT_ADD_SHORTCUT, (Class<?>[]) new Class[0]);
        this.f6711g = a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    private void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = -elapsedRealtime;
        Class cls = this.f6706b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                Object newProxyInstance = Proxy.newProxyInstance(classLoader, new Class[]{this.f6706b}, this);
                a(this.f151a, this.f149a.newInstance(), context, newProxyInstance);
            } catch (Throwable th2) {
                b("call init sdk error:" + th2);
            }
            this.f146a = elapsedRealtime;
        }
        elapsedRealtime = j2;
        this.f146a = elapsedRealtime;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f146a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Object obj2 = objArr[i2];
                if (obj2 != null && !a(obj2)) {
                    aVar.f6713b = (String) a(this.f6707c, obj2, new Object[0]);
                    aVar.f153a = (Boolean) a(this.f6710f, obj2, new Object[0]);
                    a(this.f6711g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder append = new StringBuilder().append("has get succ, check duplicate:");
                        if (this.f148a != null) {
                            z = true;
                        }
                        b(append.append(z).toString());
                        synchronized (ar.class) {
                            if (this.f148a == null) {
                                this.f148a = aVar;
                            }
                        }
                    }
                }
                i2++;
            }
        }
        a();
        return null;
    }

    private void a(String str) {
        if (this.f148a == null) {
            long j2 = this.f146a;
            long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
            int i2 = this.f145a;
            if (elapsedRealtime > 3000 && i2 < 3) {
                synchronized (this.f150a) {
                    if (this.f146a == j2 && this.f145a == i2) {
                        b("retry, current count is " + i2);
                        this.f145a++;
                        b(this.f147a);
                        j2 = this.f146a;
                        elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j2);
                    }
                }
            }
            if (this.f148a == null && j2 >= 0 && elapsedRealtime <= 3000 && Looper.myLooper() != Looper.getMainLooper()) {
                synchronized (this.f150a) {
                    if (this.f148a == null) {
                        try {
                            b(str + " wait...");
                            this.f150a.wait(3000);
                        } catch (Exception e2) {
                        }
                    }
                }
            }
        }
    }

    private void a() {
        synchronized (this.f150a) {
            try {
                this.f150a.notifyAll();
            } catch (Exception e2) {
            }
        }
    }

    private class a {

        /* renamed from: a  reason: collision with other field name */
        Boolean f153a;

        /* renamed from: a  reason: collision with other field name */
        String f154a;

        /* renamed from: b  reason: collision with root package name */
        String f6713b;

        /* renamed from: c  reason: collision with root package name */
        String f6714c;

        /* renamed from: d  reason: collision with root package name */
        String f6715d;

        private a() {
            this.f153a = null;
            this.f154a = null;
            this.f6713b = null;
            this.f6714c = null;
            this.f6715d = null;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            if (!TextUtils.isEmpty(this.f154a) || !TextUtils.isEmpty(this.f6713b) || !TextUtils.isEmpty(this.f6714c) || !TextUtils.isEmpty(this.f6715d)) {
                this.f153a = true;
            }
            if (this.f153a != null) {
                return true;
            }
            return false;
        }
    }

    private static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    private static Class<?> a(Context context, String str) {
        try {
            return C0300r.a(context, str);
        } catch (Throwable th2) {
            return null;
        }
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable th2) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T invoke = method.invoke(obj, objArr);
            if (invoke != null) {
                return invoke;
            }
            return null;
        } catch (Throwable th2) {
            return null;
        }
    }

    private static void b(String str) {
        b.a("mdid:" + str);
    }
}
