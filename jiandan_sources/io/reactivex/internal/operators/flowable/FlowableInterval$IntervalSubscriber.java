package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;

public final class FlowableInterval$IntervalSubscriber extends AtomicLong implements Subscription, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public long count;
    public final Subscriber<? super Long> downstream;
    public final AtomicReference<Disposable> resource = new AtomicReference<>();

    public FlowableInterval$IntervalSubscriber(Subscriber<? super Long> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.qw(this, j);
        }
    }

    public void run() {
        if (this.resource.get() == DisposableHelper.DISPOSED) {
            return;
        }
        if (get() != 0) {
            Subscriber<? super Long> subscriber = this.downstream;
            long j = this.count;
            this.count = j + 1;
            subscriber.onNext(Long.valueOf(j));
            qw.rg(this, 1);
            return;
        }
        Subscriber<? super Long> subscriber2 = this.downstream;
        subscriber2.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
        DisposableHelper.dispose(this.resource);
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.setOnce(this.resource, disposable);
    }
}
