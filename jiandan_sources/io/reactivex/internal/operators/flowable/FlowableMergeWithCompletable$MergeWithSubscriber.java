package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.p039if.yj.rg;

public final class FlowableMergeWithCompletable$MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -4592979584110982903L;
    public final Subscriber<? super T> downstream;
    public final AtomicThrowable error = new AtomicThrowable();
    public volatile boolean mainDone;
    public final AtomicReference<Subscription> mainSubscription = new AtomicReference<>();
    public volatile boolean otherDone;
    public final OtherObserver otherObserver = new OtherObserver(this);
    public final AtomicLong requested = new AtomicLong();

    public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
        public static final long serialVersionUID = -2935427570954647017L;
        public final FlowableMergeWithCompletable$MergeWithSubscriber<?> parent;

        public OtherObserver(FlowableMergeWithCompletable$MergeWithSubscriber<?> flowableMergeWithCompletable$MergeWithSubscriber) {
            this.parent = flowableMergeWithCompletable$MergeWithSubscriber;
        }

        public void onComplete() {
            this.parent.otherComplete();
        }

        public void onError(Throwable th2) {
            this.parent.otherError(th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }
    }

    public FlowableMergeWithCompletable$MergeWithSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
    }

    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone) {
            rg.ad(this.downstream, this, this.error);
        }
    }

    public void onError(Throwable th2) {
        SubscriptionHelper.cancel(this.mainSubscription);
        rg.fe(this.downstream, th2, this, this.error);
    }

    public void onNext(T t) {
        rg.th(this.downstream, t, this, this.error);
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, subscription);
    }

    public void otherComplete() {
        this.otherDone = true;
        if (this.mainDone) {
            rg.ad(this.downstream, this, this.error);
        }
    }

    public void otherError(Throwable th2) {
        SubscriptionHelper.cancel(this.mainSubscription);
        rg.fe(this.downstream, th2, this, this.error);
    }

    public void request(long j) {
        SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, j);
    }
}
