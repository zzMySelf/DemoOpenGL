package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimer$TimerSubscriber extends AtomicReference<Disposable> implements Subscription, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public final Subscriber<? super Long> downstream;
    public volatile boolean requested;

    public FlowableTimer$TimerSubscriber(Subscriber<? super Long> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.requested = true;
        }
    }

    public void run() {
        if (get() == DisposableHelper.DISPOSED) {
            return;
        }
        if (this.requested) {
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
            return;
        }
        lazySet(EmptyDisposable.INSTANCE);
        this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.trySet(this, disposable);
    }
}
