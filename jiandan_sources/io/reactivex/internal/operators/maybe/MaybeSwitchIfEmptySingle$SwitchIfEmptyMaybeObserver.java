package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    public static final long serialVersionUID = 4603919676453758899L;
    public final SingleObserver<? super T> downstream;
    public final SingleSource<? extends T> other;

    public static final class qw<T> implements SingleObserver<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final SingleObserver<? super T> f10007ad;

        /* renamed from: th  reason: collision with root package name */
        public final AtomicReference<Disposable> f10008th;

        public qw(SingleObserver<? super T> singleObserver, AtomicReference<Disposable> atomicReference) {
            this.f10007ad = singleObserver;
            this.f10008th = atomicReference;
        }

        public void onError(Throwable th2) {
            this.f10007ad.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f10008th, disposable);
        }

        public void onSuccess(T t) {
            this.f10007ad.onSuccess(t);
        }
    }

    public MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
        this.downstream = singleObserver;
        this.other = singleSource;
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
