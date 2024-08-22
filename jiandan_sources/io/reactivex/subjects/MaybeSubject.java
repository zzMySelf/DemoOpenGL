package io.reactivex.subjects;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import th.de.de;
import th.de.p039if.ad.qw;

public final class MaybeSubject<T> extends de<T> implements MaybeObserver<T> {

    /* renamed from: i  reason: collision with root package name */
    public static final MaybeDisposable[] f10344i = new MaybeDisposable[0];

    /* renamed from: o  reason: collision with root package name */
    public static final MaybeDisposable[] f10345o = new MaybeDisposable[0];

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<MaybeDisposable<T>[]> f10346ad = new AtomicReference<>(f10344i);

    /* renamed from: th  reason: collision with root package name */
    public final AtomicBoolean f10347th = new AtomicBoolean();

    /* renamed from: uk  reason: collision with root package name */
    public Throwable f10348uk;

    /* renamed from: yj  reason: collision with root package name */
    public T f10349yj;

    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        public static final long serialVersionUID = -7650903191002190468L;
        public final MaybeObserver<? super T> downstream;

        public MaybeDisposable(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
            this.downstream = maybeObserver;
            lazySet(maybeSubject);
        }

        public void dispose() {
            MaybeSubject maybeSubject = (MaybeSubject) getAndSet((Object) null);
            if (maybeSubject != null) {
                maybeSubject.th(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public void fe(MaybeObserver<? super T> maybeObserver) {
        MaybeDisposable maybeDisposable = new MaybeDisposable(maybeObserver, this);
        maybeObserver.onSubscribe(maybeDisposable);
        if (!rg(maybeDisposable)) {
            Throwable th2 = this.f10348uk;
            if (th2 != null) {
                maybeObserver.onError(th2);
                return;
            }
            T t = this.f10349yj;
            if (t == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(t);
            }
        } else if (maybeDisposable.isDisposed()) {
            th(maybeDisposable);
        }
    }

    public void onComplete() {
        if (this.f10347th.compareAndSet(false, true)) {
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f10346ad.getAndSet(f10345o)) {
                maybeDisposable.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        qw.rg(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f10347th.compareAndSet(false, true)) {
            this.f10348uk = th2;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f10346ad.getAndSet(f10345o)) {
                maybeDisposable.downstream.onError(th2);
            }
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f10346ad.get() == f10345o) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t) {
        qw.rg(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f10347th.compareAndSet(false, true)) {
            this.f10349yj = t;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f10346ad.getAndSet(f10345o)) {
                maybeDisposable.downstream.onSuccess(t);
            }
        }
    }

    public boolean rg(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f10346ad.get();
            if (maybeDisposableArr == f10345o) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[(length + 1)];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!this.f10346ad.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    public void th(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f10346ad.get();
            int length = maybeDisposableArr.length;
            if (length != 0) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (maybeDisposableArr[i3] == maybeDisposable) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        maybeDisposableArr2 = f10344i;
                    } else {
                        MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[(length - 1)];
                        System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i2);
                        System.arraycopy(maybeDisposableArr, i2 + 1, maybeDisposableArr3, i2, (length - i2) - 1);
                        maybeDisposableArr2 = maybeDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f10346ad.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
    }
}
