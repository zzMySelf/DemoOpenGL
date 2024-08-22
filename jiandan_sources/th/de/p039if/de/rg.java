package th.de.p039if.de;

/* renamed from: th.de.if.de.rg  reason: invalid package */
public final class rg<T> extends de<T> {
    public void onError(Throwable th2) {
        this.f10465ad = null;
        this.f10466th = th2;
        countDown();
    }

    public void onNext(T t) {
        this.f10465ad = t;
    }
}
