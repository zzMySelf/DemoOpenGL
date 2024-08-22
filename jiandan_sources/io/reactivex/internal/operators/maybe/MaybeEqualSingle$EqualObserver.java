package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeEqualSingle$EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
    public static final long serialVersionUID = -3031974433025990931L;
    public final MaybeEqualSingle$EqualCoordinator<T> parent;
    public Object value;

    public MaybeEqualSingle$EqualObserver(MaybeEqualSingle$EqualCoordinator<T> maybeEqualSingle$EqualCoordinator) {
        this.parent = maybeEqualSingle$EqualCoordinator;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.parent.done();
    }

    public void onError(Throwable th2) {
        this.parent.error(this, th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this, disposable);
    }

    public void onSuccess(T t) {
        this.value = t;
        this.parent.done();
    }
}
