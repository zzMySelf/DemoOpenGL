package i.qw;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class aaa extends ExecutorCoroutineDispatcher {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final aaa f6101ad = new aaa();
    @Nullable
    public static volatile Executor pool;

    /* renamed from: th  reason: collision with root package name */
    public static final int f6102th;

    /* renamed from: yj  reason: collision with root package name */
    public static boolean f6103yj;

    static {
        String str;
        int i2;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            i2 = -1;
        } else {
            Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            if (intOrNull == null || intOrNull.intValue() < 1) {
                throw new IllegalStateException(Intrinsics.stringPlus("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
            i2 = intOrNull.intValue();
        }
        f6102th = i2;
    }

    public static final void b() {
    }

    public static final Thread qqq(AtomicInteger atomicInteger, Runnable runnable) {
        Thread thread = new Thread(runnable, Intrinsics.stringPlus("CommonPool-worker-", Integer.valueOf(atomicInteger.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }

    public final boolean a(@NotNull Class<?> cls, @NotNull ExecutorService executorService) {
        executorService.submit(ad.f6104ad);
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (invoke instanceof Integer) {
                num = (Integer) invoke;
            }
        } catch (Throwable unused) {
        }
        if (num != null && num.intValue() >= 1) {
            return true;
        }
        return false;
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = rrr();
            }
            fe qw = rg.qw();
            executor.execute(qw == null ? runnable : qw.uk(runnable));
        } catch (RejectedExecutionException unused) {
            fe qw2 = rg.qw();
            if (qw2 != null) {
                qw2.rg();
            }
            m.f6142o.q(runnable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.concurrent.ExecutorService eee() {
        /*
            r6 = this;
            java.lang.SecurityManager r0 = java.lang.System.getSecurityManager()
            if (r0 == 0) goto L_0x000b
            java.util.concurrent.ExecutorService r0 = r6.mmm()
            return r0
        L_0x000b:
            r0 = 0
            java.lang.String r1 = "java.util.concurrent.ForkJoinPool"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0013 }
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            if (r1 != 0) goto L_0x001b
            java.util.concurrent.ExecutorService r0 = r6.mmm()
            return r0
        L_0x001b:
            boolean r2 = f6103yj
            r3 = 0
            if (r2 != 0) goto L_0x004b
            int r2 = f6102th
            if (r2 >= 0) goto L_0x004b
            java.lang.String r2 = "commonPool"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0039 }
            java.lang.reflect.Method r2 = r1.getMethod(r2, r4)     // Catch:{ all -> 0x0039 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x0039 }
            java.lang.Object r2 = r2.invoke(r0, r4)     // Catch:{ all -> 0x0039 }
            boolean r4 = r2 instanceof java.util.concurrent.ExecutorService     // Catch:{ all -> 0x0039 }
            if (r4 == 0) goto L_0x0039
            java.util.concurrent.ExecutorService r2 = (java.util.concurrent.ExecutorService) r2     // Catch:{ all -> 0x0039 }
            goto L_0x003a
        L_0x0039:
            r2 = r0
        L_0x003a:
            if (r2 != 0) goto L_0x003d
            goto L_0x004b
        L_0x003d:
            i.qw.aaa r4 = f6101ad
            boolean r4 = r4.a(r1, r2)
            if (r4 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r2 = r0
        L_0x0047:
            if (r2 != 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            return r2
        L_0x004b:
            r2 = 1
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ all -> 0x0070 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x0070 }
            r4[r3] = r5     // Catch:{ all -> 0x0070 }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r4)     // Catch:{ all -> 0x0070 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0070 }
            i.qw.aaa r4 = f6101ad     // Catch:{ all -> 0x0070 }
            int r4 = r4.tt()     // Catch:{ all -> 0x0070 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0070 }
            r2[r3] = r4     // Catch:{ all -> 0x0070 }
            java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ all -> 0x0070 }
            boolean r2 = r1 instanceof java.util.concurrent.ExecutorService     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0071
            java.util.concurrent.ExecutorService r1 = (java.util.concurrent.ExecutorService) r1     // Catch:{ all -> 0x0070 }
            r0 = r1
            goto L_0x0071
        L_0x0070:
        L_0x0071:
            if (r0 != 0) goto L_0x0077
            java.util.concurrent.ExecutorService r0 = r6.mmm()
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.qw.aaa.eee():java.util.concurrent.ExecutorService");
    }

    public final ExecutorService mmm() {
        return Executors.newFixedThreadPool(tt(), new qw(new AtomicInteger()));
    }

    public final synchronized Executor rrr() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = eee();
            pool = executor;
        }
        return executor;
    }

    @NotNull
    public String toString() {
        return "CommonPool";
    }

    public final int tt() {
        Integer valueOf = Integer.valueOf(f6102th);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return RangesKt___RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors() - 1, 1);
        }
        return valueOf.intValue();
    }

    @NotNull
    public Executor xxx() {
        Executor executor = pool;
        return executor == null ? rrr() : executor;
    }
}
