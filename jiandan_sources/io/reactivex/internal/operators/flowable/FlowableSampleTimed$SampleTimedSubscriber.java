package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;
import th.de.th;

public abstract class FlowableSampleTimed$SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
    public static final long serialVersionUID = -3517602651313910099L;
    public final Subscriber<? super T> downstream;
    public final long period;
    public final AtomicLong requested = new AtomicLong();
    public final th scheduler;
    public final SequentialDisposable timer = new SequentialDisposable();
    public final TimeUnit unit;
    public Subscription upstream;

    public FlowableSampleTimed$SampleTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, th thVar) {
        this.downstream = subscriber;
        this.period = j;
        this.unit = timeUnit;
        this.scheduler = thVar;
    }

    public void cancel() {
        cancelTimer();
        this.upstream.cancel();
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    public void emit() {
        Object andSet = getAndSet((Object) null);
        if (andSet == null) {
            return;
        }
        if (this.requested.get() != 0) {
            this.downstream.onNext(andSet);
            qw.rg(this.requested, 1);
            return;
        }
        cancel();
        this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
    }

    public void onComplete() {
        cancelTimer();
        complete();
    }

    public void onError(Throwable th2) {
        cancelTimer();
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        lazySet(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            SequentialDisposable sequentialDisposable = this.timer;
            th thVar = this.scheduler;
            long j = this.period;
            sequentialDisposable.replace(thVar.rg(this, j, j, this.unit));
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.qw(this.requested, j);
        }
    }
}
