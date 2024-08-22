package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cq;
import java.lang.ref.WeakReference;

public class cj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f6796a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<Context> f201a;

    public cj(String str, WeakReference<Context> weakReference) {
        this.f6796a = str;
        this.f201a = weakReference;
    }

    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f201a;
        if (weakReference != null && (context = (Context) weakReference.get()) != null) {
            if (cw.a(this.f6796a) > ci.f199a) {
                cm a2 = cm.a(this.f6796a);
                cl a3 = cl.a(this.f6796a);
                a2.a((cq.a) a3);
                a3.a((cq.a) ck.a(context, this.f6796a, 1000));
                cq.a(context).a((cq.a) a2);
                return;
            }
            b.b("=====> do not need clean db");
        }
    }
}
