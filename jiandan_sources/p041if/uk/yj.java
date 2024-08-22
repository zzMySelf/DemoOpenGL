package p041if.uk;

import java.util.concurrent.ThreadFactory;
import p041if.qw;
import p041if.rg.de.ad;
import p041if.rg.de.de;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;

/* renamed from: if.uk.yj  reason: invalid package */
public class yj {
    public static final yj qw = new yj();

    public static qw ad(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new ad(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static qw de() {
        return fe(new RxThreadFactory("RxIoScheduler-"));
    }

    public static qw fe(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new p041if.rg.de.qw(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static qw qw() {
        return ad(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static qw rg() {
        return th(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static qw th(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new de(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static yj uk() {
        return qw;
    }

    public qw i() {
        return null;
    }

    public qw o() {
        return null;
    }

    @Deprecated
    public Action0 pf(Action0 action0) {
        return action0;
    }

    public qw yj() {
        return null;
    }
}
