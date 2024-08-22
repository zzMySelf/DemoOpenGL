package com.meizu.i0;

import com.meizu.p0.c;
import com.meizu.p0.d;
import com.meizu.p0.e;
import java.util.HashMap;
import java.util.Map;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final String f4987a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Object> f4988b = new HashMap<>();

    public b(String str, Object obj) {
        a(str);
        a(obj);
    }

    public long a() {
        return e.a(toString());
    }

    public b a(Object obj) {
        if (obj == null) {
            return this;
        }
        this.f4988b.put("dt", obj);
        return this;
    }

    public b a(String str) {
        d.a(str, (Object) "schema cannot be null");
        d.a(!str.isEmpty(), (Object) "schema cannot be empty.");
        this.f4988b.put("sa", str);
        return this;
    }

    @Deprecated
    public void a(String str, String str2) {
        c.c(this.f4987a, "Payload: add(String, String) method called - Doing nothing.", new Object[0]);
    }

    public Map<String, Object> b() {
        return this.f4988b;
    }

    public String toString() {
        return e.a((Map) this.f4988b).toString();
    }
}
