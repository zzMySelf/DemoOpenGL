package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.i.qw;

public final class FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
    public static final long serialVersionUID = 8443155186132538303L;
    public final boolean delayErrors;
    public volatile boolean disposed;
    public final CompletableObserver downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final Function<? super T, ? extends CompletableSource> mapper;
    public final int maxConcurrency;
    public final qw set = new qw();
    public Subscription upstream;

    public final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        public static final long serialVersionUID = 8606673141535671828L;

        public InnerObserver() {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber.this.innerError(this, th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        this.downstream = completableObserver;
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i2;
        lazySet(1);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    public void innerComplete(FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
        this.set.de(innerObserver);
        onComplete();
    }

    public void innerError(FlowableFlatMapCompletableCompletable$FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th2) {
        this.set.de(innerObserver);
        onError(th2);
    }

    public boolean isDisposed() {
        return this.set.isDisposed();
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
            dispose();
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
            InnerObserver innerObserver = new InnerObserver();
            if (!this.disposed && this.set.ad(innerObserver)) {
                completableSource.qw(innerObserver);
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
}
