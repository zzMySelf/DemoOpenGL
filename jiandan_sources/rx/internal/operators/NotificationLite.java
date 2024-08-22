package rx.internal.operators;

import java.io.Serializable;
import rx.Observer;

public final class NotificationLite {

    /* renamed from: ad  reason: collision with root package name */
    public static final Object f11381ad = new Serializable() {
        public static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };
    public static final Object qw = new Serializable() {
        public static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };

    public static final class OnErrorSentinel implements Serializable {
        public static final long serialVersionUID = 3;
        public final Throwable e;

        public OnErrorSentinel(Throwable th2) {
            this.e = th2;
        }

        public String toString() {
            return "Notification=>Error:" + this.e;
        }
    }

    public static Object ad() {
        return qw;
    }

    public static Object de(Throwable th2) {
        return new OnErrorSentinel(th2);
    }

    public static Throwable fe(Object obj) {
        return ((OnErrorSentinel) obj).e;
    }

    public static <T> boolean qw(Observer<? super T> observer, Object obj) {
        if (obj == qw) {
            observer.onCompleted();
            return true;
        } else if (obj == f11381ad) {
            observer.onNext(null);
            return false;
        } else if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        } else if (obj.getClass() == OnErrorSentinel.class) {
            observer.onError(((OnErrorSentinel) obj).e);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> T rg(Object obj) {
        if (obj == f11381ad) {
            return null;
        }
        return obj;
    }

    public static boolean th(Object obj) {
        return obj == qw;
    }

    public static <T> Object uk(T t) {
        return t == null ? f11381ad : t;
    }

    public static boolean yj(Object obj) {
        return obj instanceof OnErrorSentinel;
    }
}
