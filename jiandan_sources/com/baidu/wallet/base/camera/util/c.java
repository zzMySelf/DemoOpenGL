package com.baidu.wallet.base.camera.util;

import com.baidu.android.common.others.IStringUtil;
import java.util.concurrent.LinkedBlockingQueue;

public final class c {
    public Thread[] a;
    public LinkedBlockingQueue<Runnable> b;

    public c() {
        this.a = null;
        this.b = null;
        this.b = new LinkedBlockingQueue<>();
    }

    public static int a(int i2) {
        if (i2 <= 0 || 20 < i2) {
            return 4;
        }
        return i2;
    }

    public static c a(int i2, String str) {
        if (str == null) {
            str = "";
        }
        int a2 = a(i2);
        c cVar = new c();
        cVar.a = new Thread[a2];
        for (int i3 = a2 - 1; i3 >= 0; i3 += -1) {
            cVar.a[i3] = new Thread(new d(cVar.b));
            cVar.a[i3].setPriority(5);
            cVar.a[i3].setName(str + " " + a2 + IStringUtil.CURRENT_PATH + (i3 + 1));
            cVar.a[i3].start();
        }
        return cVar;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                this.b.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void a() {
        this.b.clear();
        for (Thread isAlive : this.a) {
            if (isAlive.isAlive()) {
                this.b.offer(new b());
            }
        }
        for (Thread thread : this.a) {
            if (thread.isAlive()) {
                try {
                    synchronized (this) {
                        wait((long) (2000 / this.a.length));
                    }
                } catch (InterruptedException unused) {
                }
                thread.interrupt();
            }
        }
    }
}
