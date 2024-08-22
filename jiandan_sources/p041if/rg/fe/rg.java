package p041if.rg.fe;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* renamed from: if.rg.fe.rg  reason: invalid package */
public final class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f11230ad;
    public static final int qw;

    /* renamed from: if.rg.fe.rg$qw */
    public static class qw implements PrivilegedAction<ClassLoader> {
        /* renamed from: qw */
        public ClassLoader run() {
            return ClassLoader.getSystemClassLoader();
        }
    }

    static {
        int fe2 = fe();
        qw = fe2;
        f11230ad = fe2 != 0;
    }

    public static ClassLoader ad() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new qw());
    }

    public static boolean de() {
        return f11230ad;
    }

    public static int fe() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, ad()).getField("SDK_INT").get((Object) null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int qw() {
        return qw;
    }
}
