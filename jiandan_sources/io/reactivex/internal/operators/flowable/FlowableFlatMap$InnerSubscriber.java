package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableFlatMap$InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
    public static final long serialVersionUID = -4606175640614850599L;
    public final int bufferSize;
    public volatile boolean done;
    public int fusionMode;
    public final long id;
    public final int limit;
    public final FlowableFlatMap$MergeSubscriber<T, U> parent;
    public long produced;
    public volatile SimpleQueue<U> queue;

    public FlowableFlatMap$InnerSubscriber(FlowableFlatMap$MergeSubscriber<T, U> flowableFlatMap$MergeSubscriber, long j) {
        this.id = j;
        this.parent = flowableFlatMap$MergeSubscriber;
        int i2 = flowableFlatMap$MergeSubscriber.bufferSize;
        this.bufferSize = i2;
        this.limit = i2 >> 2;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable th2) {
        lazySet(SubscriptionHelper.CANCELLED);
        this.parent.innerError(this, th2);
    }

    public void onNext(U u) {
        if (this.fusionMode != 2) {
            this.parent.tryEmit(u, this);
        } else {
            this.parent.drain();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueSubscription;
                }
            }
            subscription.request((long) this.bufferSize);
        }
    }

    public void requestMore(long j) {
        if (this.fusionMode != 1) {
            long j2 = this.produced + j;
            if (j2 >= ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j2);
                return;
            }
            this.produced = j2;
        }
    }
}
