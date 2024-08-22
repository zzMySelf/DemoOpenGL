package p041if.rg.fe;

import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

/* renamed from: if.rg.fe.qw  reason: invalid package */
public final class qw<T> implements Observer<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Action1<? super T> f11227ad;

    /* renamed from: th  reason: collision with root package name */
    public final Action1<? super Throwable> f11228th;

    /* renamed from: yj  reason: collision with root package name */
    public final Action0 f11229yj;

    public qw(Action1<? super T> action1, Action1<? super Throwable> action12, Action0 action0) {
        this.f11227ad = action1;
        this.f11228th = action12;
        this.f11229yj = action0;
    }

    public void onCompleted() {
        this.f11229yj.call();
    }

    public void onError(Throwable th2) {
        this.f11228th.call(th2);
    }

    public void onNext(T t) {
        this.f11227ad.call(t);
    }
}
