package io.reactivex.internal.operators.flowable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithMaybe$ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
    public static final long serialVersionUID = -7346385463600070225L;
    public boolean inMaybe;
    public MaybeSource<? extends T> other;
    public final AtomicReference<Disposable> otherDisposable = new AtomicReference<>();

    public FlowableConcatWithMaybe$ConcatWithSubscriber(Subscriber<? super T> subscriber, MaybeSource<? extends T> maybeSource) {
        super(subscriber);
        this.other = maybeSource;
    }

    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    public void onComplete() {
        if (this.inMaybe) {
            this.downstream.onComplete();
            return;
        }
        this.inMaybe = true;
        this.upstream = SubscriptionHelper.CANCELLED;
        MaybeSource<? extends T> maybeSource = this.other;
        this.other = null;
        maybeSource.qw(this);
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        this.produced++;
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.otherDisposable, disposable);
    }

    public void onSuccess(T t) {
        complete(t);
    }
}
