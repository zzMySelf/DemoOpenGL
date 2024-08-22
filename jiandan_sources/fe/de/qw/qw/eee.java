package fe.de.qw.qw;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class eee implements ThreadFactory {

    /* renamed from: ad  reason: collision with root package name */
    public final ThreadFactory f1233ad = Executors.defaultThreadFactory();

    /* renamed from: th  reason: collision with root package name */
    public final AtomicInteger f1234th = new AtomicInteger(1);

    public eee(fe feVar) {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f1233ad.newThread(runnable);
        int andIncrement = this.f1234th.getAndIncrement();
        newThread.setName("PlayBillingLibrary-" + andIncrement);
        return newThread;
    }
}
