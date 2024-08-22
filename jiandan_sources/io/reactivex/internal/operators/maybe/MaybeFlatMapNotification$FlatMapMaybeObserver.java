package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapNotification$FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
    public static final long serialVersionUID = 4375739915521278546L;
    public final MaybeObserver<? super R> downstream;
    public final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
    public final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
    public final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;
    public Disposable upstream;

    public final class qw implements MaybeObserver<R> {
        public qw() {
        }

        public void onComplete() {
            MaybeFlatMapNotification$FlatMapMaybeObserver.this.downstream.onComplete();
        }

        public void onError(Throwable th2) {
            MaybeFlatMapNotification$FlatMapMaybeObserver.this.downstream.onError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(MaybeFlatMapNotification$FlatMapMaybeObserver.this, disposable);
        }

        public void onSuccess(R r) {
            MaybeFlatMapNotification$FlatMapMaybeObserver.this.downstream.onSuccess(r);
        }
    }

    public MaybeFlatMapNotification$FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
        this.downstream = maybeObserver;
        this.onSuccessMapper = function;
        this.onErrorMapper = function2;
        this.onCompleteSupplier = callable;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        try {
            Object call = this.onCompleteSupplier.call();
            th.de.p039if.ad.qw.rg(call, "The onCompleteSupplier returned a null MaybeSource");
            ((MaybeSource) call).qw(new qw());
        } catch (Exception e) {
            th.de.o.qw.ad(e);
            this.downstream.onError(e);
        }
    }

    public void onError(Throwable th2) {
        try {
            Object apply = this.onErrorMapper.apply(th2);
            th.de.p039if.ad.qw.rg(apply, "The onErrorMapper returned a null MaybeSource");
            ((MaybeSource) apply).qw(new qw());
        } catch (Exception e) {
            th.de.o.qw.ad(e);
            this.downstream.onError(new CompositeException(th2, e));
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t) {
        try {
            Object apply = this.onSuccessMapper.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The onSuccessMapper returned a null MaybeSource");
            ((MaybeSource) apply).qw(new qw());
        } catch (Exception e) {
            th.de.o.qw.ad(e);
            this.downstream.onError(e);
        }
    }
}
