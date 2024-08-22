package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;
import th.de.p039if.ad.qw;

public final class FlowableOnErrorReturn$OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
    public static final long serialVersionUID = -3740826063558713822L;
    public final Function<? super Throwable, ? extends T> valueSupplier;

    public FlowableOnErrorReturn$OnErrorReturnSubscriber(Subscriber<? super T> subscriber, Function<? super Throwable, ? extends T> function) {
        super(subscriber);
        this.valueSupplier = function;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        try {
            Object apply = this.valueSupplier.apply(th2);
            qw.rg(apply, "The valueSupplier returned a null value");
            complete(apply);
        } catch (Throwable th3) {
            th.de.o.qw.ad(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t) {
        this.produced++;
        this.downstream.onNext(t);
    }
}
