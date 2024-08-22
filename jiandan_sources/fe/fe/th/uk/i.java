package fe.fe.th.uk;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class i implements ThreadFactory {

    /* renamed from: ad  reason: collision with root package name */
    public final ThreadFactory f3143ad;

    /* renamed from: th  reason: collision with root package name */
    public final String f3144th;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicInteger f3145yj;

    public i(String str) {
        this(str, Executors.defaultThreadFactory());
    }

    public i(String str, ThreadFactory threadFactory) {
        this.f3145yj = new AtomicInteger(0);
        this.f3144th = str;
        this.f3143ad = threadFactory;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f3143ad.newThread(runnable);
        newThread.setName(qw(this.f3145yj.getAndIncrement()));
        return newThread;
    }

    public final String qw(int i2) {
        return String.format("%s-%d", new Object[]{this.f3144th, Integer.valueOf(i2)});
    }
}
