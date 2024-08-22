package p041if.rg.fe.i;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* renamed from: if.rg.fe.i.e  reason: invalid package */
public final class e {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f11213ad = (System.getProperty("rx.unsafe-disable") != null);
    public static final Unsafe qw;

    static {
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get((Object) null);
        } catch (Throwable unused) {
        }
        qw = unsafe;
    }

    public static boolean ad() {
        return qw != null && !f11213ad;
    }

    public static long qw(Class<?> cls, String str) {
        try {
            return qw.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }
}
