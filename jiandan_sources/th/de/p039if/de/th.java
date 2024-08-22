package th.de.p039if.de;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import th.de.p039if.yj.ad;

/* renamed from: th.de.if.de.th  reason: invalid package */
public final class th<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {

    /* renamed from: ad  reason: collision with root package name */
    public T f10482ad;

    /* renamed from: th  reason: collision with root package name */
    public Throwable f10483th;

    /* renamed from: uk  reason: collision with root package name */
    public volatile boolean f10484uk;

    /* renamed from: yj  reason: collision with root package name */
    public Disposable f10485yj;

    public th() {
        super(1);
    }

    public void ad() {
        this.f10484uk = true;
        Disposable disposable = this.f10485yj;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void onComplete() {
        countDown();
    }

    public void onError(Throwable th2) {
        this.f10483th = th2;
        countDown();
    }

    public void onSubscribe(Disposable disposable) {
        this.f10485yj = disposable;
        if (this.f10484uk) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t) {
        this.f10482ad = t;
        countDown();
    }

    public T qw() {
        if (getCount() != 0) {
            try {
                ad.ad();
                await();
            } catch (InterruptedException e) {
                ad();
                throw ExceptionHelper.fe(e);
            }
        }
        Throwable th2 = this.f10483th;
        if (th2 == null) {
            return this.f10482ad;
        }
        throw ExceptionHelper.fe(th2);
    }
}
