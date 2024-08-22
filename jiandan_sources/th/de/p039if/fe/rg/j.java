package th.de.p039if.fe.rg;

import io.reactivex.Observer;
import th.de.p039if.de.ad;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.j  reason: invalid package */
public final class j<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final T[] f10656ad;

    /* renamed from: th.de.if.fe.rg.j$qw */
    public static final class qw<T> extends ad<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10657ad;

        /* renamed from: i  reason: collision with root package name */
        public volatile boolean f10658i;

        /* renamed from: th  reason: collision with root package name */
        public final T[] f10659th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10660uk;

        /* renamed from: yj  reason: collision with root package name */
        public int f10661yj;

        public qw(Observer<? super T> observer, T[] tArr) {
            this.f10657ad = observer;
            this.f10659th = tArr;
        }

        public void clear() {
            this.f10661yj = this.f10659th.length;
        }

        public void dispose() {
            this.f10658i = true;
        }

        public boolean isDisposed() {
            return this.f10658i;
        }

        public boolean isEmpty() {
            return this.f10661yj == this.f10659th.length;
        }

        public T poll() {
            int i2 = this.f10661yj;
            T[] tArr = this.f10659th;
            if (i2 == tArr.length) {
                return null;
            }
            this.f10661yj = i2 + 1;
            T t = tArr[i2];
            th.de.p039if.ad.qw.rg(t, "The array element is null");
            return t;
        }

        public void qw() {
            T[] tArr = this.f10659th;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !isDisposed(); i2++) {
                T t = tArr[i2];
                if (t == null) {
                    Observer<? super T> observer = this.f10657ad;
                    observer.onError(new NullPointerException("The " + i2 + "th element is null"));
                    return;
                }
                this.f10657ad.onNext(t);
            }
            if (!isDisposed()) {
                this.f10657ad.onComplete();
            }
        }

        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f10660uk = true;
            return 1;
        }
    }

    public j(T[] tArr) {
        this.f10656ad = tArr;
    }

    public void subscribeActual(Observer<? super T> observer) {
        qw qwVar = new qw(observer, this.f10656ad);
        observer.onSubscribe(qwVar);
        if (!qwVar.f10660uk) {
            qwVar.qw();
        }
    }
}
