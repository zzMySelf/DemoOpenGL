package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;

/* renamed from: th.de.if.fe.rg.y  reason: invalid package */
public final class y<T, U> extends qw<T, U> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, ? extends U> f10872th;

    /* renamed from: th.de.if.fe.rg.y$qw */
    public static final class qw<T, U> extends th.de.p039if.de.qw<T, U> {

        /* renamed from: o  reason: collision with root package name */
        public final Function<? super T, ? extends U> f10873o;

        public qw(Observer<? super U> observer, Function<? super T, ? extends U> function) {
            super(observer);
            this.f10873o = function;
        }

        public void onNext(T t) {
            if (!this.f10478uk) {
                if (this.f10476i != 0) {
                    this.f10475ad.onNext(null);
                    return;
                }
                try {
                    Object apply = this.f10873o.apply(t);
                    th.de.p039if.ad.qw.rg(apply, "The mapper function returned a null value.");
                    this.f10475ad.onNext(apply);
                } catch (Throwable th2) {
                    de(th2);
                }
            }
        }

        public U poll() throws Exception {
            T poll = this.f10479yj.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f10873o.apply(poll);
            th.de.p039if.ad.qw.rg(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int requestFusion(int i2) {
            return fe(i2);
        }
    }

    public y(ObservableSource<T> observableSource, Function<? super T, ? extends U> function) {
        super(observableSource);
        this.f10872th = function;
    }

    public void subscribeActual(Observer<? super U> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10872th));
    }
}
