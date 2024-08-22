package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.concurrent.atomic.AtomicInteger;
import th.de.ppp.qw;

public final class SingleZipArray$ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
    public static final long serialVersionUID = -5556924161382950569L;
    public final SingleObserver<? super R> downstream;
    public final SingleZipArray$ZipSingleObserver<T>[] observers;
    public final Object[] values;
    public final Function<? super Object[], ? extends R> zipper;

    public SingleZipArray$ZipCoordinator(SingleObserver<? super R> singleObserver, int i2, Function<? super Object[], ? extends R> function) {
        super(i2);
        this.downstream = singleObserver;
        this.zipper = function;
        SingleZipArray$ZipSingleObserver<T>[] singleZipArray$ZipSingleObserverArr = new SingleZipArray$ZipSingleObserver[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            singleZipArray$ZipSingleObserverArr[i3] = new SingleZipArray$ZipSingleObserver<>(this, i3);
        }
        this.observers = singleZipArray$ZipSingleObserverArr;
        this.values = new Object[i2];
    }

    public void dispose() {
        if (getAndSet(0) > 0) {
            for (SingleZipArray$ZipSingleObserver<T> dispose : this.observers) {
                dispose.dispose();
            }
        }
    }

    public void disposeExcept(int i2) {
        SingleZipArray$ZipSingleObserver<T>[] singleZipArray$ZipSingleObserverArr = this.observers;
        int length = singleZipArray$ZipSingleObserverArr.length;
        for (int i3 = 0; i3 < i2; i3++) {
            singleZipArray$ZipSingleObserverArr[i3].dispose();
        }
        while (true) {
            i2++;
            if (i2 < length) {
                singleZipArray$ZipSingleObserverArr[i2].dispose();
            } else {
                return;
            }
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
