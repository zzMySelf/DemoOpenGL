package p041if.rg.qw;

import rx.internal.operators.OnSubscribeAmb$Selection;

/* renamed from: if.rg.qw.de  reason: invalid package */
public final class de<T> extends p041if.de<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final p041if.de<? super T> f11259ad;

    /* renamed from: th  reason: collision with root package name */
    public final OnSubscribeAmb$Selection<T> f11260th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f11261yj;

    public final boolean de() {
        if (this.f11261yj) {
            return true;
        }
        if (this.f11260th.get() == this) {
            this.f11261yj = true;
            return true;
        } else if (this.f11260th.compareAndSet((Object) null, this)) {
            this.f11260th.unsubscribeOthers(this);
            this.f11261yj = true;
            return true;
        } else {
            this.f11260th.unsubscribeLosers();
            return false;
        }
    }

    public void onCompleted() {
        if (de()) {
            this.f11259ad.onCompleted();
        }
    }

    public void onError(Throwable th2) {
        if (de()) {
            this.f11259ad.onError(th2);
        }
    }

    public void onNext(T t) {
        if (de()) {
            this.f11259ad.onNext(t);
        }
    }
}
