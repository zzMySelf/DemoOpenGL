package th.de.p039if.fe.rg;

import io.reactivex.Emitter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.q  reason: invalid package */
public final class q<T, S> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Callable<S> f10737ad;

    /* renamed from: th  reason: collision with root package name */
    public final BiFunction<S, Emitter<T>, S> f10738th;

    /* renamed from: yj  reason: collision with root package name */
    public final Consumer<? super S> f10739yj;

    /* renamed from: th.de.if.fe.rg.q$qw */
    public static final class qw<T, S> implements Emitter<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10740ad;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f10741i;

        /* renamed from: o  reason: collision with root package name */
        public boolean f10742o;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f10743pf;

        /* renamed from: th  reason: collision with root package name */
        public final BiFunction<S, ? super Emitter<T>, S> f10744th;

        /* renamed from: uk  reason: collision with root package name */
        public S f10745uk;

        /* renamed from: yj  reason: collision with root package name */
        public final Consumer<? super S> f10746yj;

        public qw(Observer<? super T> observer, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s) {
            this.f10740ad = observer;
            this.f10744th = biFunction;
            this.f10746yj = consumer;
            this.f10745uk = s;
        }

        public void ad() {
            S s = this.f10745uk;
            if (this.f10741i) {
                this.f10745uk = null;
                qw(s);
                return;
            }
            BiFunction<S, ? super Emitter<T>, S> biFunction = this.f10744th;
            while (!this.f10741i) {
                this.f10743pf = false;
                try {
                    s = biFunction.apply(s, this);
                    if (this.f10742o) {
                        this.f10741i = true;
                        this.f10745uk = null;
                        qw(s);
                        return;
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10745uk = null;
                    this.f10741i = true;
                    onError(th2);
                    qw(s);
                    return;
                }
            }
            this.f10745uk = null;
            qw(s);
        }

        public void dispose() {
            this.f10741i = true;
        }

        public boolean isDisposed() {
            return this.f10741i;
        }

        public void onComplete() {
            if (!this.f10742o) {
                this.f10742o = true;
                this.f10740ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10742o) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f10742o = true;
            this.f10740ad.onError(th2);
        }

        public void onNext(T t) {
            if (this.f10742o) {
                return;
            }
            if (this.f10743pf) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f10743pf = true;
                this.f10740ad.onNext(t);
            }
        }

        public final void qw(S s) {
            try {
                this.f10746yj.accept(s);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                th.de.ppp.qw.ddd(th2);
            }
        }
    }

    public q(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.f10737ad = callable;
        this.f10738th = biFunction;
        this.f10739yj = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            qw qwVar = new qw(observer, this.f10738th, this.f10739yj, this.f10737ad.call());
            observer.onSubscribe(qwVar);
            qwVar.ad();
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
