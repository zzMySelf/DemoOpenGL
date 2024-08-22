package io.reactivex;

import io.reactivex.disposables.Disposable;

public interface Observer<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t);

    void onSubscribe(Disposable disposable);
}
