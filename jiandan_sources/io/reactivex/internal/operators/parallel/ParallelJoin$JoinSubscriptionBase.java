package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;

public abstract class ParallelJoin$JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
    public static final long serialVersionUID = 3100232009247827843L;
    public volatile boolean cancelled;
    public final AtomicInteger done = new AtomicInteger();
    public final Subscriber<? super T> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicLong requested = new AtomicLong();
    public final ParallelJoin$JoinInnerSubscriber<T>[] subscribers;

    public ParallelJoin$JoinSubscriptionBase(Subscriber<? super T> subscriber, int i2, int i3) {
        this.downstream = subscriber;
        ParallelJoin$JoinInnerSubscriber<T>[] parallelJoin$JoinInnerSubscriberArr = new ParallelJoin$JoinInnerSubscriber[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            parallelJoin$JoinInnerSubscriberArr[i4] = new ParallelJoin$JoinInnerSubscriber<>(this, i3);
        }
        this.subscribers = parallelJoin$JoinInnerSubscriberArr;
        this.done.lazySet(i2);
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                cleanup();
            }
        }
    }

    public void cancelAll() {
        for (ParallelJoin$JoinInnerSubscriber<T> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public void cleanup() {
        for (ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber : this.subscribers) {
            parallelJoin$JoinInnerSubscriber.queue = null;
        }
    }

    public abstract void drain();

    public abstract void onComplete();

    public abstract void onError(Throwable th2);

    public abstract void onNext(ParallelJoin$JoinInnerSubscriber<T> parallelJoin$JoinInnerSubscriber, T t);

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.qw(this.requested, j);
            drain();
        }
    }
}
