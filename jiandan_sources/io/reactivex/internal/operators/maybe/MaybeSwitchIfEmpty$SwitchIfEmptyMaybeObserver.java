package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    public static final long serialVersionUID = -2223459372976438024L;
    public final MaybeObserver<? super T> downstream;
    public final MaybeSource<? extends T> other;

    public static final class qw<T> implements MaybeObserver<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final MaybeObserver<? super T> f10005ad;

        /* renamed from: th  reason: collision with root package name */
        public final AtomicReference<Disposable> f10006th;

        public qw(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
            this.f10005ad = maybeObserver;
            this.f10006th = atomicReference;
        }

        public void onComplete() {
            this.f10005ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10005ad.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f10006th, disposable);
        }

        public void onSuccess(T t) {
            this.f10005ad.onSuccess(t);
        }
    }

    public MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
        this.downstream = maybeObserver;
        this.other = maybeSource;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        Disposable disposable = (Disposable) get();
        if (disposable != DisposableHelper.DISPOSED && compareAndSet(disposable, (Object) null)) {
            this.other.qw(new qw(this.downstream, this));
        }
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.setOnce(this, disposable)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
