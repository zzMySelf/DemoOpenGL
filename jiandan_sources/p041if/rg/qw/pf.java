package p041if.rg.qw;

import p041if.de;
import rx.Observable;
import rx.Producer;
import rx.exceptions.OnErrorThrowable;

/* renamed from: if.rg.qw.pf  reason: invalid package */
public class pf<T, R> implements Observable.Operator<R, T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Class<R> f11311ad;

    /* renamed from: if.rg.qw.pf$qw */
    public static final class qw<T, R> extends de<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final de<? super R> f11312ad;

        /* renamed from: th  reason: collision with root package name */
        public final Class<R> f11313th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f11314yj;

        public qw(de<? super R> deVar, Class<R> cls) {
            this.f11312ad = deVar;
            this.f11313th = cls;
        }

        public void onCompleted() {
            if (!this.f11314yj) {
                this.f11312ad.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (this.f11314yj) {
                p041if.uk.de.i(th2);
                return;
            }
            this.f11314yj = true;
            this.f11312ad.onError(th2);
        }

        public void onNext(T t) {
            try {
                this.f11312ad.onNext(this.f11313th.cast(t));
            } catch (Throwable th2) {
                p041if.fe.qw.rg(th2);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th2, t));
            }
        }

        public void setProducer(Producer producer) {
            this.f11312ad.setProducer(producer);
        }
    }

    public pf(Class<R> cls) {
        this.f11311ad = cls;
    }

    /* renamed from: ad */
    public de<? super T> call(de<? super R> deVar) {
        qw qwVar = new qw(deVar, this.f11311ad);
        deVar.add(qwVar);
        return qwVar;
    }
}
