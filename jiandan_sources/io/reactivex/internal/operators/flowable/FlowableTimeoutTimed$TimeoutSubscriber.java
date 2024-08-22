package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.ggg;
import th.de.p039if.fe.ad.ppp;
import th.de.ppp.qw;
import th.de.th;

public final class FlowableTimeoutTimed$TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, ppp {
    public static final long serialVersionUID = 3764492702657003550L;
    public final Subscriber<? super T> downstream;
    public final AtomicLong requested = new AtomicLong();
    public final SequentialDisposable task = new SequentialDisposable();
    public final long timeout;
    public final TimeUnit unit;
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();
    public final th.de worker;

    public FlowableTimeoutTimed$TimeoutSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, th.de deVar) {
        this.downstream = subscriber;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = deVar;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        long j = get();
        if (j != Long.MAX_VALUE) {
            long j2 = 1 + j;
            if (compareAndSet(j, j2)) {
                ((Disposable) this.task.get()).dispose();
                this.downstream.onNext(t);
                startTimeout(j2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
    }

    public void onTimeout(long j) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(new TimeoutException(ExceptionHelper.de(this.timeout, this.unit)));
            this.worker.dispose();
        }
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
    }

    public void startTimeout(long j) {
        this.task.replace(this.worker.de(new ggg(j, this), this.timeout, this.unit));
    }
}
