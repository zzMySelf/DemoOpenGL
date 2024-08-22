package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.ad.qw;

public final class SingleFlatMapPublisher$SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements SingleObserver<S>, FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = 7759721921468635667L;
    public Disposable disposable;
    public final Subscriber<? super T> downstream;
    public final Function<? super S, ? extends Publisher<? extends T>> mapper;
    public final AtomicReference<Subscription> parent = new AtomicReference<>();

    public SingleFlatMapPublisher$SingleFlatMapPublisherObserver(Subscriber<? super T> subscriber, Function<? super S, ? extends Publisher<? extends T>> function) {
        this.downstream = subscriber;
        this.mapper = function;
    }

    public void cancel() {
        this.disposable.dispose();
        SubscriptionHelper.cancel(this.parent);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable2) {
        this.disposable = disposable2;
        this.downstream.onSubscribe(this);
    }

    public void onSuccess(S s) {
        try {
            Object apply = this.mapper.apply(s);
            qw.rg(apply, "the mapper returned a null Publisher");
            ((Publisher) apply).subscribe(this);
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.downstream.onError(th2);
        }
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.parent, this, j);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.parent, this, subscription);
    }
}
