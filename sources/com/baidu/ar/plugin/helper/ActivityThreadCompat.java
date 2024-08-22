package com.baidu.ar.plugin.helper;

import android.app.Instrumentation;
import android.os.Handler;
import android.os.Looper;
import com.baidu.ar.plugin.reflect.MethodUtils;

public class ActivityThreadCompat {
    /* access modifiers changed from: private */
    public static Object sActivityThread;
    private static Class sClass;

    public static final Class activityThreadClass() {
        if (sClass == null) {
            sClass = Class.forName("android.app.ActivityThread");
        }
        return sClass;
    }

    public static final synchronized Object currentActivityThread() {
        Object obj;
        synchronized (ActivityThreadCompat.class) {
            if (sActivityThread == null) {
                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(activityThreadClass(), "currentActivityThread", new Object[0]);
                sActivityThread = invokeStaticMethod;
                if (invokeStaticMethod == null) {
                    sActivityThread = currentActivityThread2();
                }
            }
            obj = sActivityThread;
        }
        return obj;
    }

    private static Object currentActivityThread2() {
        Handler handler = new Handler(Looper.getMainLooper());
        final Object obj = new Object();
        handler.post(new Runnable() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                    java.lang.Class r0 = com.baidu.ar.plugin.helper.ActivityThreadCompat.activityThreadClass()     // Catch:{ Exception -> 0x001f }
                    java.lang.String r1 = "currentActivityThread"
                    r2 = 0
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x001f }
                    java.lang.Object r0 = com.baidu.ar.plugin.reflect.MethodUtils.invokeStaticMethod(r0, r1, r2)     // Catch:{ Exception -> 0x001f }
                    java.lang.Object unused = com.baidu.ar.plugin.helper.ActivityThreadCompat.sActivityThread = r0     // Catch:{ Exception -> 0x001f }
                    java.lang.Object r0 = r1
                    monitor-enter(r0)
                    java.lang.Object r1 = r1     // Catch:{ all -> 0x001a }
                    r1.notifyAll()     // Catch:{ all -> 0x001a }
                    monitor-exit(r0)     // Catch:{ all -> 0x001a }
                    goto L_0x002c
                L_0x001a:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x001a }
                    throw r1
                L_0x001d:
                    r0 = move-exception
                    goto L_0x0030
                L_0x001f:
                    r0 = move-exception
                    r0.printStackTrace()     // Catch:{ all -> 0x001d }
                    java.lang.Object r0 = r1
                    monitor-enter(r0)
                    java.lang.Object r1 = r1     // Catch:{ all -> 0x002d }
                    r1.notifyAll()     // Catch:{ all -> 0x002d }
                    monitor-exit(r0)     // Catch:{ all -> 0x002d }
                L_0x002c:
                    return
                L_0x002d:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x002d }
                    throw r1
                L_0x0030:
                    java.lang.Object r1 = r1
                    monitor-enter(r1)
                    java.lang.Object r2 = r1     // Catch:{ all -> 0x003a }
                    r2.notifyAll()     // Catch:{ all -> 0x003a }
                    monitor-exit(r1)     // Catch:{ all -> 0x003a }
                    throw r0
                L_0x003a:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x003a }
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.plugin.helper.ActivityThreadCompat.AnonymousClass1.run():void");
            }
        });
        if (sActivityThread != null || Looper.getMainLooper() == Looper.myLooper()) {
            return null;
        }
        synchronized (obj) {
            try {
                obj.wait(300);
            } catch (InterruptedException e2) {
            }
        }
        return null;
    }

    public static Instrumentation getInstrumentation() {
        return (Instrumentation) MethodUtils.invokeMethod(currentActivityThread(), "getInstrumentation", new Object[0]);
    }
}
