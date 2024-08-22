package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.tt  reason: invalid package */
public final class tt<T> extends qw<T, T> {

    /* renamed from: i  reason: collision with root package name */
    public final Action f10797i;

    /* renamed from: th  reason: collision with root package name */
    public final Consumer<? super T> f10798th;

    /* renamed from: uk  reason: collision with root package name */
    public final Action f10799uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Consumer<? super Throwable> f10800yj;

    /* renamed from: th.de.if.fe.rg.tt$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10801ad;

        /* renamed from: i  reason: collision with root package name */
        public final Action f10802i;

        /* renamed from: o  reason: collision with root package name */
        public Disposable f10803o;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f10804pf;

        /* renamed from: th  reason: collision with root package name */
        public final Consumer<? super T> f10805th;

        /* renamed from: uk  reason: collision with root package name */
        public final Action f10806uk;

        /* renamed from: yj  reason: collision with root package name */
        public final Consumer<? super Throwable> f10807yj;

        public qw(Observer<? super T> observer, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            this.f10801ad = observer;
            this.f10805th = consumer;
            this.f10807yj = consumer2;
            this.f10806uk = action;
            this.f10802i = action2;
        }

        public void dispose() {
            this.f10803o.dispose();
        }

        public boolean isDisposed() {
            return this.f10803o.isDisposed();
        }

        public void onComplete() {
            if (!this.f10804pf) {
                try {
                    this.f10806uk.run();
                    this.f10804pf = true;
                    this.f10801ad.onComplete();
                    try {
                        this.f10802i.run();
                    } catch (Throwable th2) {
                        th.de.o.qw.ad(th2);
                        th.de.ppp.qw.ddd(th2);
                    }
                } catch (Throwable th3) {
                    th.de.o.qw.ad(th3);
                    onError(th3);
                }
            }
        }

        public void onError(Throwable th2) {
            if (this.f10804pf) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10804pf = true;
            try {
                this.f10807yj.accept(th2);
            } catch (Throwable th3) {
                th.de.o.qw.ad(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f10801ad.onError(th2);
            try {
                this.f10802i.run();
            } catch (Throwable th4) {
                th.de.o.qw.ad(th4);
                th.de.ppp.qw.ddd(th4);
            }
        }

        public void onNext(T t) {
            if (!this.f10804pf) {
                try {
                    this.f10805th.accept(t);
                    this.f10801ad.onNext(t);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10803o.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10803o, disposable)) {
                this.f10803o = disposable;
                this.f10801ad.onSubscribe(this);
            }
        }
    }

    public tt(ObservableSource<T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(observableSource);
        this.f10798th = consumer;
        this.f10800yj = consumer2;
        this.f10799uk = action;
        this.f10797i = action2;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10798th, this.f10800yj, this.f10799uk, this.f10797i));
    }
}
