package th.de.p039if.fe.de;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: th.de.if.fe.de.ad  reason: invalid package */
public final class ad<R> implements SingleObserver<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<Disposable> f10510ad;

    /* renamed from: th  reason: collision with root package name */
    public final SingleObserver<? super R> f10511th;

    public ad(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
        this.f10510ad = atomicReference;
        this.f10511th = singleObserver;
    }

    public void onError(Throwable th2) {
        this.f10511th.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f10510ad, disposable);
    }

    public void onSuccess(R r) {
        this.f10511th.onSuccess(r);
    }
}
