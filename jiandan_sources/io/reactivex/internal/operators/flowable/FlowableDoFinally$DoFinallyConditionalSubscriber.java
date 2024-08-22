package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;
import th.de.o.qw;

public final class FlowableDoFinally$DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
    public static final long serialVersionUID = 4109457741734051389L;
    public final ConditionalSubscriber<? super T> downstream;
    public final Action onFinally;
    public QueueSubscription<T> qs;
    public boolean syncFused;
    public Subscription upstream;

    public FlowableDoFinally$DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Action action) {
        this.downstream = conditionalSubscriber;
        this.onFinally = action;
    }

    public void cancel() {
        this.upstream.cancel();
        runFinally();
    }

    public void clear() {
        this.qs.clear();
    }

    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
        runFinally();
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            if (subscription instanceof QueueSubscription) {
                this.qs = (QueueSubscription) subscription;
            }
            this.downstream.onSubscribe(this);
        }
    }

    public T poll() throws Exception {
        T poll = this.qs.poll();
        if (poll == null && this.syncFused) {
            runFinally();
        }
        return poll;
    }

    public void request(long j) {
        this.upstream.request(j);
    }

    public int requestFusion(int i2) {
        QueueSubscription<T> queueSubscription = this.qs;
        boolean z = false;
        if (queueSubscription == null || (i2 & 4) != 0) {
            return 0;
        }
        int requestFusion = queueSubscription.requestFusion(i2);
        if (requestFusion != 0) {
            if (requestFusion == 1) {
                z = true;
            }
            this.syncFused = z;
        }
        return requestFusion;
    }

    public void runFinally() {
        if (compareAndSet(0, 1)) {
            try {
                this.onFinally.run();
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(th2);
            }
        }
    }

    public boolean tryOnNext(T t) {
        return this.downstream.tryOnNext(t);
    }
}
