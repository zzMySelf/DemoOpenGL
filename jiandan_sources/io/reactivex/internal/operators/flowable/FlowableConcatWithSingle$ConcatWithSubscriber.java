package io.reactivex.internal.operators.flowable;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

public final class FlowableConcatWithSingle$ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements SingleObserver<T> {
    public static final long serialVersionUID = -7346385463600070225L;
    public SingleSource<? extends T> other;
    public final AtomicReference<Disposable> otherDisposable = new AtomicReference<>();

    public FlowableConcatWithSingle$ConcatWithSubscriber(Subscriber<? super T> subscriber, SingleSource<? extends T> singleSource) {
        super(subscriber);
        this.other = singleSource;
    }

    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    public void onComplete() {
        this.upstream = SubscriptionHelper.CANCELLED;
        SingleSource<? extends T> singleSource = this.other;
        this.other = null;
        singleSource.qw(this);
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
