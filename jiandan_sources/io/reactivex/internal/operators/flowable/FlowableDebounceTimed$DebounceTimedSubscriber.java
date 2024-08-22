package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;
import th.de.th;

public final class FlowableDebounceTimed$DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -9102637559663639004L;
    public boolean done;
    public final Subscriber<? super T> downstream;
    public volatile long index;
    public final long timeout;
    public Disposable timer;
    public final TimeUnit unit;
    public Subscription upstream;
    public final th.de worker;

    public FlowableDebounceTimed$DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, th.de deVar) {
        this.downstream = subscriber;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = deVar;
    }

    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    public void emit(long j, T t, FlowableDebounceTimed$DebounceEmitter<T> flowableDebounceTimed$DebounceEmitter) {
        if (j != this.index) {
            return;
        }
        if (get() != 0) {
            this.downstream.onNext(t);
            qw.rg(this, 1);
            flowableDebounceTimed$DebounceEmitter.dispose();
            return;
        }
        cancel();
        this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            Disposable disposable = this.timer;
            if (disposable != null) {
                disposable.dispose();
            }
            FlowableDebounceTimed$DebounceEmitter flowableDebounceTimed$DebounceEmitter = (FlowableDebounceTimed$DebounceEmitter) disposable;
            if (flowableDebounceTimed$DebounceEmitter != null) {
                flowableDebounceTimed$DebounceEmitter.emit();
            }
            this.downstream.onComplete();
            this.worker.dispose();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.done = true;
        Disposable disposable = this.timer;
        if (disposable != null) {
            disposable.dispose();
        }
        this.downstream.onError(th2);
        this.worker.dispose();
    }

    public void onNext(T t) {
        if (!this.done) {
            long j = this.index + 1;
            this.index = j;
            Disposable disposable = this.timer;
            if (disposable != null) {
                disposable.dispose();
            }
            FlowableDebounceTimed$DebounceEmitter flowableDebounceTimed$DebounceEmitter = new FlowableDebounceTimed$DebounceEmitter(t, j, this);
            this.timer = flowableDebounceTimed$DebounceEmitter;
            flowableDebounceTimed$DebounceEmitter.setResource(this.worker.de(flowableDebounceTimed$DebounceEmitter, this.timeout, this.unit));
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            qw.qw(this, j);
        }
    }
}
