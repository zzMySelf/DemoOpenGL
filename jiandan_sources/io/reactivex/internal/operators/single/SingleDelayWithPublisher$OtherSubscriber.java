package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.p039if.de.Cswitch;
import th.de.ppp.qw;

public final class SingleDelayWithPublisher$OtherSubscriber<T, U> extends AtomicReference<Disposable> implements FlowableSubscriber<U>, Disposable {
    public static final long serialVersionUID = -8565274649390031272L;
    public boolean done;
    public final SingleObserver<? super T> downstream;
    public final SingleSource<T> source;
    public Subscription upstream;

    public SingleDelayWithPublisher$OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
        this.downstream = singleObserver;
        this.source = singleSource;
    }

    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.source.qw(new Cswitch(this, this.downstream));
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
    }

    public void onNext(U u) {
        this.upstream.cancel();
        onComplete();
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }
}
