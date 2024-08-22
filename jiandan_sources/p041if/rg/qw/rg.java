package p041if.rg.qw;

import java.util.Arrays;
import java.util.Collection;
import p041if.de;
import rx.Observable;
import rx.Observer;
import rx.exceptions.CompositeException;

/* renamed from: if.rg.qw.rg  reason: invalid package */
public class rg<T> implements Observable.OnSubscribe<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Observer<? super T> f11326ad;

    /* renamed from: th  reason: collision with root package name */
    public final Observable<T> f11327th;

    /* renamed from: if.rg.qw.rg$qw */
    public static final class qw<T> extends de<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final de<? super T> f11328ad;

        /* renamed from: th  reason: collision with root package name */
        public final Observer<? super T> f11329th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f11330yj;

        public qw(de<? super T> deVar, Observer<? super T> observer) {
            super(deVar);
            this.f11328ad = deVar;
            this.f11329th = observer;
        }

        public void onCompleted() {
            if (!this.f11330yj) {
                try {
                    this.f11329th.onCompleted();
                    this.f11330yj = true;
                    this.f11328ad.onCompleted();
                } catch (Throwable th2) {
                    p041if.fe.qw.th(th2, this);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f11330yj) {
                p041if.uk.de.i(th2);
                return;
            }
            this.f11330yj = true;
            try {
                this.f11329th.onError(th2);
                this.f11328ad.onError(th2);
            } catch (Throwable th3) {
                p041if.fe.qw.rg(th3);
                this.f11328ad.onError(new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th2, th3})));
            }
        }

        public void onNext(T t) {
            if (!this.f11330yj) {
                try {
                    this.f11329th.onNext(t);
                    this.f11328ad.onNext(t);
                } catch (Throwable th2) {
                    p041if.fe.qw.yj(th2, this, t);
                }
            }
        }
    }

    public rg(Observable<T> observable, Observer<? super T> observer) {
        this.f11327th = observable;
        this.f11326ad = observer;
    }

    /* renamed from: ad */
    public void call(de<? super T> deVar) {
        this.f11327th.aaa(new qw(deVar, this.f11326ad));
    }
}
