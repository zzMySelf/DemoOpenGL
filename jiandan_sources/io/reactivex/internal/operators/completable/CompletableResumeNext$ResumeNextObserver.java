package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.ad.qw;

public final class CompletableResumeNext$ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
    public static final long serialVersionUID = 5018523762564524046L;
    public final CompletableObserver downstream;
    public final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    public boolean once;

    public CompletableResumeNext$ResumeNextObserver(CompletableObserver completableObserver, Function<? super Throwable, ? extends CompletableSource> function) {
        this.downstream = completableObserver;
        this.errorMapper = function;
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
        if (this.once) {
            this.downstream.onError(th2);
            return;
        }
        this.once = true;
        try {
            Object apply = this.errorMapper.apply(th2);
            qw.rg(apply, "The errorMapper returned a null CompletableSource");
            ((CompletableSource) apply).qw(this);
        } catch (Throwable th3) {
            th.de.o.qw.ad(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
