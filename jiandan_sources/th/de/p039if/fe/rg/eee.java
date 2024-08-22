package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;

/* renamed from: th.de.if.fe.rg.eee  reason: invalid package */
public final class eee<T, K> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Function<? super T, K> f10595th;

    /* renamed from: yj  reason: collision with root package name */
    public final BiPredicate<? super K, ? super K> f10596yj;

    /* renamed from: th.de.if.fe.rg.eee$qw */
    public static final class qw<T, K> extends th.de.p039if.de.qw<T, T> {

        /* renamed from: if  reason: not valid java name */
        public K f494if;

        /* renamed from: o  reason: collision with root package name */
        public final Function<? super T, K> f10597o;

        /* renamed from: pf  reason: collision with root package name */
        public final BiPredicate<? super K, ? super K> f10598pf;

        /* renamed from: switch  reason: not valid java name */
        public boolean f495switch;

        public qw(Observer<? super T> observer, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.f10597o = function;
            this.f10598pf = biPredicate;
        }

        public void onNext(T t) {
            if (!this.f10478uk) {
                if (this.f10476i != 0) {
                    this.f10475ad.onNext(t);
                    return;
                }
                try {
                    K apply = this.f10597o.apply(t);
                    if (this.f495switch) {
                        boolean qw = this.f10598pf.qw(this.f494if, apply);
                        this.f494if = apply;
                        if (qw) {
                            return;
                        }
                    } else {
                        this.f495switch = true;
                        this.f494if = apply;
                    }
                    this.f10475ad.onNext(t);
                } catch (Throwable th2) {
                    de(th2);
                }
            }
        }

        public T poll() throws Exception {
            while (true) {
                T poll = this.f10479yj.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f10597o.apply(poll);
                if (!this.f495switch) {
                    this.f495switch = true;
                    this.f494if = apply;
                    return poll;
                } else if (!this.f10598pf.qw(this.f494if, apply)) {
                    this.f494if = apply;
                    return poll;
                } else {
                    this.f494if = apply;
                }
            }
        }

        public int requestFusion(int i2) {
            return fe(i2);
        }
    }

    public eee(ObservableSource<T> observableSource, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.f10595th = function;
        this.f10596yj = biPredicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10595th, this.f10596yj));
    }
}
