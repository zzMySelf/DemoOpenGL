package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.Cswitch;
import th.de.ppp.qw;

public final class FlowableTimeout$TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Cswitch {
    public static final long serialVersionUID = 3764492702657003550L;
    public final Subscriber<? super T> downstream;
    public final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
    public final AtomicLong requested = new AtomicLong();
    public final SequentialDisposable task = new SequentialDisposable();
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public FlowableTimeout$TimeoutSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function) {
        this.downstream = subscriber;
        this.itemTimeoutIndicator = function;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.task.dispose();
    }

    public void onComplete() {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(th2);
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        long j = get();
        if (j != Long.MAX_VALUE) {
            long j2 = 1 + j;
            if (compareAndSet(j, j2)) {
                Disposable disposable = (Disposable) this.task.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                this.downstream.onNext(t);
                try {
                    Object apply = this.itemTimeoutIndicator.apply(t);
                    th.de.p039if.ad.qw.rg(apply, "The itemTimeoutIndicator returned a null Publisher.");
                    Publisher publisher = (Publisher) apply;
                    FlowableTimeout$TimeoutConsumer flowableTimeout$TimeoutConsumer = new FlowableTimeout$TimeoutConsumer(j2, this);
                    if (this.task.replace(flowableTimeout$TimeoutConsumer)) {
                        publisher.subscribe(flowableTimeout$TimeoutConsumer);
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.upstream.get().cancel();
                    getAndSet(Long.MAX_VALUE);
                    this.downstream.onError(th2);
                }
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, subscription);
    }

    public void onTimeout(long j) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(new TimeoutException());
        }
    }

    public void onTimeoutError(long j, Throwable th2) {
        if (compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(th2);
            return;
        }
        qw.ddd(th2);
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, j);
    }

    public void startFirstTimeout(Publisher<?> publisher) {
        if (publisher != null) {
            FlowableTimeout$TimeoutConsumer flowableTimeout$TimeoutConsumer = new FlowableTimeout$TimeoutConsumer(0, this);
            if (this.task.replace(flowableTimeout$TimeoutConsumer)) {
                publisher.subscribe(flowableTimeout$TimeoutConsumer);
            }
        }
    }
}
