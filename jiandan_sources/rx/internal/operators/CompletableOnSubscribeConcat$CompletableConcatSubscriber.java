package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import p041if.de;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.internal.subscriptions.SequentialSubscription;

public final class CompletableOnSubscribeConcat$CompletableConcatSubscriber extends de<Completable> {

    /* renamed from: ad  reason: collision with root package name */
    public final SequentialSubscription f11380ad;

    public final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
        public static final long serialVersionUID = 7233503139645205620L;

        public ConcatInnerSubscriber() {
        }

        public void onCompleted() {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.de();
        }

        public void onError(Throwable th2) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.fe(th2);
        }

        public void onSubscribe(Subscription subscription) {
            CompletableOnSubscribeConcat$CompletableConcatSubscriber.this.f11380ad.set(subscription);
        }
    }

    public abstract void de();

    public abstract void fe(Throwable th2);
}
