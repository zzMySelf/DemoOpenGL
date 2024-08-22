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

public final class FlowableIntervalRange$IntervalRangeSubscriber extends AtomicLong implements Subscription, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public long count;
    public final Subscriber<? super Long> downstream;
    public final long end;
    public final AtomicReference<Disposable> resource = new AtomicReference<>();

    public FlowableIntervalRange$IntervalRangeSubscriber(Subscriber<? super Long> subscriber, long j, long j2) {
        this.downstream = subscriber;
        this.count = j;
        this.end = j2;
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
        if (this.resource.get() != DisposableHelper.DISPOSED) {
            long j = get();
            if (j != 0) {
                long j2 = this.count;
                this.downstream.onNext(Long.valueOf(j2));
                if (j2 == this.end) {
                    if (this.resource.get() != DisposableHelper.DISPOSED) {
                        this.downstream.onComplete();
                    }
                    DisposableHelper.dispose(this.resource);
                    return;
                }
                this.count = j2 + 1;
                if (j != Long.MAX_VALUE) {
                    decrementAndGet();
                    return;
                }
                return;
            }
            Subscriber<? super Long> subscriber = this.downstream;
            subscriber.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
            DisposableHelper.dispose(this.resource);
        }
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.setOnce(this.resource, disposable);
    }
}
