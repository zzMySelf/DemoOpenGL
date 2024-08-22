package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.rg.qw;
import th.de.th;

public final class FlowableSkipLastTimed$SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public final Subscriber<? super T> downstream;
    public Throwable error;
    public final qw<Object> queue;
    public final AtomicLong requested = new AtomicLong();
    public final th scheduler;
    public final long time;
    public final TimeUnit unit;
    public Subscription upstream;

    public FlowableSkipLastTimed$SkipLastTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, th thVar, int i2, boolean z) {
        this.downstream = subscriber;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = thVar;
        this.queue = new qw<>(i2);
        this.delayError = z;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!z3) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    subscriber.onError(th2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                Throwable th3 = this.error;
                if (th3 != null) {
                    subscriber.onError(th3);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            Subscriber<? super T> subscriber = this.downstream;
            qw<Object> qwVar = this.queue;
            boolean z = this.delayError;
            TimeUnit timeUnit = this.unit;
            th thVar = this.scheduler;
            long j = this.time;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    boolean z2 = this.done;
                    Long l = (Long) qwVar.peek();
                    boolean z3 = l == null;
                    boolean z4 = (z3 || l.longValue() <= thVar.ad(timeUnit) - j) ? z3 : true;
                    if (!checkTerminated(z2, z4, subscriber, z)) {
                        if (z4) {
                            break;
                        }
                        qwVar.poll();
                        subscriber.onNext(qwVar.poll());
                        j3++;
                    } else {
                        return;
                    }
                }
                if (j3 != 0) {
                    th.de.p039if.yj.qw.rg(this.requested, j3);
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
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
        this.queue.m2355if(Long.valueOf(this.scheduler.ad(this.unit)), t);
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
            th.de.p039if.yj.qw.qw(this.requested, j);
            drain();
        }
    }
}
