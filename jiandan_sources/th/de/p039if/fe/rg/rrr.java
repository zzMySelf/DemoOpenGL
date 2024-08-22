package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

/* renamed from: th.de.if.fe.rg.rrr  reason: invalid package */
public final class rrr<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Consumer<? super T> f10767th;

    /* renamed from: th.de.if.fe.rg.rrr$qw */
    public static final class qw<T> extends th.de.p039if.de.qw<T, T> {

        /* renamed from: o  reason: collision with root package name */
        public final Consumer<? super T> f10768o;

        public qw(Observer<? super T> observer, Consumer<? super T> consumer) {
            super(observer);
            this.f10768o = consumer;
        }

        public void onNext(T t) {
            this.f10475ad.onNext(t);
            if (this.f10476i == 0) {
                try {
                    this.f10768o.accept(t);
                } catch (Throwable th2) {
                    de(th2);
                }
            }
        }

        public T poll() throws Exception {
            T poll = this.f10479yj.poll();
            if (poll != null) {
                this.f10768o.accept(poll);
            }
            return poll;
        }

        public int requestFusion(int i2) {
            return fe(i2);
        }
    }

    public rrr(ObservableSource<T> observableSource, Consumer<? super T> consumer) {
        super(observableSource);
        this.f10767th = consumer;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10767th));
    }
}
