package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.i.qw;

public final class FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
    public static final long serialVersionUID = 8443155186132538303L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final Subscriber<? super T> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final Function<? super T, ? extends CompletableSource> mapper;
    public final int maxConcurrency;
    public final qw set = new qw();
    public Subscription upstream;

    public final class InnerConsumer extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        public static final long serialVersionUID = 8606673141535671828L;

        public InnerConsumer() {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber.this.innerError(this, th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber(Subscriber<? super T> subscriber, Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        this.downstream = subscriber;
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i2;
        lazySet(1);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    public void clear() {
    }

    public void innerComplete(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
        this.set.de(innerConsumer);
        onComplete();
    }

    public void innerError(FlowableFlatMapCompletable$FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th2) {
        this.set.de(innerConsumer);
        onError(th2);
    }

    public boolean isEmpty() {
        return true;
    }

    public void onComplete() {
        if (decrementAndGet() == 0) {
            Throwable terminate = this.errors.terminate();
            if (terminate != null) {
                this.downstream.onError(terminate);
            } else {
                this.downstream.onComplete();
            }
        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.upstream.request(1);
        }
    }

    public void onError(Throwable th2) {
        if (!this.errors.addThrowable(th2)) {
            th.de.ppp.qw.ddd(th2);
        } else if (!this.delayErrors) {
            cancel();
            if (getAndSet(0) > 0) {
                this.downstream.onError(this.errors.terminate());
            }
        } else if (decrementAndGet() == 0) {
            this.downstream.onError(this.errors.terminate());
        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.upstream.request(1);
        }
    }

    public void onNext(T t) {
        try {
            Object apply = this.mapper.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The mapper returned a null CompletableSource");
            CompletableSource completableSource = (CompletableSource) apply;
            getAndIncrement();
            InnerConsumer innerConsumer = new InnerConsumer();
            if (!this.cancelled && this.set.ad(innerConsumer)) {
                completableSource.qw(innerConsumer);
            }
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.upstream.cancel();
            onError(th2);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
            int i2 = this.maxConcurrency;
            if (i2 == Integer.MAX_VALUE) {
                subscription.request(Long.MAX_VALUE);
            } else {
                subscription.request((long) i2);
            }
        }
    }

    public T poll() throws Exception {
        return null;
    }

    public void request(long j) {
    }

    public int requestFusion(int i2) {
        return i2 & 2;
    }
}
