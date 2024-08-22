package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableCombineLatest$CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -8730235182291002949L;
    public final int index;
    public final int limit;
    public final FlowableCombineLatest$CombineLatestCoordinator<T, ?> parent;
    public final int prefetch;
    public int produced;

    public FlowableCombineLatest$CombineLatestInnerSubscriber(FlowableCombineLatest$CombineLatestCoordinator<T, ?> flowableCombineLatest$CombineLatestCoordinator, int i2, int i3) {
        this.parent = flowableCombineLatest$CombineLatestCoordinator;
        this.index = i2;
        this.prefetch = i3;
        this.limit = i3 - (i3 >> 2);
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index);
    }

    public void onError(Throwable th2) {
        this.parent.innerError(this.index, th2);
    }

    public void onNext(T t) {
        this.parent.innerValue(this.index, t);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, (long) this.prefetch);
    }

    public void requestOne() {
        int i2 = this.produced + 1;
        if (i2 == this.limit) {
            this.produced = 0;
            ((Subscription) get()).request((long) i2);
            return;
        }
        this.produced = i2;
    }
}
