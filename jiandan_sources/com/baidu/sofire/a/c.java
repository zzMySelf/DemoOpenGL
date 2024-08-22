package com.baidu.sofire.a;

import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import com.baidu.sofire.b.l;
import com.baidu.sofire.l.w;
import java.io.File;

public class c extends FileObserver {
    public String a;
    public String b;
    public int c;
    public Context d;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                synchronized (c.class) {
                    if (!com.baidu.sofire.l.c.f(c.this.a)) {
                        c cVar = c.this;
                        String str = cVar.b;
                        String str2 = cVar.a;
                        if (!TextUtils.isEmpty(str)) {
                            if (!TextUtils.isEmpty(str2)) {
                                l.a(new File(str), new File(str2));
                            }
                        }
                        com.baidu.sofire.l.c.a(c.this.a, true);
                        b.a(new File(c.this.a));
                        c cVar2 = c.this;
                        b.a(cVar2.d, cVar2.c, new File(c.this.a), new File(c.this.b));
                        com.baidu.sofire.c.a.a(c.this.d).b(c.this.c, -1);
                    }
                }
            } catch (Throwable unused) {
                int i2 = a.a;
            }
        }
    }

    public c(Context context, int i2, String str, String str2) {
        super(str, 4095);
        try {
            this.a = str;
            this.b = str2;
            this.c = i2;
            this.d = context;
        } catch (Throwable th2) {
            com.baidu.sofire.l.c.a(th2);
        }
    }

    public boolean a() {
        try {
            File file = new File(this.b);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }

    public void onEvent(int i2, String str) {
        if (i2 == 2 || i2 == 4 || i2 == 64 || i2 == 128 || i2 == 512 || i2 == 1024 || i2 == 2048) {
            try {
                w.a(this.d).a((Runnable) new a());
            } catch (Throwable unused) {
                int i3 = a.a;
            }
        }
    }
}
