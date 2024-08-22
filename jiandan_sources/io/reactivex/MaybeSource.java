package io.reactivex;

public interface MaybeSource<T> {
    void qw(MaybeObserver<? super T> maybeObserver);
}
