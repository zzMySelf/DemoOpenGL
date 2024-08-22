package fe.fe.o.th;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class o implements ThreadFactory {

    /* renamed from: ad  reason: collision with root package name */
    public final ThreadFactory f2675ad;

    /* renamed from: th  reason: collision with root package name */
    public final String f2676th;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicInteger f2677yj;

    public o(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public o(String str, ThreadFactory threadFactory) {
        this.f2677yj = new AtomicInteger(0);
        this.f2676th = str;
        this.f2675ad = threadFactory;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f2675ad.newThread(runnable);
        newThread.setName(qw(this.f2677yj.getAndIncrement()));
        return newThread;
    }

    public final String qw(int i2) {
        return String.format("%s-%d", new Object[]{this.f2676th, Integer.valueOf(i2)});
    }
}
