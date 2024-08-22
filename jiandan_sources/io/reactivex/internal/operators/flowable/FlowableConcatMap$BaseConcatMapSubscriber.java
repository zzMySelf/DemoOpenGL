package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.de;

public abstract class FlowableConcatMap$BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, de<R>, Subscription {
    public static final long serialVersionUID = -3511336836796789179L;
    public volatile boolean active;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final FlowableConcatMap$ConcatMapInner<R> inner = new FlowableConcatMap$ConcatMapInner<>(this);
    public final int limit;
    public final Function<? super T, ? extends Publisher<? extends R>> mapper;
    public final int prefetch;
    public SimpleQueue<T> queue;
    public int sourceMode;
    public Subscription upstream;

    public FlowableConcatMap$BaseConcatMapSubscriber(Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        this.mapper = function;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
    }

    public abstract void drain();

    public final void innerComplete() {
        this.active = false;
        drain();
    }

    public abstract /* synthetic */ void innerError(Throwable th2);

    public abstract /* synthetic */ void innerNext(T t);

    public final void onComplete() {
        this.done = true;
        drain();
    }

    public final void onNext(T t) {
        if (this.sourceMode == 2 || this.queue.offer(t)) {
            drain();
            return;
        }
        this.upstream.cancel();
        onError(new IllegalStateException("Queue full?!"));
    }

    public final void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = queueSubscription;
                    this.done = true;
                    subscribeActual();
                    drain();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = queueSubscription;
                    subscribeActual();
                    subscription.request((long) this.prefetch);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.prefetch);
            subscribeActual();
            subscription.request((long) this.prefetch);
        }
    }

    public abstract void subscribeActual();
}
