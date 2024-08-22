package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;

public final class FlowableScanSeed$ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -1776795561228106469L;
    public final BiFunction<R, ? super T, R> accumulator;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final Subscriber<? super R> downstream;
    public Throwable error;
    public final int limit;
    public final int prefetch;
    public final SimplePlainQueue<R> queue;
    public final AtomicLong requested = new AtomicLong();
    public Subscription upstream;
    public R value;

    public FlowableScanSeed$ScanSeedSubscriber(Subscriber<? super R> subscriber, BiFunction<R, ? super T, R> biFunction, R r, int i2) {
        this.downstream = subscriber;
        this.accumulator = biFunction;
        this.value = r;
        this.prefetch = i2;
        this.limit = i2 - (i2 >> 2);
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i2);
        this.queue = spscArrayQueue;
        spscArrayQueue.offer(r);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public void drain() {
        int i2;
        Throwable th2;
        if (getAndIncrement() == 0) {
            Subscriber<? super R> subscriber = this.downstream;
            SimplePlainQueue<R> simplePlainQueue = this.queue;
            int i3 = this.limit;
            int i4 = this.consumed;
            int i5 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.cancelled) {
                        simplePlainQueue.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        if (!z || (th2 = this.error) == null) {
                            R poll = simplePlainQueue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                subscriber.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(poll);
                                j2++;
                                i4++;
                                if (i4 == i3) {
                                    this.upstream.request((long) i3);
                                    i4 = 0;
                                }
                            }
                        } else {
                            simplePlainQueue.clear();
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                if (i2 == 0 && this.done) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        simplePlainQueue.clear();
                        subscriber.onError(th3);
                        return;
                    } else if (simplePlainQueue.isEmpty()) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j2 != 0) {
                    qw.rg(this.requested, j2);
                }
                this.consumed = i4;
                i5 = addAndGet(-i5);
            } while (i5 != 0);
        }
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        if (!this.done) {
            try {
                R apply = this.accumulator.apply(this.value, t);
                th.de.p039if.ad.qw.rg(apply, "The accumulator returned a null value");
                this.value = apply;
                this.queue.offer(apply);
                drain();
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request((long) (this.prefetch - 1));
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.qw(this.requested, j);
            drain();
        }
    }
}
