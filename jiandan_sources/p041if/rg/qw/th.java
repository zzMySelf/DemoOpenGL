package p041if.rg.qw;

import p041if.de;
import rx.Observable;
import rx.Producer;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

/* renamed from: if.rg.qw.th  reason: invalid package */
public final class th<T> implements Observable.OnSubscribe<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Observable<T> f11332ad;

    /* renamed from: th  reason: collision with root package name */
    public final Func1<? super T, Boolean> f11333th;

    /* renamed from: if.rg.qw.th$qw */
    public static final class qw<T> extends de<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final de<? super T> f11334ad;

        /* renamed from: th  reason: collision with root package name */
        public final Func1<? super T, Boolean> f11335th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f11336yj;

        public qw(de<? super T> deVar, Func1<? super T, Boolean> func1) {
            this.f11334ad = deVar;
            this.f11335th = func1;
            request(0);
        }

        public void onCompleted() {
            if (!this.f11336yj) {
                this.f11334ad.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (this.f11336yj) {
                p041if.uk.de.i(th2);
                return;
            }
            this.f11336yj = true;
            this.f11334ad.onError(th2);
        }

        public void onNext(T t) {
            try {
                if (this.f11335th.call(t).booleanValue()) {
                    this.f11334ad.onNext(t);
                } else {
                    request(1);
                }
            } catch (Throwable th2) {
                p041if.fe.qw.rg(th2);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th2, t));
            }
        }

        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.f11334ad.setProducer(producer);
        }
    }

    public th(Observable<T> observable, Func1<? super T, Boolean> func1) {
        this.f11332ad = observable;
        this.f11333th = func1;
    }

    /* renamed from: ad */
    public void call(de<? super T> deVar) {
        qw qwVar = new qw(deVar, this.f11333th);
        deVar.add(qwVar);
        this.f11332ad.aaa(qwVar);
    }
}
