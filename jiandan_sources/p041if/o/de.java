package p041if.o;

import rx.Observable;

/* renamed from: if.o.de  reason: invalid package */
public class de<T, R> extends fe<T, R> {

    /* renamed from: th  reason: collision with root package name */
    public final p041if.yj.de<T> f11131th;

    /* renamed from: if.o.de$qw */
    public class qw implements Observable.OnSubscribe<R> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe f11132ad;

        public qw(fe feVar) {
            this.f11132ad = feVar;
        }

        /* renamed from: ad */
        public void call(p041if.de<? super R> deVar) {
            this.f11132ad.aaa(deVar);
        }
    }

    public de(fe<T, R> feVar) {
        super(new qw(feVar));
        this.f11131th = new p041if.yj.de<>(feVar);
    }

    public void onCompleted() {
        this.f11131th.onCompleted();
    }

    public void onError(Throwable th2) {
        this.f11131th.onError(th2);
    }

    public void onNext(T t) {
        this.f11131th.onNext(t);
    }
}
