package p041if.rg.qw;

import p041if.de;
import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;

/* renamed from: if.rg.qw.fe  reason: invalid package */
public final class fe<T, R> extends de<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f11262ad;

    /* renamed from: th  reason: collision with root package name */
    public final int f11263th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f11264yj;

    public fe(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i2) {
        this.f11262ad = onSubscribeCombineLatest$LatestCoordinator;
        this.f11263th = i2;
        request((long) onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void de(long j) {
        request(j);
    }

    public void onCompleted() {
        if (!this.f11264yj) {
            this.f11264yj = true;
            this.f11262ad.combine((Object) null, this.f11263th);
        }
    }

    public void onError(Throwable th2) {
        if (this.f11264yj) {
            p041if.uk.de.i(th2);
            return;
        }
        this.f11262ad.onError(th2);
        this.f11264yj = true;
        this.f11262ad.combine((Object) null, this.f11263th);
    }

    public void onNext(T t) {
        if (!this.f11264yj) {
            this.f11262ad.combine(NotificationLite.uk(t), this.f11263th);
        }
    }
}
