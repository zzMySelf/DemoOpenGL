package com.baidu.sofire.rp;

import android.content.Context;
import android.os.Message;
import com.baidu.sofire.a.a;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.d;

public class Report {
    public static Report b;
    public Context a;

    public Report(Context context) {
        this.a = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            if (b == null) {
                b = new Report(context);
            }
            report = b;
        }
        return report;
    }

    public void fr() {
        try {
            d a2 = d.a(this.a);
            a2.getClass();
            Message message = new Message();
            message.what = 9;
            a2.b.a.sendMessage(message);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            c.a(this.a, str, str2, str3, str4, str5, false);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public void n() {
        try {
            d a2 = d.a(this.a);
            a2.getClass();
            Message message = new Message();
            message.what = 6;
            a2.b.a.sendMessage(message);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public void r(boolean z) {
        try {
            d.a(this.a).a();
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public void s(String str) {
        s(str, c.d());
    }

    public void sr(String str) {
        try {
            d a2 = d.a(this.a);
            a2.getClass();
            Message message = new Message();
            message.what = 11;
            message.obj = str;
            a2.b.a.sendMessage(message);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public void w(String str) {
        try {
            c.b(this.a, str);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(java.lang.String r2, boolean r3) {
        /*
            r1 = this;
            android.content.Context r0 = r1.a     // Catch:{ all -> 0x0011 }
            com.baidu.sofire.h.a r2 = com.baidu.sofire.l.c.b((java.lang.String) r2)     // Catch:{ all -> 0x000e }
            com.baidu.sofire.l.d r0 = com.baidu.sofire.l.d.a((android.content.Context) r0)     // Catch:{ all -> 0x000e }
            r0.a((com.baidu.sofire.h.a) r2, (boolean) r3)     // Catch:{ all -> 0x000e }
            goto L_0x0013
        L_0x000e:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0011 }
            goto L_0x0013
        L_0x0011:
            int r2 = com.baidu.sofire.a.a.a
        L_0x0013:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.rp.Report.s(java.lang.String, boolean):void");
    }
}
