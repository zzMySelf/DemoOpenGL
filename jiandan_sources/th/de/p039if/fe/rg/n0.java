package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import th.de.when.fe;

/* renamed from: th.de.if.fe.rg.n0  reason: invalid package */
public final class n0<T, U> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final ObservableSource<U> f10697th;

    /* renamed from: th.de.if.fe.rg.n0$ad */
    public static final class ad<T> implements Observer<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10698ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10699i;

        /* renamed from: th  reason: collision with root package name */
        public final ArrayCompositeDisposable f10700th;

        /* renamed from: uk  reason: collision with root package name */
        public volatile boolean f10701uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10702yj;

        public ad(Observer<? super T> observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f10698ad = observer;
            this.f10700th = arrayCompositeDisposable;
        }

        public void onComplete() {
            this.f10700th.dispose();
            this.f10698ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10700th.dispose();
            this.f10698ad.onError(th2);
        }

        public void onNext(T t) {
            if (this.f10699i) {
                this.f10698ad.onNext(t);
            } else if (this.f10701uk) {
                this.f10699i = true;
                this.f10698ad.onNext(t);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10702yj, disposable)) {
                this.f10702yj = disposable;
                this.f10700th.setResource(0, disposable);
            }
        }
    }

    /* renamed from: th.de.if.fe.rg.n0$qw */
    public final class qw implements Observer<U> {

        /* renamed from: ad  reason: collision with root package name */
        public final ArrayCompositeDisposable f10703ad;

        /* renamed from: th  reason: collision with root package name */
        public final ad<T> f10704th;

        /* renamed from: uk  reason: collision with root package name */
        public Disposable f10705uk;

        /* renamed from: yj  reason: collision with root package name */
        public final fe<T> f10706yj;

        public qw(n0 n0Var, ArrayCompositeDisposable arrayCompositeDisposable, ad<T> adVar, fe<T> feVar) {
            this.f10703ad = arrayCompositeDisposable;
            this.f10704th = adVar;
            this.f10706yj = feVar;
        }

        public void onComplete() {
            this.f10704th.f10701uk = true;
        }

        public void onError(Throwable th2) {
            this.f10703ad.dispose();
            this.f10706yj.onError(th2);
        }

        public void onNext(U u) {
            this.f10705uk.dispose();
            this.f10704th.f10701uk = true;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10705uk, disposable)) {
                this.f10705uk = disposable;
                this.f10703ad.setResource(1, disposable);
            }
        }
    }

    public n0(ObservableSource<T> observableSource, ObservableSource<U> observableSource2) {
        super(observableSource);
        this.f10697th = observableSource2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        fe feVar = new fe(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        feVar.onSubscribe(arrayCompositeDisposable);
        ad adVar = new ad(feVar, arrayCompositeDisposable);
        this.f10697th.subscribe(new qw(this, arrayCompositeDisposable, adVar, feVar));
        this.f10756ad.subscribe(adVar);
    }
}
