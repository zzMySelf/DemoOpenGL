package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import th.de.th;
import th.de.vvv.ad;

/* renamed from: th.de.if.fe.rg.u0  reason: invalid package */
public final class u0<T> extends qw<T, ad<T>> {

    /* renamed from: th  reason: collision with root package name */
    public final th f10809th;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10810yj;

    /* renamed from: th.de.if.fe.rg.u0$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super ad<T>> f10811ad;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f10812i;

        /* renamed from: th  reason: collision with root package name */
        public final TimeUnit f10813th;

        /* renamed from: uk  reason: collision with root package name */
        public long f10814uk;

        /* renamed from: yj  reason: collision with root package name */
        public final th f10815yj;

        public qw(Observer<? super ad<T>> observer, TimeUnit timeUnit, th thVar) {
            this.f10811ad = observer;
            this.f10815yj = thVar;
            this.f10813th = timeUnit;
        }

        public void dispose() {
            this.f10812i.dispose();
        }

        public boolean isDisposed() {
            return this.f10812i.isDisposed();
        }

        public void onComplete() {
            this.f10811ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10811ad.onError(th2);
        }

        public void onNext(T t) {
            long ad2 = this.f10815yj.ad(this.f10813th);
            long j = this.f10814uk;
            this.f10814uk = ad2;
            this.f10811ad.onNext(new ad(t, ad2 - j, this.f10813th));
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10812i, disposable)) {
                this.f10812i = disposable;
                this.f10814uk = this.f10815yj.ad(this.f10813th);
                this.f10811ad.onSubscribe(this);
            }
        }
    }

    public u0(ObservableSource<T> observableSource, TimeUnit timeUnit, th thVar) {
        super(observableSource);
        this.f10809th = thVar;
        this.f10810yj = timeUnit;
    }

    public void subscribeActual(Observer<? super ad<T>> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10810yj, this.f10809th));
    }
}
