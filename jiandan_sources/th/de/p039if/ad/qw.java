package th.de.p039if.ad;

import io.reactivex.functions.BiPredicate;

/* renamed from: th.de.if.ad.qw  reason: invalid package */
public final class qw {
    public static final BiPredicate<Object, Object> qw = new C0335qw();

    /* renamed from: th.de.if.ad.qw$qw  reason: collision with other inner class name */
    public static final class C0335qw implements BiPredicate<Object, Object> {
        public boolean qw(Object obj, Object obj2) {
            return qw.de(obj, obj2);
        }
    }

    public static int ad(long j, long j2) {
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static boolean de(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> BiPredicate<T, T> fe() {
        return qw;
    }

    public static int qw(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static <T> T rg(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int th(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }

    public static long yj(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j);
    }
}
