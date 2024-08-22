package io.reactivex;

import io.reactivex.disposables.Disposable;

public interface SingleObserver<T> {
    void onError(Throwable th2);

    void onSubscribe(Disposable disposable);

    void onSuccess(T t);
}
