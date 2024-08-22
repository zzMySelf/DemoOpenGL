package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatten$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    public static final long serialVersionUID = 4375739915521278546L;
    public final MaybeObserver<? super R> downstream;
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    public Disposable upstream;

    public final class qw implements MaybeObserver<R> {
        public qw() {
        }

        public void onComplete() {
            MaybeFlatten$FlatMapMaybeObserver.this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            MaybeFlatten$FlatMapMaybeObserver.this.downstream.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(MaybeFlatten$FlatMapMaybeObserver.this, disposable);
        }

        public void onSuccess(R r) {
            MaybeFlatten$FlatMapMaybeObserver.this.downstream.onSuccess(r);
        }
    }

    public MaybeFlatten$FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        this.downstream = maybeObserver;
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
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
        try {
            Object apply = this.mapper.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The mapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            if (!isDisposed()) {
                maybeSource.qw(new qw());
            }
        } catch (Exception e) {
            th.de.o.qw.ad(e);
            this.downstream.onError(e);
        }
    }
}
