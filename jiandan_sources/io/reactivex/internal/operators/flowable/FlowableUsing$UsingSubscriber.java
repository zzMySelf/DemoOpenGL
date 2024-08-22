package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.o.qw;

public final class FlowableUsing$UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = 5904473792286235046L;
    public final Consumer<? super D> disposer;
    public final Subscriber<? super T> downstream;
    public final boolean eager;
    public final D resource;
    public Subscription upstream;

    public FlowableUsing$UsingSubscriber(Subscriber<? super T> subscriber, D d, Consumer<? super D> consumer, boolean z) {
        this.downstream = subscriber;
        this.resource = d;
        this.disposer = consumer;
        this.eager = z;
    }

    public void cancel() {
        disposeAfter();
        this.upstream.cancel();
    }

    public void disposeAfter() {
        if (compareAndSet(false, true)) {
            try {
                this.disposer.accept(this.resource);
            } catch (Throwable th2) {
                qw.ad(th2);
                th.de.ppp.qw.ddd(th2);
            }
        }
    }

    public void onComplete() {
        if (this.eager) {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    qw.ad(th2);
                    this.downstream.onError(th2);
                    return;
                }
            }
            this.upstream.cancel();
            this.downstream.onComplete();
            return;
        }
        this.downstream.onComplete();
        this.upstream.cancel();
        disposeAfter();
    }

    public void onError(Throwable th2) {
        if (this.eager) {
            Throwable th3 = null;
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th4) {
                    th3 = th4;
                    qw.ad(th3);
                }
            }
            this.upstream.cancel();
            if (th3 != null) {
                this.downstream.onError(new CompositeException(th2, th3));
                return;
            }
            this.downstream.onError(th2);
            return;
        }
        this.downstream.onError(th2);
        this.upstream.cancel();
        disposeAfter();
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j) {
        this.upstream.request(j);
    }
}
