package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p041if.pf.de;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;

public final class CompletableOnSubscribeConcatIterable$ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
    public static final long serialVersionUID = -7965400327305809232L;
    public final CompletableSubscriber actual;
    public final de sd = new de();
    public final Iterator<? extends Completable> sources;

    public CompletableOnSubscribeConcatIterable$ConcatInnerSubscriber(CompletableSubscriber completableSubscriber, Iterator<? extends Completable> it) {
        this.actual = completableSubscriber;
        this.sources = it;
    }

    public void next() {
        if (!this.sd.isUnsubscribed() && getAndIncrement() == 0) {
            Iterator<? extends Completable> it = this.sources;
            while (!this.sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        Completable completable = (Completable) it.next();
                        if (completable == null) {
                            this.actual.onError(new NullPointerException("The completable returned is null"));
                            return;
                        }
                        completable.de(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } catch (Throwable th2) {
                        this.actual.onError(th2);
                        return;
                    }
                } catch (Throwable th3) {
                    this.actual.onError(th3);
                    return;
                }
            }
        }
    }

    public void onCompleted() {
        next();
    }

    public void onError(Throwable th2) {
        this.actual.onError(th2);
    }

    public void onSubscribe(Subscription subscription) {
        this.sd.qw(subscription);
    }
}
