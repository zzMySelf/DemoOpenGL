package th.de.p039if.fe.ad;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;

/* renamed from: th.de.if.fe.ad.rg  reason: invalid package */
public final class rg<T> extends ad<T> {

    /* renamed from: th  reason: collision with root package name */
    public final th.de.rg<T> f10500th;

    /* renamed from: th.de.if.fe.ad.rg$qw */
    public static final class qw<T> implements Observer<T>, Subscription {

        /* renamed from: ad  reason: collision with root package name */
        public final Subscriber<? super T> f10501ad;

        /* renamed from: th  reason: collision with root package name */
        public Disposable f10502th;

        public qw(Subscriber<? super T> subscriber) {
            this.f10501ad = subscriber;
        }

        public void cancel() {
            this.f10502th.dispose();
        }

        public void onComplete() {
            this.f10501ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10501ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10501ad.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            this.f10502th = disposable;
            this.f10501ad.onSubscribe(this);
        }

        public void request(long j) {
        }
    }

    public rg(th.de.rg<T> rgVar) {
        this.f10500th = rgVar;
    }

    public void yj(Subscriber<? super T> subscriber) {
        this.f10500th.subscribe(new qw(subscriber));
    }
}
