package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.Cif;

public final class FlowableSequenceEqual$EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
    public static final long serialVersionUID = 4804128302091633067L;
    public volatile boolean done;
    public final int limit;
    public final Cif parent;
    public final int prefetch;
    public long produced;
    public volatile SimpleQueue<T> queue;
    public int sourceMode;

    public FlowableSequenceEqual$EqualSubscriber(Cif ifVar, int i2) {
        this.parent = ifVar;
        this.limit = i2 - (i2 >> 2);
        this.prefetch = i2;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void clear() {
        SimpleQueue<T> simpleQueue = this.queue;
        if (simpleQueue != null) {
            simpleQueue.clear();
        }
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable th2) {
        this.parent.innerError(th2);
    }

    public void onNext(T t) {
        if (this.sourceMode != 0 || this.queue.offer(t)) {
            this.parent.drain();
        } else {
            onError(new MissingBackpressureException());
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(3);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    this.parent.drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = queueSubscription;
                    subscription.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            subscription.request((long) this.prefetch);
        }
    }

    public void request() {
        if (this.sourceMode != 1) {
            long j = this.produced + 1;
            if (j >= ((long) this.limit)) {
                this.produced = 0;
                ((Subscription) get()).request(j);
                return;
            }
            this.produced = j;
        }
    }
}
