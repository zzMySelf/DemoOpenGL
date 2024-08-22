package th.de.p039if.de;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import th.de.p039if.yj.ad;

/* renamed from: th.de.if.de.de  reason: invalid package */
public abstract class de<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* renamed from: ad  reason: collision with root package name */
    public T f10465ad;

    /* renamed from: th  reason: collision with root package name */
    public Throwable f10466th;

    /* renamed from: uk  reason: collision with root package name */
    public volatile boolean f10467uk;

    /* renamed from: yj  reason: collision with root package name */
    public Disposable f10468yj;

    public de() {
        super(1);
    }

    public final void dispose() {
        this.f10467uk = true;
        Disposable disposable = this.f10468yj;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f10467uk;
    }

    public final void onComplete() {
        countDown();
    }

    public final void onSubscribe(Disposable disposable) {
        this.f10468yj = disposable;
        if (this.f10467uk) {
            disposable.dispose();
        }
    }

    public final T qw() {
        if (getCount() != 0) {
            try {
                ad.ad();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.fe(e);
            }
        }
        Throwable th2 = this.f10466th;
        if (th2 == null) {
            return this.f10465ad;
        }
        throw ExceptionHelper.fe(th2);
    }
}
