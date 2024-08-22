package fe.p036switch.qw;

/* renamed from: fe.switch.qw.c  reason: invalid package */
public class c {
    public static void ad(String str, Object obj) {
        de(str, obj != null);
    }

    public static void de(String str, boolean z) {
        if (!z) {
            fe(str);
            throw null;
        }
    }

    public static void fe(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    public static void qw(Object obj) {
        ad((String) null, obj);
    }
}
