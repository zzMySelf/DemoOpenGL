package th.de.p039if.fe.qw;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: th.de.if.fe.qw.qw  reason: invalid package */
public final class qw implements CompletableObserver {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<Disposable> f10516ad;

    /* renamed from: th  reason: collision with root package name */
    public final CompletableObserver f10517th;

    public qw(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
        this.f10516ad = atomicReference;
        this.f10517th = completableObserver;
    }

    public void onComplete() {
        this.f10517th.onComplete();
    }

    public void onError(Throwable th2) {
        this.f10517th.onError(th2);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.f10516ad, disposable);
    }
}
