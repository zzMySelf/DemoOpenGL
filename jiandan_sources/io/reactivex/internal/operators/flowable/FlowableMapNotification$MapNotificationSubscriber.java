package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import th.de.p039if.ad.qw;

public final class FlowableMapNotification$MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
    public static final long serialVersionUID = 2757120512858778108L;
    public final Callable<? extends R> onCompleteSupplier;
    public final Function<? super Throwable, ? extends R> onErrorMapper;
    public final Function<? super T, ? extends R> onNextMapper;

    public FlowableMapNotification$MapNotificationSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
        super(subscriber);
        this.onNextMapper = function;
        this.onErrorMapper = function2;
        this.onCompleteSupplier = callable;
    }

    public void onComplete() {
        try {
            Object call = this.onCompleteSupplier.call();
            qw.rg(call, "The onComplete publisher returned is null");
            complete(call);
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.downstream.onError(th2);
        }
    }

    public void onError(Throwable th2) {
        try {
            Object apply = this.onErrorMapper.apply(th2);
            qw.rg(apply, "The onError publisher returned is null");
            complete(apply);
        } catch (Throwable th3) {
            th.de.o.qw.ad(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t) {
        try {
            Object apply = this.onNextMapper.apply(t);
            qw.rg(apply, "The onNext publisher returned is null");
            this.produced++;
            this.downstream.onNext(apply);
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.downstream.onError(th2);
        }
    }
}
