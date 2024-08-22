package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;
import th.de.th;

public abstract class ParallelRunOn$BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
    public static final long serialVersionUID = 9222303586456402150L;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public Throwable error;
    public final int limit;
    public final int prefetch;
    public final SpscArrayQueue<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public Subscription upstream;
    public final th.de worker;

    public ParallelRunOn$BaseRunOnSubscriber(int i2, SpscArrayQueue<T> spscArrayQueue, th.de deVar) {
        this.prefetch = i2;
        this.queue = spscArrayQueue;
        this.limit = i2 - (i2 >> 2);
        this.worker = deVar;
    }

    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public final void onComplete() {
        if (!this.done) {
            this.done = true;
            schedule();
        }
    }

    public final void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        schedule();
    }

    public final void onNext(T t) {
        if (!this.done) {
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
                return;
            }
            schedule();
        }
    }

    public abstract /* synthetic */ void onSubscribe(Subscription subscription);

    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            schedule();
        }
    }

    public final void schedule() {
        if (getAndIncrement() == 0) {
            this.worker.ad(this);
        }
    }
}
