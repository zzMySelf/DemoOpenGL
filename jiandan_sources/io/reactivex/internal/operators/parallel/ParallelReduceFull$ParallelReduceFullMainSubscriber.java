package io.reactivex.internal.operators.parallel;

import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import th.de.p039if.ad.qw;

public final class ParallelReduceFull$ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
    public static final long serialVersionUID = -5370107872170712765L;
    public final AtomicReference<ParallelReduceFull$SlotPair<T>> current = new AtomicReference<>();
    public final AtomicReference<Throwable> error = new AtomicReference<>();
    public final BiFunction<T, T, T> reducer;
    public final AtomicInteger remaining = new AtomicInteger();
    public final ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] subscribers;

    public ParallelReduceFull$ParallelReduceFullMainSubscriber(Subscriber<? super T> subscriber, int i2, BiFunction<T, T, T> biFunction) {
        super(subscriber);
        ParallelReduceFull$ParallelReduceFullInnerSubscriber<T>[] parallelReduceFull$ParallelReduceFullInnerSubscriberArr = new ParallelReduceFull$ParallelReduceFullInnerSubscriber[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            parallelReduceFull$ParallelReduceFullInnerSubscriberArr[i3] = new ParallelReduceFull$ParallelReduceFullInnerSubscriber<>(this, biFunction);
        }
        this.subscribers = parallelReduceFull$ParallelReduceFullInnerSubscriberArr;
        this.reducer = biFunction;
        this.remaining.lazySet(i2);
    }

    public ParallelReduceFull$SlotPair<T> addValue(T t) {
        ParallelReduceFull$SlotPair<T> parallelReduceFull$SlotPair;
        int tryAcquireSlot;
        while (true) {
            parallelReduceFull$SlotPair = this.current.get();
            if (parallelReduceFull$SlotPair == null) {
                parallelReduceFull$SlotPair = new ParallelReduceFull$SlotPair<>();
                if (!this.current.compareAndSet((Object) null, parallelReduceFull$SlotPair)) {
                    continue;
                }
            }
            tryAcquireSlot = parallelReduceFull$SlotPair.tryAcquireSlot();
            if (tryAcquireSlot >= 0) {
                break;
            }
            this.current.compareAndSet(parallelReduceFull$SlotPair, (Object) null);
        }
        if (tryAcquireSlot == 0) {
            parallelReduceFull$SlotPair.first = t;
        } else {
            parallelReduceFull$SlotPair.second = t;
        }
        if (!parallelReduceFull$SlotPair.releaseSlot()) {
            return null;
        }
        this.current.compareAndSet(parallelReduceFull$SlotPair, (Object) null);
        return parallelReduceFull$SlotPair;
    }

    public void cancel() {
        for (ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> cancel : this.subscribers) {
            cancel.cancel();
        }
    }

    public void innerComplete(T t) {
        if (t != null) {
            while (true) {
                ParallelReduceFull$SlotPair addValue = addValue(t);
                if (addValue == null) {
                    break;
                }
                try {
                    t = this.reducer.apply(addValue.first, addValue.second);
                    qw.rg(t, "The reducer returned a null value");
                } catch (Throwable th2) {
                    th.de.o.qw.ad(th2);
                    innerError(th2);
                    return;
                }
            }
        }
        if (this.remaining.decrementAndGet() == 0) {
            ParallelReduceFull$SlotPair parallelReduceFull$SlotPair = this.current.get();
            this.current.lazySet((Object) null);
            if (parallelReduceFull$SlotPair != null) {
                complete(parallelReduceFull$SlotPair.first);
            } else {
                this.downstream.onComplete();
            }
        }
    }

    public void innerError(Throwable th2) {
        if (this.error.compareAndSet((Object) null, th2)) {
            cancel();
            this.downstream.onError(th2);
        } else if (th2 != this.error.get()) {
            th.de.ppp.qw.ddd(th2);
        }
    }
}
