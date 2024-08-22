package p041if.rg.qw;

import p041if.de;
import rx.Observable;
import rx.Producer;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

/* renamed from: if.rg.qw.uk  reason: invalid package */
public final class uk<T, R> implements Observable.OnSubscribe<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final Observable<T> f11337ad;

    /* renamed from: th  reason: collision with root package name */
    public final Func1<? super T, ? extends R> f11338th;

    /* renamed from: if.rg.qw.uk$qw */
    public static final class qw<T, R> extends de<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final de<? super R> f11339ad;

        /* renamed from: th  reason: collision with root package name */
        public final Func1<? super T, ? extends R> f11340th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f11341yj;

        public qw(de<? super R> deVar, Func1<? super T, ? extends R> func1) {
            this.f11339ad = deVar;
            this.f11340th = func1;
        }

        public void onCompleted() {
            if (!this.f11341yj) {
                this.f11339ad.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (this.f11341yj) {
                p041if.uk.de.i(th2);
                return;
            }
            this.f11341yj = true;
            this.f11339ad.onError(th2);
        }

        public void onNext(T t) {
            try {
                this.f11339ad.onNext(this.f11340th.call(t));
            } catch (Throwable th2) {
                p041if.fe.qw.rg(th2);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th2, t));
            }
        }

        public void setProducer(Producer producer) {
            this.f11339ad.setProducer(producer);
        }
    }

    public uk(Observable<T> observable, Func1<? super T, ? extends R> func1) {
        this.f11337ad = observable;
        this.f11338th = func1;
    }

    /* renamed from: ad */
    public void call(de<? super R> deVar) {
        qw qwVar = new qw(deVar, this.f11338th);
        deVar.add(qwVar);
        this.f11337ad.aaa(qwVar);
    }
}
