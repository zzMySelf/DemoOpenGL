package th.de;

import io.reactivex.internal.util.NotificationLite;
import th.de.p039if.ad.qw;

public final class fe<T> {

    /* renamed from: ad  reason: collision with root package name */
    public static final fe<Object> f10462ad = new fe<>((Object) null);
    public final Object qw;

    public fe(Object obj) {
        this.qw = obj;
    }

    public static <T> fe<T> ad(Throwable th2) {
        qw.rg(th2, "error is null");
        return new fe<>(NotificationLite.error(th2));
    }

    public static <T> fe<T> de(T t) {
        qw.rg(t, "value is null");
        return new fe<>(t);
    }

    public static <T> fe<T> qw() {
        return f10462ad;
    }

    public boolean equals(Object obj) {
        if (obj instanceof fe) {
            return qw.de(this.qw, ((fe) obj).qw);
        }
        return false;
    }

    public Throwable fe() {
        Object obj = this.qw;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public int hashCode() {
        Object obj = this.qw;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public T rg() {
        Object obj = this.qw;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return this.qw;
    }

    public boolean th() {
        return this.qw == null;
    }

    public String toString() {
        Object obj = this.qw;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.qw + "]";
    }

    public boolean uk() {
        Object obj = this.qw;
        return obj != null && !NotificationLite.isError(obj);
    }

    public boolean yj() {
        return NotificationLite.isError(this.qw);
    }
}
