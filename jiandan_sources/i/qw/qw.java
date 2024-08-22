package i.qw;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: lambda */
public final /* synthetic */ class qw implements ThreadFactory {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f6161ad;

    public /* synthetic */ qw(AtomicInteger atomicInteger) {
        this.f6161ad = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        return aaa.qqq(this.f6161ad, runnable);
    }
}
