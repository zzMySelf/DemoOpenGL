package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class ParallelReduceFull$ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
    public static final long serialVersionUID = -7954444275102466525L;
    public boolean done;
    public final ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parent;
    public final BiFunction<T, T, T> reducer;
    public T value;

    public ParallelReduceFull$ParallelReduceFullInnerSubscriber(ParallelReduceFull$ParallelReduceFullMainSubscriber<T> parallelReduceFull$ParallelReduceFullMainSubscriber, BiFunction<T, T, T> biFunction) {
        this.parent = parallelReduceFull$ParallelReduceFullMainSubscriber;
        this.reducer = biFunction;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.parent.innerComplete(this.value);
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            qw.ddd(th2);
            return;
        }
        this.done = true;
        this.parent.innerError(th2);
    }

    public void onNext(T t) {
        if (!this.done) {
            T t2 = this.value;
            if (t2 == null) {
                this.value = t;
                return;
            }
            try {
                T apply = this.reducer.apply(t2, t);
                th.de.p039if.ad.qw.rg(apply, "The reducer returned a null value");
                this.value = apply;
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                ((Subscription) get()).cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
    }
}
