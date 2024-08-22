package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenObservable$AndThenObservableObserver<R> extends AtomicReference<Disposable> implements Observer<R>, CompletableObserver, Disposable {
    public static final long serialVersionUID = -8948264376121066672L;
    public final Observer<? super R> downstream;
    public ObservableSource<? extends R> other;

    public CompletableAndThenObservable$AndThenObservableObserver(Observer<? super R> observer, ObservableSource<? extends R> observableSource) {
        this.other = observableSource;
        this.downstream = observer;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable) get());
    }

    public void onComplete() {
        ObservableSource<? extends R> observableSource = this.other;
        if (observableSource == null) {
            this.downstream.onComplete();
            return;
        }
        this.other = null;
        observableSource.subscribe(this);
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onNext(R r) {
        this.downstream.onNext(r);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this, disposable);
    }
}
