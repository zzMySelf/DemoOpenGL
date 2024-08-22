package com.sdk.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.sdk.a.f;
import com.sdk.b.c;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    public static long a = 60000;
    public static final ConcurrentHashMap<String, Boolean> b;
    public final c<String, String> c;
    public int d;

    static {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = new ConcurrentHashMap<>(10);
        b = concurrentHashMap;
        concurrentHashMap.put(f.a.a.l, Boolean.TRUE);
        new ConcurrentHashMap(10);
    }

    public d() {
        this.d = 102400;
        this.d = 102400;
        a = 60000;
        this.c = new c(this, 102400);
    }

    public String a(String str) {
        if (str != null) {
            return this.c.a(str);
        }
        return null;
    }

    public void a(String str, String str2, long j) {
        if (str != null && str2 != null && j >= 1) {
            this.c.a(str, str2, System.currentTimeMillis() + j);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public boolean b(String str) {
        Boolean bool;
        if (!TextUtils.isEmpty(str) && (bool = b.get(str.toUpperCase())) != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
