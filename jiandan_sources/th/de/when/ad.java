package th.de.when;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.yj.fe;

public abstract class ad<T> implements Observer<T>, Disposable {

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<Disposable> f11034ad = new AtomicReference<>();

    public final void dispose() {
        DisposableHelper.dispose(this.f11034ad);
    }

    public final boolean isDisposed() {
        return this.f11034ad.get() == DisposableHelper.DISPOSED;
    }

    public final void onSubscribe(Disposable disposable) {
        if (fe.de(this.f11034ad, disposable, getClass())) {
            qw();
        }
    }

    public void qw() {
    }
}
