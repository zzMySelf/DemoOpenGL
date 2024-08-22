package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;
import th.de.when.fe;

public final class ObservableDebounceTimed<T> extends th.de.p039if.fe.rg.qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final long f10080th;

    /* renamed from: uk  reason: collision with root package name */
    public final th f10081uk;

    /* renamed from: yj  reason: collision with root package name */
    public final TimeUnit f10082yj;

    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        public static final long serialVersionUID = 6812032969491025141L;
        public final long idx;
        public final AtomicBoolean once = new AtomicBoolean();
        public final qw<T> parent;
        public final T value;

        public DebounceEmitter(T t, long j, qw<T> qwVar) {
            this.value = t;
            this.idx = j;
            this.parent = qwVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.qw(this.idx, this.value, this);
            }
        }

        public void setResource(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10083ad;

        /* renamed from: i  reason: collision with root package name */
        public Disposable f10084i;

        /* renamed from: if  reason: not valid java name */
        public boolean f482if;

        /* renamed from: o  reason: collision with root package name */
        public Disposable f10085o;

        /* renamed from: pf  reason: collision with root package name */
        public volatile long f10086pf;

        /* renamed from: th  reason: collision with root package name */
        public final long f10087th;

        /* renamed from: uk  reason: collision with root package name */
        public final th.de f10088uk;

        /* renamed from: yj  reason: collision with root package name */
        public final TimeUnit f10089yj;

        public qw(Observer<? super T> observer, long j, TimeUnit timeUnit, th.de deVar) {
            this.f10083ad = observer;
            this.f10087th = j;
            this.f10089yj = timeUnit;
            this.f10088uk = deVar;
        }

        public void dispose() {
            this.f10084i.dispose();
            this.f10088uk.dispose();
        }

        public boolean isDisposed() {
            return this.f10088uk.isDisposed();
        }

        public void onComplete() {
            if (!this.f482if) {
                this.f482if = true;
                Disposable disposable = this.f10085o;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.run();
                }
                this.f10083ad.onComplete();
                this.f10088uk.dispose();
            }
        }

        public void onError(Throwable th2) {
            if (this.f482if) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            Disposable disposable = this.f10085o;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f482if = true;
            this.f10083ad.onError(th2);
            this.f10088uk.dispose();
        }

        public void onNext(T t) {
            if (!this.f482if) {
                long j = this.f10086pf + 1;
                this.f10086pf = j;
                Disposable disposable = this.f10085o;
                if (disposable != null) {
                    disposable.dispose();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
                this.f10085o = debounceEmitter;
                debounceEmitter.setResource(this.f10088uk.de(debounceEmitter, this.f10087th, this.f10089yj));
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10084i, disposable)) {
                this.f10084i = disposable;
                this.f10083ad.onSubscribe(this);
            }
        }

        public void qw(long j, T t, DebounceEmitter<T> debounceEmitter) {
            if (j == this.f10086pf) {
                this.f10083ad.onNext(t);
                debounceEmitter.dispose();
            }
        }
    }

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, th thVar) {
        super(observableSource);
        this.f10080th = j;
        this.f10082yj = timeUnit;
        this.f10081uk = thVar;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(new fe(observer), this.f10080th, this.f10082yj, this.f10081uk.qw()));
    }
}
