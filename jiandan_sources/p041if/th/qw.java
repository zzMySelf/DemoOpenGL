package p041if.th;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* renamed from: if.th.qw  reason: invalid package */
public abstract class qw<T> extends Observable<T> {
    public qw(Observable.OnSubscribe<T> onSubscribe) {
        super(onSubscribe);
    }

    public abstract void qqq(Action1<? super Subscription> action1);
}
