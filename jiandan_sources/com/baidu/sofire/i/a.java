package com.baidu.sofire.i;

import com.baidu.sofire.l.c;
import java.util.Timer;
import java.util.TimerTask;

public class a extends TimerTask {
    public final /* synthetic */ Timer a;
    public final /* synthetic */ b b;

    public a(b bVar, Timer timer) {
        this.b = bVar;
        this.a = timer;
    }

    public void run() {
        try {
            boolean unused = this.b.e = false;
            b.a(this.b, 0, c.g(this.b.c));
            Timer timer = this.a;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Throwable unused2) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }
}
