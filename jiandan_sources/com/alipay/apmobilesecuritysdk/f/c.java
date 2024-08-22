package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

public final class c implements Runnable {
    public final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.a.c.isEmpty()) {
                Runnable runnable = (Runnable) this.a.c.get(0);
                this.a.c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th2) {
            Thread unused2 = this.a.b = null;
            throw th2;
        }
        Thread unused3 = this.a.b = null;
    }
}
