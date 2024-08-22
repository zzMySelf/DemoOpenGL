package com.baidu.sofire.l;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.baidu.sofire.i.b;
import com.baidu.sofire.rp.receiver.Receiver;
import java.util.Timer;
import java.util.TimerTask;

public class d {
    public static d d;
    public Context a;
    public b b;
    public boolean c = false;

    public class a extends TimerTask {
        public final /* synthetic */ Timer a;

        public a(Timer timer) {
            this.a = timer;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
                com.baidu.sofire.l.d r0 = com.baidu.sofire.l.d.this     // Catch:{ all -> 0x0025 }
                r1 = 0
                boolean unused = r0.c = r1     // Catch:{ all -> 0x0025 }
                com.baidu.sofire.l.d r0 = com.baidu.sofire.l.d.this     // Catch:{ all -> 0x0025 }
                r0.getClass()     // Catch:{ all -> 0x0025 }
                android.os.Message r1 = new android.os.Message     // Catch:{ all -> 0x001b }
                r1.<init>()     // Catch:{ all -> 0x001b }
                r2 = 2
                r1.what = r2     // Catch:{ all -> 0x001b }
                com.baidu.sofire.i.b r0 = r0.b     // Catch:{ all -> 0x001b }
                com.baidu.sofire.i.b$a r0 = r0.a     // Catch:{ all -> 0x001b }
                r0.sendMessage(r1)     // Catch:{ all -> 0x001b }
                goto L_0x001d
            L_0x001b:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0025 }
            L_0x001d:
                java.util.Timer r0 = r3.a     // Catch:{ all -> 0x0025 }
                if (r0 == 0) goto L_0x0027
                r0.cancel()     // Catch:{ all -> 0x0025 }
                goto L_0x0027
            L_0x0025:
                int r0 = com.baidu.sofire.a.a.a
            L_0x0027:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.d.a.run():void");
        }
    }

    public d(Context context) {
        this.a = context.getApplicationContext();
        this.b = new b(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (d == null) {
                d = new d(context);
            }
            dVar = d;
        }
        return dVar;
    }

    public void a() {
        b bVar = this.b;
        if (bVar.d == null) {
            bVar.d = new Receiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.b.r.p");
        String str = bVar.c.getPackageName() + ".permission." + "sofire" + ".RECEIVE";
        if (Build.VERSION.SDK_INT >= 33) {
            bVar.c.getApplicationContext().registerReceiver(bVar.d, intentFilter, str, (Handler) null, 4);
        } else {
            bVar.c.getApplicationContext().registerReceiver(bVar.d, intentFilter, str, (Handler) null);
        }
        Message message = new Message();
        message.what = 5;
        bVar.a.sendMessage(message);
    }

    public void a(com.baidu.sofire.h.a aVar, boolean z) {
        Message message = new Message();
        if (z || c.d()) {
            message.what = 1;
            message.obj = aVar;
        } else {
            com.baidu.sofire.g.a.a(this.a).a(aVar);
            if (!this.c && System.currentTimeMillis() - b.f >= 180000) {
                b.f = System.currentTimeMillis();
                message.what = 10;
            } else {
                return;
            }
        }
        this.b.a.sendMessage(message);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|13|14|15) */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.c     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            if (r4 == 0) goto L_0x001c
            r4 = 1
            r3.c = r4     // Catch:{ all -> 0x002f }
            java.util.Timer r4 = new java.util.Timer     // Catch:{ all -> 0x002f }
            r4.<init>()     // Catch:{ all -> 0x002f }
            com.baidu.sofire.l.d$a r0 = new com.baidu.sofire.l.d$a     // Catch:{ all -> 0x002f }
            r0.<init>(r4)     // Catch:{ all -> 0x002f }
            r1 = 10000(0x2710, double:4.9407E-320)
            r4.schedule(r0, r1)     // Catch:{ all -> 0x002f }
            goto L_0x0031
        L_0x001c:
            android.os.Message r4 = new android.os.Message     // Catch:{ all -> 0x002c }
            r4.<init>()     // Catch:{ all -> 0x002c }
            r0 = 2
            r4.what = r0     // Catch:{ all -> 0x002c }
            com.baidu.sofire.i.b r0 = r3.b     // Catch:{ all -> 0x002c }
            com.baidu.sofire.i.b$a r0 = r0.a     // Catch:{ all -> 0x002c }
            r0.sendMessage(r4)     // Catch:{ all -> 0x002c }
            goto L_0x0031
        L_0x002c:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002f }
            goto L_0x0031
        L_0x002f:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0033 }
        L_0x0031:
            monitor-exit(r3)
            return
        L_0x0033:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.d.a(boolean):void");
    }
}
