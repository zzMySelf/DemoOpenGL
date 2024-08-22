package p041if;

import java.util.concurrent.TimeUnit;
import rx.Subscription;
import rx.functions.Action0;

/* renamed from: if.qw  reason: invalid package */
public abstract class qw {

    /* renamed from: if.qw$qw  reason: collision with other inner class name */
    public static abstract class C0349qw implements Subscription {
        public long ad() {
            return System.currentTimeMillis();
        }

        public abstract Subscription de(Action0 action0);

        public abstract Subscription fe(Action0 action0, long j, TimeUnit timeUnit);
    }

    static {
        TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());
    }

    public long ad() {
        return System.currentTimeMillis();
    }

    public abstract C0349qw qw();
}
