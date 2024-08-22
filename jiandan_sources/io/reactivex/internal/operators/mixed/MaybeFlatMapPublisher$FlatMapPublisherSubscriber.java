package io.reactivex.internal.operators.mixed;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.ad.qw;

public final class MaybeFlatMapPublisher$FlatMapPublisherSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, MaybeObserver<T>, Subscription {
    public static final long serialVersionUID = -8948264376121066672L;
    public final Subscriber<? super R> downstream;
    public final Function<? super T, ? extends Publisher<? extends R>> mapper;
    public final AtomicLong requested = new AtomicLong();
    public Disposable upstream;

    public MaybeFlatMapPublisher$FlatMapPublisherSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        this.downstream = subscriber;
        this.mapper = function;
    }

    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(R r) {
        this.downstream.onNext(r);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        try {
            Object apply = this.mapper.apply(t);
            qw.rg(apply, "The mapper returned a null Publisher");
            ((Publisher) apply).subscribe(this);
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.downstream.onError(th2);
        }
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this, this.requested, j);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this, this.requested, subscription);
    }
}
