package th.de.p039if.de;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: th.de.if.de.switch  reason: invalid class name and invalid package */
public final class Cswitch<T> implements SingleObserver<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<Disposable> f10480ad;

    /* renamed from: th  reason: collision with root package name */
    public final SingleObserver<? super T> f10481th;

    public Cswitch(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.f10480ad = atomicReference;
        this.f10481th = singleObserver;
    }

    public void onError(Throwable th2) {
        this.f10481th.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f10480ad, disposable);
    }

    public void onSuccess(T t) {
        this.f10481th.onSuccess(t);
    }
}
