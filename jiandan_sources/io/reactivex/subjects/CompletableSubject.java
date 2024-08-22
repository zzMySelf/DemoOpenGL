package io.reactivex.subjects;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.qw;

public final class CompletableSubject extends qw implements CompletableObserver {

    /* renamed from: i  reason: collision with root package name */
    public static final CompletableDisposable[] f10339i = new CompletableDisposable[0];

    /* renamed from: uk  reason: collision with root package name */
    public static final CompletableDisposable[] f10340uk = new CompletableDisposable[0];

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<CompletableDisposable[]> f10341ad = new AtomicReference<>(f10340uk);

    /* renamed from: th  reason: collision with root package name */
    public final AtomicBoolean f10342th = new AtomicBoolean();

    /* renamed from: yj  reason: collision with root package name */
    public Throwable f10343yj;

    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        public static final long serialVersionUID = -7650903191002190468L;
        public final CompletableObserver downstream;

        public CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.downstream = completableObserver;
            lazySet(completableSubject);
        }

        public void dispose() {
            CompletableSubject completableSubject = (CompletableSubject) getAndSet((Object) null);
            if (completableSubject != null) {
                completableSubject.th(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public void de(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (!rg(completableDisposable)) {
            Throwable th2 = this.f10343yj;
            if (th2 != null) {
                completableObserver.onError(th2);
            } else {
                completableObserver.onComplete();
            }
        } else if (completableDisposable.isDisposed()) {
            th(completableDisposable);
        }
    }

    public void onComplete() {
        if (this.f10342th.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f10341ad.getAndSet(f10339i)) {
                completableDisposable.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        th.de.p039if.ad.qw.rg(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f10342th.compareAndSet(false, true)) {
            this.f10343yj = th2;
            for (CompletableDisposable completableDisposable : this.f10341ad.getAndSet(f10339i)) {
                completableDisposable.downstream.onError(th2);
            }
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f10341ad.get() == f10339i) {
            disposable.dispose();
        }
    }

    public boolean rg(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f10341ad.get();
            if (completableDisposableArr == f10339i) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!this.f10341ad.compareAndSet(completableDisposableArr, completableDisposableArr2));
        return true;
    }

    public void th(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f10341ad.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (completableDisposableArr[i3] == completableDisposable) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        completableDisposableArr2 = f10340uk;
                    } else {
                        CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[(length - 1)];
                        System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i2);
                        System.arraycopy(completableDisposableArr, i2 + 1, completableDisposableArr3, i2, (length - i2) - 1);
                        completableDisposableArr2 = completableDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f10341ad.compareAndSet(completableDisposableArr, completableDisposableArr2));
    }
}
