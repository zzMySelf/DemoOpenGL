package p041if.rg.qw;

import p041if.de;
import rx.Observable;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

/* renamed from: if.rg.qw.o  reason: invalid package */
public final class o<T> implements Observable.Operator<Boolean, T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Func1<? super T, Boolean> f11304ad;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f11305th;

    /* renamed from: if.rg.qw.o$qw */
    public class qw extends de<T> {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f11306ad;

        /* renamed from: th  reason: collision with root package name */
        public boolean f11308th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ de f11309uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f11310yj;

        public qw(SingleDelayedProducer singleDelayedProducer, de deVar) {
            this.f11310yj = singleDelayedProducer;
            this.f11309uk = deVar;
        }

        public void onCompleted() {
            if (!this.f11308th) {
                this.f11308th = true;
                if (this.f11306ad) {
                    this.f11310yj.setValue(Boolean.FALSE);
                } else {
                    this.f11310yj.setValue(Boolean.valueOf(o.this.f11305th));
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.f11308th) {
                this.f11308th = true;
                this.f11309uk.onError(th2);
                return;
            }
            p041if.uk.de.i(th2);
        }

        public void onNext(T t) {
            if (!this.f11308th) {
                this.f11306ad = true;
                try {
                    if (o.this.f11304ad.call(t).booleanValue()) {
                        this.f11308th = true;
                        this.f11310yj.setValue(Boolean.valueOf(true ^ o.this.f11305th));
                        unsubscribe();
                    }
                } catch (Throwable th2) {
                    p041if.fe.qw.yj(th2, this, t);
                }
            }
        }
    }

    public o(Func1<? super T, Boolean> func1, boolean z) {
        this.f11304ad = func1;
        this.f11305th = z;
    }

    /* renamed from: ad */
    public de<? super T> call(de<? super Boolean> deVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(deVar);
        qw qwVar = new qw(singleDelayedProducer, deVar);
        deVar.add(qwVar);
        deVar.setProducer(singleDelayedProducer);
        return qwVar;
    }
}
