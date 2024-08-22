package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.qw;
import th.de.rg;

public final class ObservableSwitchMapCompletable<T> extends qw {

    /* renamed from: ad  reason: collision with root package name */
    public final rg<T> f10022ad;

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends CompletableSource> f10023th;

    /* renamed from: yj  reason: collision with root package name */
    public final boolean f10024yj;

    public static final class SwitchMapCompletableObserver<T> implements Observer<T>, Disposable {

        /* renamed from: if  reason: not valid java name */
        public static final SwitchMapInnerObserver f479if = new SwitchMapInnerObserver((SwitchMapCompletableObserver<?>) null);

        /* renamed from: ad  reason: collision with root package name */
        public final CompletableObserver f10025ad;

        /* renamed from: i  reason: collision with root package name */
        public final AtomicReference<SwitchMapInnerObserver> f10026i = new AtomicReference<>();

        /* renamed from: o  reason: collision with root package name */
        public volatile boolean f10027o;

        /* renamed from: pf  reason: collision with root package name */
        public Disposable f10028pf;

        /* renamed from: th  reason: collision with root package name */
        public final Function<? super T, ? extends CompletableSource> f10029th;

        /* renamed from: uk  reason: collision with root package name */
        public final AtomicThrowable f10030uk = new AtomicThrowable();

        /* renamed from: yj  reason: collision with root package name */
        public final boolean f10031yj;

        public static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            public static final long serialVersionUID = -8003404460084760287L;
            public final SwitchMapCompletableObserver<?> parent;

            public SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.parent = switchMapCompletableObserver;
            }

            public void dispose() {
                DisposableHelper.dispose(this);
            }

            public void onComplete() {
                this.parent.ad(this);
            }

            public void onError(Throwable th2) {
                this.parent.de(this, th2);
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.f10025ad = completableObserver;
            this.f10029th = function;
            this.f10031yj = z;
        }

        public void ad(SwitchMapInnerObserver switchMapInnerObserver) {
            if (this.f10026i.compareAndSet(switchMapInnerObserver, (Object) null) && this.f10027o) {
                Throwable terminate = this.f10030uk.terminate();
                if (terminate == null) {
                    this.f10025ad.onComplete();
                } else {
                    this.f10025ad.onError(terminate);
                }
            }
        }

        public void de(SwitchMapInnerObserver switchMapInnerObserver, Throwable th2) {
            if (!this.f10026i.compareAndSet(switchMapInnerObserver, (Object) null) || !this.f10030uk.addThrowable(th2)) {
                th.de.ppp.qw.ddd(th2);
            } else if (!this.f10031yj) {
                dispose();
                Throwable terminate = this.f10030uk.terminate();
                if (terminate != ExceptionHelper.qw) {
                    this.f10025ad.onError(terminate);
                }
            } else if (this.f10027o) {
                this.f10025ad.onError(this.f10030uk.terminate());
            }
        }

        public void dispose() {
            this.f10028pf.dispose();
            qw();
        }

        public boolean isDisposed() {
            return this.f10026i.get() == f479if;
        }

        public void onComplete() {
            this.f10027o = true;
            if (this.f10026i.get() == null) {
                Throwable terminate = this.f10030uk.terminate();
                if (terminate == null) {
                    this.f10025ad.onComplete();
                } else {
                    this.f10025ad.onError(terminate);
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.f10030uk.addThrowable(th2)) {
                th.de.ppp.qw.ddd(th2);
            } else if (this.f10031yj) {
                onComplete();
            } else {
                qw();
                Throwable terminate = this.f10030uk.terminate();
                if (terminate != ExceptionHelper.qw) {
                    this.f10025ad.onError(terminate);
                }
            }
        }

        public void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                Object apply = this.f10029th.apply(t);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.f10026i.get();
                    if (switchMapInnerObserver == f479if) {
                        return;
                    }
                } while (!this.f10026i.compareAndSet(switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.dispose();
                }
                completableSource.qw(switchMapInnerObserver2);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.f10028pf.dispose();
                onError(th2);
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10028pf, disposable)) {
                this.f10028pf = disposable;
                this.f10025ad.onSubscribe(this);
            }
        }

        public void qw() {
            SwitchMapInnerObserver andSet = this.f10026i.getAndSet(f479if);
            if (andSet != null && andSet != f479if) {
                andSet.dispose();
            }
        }
    }

    public ObservableSwitchMapCompletable(rg<T> rgVar, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.f10022ad = rgVar;
        this.f10023th = function;
        this.f10024yj = z;
    }

    public void de(CompletableObserver completableObserver) {
        if (!th.de.p039if.fe.fe.qw.qw(this.f10022ad, this.f10023th, completableObserver)) {
            this.f10022ad.subscribe(new SwitchMapCompletableObserver(completableObserver, this.f10023th, this.f10024yj));
        }
    }
}
