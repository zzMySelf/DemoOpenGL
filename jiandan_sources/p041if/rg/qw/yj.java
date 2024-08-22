package p041if.rg.qw;

import p041if.de;
import p041if.fe.qw;
import rx.Observable;

/* renamed from: if.rg.qw.yj  reason: invalid package */
public final class yj<T, R> implements Observable.OnSubscribe<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final Observable.OnSubscribe<T> f11342ad;

    /* renamed from: th  reason: collision with root package name */
    public final Observable.Operator<? extends R, ? super T> f11343th;

    public yj(Observable.OnSubscribe<T> onSubscribe, Observable.Operator<? extends R, ? super T> operator) {
        this.f11342ad = onSubscribe;
        this.f11343th = operator;
    }

    /* renamed from: ad */
    public void call(de<? super R> deVar) {
        de deVar2;
        try {
            deVar2 = (de) p041if.uk.de.pf(this.f11343th).call(deVar);
            deVar2.onStart();
            this.f11342ad.call(deVar2);
        } catch (Throwable th2) {
            qw.rg(th2);
            deVar.onError(th2);
        }
    }
}
