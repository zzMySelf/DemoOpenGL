package th.de.p039if.fe.rg;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.n  reason: invalid package */
public final class n<T> extends rg<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final Publisher<? extends T> f10694ad;

    /* renamed from: th.de.if.fe.rg.n$qw */
    public static final class qw<T> implements FlowableSubscriber<T>, Disposable {

        /* renamed from: ad  reason: collision with root package name */
        public final Observer<? super T> f10695ad;

        /* renamed from: th  reason: collision with root package name */
        public Subscription f10696th;

        public qw(Observer<? super T> observer) {
            this.f10695ad = observer;
        }

        public void dispose() {
            this.f10696th.cancel();
            this.f10696th = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.f10696th == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            this.f10695ad.onComplete();
        }

        public void onError(Throwable th2) {
            this.f10695ad.onError(th2);
        }

        public void onNext(T t) {
            this.f10695ad.onNext(t);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.f10696th, subscription)) {
                this.f10696th = subscription;
                this.f10695ad.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }
    }

    public n(Publisher<? extends T> publisher) {
        this.f10694ad = publisher;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.f10694ad.subscribe(new qw(observer));
    }
}
