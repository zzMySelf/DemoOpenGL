package io.reactivex;

import io.reactivex.disposables.Disposable;

public interface MaybeObserver<T> {
    void onComplete();

    void onError(Throwable th2);

    void onSubscribe(Disposable disposable);

    void onSuccess(T t);
}
