package com.baidu.android.common.others.java;

@Deprecated
public class Pair<F, S> {
    public final F mFirst;
    public final S mSecond;

    public Pair(F f, S s) {
        this.mFirst = f;
        this.mSecond = s;
    }

    public static <A, B> Pair<A, B> create(A a, B b) {
        return new Pair<>(a, b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        try {
            Pair pair = (Pair) obj;
            if (!this.mFirst.equals(pair.mFirst) || !this.mSecond.equals(pair.mSecond)) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return ((this.mFirst.hashCode() + 31) * 31) + this.mSecond.hashCode();
    }
}
