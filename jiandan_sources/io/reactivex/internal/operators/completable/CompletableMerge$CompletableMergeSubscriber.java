package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.i.qw;

public final class CompletableMerge$CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
    public static final long serialVersionUID = -2108443387387077490L;
    public final boolean delayErrors;
    public final CompletableObserver downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public final int maxConcurrency;
    public final qw set = new qw();
    public Subscription upstream;

    public final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        public static final long serialVersionUID = 251330541679988317L;

        public MergeInnerObserver() {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            CompletableMerge$CompletableMergeSubscriber.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            CompletableMerge$CompletableMergeSubscriber.this.innerError(this, th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public CompletableMerge$CompletableMergeSubscriber(CompletableObserver completableObserver, int i2, boolean z) {
        this.downstream = completableObserver;
        this.maxConcurrency = i2;
        this.delayErrors = z;
        lazySet(1);
    }

    public void dispose() {
        this.upstream.cancel();
        this.set.dispose();
    }

    public void innerComplete(MergeInnerObserver mergeInnerObserver) {
        this.set.de(mergeInnerObserver);
        if (decrementAndGet() == 0) {
            Throwable th2 = (Throwable) this.error.get();
            if (th2 != null) {
                this.downstream.onError(th2);
            } else {
                this.downstream.onComplete();
            }
        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.upstream.request(1);
        }
    }

    public void innerError(MergeInnerObserver mergeInnerObserver, Throwable th2) {
        this.set.de(mergeInnerObserver);
        if (!this.delayErrors) {
            this.upstream.cancel();
            this.set.dispose();
            if (!this.error.addThrowable(th2)) {
                th.de.ppp.qw.ddd(th2);
            } else if (getAndSet(0) > 0) {
                this.downstream.onError(this.error.terminate());
            }
        } else if (!this.error.addThrowable(th2)) {
            th.de.ppp.qw.ddd(th2);
        } else if (decrementAndGet() == 0) {
            this.downstream.onError(this.error.terminate());
        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.upstream.request(1);
        }
    }

    public boolean isDisposed() {
        return this.set.isDisposed();
    }

    public void onComplete() {
        if (decrementAndGet() != 0) {
            return;
        }
        if (((Throwable) this.error.get()) != null) {
            this.downstream.onError(this.error.terminate());
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (!this.delayErrors) {
            this.set.dispose();
            if (!this.error.addThrowable(th2)) {
                th.de.ppp.qw.ddd(th2);
            } else if (getAndSet(0) > 0) {
                this.downstream.onError(this.error.terminate());
            }
        } else if (!this.error.addThrowable(th2)) {
            th.de.ppp.qw.ddd(th2);
        } else if (decrementAndGet() == 0) {
            this.downstream.onError(this.error.terminate());
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

    public void onNext(CompletableSource completableSource) {
        getAndIncrement();
        MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
        this.set.ad(mergeInnerObserver);
        completableSource.qw(mergeInnerObserver);
    }
}
