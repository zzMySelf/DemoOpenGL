package com.sdk.d;

public class a<T> {
    public boolean a = false;
    public h<?> b;
    public a<T> c;

    public a(T t) {
        a(t);
    }

    public b a() {
        return this.b.a;
    }

    public void a(T t) {
        if (t == null) {
            this.b = null;
        } else if (t instanceof h) {
            this.b = (h) t;
            this.a = true;
        } else {
            this.b = new h<>(b.DEFAULT, t);
        }
    }

    public T b() {
        T t = this.b;
        if (t == null) {
            return null;
        }
        return this.a ? t : t.b;
    }
}
