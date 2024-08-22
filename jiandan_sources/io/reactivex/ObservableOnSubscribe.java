package io.reactivex;

public interface ObservableOnSubscribe<T> {
    void qw(ObservableEmitter<T> observableEmitter) throws Exception;
}
