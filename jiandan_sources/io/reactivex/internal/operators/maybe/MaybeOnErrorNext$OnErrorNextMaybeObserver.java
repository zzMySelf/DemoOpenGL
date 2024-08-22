package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeOnErrorNext$OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    public static final long serialVersionUID = 2026620218879969836L;
    public final boolean allowFatal;
    public final MaybeObserver<? super T> downstream;
    public final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

    public static final class qw<T> implements MaybeObserver<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final MaybeObserver<? super T> f10003ad;

        /* renamed from: th  reason: collision with root package name */
        public final AtomicReference<Disposable> f10004th;

        public qw(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
            this.f10003ad = maybeObserver;
            this.f10004th = atomicReference;
        }

        public void onComplete() {
            this.f10003ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10003ad.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.f10004th, disposable);
        }

        public void onSuccess(T t) {
            this.f10003ad.onSuccess(t);
        }
    }

    public MaybeOnErrorNext$OnErrorNextMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends MaybeSource<? extends T>> function, boolean z) {
        this.downstream = maybeObserver;
        this.resumeFunction = function;
        this.allowFatal = z;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        if (this.allowFatal || (th2 instanceof Exception)) {
            try {
                Object apply = this.resumeFunction.apply(th2);
                th.de.p039if.ad.qw.rg(apply, "The resumeFunction returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                DisposableHelper.replace(this, (Disposable) null);
                maybeSource.qw(new qw(this.downstream, this));
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        } else {
            this.downstream.onError(th2);
        }
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
