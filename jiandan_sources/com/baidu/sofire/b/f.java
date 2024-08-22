package com.baidu.sofire.b;

import android.content.Context;
import android.util.Pair;
import com.baidu.sofire.a.a;
import java.util.Timer;
import java.util.TimerTask;

public class f extends TimerTask {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public f(Context context, String str, int i2, String str2, long j) {
        this.a = context;
        this.b = str;
        this.c = i2;
        this.d = str2;
        this.e = j;
    }

    public void run() {
        try {
            Pair<Integer, String> a2 = d.a(this.a);
            if (a2 != null && ((Integer) a2.first).intValue() == 1) {
                d.a(((Integer) a2.first).intValue(), d.a(this.a, this.b, this.c, this.d), "");
                String str = d.a;
                synchronized (d.h) {
                    Timer timer = d.g;
                    if (timer != null) {
                        timer.cancel();
                        d.g = null;
                    }
                }
            } else if (System.currentTimeMillis() > this.e) {
                String a3 = d.a(this.a, this.b, this.c, this.d);
                if (a2 != null) {
                    d.a(((Integer) a2.first).intValue(), a3, (String) a2.second);
                } else {
                    d.a(-1, a3, "");
                }
                String str2 = d.a;
                synchronized (d.h) {
                    Timer timer2 = d.g;
                    if (timer2 != null) {
                        timer2.cancel();
                        d.g = null;
                    }
                }
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }
}
