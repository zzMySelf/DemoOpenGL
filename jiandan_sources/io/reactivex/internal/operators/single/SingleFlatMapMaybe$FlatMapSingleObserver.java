package io.reactivex.internal.operators.single;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.ad.qw;

public final class SingleFlatMapMaybe$FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    public static final long serialVersionUID = -5843758257109742742L;
    public final MaybeObserver<? super R> downstream;
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;

    public SingleFlatMapMaybe$FlatMapSingleObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        this.downstream = maybeObserver;
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
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
        try {
            Object apply = this.mapper.apply(t);
            qw.rg(apply, "The mapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            if (!isDisposed()) {
                maybeSource.qw(new th.de.p039if.fe.th.qw(this, this.downstream));
            }
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            onError(th2);
        }
    }
}
