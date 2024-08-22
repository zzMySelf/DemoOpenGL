package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;

public final class FlowableTakeLast$TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = 7240042530241604978L;
    public volatile boolean cancelled;
    public final int count;
    public volatile boolean done;
    public final Subscriber<? super T> downstream;
    public final AtomicLong requested = new AtomicLong();
    public Subscription upstream;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableTakeLast$TakeLastSubscriber(Subscriber<? super T> subscriber, int i2) {
        this.downstream = subscriber;
        this.count = i2;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    public void drain() {
        if (this.wip.getAndIncrement() == 0) {
            Subscriber<? super T> subscriber = this.downstream;
            long j = this.requested.get();
            while (!this.cancelled) {
                if (this.done) {
                    long j2 = 0;
                    while (j2 != j) {
                        if (!this.cancelled) {
                            Object poll = poll();
                            if (poll == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.onNext(poll);
                                j2++;
                            }
                        } else {
                            return;
                        }
                    }
                    if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                        j = this.requested.addAndGet(-j2);
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (this.count == size()) {
            poll();
        }
        offer(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.qw(this.requested, j);
            drain();
        }
    }
}
