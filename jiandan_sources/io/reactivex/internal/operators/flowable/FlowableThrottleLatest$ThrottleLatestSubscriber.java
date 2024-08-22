package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;
import th.de.th;

public final class FlowableThrottleLatest$ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
    public static final long serialVersionUID = -8296689127439125014L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final Subscriber<? super T> downstream;
    public final boolean emitLast;
    public long emitted;
    public Throwable error;
    public final AtomicReference<T> latest = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final long timeout;
    public volatile boolean timerFired;
    public boolean timerRunning;
    public final TimeUnit unit;
    public Subscription upstream;
    public final th.de worker;

    public FlowableThrottleLatest$ThrottleLatestSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, th.de deVar, boolean z) {
        this.downstream = subscriber;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = deVar;
        this.emitLast = z;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.latest.lazySet((Object) null);
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            AtomicReference<T> atomicReference = this.latest;
            AtomicLong atomicLong = this.requested;
            Subscriber<? super T> subscriber = this.downstream;
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                if (!z || this.error == null) {
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        if (z2 || !this.emitLast) {
                            atomicReference.lazySet((Object) null);
                            subscriber.onComplete();
                        } else {
                            T andSet = atomicReference.getAndSet((Object) null);
                            long j = this.emitted;
                            if (j != atomicLong.get()) {
                                this.emitted = j + 1;
                                subscriber.onNext(andSet);
                                subscriber.onComplete();
                            } else {
                                subscriber.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                            }
                        }
                        this.worker.dispose();
                        return;
                    }
                    if (z2) {
                        if (this.timerFired) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                    } else if (!this.timerRunning || this.timerFired) {
                        T andSet2 = atomicReference.getAndSet((Object) null);
                        long j2 = this.emitted;
                        if (j2 != atomicLong.get()) {
                            subscriber.onNext(andSet2);
                            this.emitted = j2 + 1;
                            this.timerFired = false;
                            this.timerRunning = true;
                            this.worker.de(this, this.timeout, this.unit);
                        } else {
                            this.upstream.cancel();
                            subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                            this.worker.dispose();
                            return;
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    atomicReference.lazySet((Object) null);
                    subscriber.onError(this.error);
                    this.worker.dispose();
                    return;
                }
            }
            atomicReference.lazySet((Object) null);
        }
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        this.latest.set(t);
        drain();
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
        }
    }

    public void run() {
        this.timerFired = true;
        drain();
    }
}
