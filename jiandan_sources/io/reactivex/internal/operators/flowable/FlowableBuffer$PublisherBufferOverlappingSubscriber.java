package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.qw;
import th.de.p039if.yj.uk;

public final class FlowableBuffer$PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
    public static final long serialVersionUID = -7370244972039324525L;
    public final Callable<C> bufferSupplier;
    public final ArrayDeque<C> buffers = new ArrayDeque<>();
    public volatile boolean cancelled;
    public boolean done;
    public final Subscriber<? super C> downstream;
    public int index;
    public final AtomicBoolean once = new AtomicBoolean();
    public long produced;
    public final int size;
    public final int skip;
    public Subscription upstream;

    public FlowableBuffer$PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i2, int i3, Callable<C> callable) {
        this.downstream = subscriber;
        this.size = i2;
        this.skip = i3;
        this.bufferSupplier = callable;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
    }

    public boolean getAsBoolean() {
        return this.cancelled;
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            long j = this.produced;
            if (j != 0) {
                qw.rg(this, j);
            }
            uk.rg(this.downstream, this.buffers, this, this);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.done = true;
        this.buffers.clear();
        this.downstream.onError(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            ArrayDeque<C> arrayDeque = this.buffers;
            int i2 = this.index;
            int i3 = i2 + 1;
            if (i2 == 0) {
                try {
                    C call = this.bufferSupplier.call();
                    th.de.p039if.ad.qw.rg(call, "The bufferSupplier returned a null buffer");
                    arrayDeque.offer((Collection) call);
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    cancel();
                    onError(th2);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.size) {
                arrayDeque.poll();
                collection.add(t);
                this.produced++;
                this.downstream.onNext(collection);
            }
            Iterator<C> it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
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
        if (SubscriptionHelper.validate(j)) {
            if (!uk.yj(j, this.downstream, this.buffers, this, this)) {
                if (this.once.get() || !this.once.compareAndSet(false, true)) {
                    this.upstream.request(qw.fe((long) this.skip, j));
                    return;
                }
                this.upstream.request(qw.de((long) this.size, qw.fe((long) this.skip, j - 1)));
            }
        }
    }
}
