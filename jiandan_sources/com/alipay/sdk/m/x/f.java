package com.alipay.sdk.m.x;

import java.util.Iterator;
import java.util.Stack;

public class f {
    public Stack<e> a = new Stack<>();

    public void a(e eVar) {
        this.a.push(eVar);
    }

    public boolean b() {
        return this.a.isEmpty();
    }

    public e c() {
        return this.a.pop();
    }

    public void a() {
        if (!b()) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a();
            }
            this.a.clear();
        }
    }
}
