package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;

public final class g {
    public final Object a;
    public final Method b;
    public final int c;
    public final String d;
    public final EventBus.ThreadMode e;
    public volatile boolean f = true;

    public g(Object obj, Method method, String str, int i2, EventBus.ThreadMode threadMode) {
        this.a = obj;
        this.b = method;
        this.d = str;
        this.c = i2;
        this.e = threadMode;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.a != gVar.a || !this.b.equals(gVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.hashCode();
    }
}
