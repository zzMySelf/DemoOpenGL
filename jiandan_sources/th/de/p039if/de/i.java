package th.de.p039if.de;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import th.de.p039if.yj.uk;

/* renamed from: th.de.if.de.i  reason: invalid package */
public abstract class i<T, U, V> extends pf implements Observer<T>, ObservableQueueDrain<U, V> {

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f10469i;

    /* renamed from: o  reason: collision with root package name */
    public Throwable f10470o;

    /* renamed from: th  reason: collision with root package name */
    public final Observer<? super V> f10471th;

    /* renamed from: uk  reason: collision with root package name */
    public volatile boolean f10472uk;

    /* renamed from: yj  reason: collision with root package name */
    public final SimplePlainQueue<U> f10473yj;

    public i(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.f10471th = observer;
        this.f10473yj = simplePlainQueue;
    }

    public final Throwable ad() {
        return this.f10470o;
    }

    public final int de(int i2) {
        return this.f10474ad.addAndGet(i2);
    }

    public final boolean fe() {
        return this.f10469i;
    }

    public final void i(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.f10471th;
        SimplePlainQueue<U> simplePlainQueue = this.f10473yj;
        if (this.f10474ad.get() != 0 || !this.f10474ad.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u);
            if (!th()) {
                return;
            }
        } else if (simplePlainQueue.isEmpty()) {
            qw(observer, u);
            if (de(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
        }
        uk.de(simplePlainQueue, observer, z, disposable, this);
    }

    public void qw(Observer<? super V> observer, U u) {
    }

    public final boolean rg() {
        return this.f10472uk;
    }

    public final boolean th() {
        return this.f10474ad.getAndIncrement() == 0;
    }

    public final void uk(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.f10471th;
        SimplePlainQueue<U> simplePlainQueue = this.f10473yj;
        if (this.f10474ad.get() != 0 || !this.f10474ad.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u);
            if (!th()) {
                return;
            }
        } else {
            qw(observer, u);
            if (de(-1) == 0) {
                return;
            }
        }
        uk.de(simplePlainQueue, observer, z, disposable, this);
    }

    public final boolean yj() {
        return this.f10474ad.get() == 0 && this.f10474ad.compareAndSet(0, 1);
    }
}
