package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends th.de.p039if.fe.ad.qw<T, T> implements FlowableSubscriber<T> {

    /* renamed from: yj  reason: collision with root package name */
    public final qw<T> f9980yj;

    public static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        public static final long serialVersionUID = 6770240836423125754L;
        public final Subscriber<? super T> downstream;
        public long index;
        public qw<T> node;
        public int offset;
        public final FlowableCache<T> parent;
        public final AtomicLong requested = new AtomicLong();

        public CacheSubscription(Subscriber<? super T> subscriber, FlowableCache<T> flowableCache) {
            this.downstream = subscriber;
            this.parent = flowableCache;
            this.node = flowableCache.f9980yj;
        }

        public void cancel() {
            if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.uk(this);
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                th.de.p039if.yj.qw.ad(this.requested, j);
                this.parent.i(this);
            }
        }
    }

    public static final class qw<T> {
    }

    public abstract void i(CacheSubscription<T> cacheSubscription);

    public abstract void uk(CacheSubscription<T> cacheSubscription);
}
