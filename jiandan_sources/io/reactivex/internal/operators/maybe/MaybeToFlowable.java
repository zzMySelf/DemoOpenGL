package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import th.de.ad;

public final class MaybeToFlowable<T> extends ad<T> implements HasUpstreamMaybeSource<T> {

    /* renamed from: th  reason: collision with root package name */
    public final MaybeSource<T> f10009th;

    public static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements MaybeObserver<T> {
        public static final long serialVersionUID = 7603343402964826922L;
        public Disposable upstream;

        public MaybeToFlowableSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.upstream.dispose();
        }

        public void onComplete() {
            this.downstream.onComplete();
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

    public MaybeToFlowable(MaybeSource<T> maybeSource) {
        this.f10009th = maybeSource;
    }

    public void yj(Subscriber<? super T> subscriber) {
        this.f10009th.qw(new MaybeToFlowableSubscriber(subscriber));
    }
}
