package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* renamed from: th.de.if.fe.rg.b  reason: invalid package */
public final class b<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final long f10528th;

    /* renamed from: uk  reason: collision with root package name */
    public final boolean f10529uk;

    /* renamed from: yj  reason: collision with root package name */
    public final T f10530yj;

    /* renamed from: th.de.if.fe.rg.b$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10531ad;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f10532i;

        /* renamed from: o  reason: collision with root package name */
        public long f10533o;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f10534pf;

        /* renamed from: th  reason: collision with root package name */
        public final long f10535th;

        /* renamed from: uk  reason: collision with root package name */
        public final boolean f10536uk;

        /* renamed from: yj  reason: collision with root package name */
        public final T f10537yj;

        public qw(Observer<? super T> observer, long j, T t, boolean z) {
            this.f10531ad = observer;
            this.f10535th = j;
            this.f10537yj = t;
            this.f10536uk = z;
        }

        public void dispose() {
            this.f10532i.dispose();
        }

        public boolean isDisposed() {
            return this.f10532i.isDisposed();
        }

        public void onComplete() {
            if (!this.f10534pf) {
                this.f10534pf = true;
                T t = this.f10537yj;
                if (t != null || !this.f10536uk) {
                    if (t != null) {
                        this.f10531ad.onNext(t);
                    }
                    this.f10531ad.onComplete();
                    return;
                }
                this.f10531ad.onError(new NoSuchElementException());
            }
        }

        public void onError(Throwable th2) {
            if (this.f10534pf) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10534pf = true;
            this.f10531ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10534pf) {
                long j = this.f10533o;
                if (j == this.f10535th) {
                    this.f10534pf = true;
                    this.f10532i.dispose();
                    this.f10531ad.onNext(t);
                    this.f10531ad.onComplete();
                    return;
                }
                this.f10533o = j + 1;
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10532i, disposable)) {
                this.f10532i = disposable;
                this.f10531ad.onSubscribe(this);
            }
        }
    }

    public b(ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.f10528th = j;
        this.f10530yj = t;
        this.f10529uk = z;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10528th, this.f10530yj, this.f10529uk));
    }
}
