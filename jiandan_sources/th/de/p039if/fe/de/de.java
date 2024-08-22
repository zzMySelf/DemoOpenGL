package th.de.p039if.fe.de;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: th.de.if.fe.de.de  reason: invalid package */
public final class de<R> implements SingleObserver<R> {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<Disposable> f10512ad;

    /* renamed from: th  reason: collision with root package name */
    public final MaybeObserver<? super R> f10513th;

    public de(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
        this.f10512ad = atomicReference;
        this.f10513th = maybeObserver;
    }

    public void onError(Throwable th2) {
        this.f10513th.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f10512ad, disposable);
    }

    public void onSuccess(R r) {
        this.f10513th.onSuccess(r);
    }
}
