package io.reactivex;

public interface ObservableOperator<Downstream, Upstream> {
    Observer<? super Upstream> qw(Observer<? super Downstream> observer) throws Exception;
}
