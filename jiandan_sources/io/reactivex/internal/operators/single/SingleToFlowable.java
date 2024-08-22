package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import th.de.ad;

public final class SingleToFlowable<T> extends ad<T> {

    /* renamed from: th  reason: collision with root package name */
    public final SingleSource<? extends T> f10311th;

    public static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        public static final long serialVersionUID = 187782011903685568L;
        public Disposable upstream;

        public SingleToFlowableObserver(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            complete(t);
        }
    }

    public SingleToFlowable(SingleSource<? extends T> singleSource) {
        this.f10311th = singleSource;
    }

    public void yj(Subscriber<? super T> subscriber) {
        this.f10311th.qw(new SingleToFlowableObserver(subscriber));
    }
}
