package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class ParallelJoin$JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
    public static final long serialVersionUID = 8410034718427740355L;
    public final int limit;
    public final ParallelJoin$JoinSubscriptionBase<T> parent;
    public final int prefetch;
    public long produced;
    public volatile SimplePlainQueue<T> queue;

    public ParallelJoin$JoinInnerSubscriber(ParallelJoin$JoinSubscriptionBase<T> parallelJoin$JoinSubscriptionBase, int i2) {
        this.parent = parallelJoin$JoinSubscriptionBase;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
    }

    public boolean cancel() {
        return SubscriptionHelper.cancel(this);
    }

    public SimplePlainQueue<T> getQueue() {
        SimplePlainQueue<T> simplePlainQueue = this.queue;
        if (simplePlainQueue != null) {
            return simplePlainQueue;
        }
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
        this.queue = spscArrayQueue;
        return spscArrayQueue;
    }

    public void onComplete() {
        this.parent.onComplete();
    }

    public void onError(Throwable th2) {
        this.parent.onError(th2);
    }

    public void onNext(T t) {
        this.parent.onNext(this, t);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, (long) this.prefetch);
    }

    public void request(long j) {
        long j2 = this.produced + j;
        if (j2 >= ((long) this.limit)) {
            this.produced = 0;
            ((Subscription) get()).request(j2);
            return;
        }
        this.produced = j2;
    }

    public void requestOne() {
        long j = this.produced + 1;
        if (j == ((long) this.limit)) {
            this.produced = 0;
            ((Subscription) get()).request(j);
            return;
        }
        this.produced = j;
    }
}
