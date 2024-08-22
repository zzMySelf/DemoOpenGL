package th.de.uk.qw;

import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import th.de.th;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile Function<th, th> f11028ad;
    public static volatile Function<Callable<th>, th> qw;

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.functions.Function<java.util.concurrent.Callable<th.de.th>, th.de.th>, io.reactivex.functions.Function] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static th.de.th ad(io.reactivex.functions.Function<java.util.concurrent.Callable<th.de.th>, th.de.th> r0, java.util.concurrent.Callable<th.de.th> r1) {
        /*
            java.lang.Object r0 = qw(r0, r1)
            th.de.th r0 = (th.de.th) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: th.de.uk.qw.qw.ad(io.reactivex.functions.Function, java.util.concurrent.Callable):th.de.th");
    }

    public static th de(Callable<th> callable) {
        try {
            th call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th2) {
            th.de.o.qw.qw(th2);
            throw null;
        }
    }

    public static th fe(Callable<th> callable) {
        if (callable != null) {
            Function<Callable<th>, th> function = qw;
            if (function == null) {
                return de(callable);
            }
            return ad(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static <T, R> R qw(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th2) {
            th.de.o.qw.qw(th2);
            throw null;
        }
    }

    public static th rg(th thVar) {
        if (thVar != null) {
            Function function = f11028ad;
            if (function == null) {
                return thVar;
            }
            return (th) qw(function, thVar);
        }
        throw new NullPointerException("scheduler == null");
    }
}
