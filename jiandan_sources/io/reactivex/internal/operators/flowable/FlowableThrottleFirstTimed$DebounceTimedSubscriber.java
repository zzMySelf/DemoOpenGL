package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;
import th.de.th;

public final class FlowableThrottleFirstTimed$DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
    public static final long serialVersionUID = -9102637559663639004L;
    public boolean done;
    public final Subscriber<? super T> downstream;
    public volatile boolean gate;
    public final long timeout;
    public final SequentialDisposable timer = new SequentialDisposable();
    public final TimeUnit unit;
    public Subscription upstream;
    public final th.de worker;

    public FlowableThrottleFirstTimed$DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, th.de deVar) {
        this.downstream = subscriber;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = deVar;
    }

    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
        this.worker.dispose();
    }

    public void onNext(T t) {
        if (!this.done && !this.gate) {
            this.gate = true;
            if (get() != 0) {
                this.downstream.onNext(t);
                th.de.p039if.yj.qw.rg(this, 1);
                Disposable disposable = (Disposable) this.timer.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                this.timer.replace(this.worker.de(this, this.timeout, this.unit));
                return;
            }
            this.done = true;
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }
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
            th.de.p039if.yj.qw.qw(this, j);
        }
    }

    public void run() {
        this.gate = false;
    }
}
