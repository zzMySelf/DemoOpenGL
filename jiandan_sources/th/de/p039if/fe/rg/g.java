package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;

/* renamed from: th.de.if.fe.rg.g  reason: invalid package */
public final class g<T> extends qw<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final Predicate<? super T> f10617th;

    /* renamed from: th.de.if.fe.rg.g$qw */
    public static final class qw<T> extends th.de.p039if.de.qw<T, T> {

        /* renamed from: o  reason: collision with root package name */
        public final Predicate<? super T> f10618o;

        public qw(Observer<? super T> observer, Predicate<? super T> predicate) {
            super(observer);
            this.f10618o = predicate;
        }

        public void onNext(T t) {
            if (this.f10476i == 0) {
                try {
                    if (this.f10618o.test(t)) {
                        this.f10475ad.onNext(t);
                    }
                } catch (Throwable th2) {
                    de(th2);
                }
            } else {
                this.f10475ad.onNext(null);
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public T poll() throws java.lang.Exception {
            /*
                r2 = this;
            L_0x0000:
                io.reactivex.internal.fuseable.QueueDisposable<T> r0 = r2.f10479yj
                java.lang.Object r0 = r0.poll()
                if (r0 == 0) goto L_0x0010
                io.reactivex.functions.Predicate<? super T> r1 = r2.f10618o
                boolean r1 = r1.test(r0)
                if (r1 == 0) goto L_0x0000
            L_0x0010:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: th.de.p039if.fe.rg.g.qw.poll():java.lang.Object");
        }

        public int requestFusion(int i2) {
            return fe(i2);
        }
    }

    public g(ObservableSource<T> observableSource, Predicate<? super T> predicate) {
        super(observableSource);
        this.f10617th = predicate;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10756ad.subscribe(new qw(observer, this.f10617th));
    }
}
