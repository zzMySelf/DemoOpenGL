package com.baidu.location.a;

import android.os.HandlerThread;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static HandlerThread f13746a = null;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (m.class) {
            if (f13746a == null) {
                try {
                    HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                    f13746a = handlerThread2;
                    handlerThread2.start();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    f13746a = null;
                }
            }
            handlerThread = f13746a;
        }
        return handlerThread;
    }
}
