package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: th.de.if.fe.rg.rg  reason: invalid package */
public final class rg<T> extends qw<T, Boolean> {

    /* renamed from: th  reason: collision with root package name */
    public final Predicate<? super T> f10762th;

    /* renamed from: th.de.if.fe.rg.rg$qw */
    public static final class qw<T> implements Observer<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super Boolean> f10763ad;

        /* renamed from: th  reason: collision with root package name */
        public final Predicate<? super T> f10764th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10765uk;

        /* renamed from: yj  reason: collision with root package name */
        public Disposable f10766yj;

        public qw(Observer<? super Boolean> observer, Predicate<? super T> predicate) {
            this.f10763ad = observer;
            this.f10764th = predicate;
        }

        public void dispose() {
            this.f10766yj.dispose();
        }

        public boolean isDisposed() {
            return this.f10766yj.isDisposed();
        }

        public void onComplete() {
            if (!this.f10765uk) {
                this.f10765uk = true;
                this.f10763ad.onNext(Boolean.TRUE);
                this.f10763ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10765uk) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10765uk = true;
            this.f10763ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10765uk) {
                try {
                    if (!this.f10764th.test(t)) {
                        this.f10765uk = true;
                        this.f10766yj.dispose();
                        this.f10763ad.onNext(Boolean.FALSE);
                        this.f10763ad.onComplete();
                    }
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    this.f10766yj.dispose();
                    onError(th2);
                }
            }
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f10766yj, disposable)) {
                this.f10766yj = disposable;
                this.f10763ad.onSubscribe(this);
            }
        }
    }

    public rg(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f10762th = predicate;
    }

    public void subscribeActual(Observer<? super Boolean> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10762th));
    }
}
