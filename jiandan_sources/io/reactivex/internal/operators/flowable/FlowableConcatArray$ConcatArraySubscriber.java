package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatArray$ConcatArraySubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -8158322871608889516L;
    public final boolean delayError;
    public final Subscriber<? super T> downstream;
    public List<Throwable> errors;
    public int index;
    public long produced;
    public final Publisher<? extends T>[] sources;
    public final AtomicInteger wip = new AtomicInteger();

    public FlowableConcatArray$ConcatArraySubscriber(Publisher<? extends T>[] publisherArr, boolean z, Subscriber<? super T> subscriber) {
        super(false);
        this.downstream = subscriber;
        this.sources = publisherArr;
        this.delayError = z;
    }

    public void onComplete() {
        if (this.wip.getAndIncrement() == 0) {
            Publisher<? extends T>[] publisherArr = this.sources;
            int length = publisherArr.length;
            int i2 = this.index;
            while (i2 != length) {
                Publisher<? extends T> publisher = publisherArr[i2];
                if (publisher == null) {
                    NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                    if (this.delayError) {
                        List list = this.errors;
                        if (list == null) {
                            list = new ArrayList((length - i2) + 1);
                            this.errors = list;
                        }
                        list.add(nullPointerException);
                        i2++;
                    } else {
                        this.downstream.onError(nullPointerException);
                        return;
                    }
                } else {
                    long j = this.produced;
                    if (j != 0) {
                        this.produced = 0;
                        produced(j);
                    }
                    publisher.subscribe(this);
                    i2++;
                    this.index = i2;
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
            List<Throwable> list2 = this.errors;
            if (list2 == null) {
                this.downstream.onComplete();
            } else if (list2.size() == 1) {
                this.downstream.onError(list2.get(0));
            } else {
                this.downstream.onError(new CompositeException((Iterable<? extends Throwable>) list2));
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.delayError) {
            List list = this.errors;
            if (list == null) {
                list = new ArrayList((this.sources.length - this.index) + 1);
                this.errors = list;
            }
            list.add(th2);
            onComplete();
            return;
        }
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        this.produced++;
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        setSubscription(subscription);
    }
}
