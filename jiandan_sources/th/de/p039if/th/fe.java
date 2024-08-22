package th.de.p039if.th;

import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;
import th.de.th;

/* renamed from: th.de.if.th.fe  reason: invalid package */
public final class fe extends th {

    /* renamed from: yj  reason: collision with root package name */
    public static final RxThreadFactory f10947yj = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: th  reason: collision with root package name */
    public final ThreadFactory f10948th;

    public fe() {
        this(f10947yj);
    }

    public th.de qw() {
        return new rg(this.f10948th);
    }

    public fe(ThreadFactory threadFactory) {
        this.f10948th = threadFactory;
    }
}
