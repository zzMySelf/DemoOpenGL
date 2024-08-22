package rx.internal.operators;

import java.io.Serializable;
import rx.Observer;

public final class NotificationLite {
    private static final Object ON_COMPLETED_SENTINEL = new Serializable() {
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };
    private static final Object ON_NEXT_NULL_SENTINEL = new Serializable() {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    private NotificationLite() {
    }

    static final class OnErrorSentinel implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: e  reason: collision with root package name */
        final Throwable f7802e;

        public OnErrorSentinel(Throwable e2) {
            this.f7802e = e2;
        }

        public String toString() {
            return "Notification=>Error:" + this.f7802e;
        }
    }

    public static <T> Object next(T t) {
        if (t == null) {
            return ON_NEXT_NULL_SENTINEL;
        }
        return t;
    }

    public static Object completed() {
        return ON_COMPLETED_SENTINEL;
    }

    public static Object error(Throwable e2) {
        return new OnErrorSentinel(e2);
    }

    public static <T> boolean accept(Observer<? super T> o, Object n) {
        if (n == ON_COMPLETED_SENTINEL) {
            o.onCompleted();
            return true;
        } else if (n == ON_NEXT_NULL_SENTINEL) {
            o.onNext(null);
            return false;
        } else if (n == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        } else if (n.getClass() == OnErrorSentinel.class) {
            o.onError(((OnErrorSentinel) n).f7802e);
            return true;
        } else {
            o.onNext(n);
            return false;
        }
    }

    public static boolean isCompleted(Object n) {
        return n == ON_COMPLETED_SENTINEL;
    }

    public static boolean isError(Object n) {
        return n instanceof OnErrorSentinel;
    }

    public static boolean isNull(Object n) {
        return n == ON_NEXT_NULL_SENTINEL;
    }

    public static boolean isNext(Object n) {
        return n != null && !isError(n) && !isCompleted(n);
    }

    public static <T> T getValue(Object n) {
        if (n == ON_NEXT_NULL_SENTINEL) {
            return null;
        }
        return n;
    }

    public static Throwable getError(Object n) {
        return ((OnErrorSentinel) n).f7802e;
    }
}
