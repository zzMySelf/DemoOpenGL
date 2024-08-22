package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* renamed from: th.de.if.fe.rg.qqq  reason: invalid package */
public final class qqq<T, K> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, K> f10752th;

    /* renamed from: yj  reason: collision with root package name */
    public final Callable<? extends Collection<? super K>> f10753yj;

    /* renamed from: th.de.if.fe.rg.qqq$qw */
    public static final class qw<T, K> extends th.de.p039if.de.qw<T, T> {

        /* renamed from: o  reason: collision with root package name */
        public final Collection<? super K> f10754o;

        /* renamed from: pf  reason: collision with root package name */
        public final Function<? super T, K> f10755pf;

        public qw(Observer<? super T> observer, Function<? super T, K> function, Collection<? super K> collection) {
            super(observer);
            this.f10755pf = function;
            this.f10754o = collection;
        }

        public void clear() {
            this.f10754o.clear();
            super.clear();
        }

        public void onComplete() {
            if (!this.f10478uk) {
                this.f10478uk = true;
                this.f10754o.clear();
                this.f10475ad.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (this.f10478uk) {
                th.de.ppp.qw.ddd(th2);
                return;
            }
            this.f10478uk = true;
            this.f10754o.clear();
            this.f10475ad.onError(th2);
        }

        public void onNext(T t) {
            if (!this.f10478uk) {
                if (this.f10476i == 0) {
                    try {
                        K apply = this.f10755pf.apply(t);
                        th.de.p039if.ad.qw.rg(apply, "The keySelector returned a null key");
                        if (this.f10754o.add(apply)) {
                            this.f10475ad.onNext(t);
                        }
                    } catch (Throwable th2) {
                        de(th2);
                    }
                } else {
                    this.f10475ad.onNext(null);
                }
            }
        }

        public T poll() throws Exception {
            T poll;
            Collection<? super K> collection;
            K apply;
            do {
                poll = this.f10479yj.poll();
                if (poll == null) {
                    break;
                }
                collection = this.f10754o;
                apply = this.f10755pf.apply(poll);
                th.de.p039if.ad.qw.rg(apply, "The keySelector returned a null key");
            } while (!collection.add(apply));
            return poll;
        }

        public int requestFusion(int i2) {
            return fe(i2);
        }
    }

    public qqq(ObservableSource<T> observableSource, Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        super(observableSource);
        this.f10752th = function;
        this.f10753yj = callable;
    }

    public void subscribeActual(Observer<? super T> observer) {
        try {
            Object call = this.f10753yj.call();
            th.de.p039if.ad.qw.rg(call, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f10756ad.subscribe(new qw(observer, this.f10752th, (Collection) call));
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
        }
    }
}
