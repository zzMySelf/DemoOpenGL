package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ggg.qw;

public final class PublishProcessor<T> extends qw<T> {

    public static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        public static final long serialVersionUID = 3562861878281475070L;
        public final Subscriber<? super T> downstream;
        public final PublishProcessor<T> parent;

        public PublishSubscription(Subscriber<? super T> subscriber, PublishProcessor<T> publishProcessor) {
            this.downstream = subscriber;
            this.parent = publishProcessor;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.uk(this);
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        public boolean isFull() {
            return get() == 0;
        }

        public void onComplete() {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.downstream.onError(th2);
            } else {
                th.de.ppp.qw.ddd(th2);
            }
        }

        public void onNext(T t) {
            long j = get();
            if (j != Long.MIN_VALUE) {
                if (j != 0) {
                    this.downstream.onNext(t);
                    th.de.p039if.yj.qw.th(this, 1);
                    return;
                }
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                th.de.p039if.yj.qw.ad(this, j);
            }
        }
    }

    public abstract void uk(PublishSubscription<T> publishSubscription);
}
