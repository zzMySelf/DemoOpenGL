package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.ppp.qw;

public final class MaybeZipArray$ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
    public static final long serialVersionUID = -5556924161382950569L;
    public final MaybeObserver<? super R> downstream;
    public final MaybeZipArray$ZipMaybeObserver<T>[] observers;
    public final Object[] values;
    public final Function<? super Object[], ? extends R> zipper;

    public MaybeZipArray$ZipCoordinator(MaybeObserver<? super R> maybeObserver, int i2, Function<? super Object[], ? extends R> function) {
        super(i2);
        this.downstream = maybeObserver;
        this.zipper = function;
        MaybeZipArray$ZipMaybeObserver<T>[] maybeZipArray$ZipMaybeObserverArr = new MaybeZipArray$ZipMaybeObserver[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            maybeZipArray$ZipMaybeObserverArr[i3] = new MaybeZipArray$ZipMaybeObserver<>(this, i3);
        }
        this.observers = maybeZipArray$ZipMaybeObserverArr;
        this.values = new Object[i2];
    }

    public void dispose() {
        if (getAndSet(0) > 0) {
            for (MaybeZipArray$ZipMaybeObserver<T> dispose : this.observers) {
                dispose.dispose();
            }
        }
    }

    public void disposeExcept(int i2) {
        MaybeZipArray$ZipMaybeObserver<T>[] maybeZipArray$ZipMaybeObserverArr = this.observers;
        int length = maybeZipArray$ZipMaybeObserverArr.length;
        for (int i3 = 0; i3 < i2; i3++) {
            maybeZipArray$ZipMaybeObserverArr[i3].dispose();
        }
        while (true) {
            i2++;
            if (i2 < length) {
                maybeZipArray$ZipMaybeObserverArr[i2].dispose();
            } else {
                return;
            }
        }
    }

    public void innerComplete(int i2) {
        if (getAndSet(0) > 0) {
            disposeExcept(i2);
            this.downstream.onComplete();
        }
    }

    public void innerError(Throwable th2, int i2) {
        if (getAndSet(0) > 0) {
            disposeExcept(i2);
            this.downstream.onError(th2);
            return;
        }
        qw.ddd(th2);
    }

    public void innerSuccess(T t, int i2) {
        this.values[i2] = t;
        if (decrementAndGet() == 0) {
            try {
                Object apply = this.zipper.apply(this.values);
                th.de.p039if.ad.qw.rg(apply, "The zipper returned a null value");
                this.downstream.onSuccess(apply);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public boolean isDisposed() {
        return get() <= 0;
    }
}
