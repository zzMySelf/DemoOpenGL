package io.reactivex.internal.operators.single;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.ad.qw;

public final class SingleFlatMapCompletable$FlatMapCompletableObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, CompletableObserver, Disposable {
    public static final long serialVersionUID = -2177128922851101253L;
    public final CompletableObserver downstream;
    public final Function<? super T, ? extends CompletableSource> mapper;

    public SingleFlatMapCompletable$FlatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function) {
        this.downstream = completableObserver;
        this.mapper = function;
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
        this.downstream.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }

    public void onSuccess(T t) {
        try {
            Object apply = this.mapper.apply(t);
            qw.rg(apply, "The mapper returned a null CompletableSource");
            CompletableSource completableSource = (CompletableSource) apply;
            if (!isDisposed()) {
                completableSource.qw(this);
            }
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            onError(th2);
        }
    }
}
