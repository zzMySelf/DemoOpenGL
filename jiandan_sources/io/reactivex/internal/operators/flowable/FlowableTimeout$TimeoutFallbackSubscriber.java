package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.fe.ad.Cswitch;
import th.de.p039if.fe.ad.when;
import th.de.ppp.qw;

public final class FlowableTimeout$TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, Cswitch {
    public static final long serialVersionUID = 3764492702657003550L;
    public long consumed;
    public final Subscriber<? super T> downstream;
    public Publisher<? extends T> fallback;
    public final AtomicLong index;
    public final Function<? super T, ? extends Publisher<?>> itemTimeoutIndicator;
    public final SequentialDisposable task = new SequentialDisposable();
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public FlowableTimeout$TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends Publisher<?>> function, Publisher<? extends T> publisher) {
        super(true);
        this.downstream = subscriber;
        this.itemTimeoutIndicator = function;
        this.fallback = publisher;
        this.index = new AtomicLong();
    }

    public void cancel() {
        super.cancel();
        this.task.dispose();
    }

    public void onComplete() {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onComplete();
            this.task.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
            this.task.dispose();
            this.downstream.onError(th2);
            this.task.dispose();
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        long j = this.index.get();
        if (j != Long.MAX_VALUE) {
            long j2 = j + 1;
            if (this.index.compareAndSet(j, j2)) {
                Disposable disposable = (Disposable) this.task.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                this.consumed++;
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
                    this.index.getAndSet(Long.MAX_VALUE);
                    this.downstream.onError(th2);
                }
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
            Publisher<? extends T> publisher = this.fallback;
            this.fallback = null;
            long j2 = this.consumed;
            if (j2 != 0) {
                produced(j2);
            }
            publisher.subscribe(new when(this.downstream, this));
        }
    }

    public void onTimeoutError(long j, Throwable th2) {
        if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
            SubscriptionHelper.cancel(this.upstream);
            this.downstream.onError(th2);
            return;
        }
        qw.ddd(th2);
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
