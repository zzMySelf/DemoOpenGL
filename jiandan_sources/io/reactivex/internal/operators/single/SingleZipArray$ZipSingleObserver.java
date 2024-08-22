package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleZipArray$ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
    public static final long serialVersionUID = 3323743579927613702L;
    public final int index;
    public final SingleZipArray$ZipCoordinator<T, ?> parent;

    public SingleZipArray$ZipSingleObserver(SingleZipArray$ZipCoordinator<T, ?> singleZipArray$ZipCoordinator, int i2) {
        this.parent = singleZipArray$ZipCoordinator;
        this.index = i2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onError(Throwable th2) {
        this.parent.innerError(th2, this.index);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void onSuccess(T t) {
        this.parent.innerSuccess(t, this.index);
    }
}
