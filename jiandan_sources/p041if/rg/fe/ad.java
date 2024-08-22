package p041if.rg.fe;

import p041if.de;
import rx.functions.Action0;
import rx.functions.Action1;

/* renamed from: if.rg.fe.ad  reason: invalid package */
public final class ad<T> extends de<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Action1<? super T> f11201ad;

    /* renamed from: th  reason: collision with root package name */
    public final Action1<Throwable> f11202th;

    /* renamed from: yj  reason: collision with root package name */
    public final Action0 f11203yj;

    public ad(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        this.f11201ad = action1;
        this.f11202th = action12;
        this.f11203yj = action0;
    }

    public void onCompleted() {
        this.f11203yj.call();
    }

    public void onError(Throwable th2) {
        this.f11202th.call(th2);
    }

    public void onNext(T t) {
        this.f11201ad.call(t);
    }
}
