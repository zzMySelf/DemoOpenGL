package p041if.fe;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import rx.Observer;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.OnErrorThrowable;

/* renamed from: if.fe.qw  reason: invalid package */
public final class qw {
    public static Throwable ad(Throwable th2) {
        int i2 = 0;
        while (th2.getCause() != null) {
            int i3 = i2 + 1;
            if (i2 >= 25) {
                return new RuntimeException("Stack too deep to get final cause");
            }
            th2 = th2.getCause();
            i2 = i3;
        }
        return th2;
    }

    public static RuntimeException de(Throwable th2) {
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else if (th2 instanceof Error) {
            throw ((Error) th2);
        } else {
            throw new RuntimeException(th2);
        }
    }

    public static void fe(List<? extends Throwable> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                Throwable th2 = (Throwable) list.get(0);
                if (th2 instanceof RuntimeException) {
                    throw ((RuntimeException) th2);
                } else if (th2 instanceof Error) {
                    throw ((Error) th2);
                } else {
                    throw new RuntimeException(th2);
                }
            } else {
                throw new CompositeException((Collection<? extends Throwable>) list);
            }
        }
    }

    public static void qw(Throwable th2, Throwable th3) {
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (th2.getCause() != null) {
            int i3 = i2 + 1;
            if (i2 < 25) {
                th2 = th2.getCause();
                if (!hashSet.contains(th2.getCause())) {
                    hashSet.add(th2.getCause());
                    i2 = i3;
                }
            } else {
                return;
            }
        }
        try {
            th2.initCause(th3);
        } catch (Throwable unused) {
        }
    }

    public static void rg(Throwable th2) {
        if (th2 instanceof OnErrorNotImplementedException) {
            throw ((OnErrorNotImplementedException) th2);
        } else if (th2 instanceof OnErrorFailedException) {
            throw ((OnErrorFailedException) th2);
        } else if (th2 instanceof OnCompletedFailedException) {
            throw ((OnCompletedFailedException) th2);
        } else if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        } else if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        } else if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }

    public static void th(Throwable th2, Observer<?> observer) {
        rg(th2);
        observer.onError(th2);
    }

    public static void yj(Throwable th2, Observer<?> observer, Object obj) {
        rg(th2);
        observer.onError(OnErrorThrowable.addValueAsLastCause(th2, obj));
    }
}
