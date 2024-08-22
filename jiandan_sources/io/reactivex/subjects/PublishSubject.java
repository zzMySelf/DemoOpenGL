package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.ppp.qw;
import th.de.xxx.ad;

public final class PublishSubject<T> extends ad<T> {

    /* renamed from: uk  reason: collision with root package name */
    public static final PublishDisposable[] f10350uk = new PublishDisposable[0];

    /* renamed from: yj  reason: collision with root package name */
    public static final PublishDisposable[] f10351yj = new PublishDisposable[0];

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<PublishDisposable<T>[]> f10352ad = new AtomicReference<>(f10350uk);

    /* renamed from: th  reason: collision with root package name */
    public Throwable f10353th;

    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        public static final long serialVersionUID = 3562861878281475070L;
        public final Observer<? super T> downstream;
        public final PublishSubject<T> parent;

        public PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.downstream = observer;
            this.parent = publishSubject;
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.th(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get()) {
                qw.ddd(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        public void onNext(T t) {
            if (!get()) {
                this.downstream.onNext(t);
            }
        }
    }

    public static <T> PublishSubject<T> rg() {
        return new PublishSubject<>();
    }

    public boolean fe(PublishDisposable<T> publishDisposable) {
        PublishDisposable[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f10352ad.get();
            if (publishDisposableArr == f10351yj) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[(length + 1)];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!this.f10352ad.compareAndSet(publishDisposableArr, publishDisposableArr2));
        return true;
    }

    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f10352ad.get();
        PublishDisposable<T>[] publishDisposableArr2 = f10351yj;
        if (publishDisposableArr != publishDisposableArr2) {
            for (PublishDisposable onComplete : (PublishDisposable[]) this.f10352ad.getAndSet(publishDisposableArr2)) {
                onComplete.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        th.de.p039if.ad.qw.rg(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f10352ad.get();
        PublishDisposable<T>[] publishDisposableArr2 = f10351yj;
        if (publishDisposableArr == publishDisposableArr2) {
            qw.ddd(th2);
            return;
        }
        this.f10353th = th2;
        for (PublishDisposable onError : (PublishDisposable[]) this.f10352ad.getAndSet(publishDisposableArr2)) {
            onError.onError(th2);
        }
    }

    public void onNext(T t) {
        th.de.p039if.ad.qw.rg(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable onNext : (PublishDisposable[]) this.f10352ad.get()) {
            onNext.onNext(t);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f10352ad.get() == f10351yj) {
            disposable.dispose();
        }
    }

    public void subscribeActual(Observer<? super T> observer) {
        PublishDisposable publishDisposable = new PublishDisposable(observer, this);
        observer.onSubscribe(publishDisposable);
        if (!fe(publishDisposable)) {
            Throwable th2 = this.f10353th;
            if (th2 != null) {
                observer.onError(th2);
            } else {
                observer.onComplete();
            }
        } else if (publishDisposable.isDisposed()) {
            th(publishDisposable);
        }
    }

    public void th(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = (PublishDisposable[]) this.f10352ad.get();
            if (publishDisposableArr != f10351yj && publishDisposableArr != f10350uk) {
                int length = publishDisposableArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (publishDisposableArr[i3] == publishDisposable) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        publishDisposableArr2 = f10350uk;
                    } else {
                        PublishDisposable[] publishDisposableArr3 = new PublishDisposable[(length - 1)];
                        System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i2);
                        System.arraycopy(publishDisposableArr, i2 + 1, publishDisposableArr3, i2, (length - i2) - 1);
                        publishDisposableArr2 = publishDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f10352ad.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }
}
