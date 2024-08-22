package th.de.p039if.fe.ad;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* renamed from: th.de.if.fe.ad.fe  reason: invalid package */
public final class fe<T> implements Subscription {

    /* renamed from: ad  reason: collision with root package name */
    public final Subscriber<? super T> f10493ad;

    /* renamed from: th  reason: collision with root package name */
    public final T f10494th;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f10495yj;

    public fe(T t, Subscriber<? super T> subscriber) {
        this.f10494th = t;
        this.f10493ad = subscriber;
    }

    public void cancel() {
    }

    public void request(long j) {
        if (j > 0 && !this.f10495yj) {
            this.f10495yj = true;
            Subscriber<? super T> subscriber = this.f10493ad;
            subscriber.onNext(this.f10494th);
            subscriber.onComplete();
        }
    }
}
