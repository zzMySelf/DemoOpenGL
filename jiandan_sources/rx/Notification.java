package rx;

import com.google.common.base.Ascii;

public final class Notification<T> {

    /* renamed from: fe  reason: collision with root package name */
    public static final Notification<Void> f11376fe = new Notification<>(Kind.OnCompleted, (Object) null, (Throwable) null);

    /* renamed from: ad  reason: collision with root package name */
    public final Throwable f11377ad;

    /* renamed from: de  reason: collision with root package name */
    public final T f11378de;
    public final Kind qw;

    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public Notification(Kind kind, T t, Throwable th2) {
        this.f11378de = t;
        this.f11377ad = th2;
        this.qw = kind;
    }

    public static <T> Notification<T> ad(Throwable th2) {
        return new Notification<>(Kind.OnError, (Object) null, th2);
    }

    public static <T> Notification<T> de(T t) {
        return new Notification<>(Kind.OnNext, t, (Throwable) null);
    }

    public static <T> Notification<T> qw() {
        return f11376fe;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.fe() != fe()) {
            return false;
        }
        T t = this.f11378de;
        T t2 = notification.f11378de;
        if (t != t2 && (t == null || !t.equals(t2))) {
            return false;
        }
        Throwable th2 = this.f11377ad;
        Throwable th3 = notification.f11377ad;
        if (th2 == th3 || (th2 != null && th2.equals(th3))) {
            return true;
        }
        return false;
    }

    public Kind fe() {
        return this.qw;
    }

    public int hashCode() {
        int hashCode = fe().hashCode();
        if (uk()) {
            hashCode = (hashCode * 31) + th().hashCode();
        }
        return yj() ? (hashCode * 31) + rg().hashCode() : hashCode;
    }

    public boolean i() {
        return fe() == Kind.OnCompleted;
    }

    public boolean o() {
        return fe() == Kind.OnError;
    }

    public boolean pf() {
        return fe() == Kind.OnNext;
    }

    public Throwable rg() {
        return this.f11377ad;
    }

    public T th() {
        return this.f11378de;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(Ascii.CASE_MASK);
        sb.append(fe());
        if (uk()) {
            sb.append(Ascii.CASE_MASK);
            sb.append(th());
        }
        if (yj()) {
            sb.append(Ascii.CASE_MASK);
            sb.append(rg().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }

    public boolean uk() {
        return pf() && this.f11378de != null;
    }

    public boolean yj() {
        return o() && this.f11377ad != null;
    }
}
