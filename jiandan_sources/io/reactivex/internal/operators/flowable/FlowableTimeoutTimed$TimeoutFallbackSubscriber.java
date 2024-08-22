package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.ggg;
import th.de.p039if.fe.ad.ppp;
import th.de.p039if.fe.ad.when;
import th.de.ppp.qw;
import th.de.th;

public final class FlowableTimeoutTimed$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, ppp {
    public static final long serialVersionUID = 3764492702657003550L;
    public long consumed;
    public final Subscriber<? super T> downstream;
    public Publisher<? extends T> fallback;
    public final AtomicLong index = new AtomicLong();
    public final SequentialDisposable task = new SequentialDisposable();
    public final long timeout;
    public final TimeUnit unit;
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();
    public final th.de worker;

    public FlowableTimeoutTimed$TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, th.de deVar, Publisher<? extends T> publisher) {
        super(true);
        this.downstream = subscriber;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = deVar;
        this.fallback = publisher;
    }

    public void cancel() {
        super.cancel();
        this.worker.dispose();
    }

    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onComplete();
            this.worker.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        long j = this.index.get();
        if (j != Long.MAX_VALUE) {
            long j2 = j + 1;
            if (this.index.compareAndSet(j, j2)) {
                ((Disposable) this.task.get()).dispose();
                this.consumed++;
                this.downstream.onNext(t);
                startTimeout(j2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
            setSubscription(subscription);
        }
    }

    public void onTimeout(long j) {
        if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            long j2 = this.consumed;
            if (j2 != 0) {
                produced(j2);
            }
            Publisher<? extends T> publisher = this.fallback;
            this.fallback = null;
            publisher.subscribe(new when(this.downstream, this));
            this.worker.dispose();
        }
    }

    public void startTimeout(long j) {
        this.task.replace(this.worker.de(new ggg(j, this), this.timeout, this.unit));
    }
}
