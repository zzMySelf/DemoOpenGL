package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import p041if.pf.de;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;

public final class CompletableOnSubscribeConcatArray$ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
    public static final long serialVersionUID = -7965400327305809232L;
    public final CompletableSubscriber actual;
    public int index;
    public final de sd = new de();
    public final Completable[] sources;

    public CompletableOnSubscribeConcatArray$ConcatInnerSubscriber(CompletableSubscriber completableSubscriber, Completable[] completableArr) {
        this.actual = completableSubscriber;
        this.sources = completableArr;
    }

    public void next() {
        if (!this.sd.isUnsubscribed() && getAndIncrement() == 0) {
            Completable[] completableArr = this.sources;
            while (!this.sd.isUnsubscribed()) {
                int i2 = this.index;
                this.index = i2 + 1;
                if (i2 == completableArr.length) {
                    this.actual.onCompleted();
                    return;
                }
                completableArr[i2].de(this);
                if (decrementAndGet() == 0) {
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
