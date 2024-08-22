package th.de.p039if.de;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.yj.ad;
import th.de.ppp.qw;

/* renamed from: th.de.if.de.uk  reason: invalid package */
public final class uk<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {

    /* renamed from: ad  reason: collision with root package name */
    public T f10486ad;

    /* renamed from: th  reason: collision with root package name */
    public Throwable f10487th;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicReference<Disposable> f10488yj = new AtomicReference<>();

    public uk() {
        super(1);
    }

    public boolean cancel(boolean z) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = this.f10488yj.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!this.f10488yj.compareAndSet(disposable, disposableHelper));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    public void dispose() {
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            ad.ad();
            await();
        }
        if (!isCancelled()) {
            Throwable th2 = this.f10487th;
            if (th2 == null) {
                return this.f10486ad;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }

    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f10488yj.get());
    }

    public boolean isDisposed() {
        return isDone();
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public void onComplete() {
        Disposable disposable;
        if (this.f10486ad == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            disposable = this.f10488yj.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!this.f10488yj.compareAndSet(disposable, this));
        countDown();
    }

    public void onError(Throwable th2) {
        Disposable disposable;
        if (this.f10487th == null) {
            this.f10487th = th2;
            do {
                disposable = this.f10488yj.get();
                if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                    qw.ddd(th2);
                    return;
                }
            } while (!this.f10488yj.compareAndSet(disposable, this));
            countDown();
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        if (this.f10486ad != null) {
            this.f10488yj.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f10486ad = t;
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce(this.f10488yj, disposable);
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            ad.ad();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.de(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f10487th;
            if (th2 == null) {
                return this.f10486ad;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
