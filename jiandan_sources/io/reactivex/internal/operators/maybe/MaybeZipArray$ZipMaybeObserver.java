package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeZipArray$ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
    public static final long serialVersionUID = 3323743579927613702L;
    public final int index;
    public final MaybeZipArray$ZipCoordinator<T, ?> parent;

    public MaybeZipArray$ZipMaybeObserver(MaybeZipArray$ZipCoordinator<T, ?> maybeZipArray$ZipCoordinator, int i2) {
        this.parent = maybeZipArray$ZipCoordinator;
        this.index = i2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.parent.innerComplete(this.index);
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
