package io.reactivex.subjects;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.ad.qw;
import th.de.yj;

public final class SingleSubject<T> extends yj<T> implements SingleObserver<T> {

    /* renamed from: i  reason: collision with root package name */
    public static final SingleDisposable[] f10354i = new SingleDisposable[0];

    /* renamed from: o  reason: collision with root package name */
    public static final SingleDisposable[] f10355o = new SingleDisposable[0];

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<SingleDisposable<T>[]> f10356ad = new AtomicReference<>(f10354i);

    /* renamed from: th  reason: collision with root package name */
    public final AtomicBoolean f10357th = new AtomicBoolean();

    /* renamed from: uk  reason: collision with root package name */
    public Throwable f10358uk;

    /* renamed from: yj  reason: collision with root package name */
    public T f10359yj;

    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        public static final long serialVersionUID = -7650903191002190468L;
        public final SingleObserver<? super T> downstream;

        public SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.downstream = singleObserver;
            lazySet(singleSubject);
        }

        public void dispose() {
            SingleSubject singleSubject = (SingleSubject) getAndSet((Object) null);
            if (singleSubject != null) {
                singleSubject.uk(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public void onError(Throwable th2) {
        qw.rg(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f10357th.compareAndSet(false, true)) {
            this.f10358uk = th2;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f10356ad.getAndSet(f10355o)) {
                singleDisposable.downstream.onError(th2);
            }
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f10356ad.get() == f10355o) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t) {
        qw.rg(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f10357th.compareAndSet(false, true)) {
            this.f10359yj = t;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f10356ad.getAndSet(f10355o)) {
                singleDisposable.downstream.onSuccess(t);
            }
        }
    }

    public void rg(SingleObserver<? super T> singleObserver) {
        SingleDisposable singleDisposable = new SingleDisposable(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (!yj(singleDisposable)) {
            Throwable th2 = this.f10358uk;
            if (th2 != null) {
                singleObserver.onError(th2);
            } else {
                singleObserver.onSuccess(this.f10359yj);
            }
        } else if (singleDisposable.isDisposed()) {
            uk(singleDisposable);
        }
    }

    public void uk(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f10356ad.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (singleDisposableArr[i3] == singleDisposable) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        singleDisposableArr2 = f10354i;
                    } else {
                        SingleDisposable[] singleDisposableArr3 = new SingleDisposable[(length - 1)];
                        System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i2);
                        System.arraycopy(singleDisposableArr, i2 + 1, singleDisposableArr3, i2, (length - i2) - 1);
                        singleDisposableArr2 = singleDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f10356ad.compareAndSet(singleDisposableArr, singleDisposableArr2));
    }

    public boolean yj(SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f10356ad.get();
            if (singleDisposableArr == f10355o) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!this.f10356ad.compareAndSet(singleDisposableArr, singleDisposableArr2));
        return true;
    }
}
