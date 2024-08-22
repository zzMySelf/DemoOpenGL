package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import th.de.th;
import th.de.when.fe;

/* renamed from: th.de.if.fe.rg.ddd  reason: invalid package */
public final class ddd<T> extends qw<T, T> {

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10567i;

    /* renamed from: th  reason: collision with root package name */
    public final long f10568th;

    /* renamed from: uk  reason: collision with root package name */
    public final th f10569uk;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10570yj;

    /* renamed from: th.de.if.fe.rg.ddd$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10571ad;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f10572i;

        /* renamed from: o  reason: collision with root package name */
        public Disposable f10573o;

        /* renamed from: th  reason: collision with root package name */
        public final long f10574th;

        /* renamed from: uk  reason: collision with root package name */
        public final th.de f10575uk;

        /* renamed from: yj  reason: collision with root package name */
        public final TimeUnit f10576yj;

        /* renamed from: th.de.if.fe.rg.ddd$qw$ad */
        public final class ad implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final Throwable f10577ad;

            public ad(Throwable th2) {
                this.f10577ad = th2;
            }

            public void run() {
                try {
                    qw.this.f10571ad.onError(this.f10577ad);
                } finally {
                    qw.this.f10575uk.dispose();
                }
            }
        }

        /* renamed from: th.de.if.fe.rg.ddd$qw$de */
        public final class de implements Runnable {

            /* renamed from: ad  reason: collision with root package name */
            public final T f10579ad;

            public de(T t) {
                this.f10579ad = t;
            }

            public void run() {
                qw.this.f10571ad.onNext(this.f10579ad);
            }
        }

        /* renamed from: th.de.if.fe.rg.ddd$qw$qw  reason: collision with other inner class name */
        public final class C0336qw implements Runnable {
            public C0336qw() {
            }

            public void run() {
                try {
                    qw.this.f10571ad.onComplete();
                } finally {
                    qw.this.f10575uk.dispose();
                }
            }
        }

        public qw(Observer<? super T> observer, long j, TimeUnit timeUnit, th.de deVar, boolean z) {
            this.f10571ad = observer;
            this.f10574th = j;
            this.f10576yj = timeUnit;
            this.f10575uk = deVar;
            this.f10572i = z;
        }

        public void dispose() {
            this.f10573o.dispose();
            this.f10575uk.dispose();
        }

        public boolean isDisposed() {
            return this.f10575uk.isDisposed();
        }

        public void onComplete() {
            this.f10575uk.de(new C0336qw(), this.f10574th, this.f10576yj);
        }

        public void onError(Throwable th2) {
            this.f10575uk.de(new ad(th2), this.f10572i ? this.f10574th : 0, this.f10576yj);
        }

        public void onNext(T t) {
            this.f10575uk.de(new de(t), this.f10574th, this.f10576yj);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10573o, disposable)) {
                this.f10573o = disposable;
                this.f10571ad.onSubscribe(this);
            }
        }
    }

    public ddd(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, th thVar, boolean z) {
        super(observableSource);
        this.f10568th = j;
        this.f10570yj = timeUnit;
        this.f10569uk = thVar;
        this.f10567i = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        fe feVar;
        if (this.f10567i) {
            feVar = observer;
        } else {
            feVar = new fe(observer);
        }
        this.f10756ad.subscribe(new qw(feVar, this.f10568th, this.f10570yj, this.f10569uk.qw(), this.f10567i));
    }
}
