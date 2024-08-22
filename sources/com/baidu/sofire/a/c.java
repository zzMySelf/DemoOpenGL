package com.baidu.sofire.a;

import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import com.baidu.searchbox.file.watcher.base.FileWatcher;
import com.baidu.sofire.b.l;
import com.baidu.sofire.m.x;
import java.io.File;

/* compiled from: MyFileObserver */
public class c extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f3013a;

    /* renamed from: b  reason: collision with root package name */
    public String f3014b;

    /* renamed from: c  reason: collision with root package name */
    public int f3015c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3016d;

    /* compiled from: MyFileObserver */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                synchronized (c.class) {
                    if (!com.baidu.sofire.m.c.f(c.this.f3013a)) {
                        c cVar = c.this;
                        String str = cVar.f3014b;
                        String str2 = cVar.f3013a;
                        if (!TextUtils.isEmpty(str)) {
                            if (!TextUtils.isEmpty(str2)) {
                                l.a(new File(str), new File(str2));
                            }
                        }
                        b.a(new File(c.this.f3013a));
                        c cVar2 = c.this;
                        b.a(cVar2.f3016d, cVar2.f3015c, new File(c.this.f3013a), new File(c.this.f3014b));
                        com.baidu.sofire.c.a.a(c.this.f3016d).b(c.this.f3015c, -1);
                    }
                }
            } catch (Throwable th2) {
                int i2 = a.f3011a;
            }
        }
    }

    public c(Context context, int i2, String str, String str2) {
        super(str, FileWatcher.ALL_EVENTS);
        try {
            this.f3013a = str;
            this.f3014b = str2;
            this.f3015c = i2;
            this.f3016d = context;
        } catch (Throwable th2) {
            com.baidu.sofire.m.c.a(th2);
        }
    }

    public boolean a() {
        try {
            File file = new File(this.f3014b);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th2) {
            int i2 = a.f3011a;
            return false;
        }
    }

    public void onEvent(int i2, String str) {
        switch (i2) {
            case 2:
            case 4:
            case 64:
            case 128:
            case 512:
            case 1024:
            case 2048:
                try {
                    x.a(this.f3016d).a((Runnable) new a());
                    return;
                } catch (Throwable th2) {
                    int i3 = a.f3011a;
                    return;
                }
            default:
                return;
        }
    }
}
