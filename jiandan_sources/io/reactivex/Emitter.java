package io.reactivex;

public interface Emitter<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t);
}
