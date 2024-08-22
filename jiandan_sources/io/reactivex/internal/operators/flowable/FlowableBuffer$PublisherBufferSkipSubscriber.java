package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableBuffer$PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -5616169793639412593L;
    public C buffer;
    public final Callable<C> bufferSupplier;
    public boolean done;
    public final Subscriber<? super C> downstream;
    public int index;
    public final int size;
    public final int skip;
    public Subscription upstream;

    public FlowableBuffer$PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i2, int i3, Callable<C> callable) {
        this.downstream = subscriber;
        this.size = i2;
        this.skip = i3;
        this.bufferSupplier = callable;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            C c = this.buffer;
            this.buffer = null;
            if (c != null) {
                this.downstream.onNext(c);
            }
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        this.buffer = null;
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            C c = this.buffer;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    C call = this.bufferSupplier.call();
                    th.de.p039if.ad.qw.rg(call, "The bufferSupplier returned a null buffer");
                    c = (Collection) call;
                    this.buffer = c;
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    cancel();
                    onError(th2);
                    return;
                }
            }
            if (c != null) {
                c.add(t);
                if (c.size() == this.size) {
                    this.buffer = null;
                    this.downstream.onNext(c);
                }
            }
            if (i3 == this.skip) {
                i3 = 0;
            }
            this.index = i3;
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j) {
        if (!SubscriptionHelper.validate(j)) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            this.upstream.request(th.de.p039if.yj.qw.fe((long) this.skip, j));
            return;
        }
        this.upstream.request(th.de.p039if.yj.qw.de(th.de.p039if.yj.qw.fe(j, (long) this.size), th.de.p039if.yj.qw.fe((long) (this.skip - this.size), j - 1)));
    }
}
