package com.baidu.sofire.b;

import android.content.Context;
import com.baidu.sofire.a.a;

public class e implements Runnable {
    public final /* synthetic */ Context a;

    public e(Context context) {
        this.a = context;
    }

    public void run() {
        try {
            c a2 = c.a(this.a);
            if (a2 != null) {
                if (c.f == 0) {
                    c.f = 1;
                }
                a2.a();
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }
}
