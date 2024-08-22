package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.when.ad;
import th.de.when.fe;

/* renamed from: th.de.if.fe.rg.vvv  reason: invalid package */
public final class vvv<T, U> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<U>> f10830th;

    /* renamed from: th.de.if.fe.rg.vvv$qw */
    public static final class qw<T, U> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10831ad;

        /* renamed from: i  reason: collision with root package name */
        public volatile long f10832i;

        /* renamed from: o  reason: collision with root package name */
        public boolean f10833o;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<U>> f10834th;

        /* renamed from: uk  reason: collision with root package name */
        public final AtomicReference<Disposable> f10835uk = new AtomicReference<>();

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10836yj;

        /* renamed from: th.de.if.fe.rg.vvv$qw$qw  reason: collision with other inner class name */
        public static final class C0339qw<T, U> extends ad<U> {

            /* renamed from: i  reason: collision with root package name */
            public boolean f10837i;

            /* renamed from: o  reason: collision with root package name */
            public final AtomicBoolean f10838o = new AtomicBoolean();

            /* renamed from: th  reason: collision with root package name */
            public final qw<T, U> f10839th;

            /* renamed from: uk  reason: collision with root package name */
            public final T f10840uk;

            /* renamed from: yj  reason: collision with root package name */
            public final long f10841yj;

            public C0339qw(qw<T, U> qwVar, long j, T t) {
                this.f10839th = qwVar;
                this.f10841yj = j;
                this.f10840uk = t;
            }

            public void ad() {
                if (this.f10838o.compareAndSet(false, true)) {
                    this.f10839th.qw(this.f10841yj, this.f10840uk);
                }
            }

            public void onComplete() {
                if (!this.f10837i) {
                    this.f10837i = true;
                    ad();
                }
            }

            public void onError(Throwable th2) {
                if (this.f10837i) {
                    th.de.ppp.qw.ddd(th2);
                    return;
                }
                this.f10837i = true;
                this.f10839th.onError(th2);
            }

            public void onNext(U u) {
                if (!this.f10837i) {
                    this.f10837i = true;
                    dispose();
                    ad();
                }
            }
        }

        public qw(Observer<? super T> observer, Function<? super T, ? extends ObservableSource<U>> function) {
            this.f10831ad = observer;
            this.f10834th = function;
        }

        public void dispose() {
            this.f10836yj.dispose();
            DisposableHelper.dispose(this.f10835uk);
        }

        public boolean isDisposed() {
            return this.f10836yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10833o) {
                this.f10833o = true;
                Disposable disposable = this.f10835uk.get();
                if (disposable != DisposableHelper.DISPOSED) {
                    ((C0339qw) disposable).ad();
                    DisposableHelper.dispose(this.f10835uk);
                    this.f10831ad.onComplete();
                }
            }
        }

        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f10835uk);
            this.f10831ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10833o) {
                long j = this.f10832i + 1;
                this.f10832i = j;
                Disposable disposable = this.f10835uk.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                try {
                    Object apply = this.f10834th.apply(t);
                    th.de.p039if.ad.qw.rg(apply, "The ObservableSource supplied is null");
                    ObservableSource observableSource = (ObservableSource) apply;
                    C0339qw qwVar = new C0339qw(this, j, t);
                    if (this.f10835uk.compareAndSet(disposable, qwVar)) {
                        observableSource.subscribe(qwVar);
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    dispose();
                    this.f10831ad.onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10836yj, disposable)) {
                this.f10836yj = disposable;
                this.f10831ad.onSubscribe(this);
            }
        }

        public void qw(long j, T t) {
            if (j == this.f10832i) {
                this.f10831ad.onNext(t);
            }
        }
    }

    public vvv(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<U>> function) {
        super(observableSource);
        this.f10830th = function;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(new fe(observer), this.f10830th));
    }
}
