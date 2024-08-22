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

public final class FlowableTakeLastTimed$TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
    public final long count;
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

    public FlowableTakeLastTimed$TakeLastTimedSubscriber(Subscriber<? super T> subscriber, long j, long j2, TimeUnit timeUnit, th thVar, int i2, boolean z) {
        this.downstream = subscriber;
        this.count = j;
        this.time = j2;
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

    public boolean checkTerminated(boolean z, Subscriber<? super T> subscriber, boolean z2) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        } else if (!z2) {
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                subscriber.onError(th2);
                return true;
            } else if (!z) {
                return false;
            } else {
                subscriber.onComplete();
                return true;
            }
        } else if (!z) {
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

    public void drain() {
        if (getAndIncrement() == 0) {
            Subscriber<? super T> subscriber = this.downstream;
            qw<Object> qwVar = this.queue;
            boolean z = this.delayError;
            int i2 = 1;
            do {
                if (this.done) {
                    if (!checkTerminated(qwVar.isEmpty(), subscriber, z)) {
                        long j = this.requested.get();
                        long j2 = 0;
                        while (true) {
                            if (!checkTerminated(qwVar.peek() == null, subscriber, z)) {
                                if (j != j2) {
                                    qwVar.poll();
                                    subscriber.onNext(qwVar.poll());
                                    j2++;
                                } else if (j2 != 0) {
                                    th.de.p039if.yj.qw.rg(this.requested, j2);
                                }
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    public void onComplete() {
        trim(this.scheduler.ad(this.unit), this.queue);
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.delayError) {
            trim(this.scheduler.ad(this.unit), this.queue);
        }
        this.error = th2;
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        qw<Object> qwVar = this.queue;
        long ad2 = this.scheduler.ad(this.unit);
        qwVar.m2355if(Long.valueOf(ad2), t);
        trim(ad2, qwVar);
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

    public void trim(long j, qw<Object> qwVar) {
        long j2 = this.time;
        long j3 = this.count;
        boolean z = j3 == Long.MAX_VALUE;
        while (!qwVar.isEmpty()) {
            if (((Long) qwVar.peek()).longValue() < j - j2 || (!z && ((long) (qwVar.when() >> 1)) > j3)) {
                qwVar.poll();
                qwVar.poll();
            } else {
                return;
            }
        }
    }
}
