package th.de.p039if.de;

/* renamed from: th.de.if.de.fe  reason: invalid package */
public final class fe<T> extends de<T> {
    public void onError(Throwable th2) {
        if (this.f10465ad == null) {
            this.f10466th = th2;
        }
        countDown();
    }

    public void onNext(T t) {
        if (this.f10465ad == null) {
            this.f10465ad = t;
            this.f10468yj.dispose();
            countDown();
        }
    }
}
