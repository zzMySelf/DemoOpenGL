package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f1993a;

    public c(b bVar) {
        this.f1993a = bVar;
    }

    public final void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.f1993a.f1992c.isEmpty()) {
                Runnable runnable = (Runnable) this.f1993a.f1992c.get(0);
                this.f1993a.f1992c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception e2) {
        } catch (Throwable th2) {
            Thread unused = this.f1993a.f1991b = null;
            throw th2;
        }
        Thread unused2 = this.f1993a.f1991b = null;
    }
}
