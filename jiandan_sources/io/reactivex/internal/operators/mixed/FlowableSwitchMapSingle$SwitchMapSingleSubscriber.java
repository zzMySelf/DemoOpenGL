package io.reactivex.internal.operators.mixed;

import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableSwitchMapSingle$SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final SwitchMapSingleObserver<Object> INNER_DISPOSED = new SwitchMapSingleObserver<>((FlowableSwitchMapSingle$SwitchMapSingleSubscriber) null);
    public static final long serialVersionUID = -5402190102429853762L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final Subscriber<? super R> downstream;
    public long emitted;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();
    public final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    public final AtomicLong requested = new AtomicLong();
    public Subscription upstream;

    public static final class SwitchMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
        public static final long serialVersionUID = 8042919737683345351L;
        public volatile R item;
        public final FlowableSwitchMapSingle$SwitchMapSingleSubscriber<?, R> parent;

        public SwitchMapSingleObserver(FlowableSwitchMapSingle$SwitchMapSingleSubscriber<?, R> flowableSwitchMapSingle$SwitchMapSingleSubscriber) {
            this.parent = flowableSwitchMapSingle$SwitchMapSingleSubscriber;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onError(Throwable th2) {
            this.parent.innerError(this, th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(R r) {
            this.item = r;
            this.parent.drain();
        }
    }

    public FlowableSwitchMapSingle$SwitchMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.downstream = subscriber;
        this.mapper = function;
        this.delayErrors = z;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        disposeInner();
    }

    public void disposeInner() {
        SwitchMapSingleObserver<Object> andSet = this.inner.getAndSet(INNER_DISPOSED);
        if (andSet != null && andSet != INNER_DISPOSED) {
            andSet.dispose();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            Subscriber<? super R> subscriber = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            AtomicLong atomicLong = this.requested;
            long j = this.emitted;
            int i2 = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() == null || this.delayErrors) {
                    boolean z = this.done;
                    SwitchMapSingleObserver switchMapSingleObserver = atomicReference.get();
                    boolean z2 = switchMapSingleObserver == null;
                    if (z && z2) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate != null) {
                            subscriber.onError(terminate);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    } else if (z2 || switchMapSingleObserver.item == null || j == atomicLong.get()) {
                        this.emitted = j;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.compareAndSet(switchMapSingleObserver, (Object) null);
                        subscriber.onNext(switchMapSingleObserver.item);
                        j++;
                    }
                } else {
                    subscriber.onError(atomicThrowable.terminate());
                    return;
                }
            }
        }
    }

    public void innerError(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th2) {
        if (!this.inner.compareAndSet(switchMapSingleObserver, (Object) null) || !this.errors.addThrowable(th2)) {
            qw.ddd(th2);
            return;
        }
        if (!this.delayErrors) {
            this.upstream.cancel();
            disposeInner();
        }
        drain();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.addThrowable(th2)) {
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        SwitchMapSingleObserver<Object> switchMapSingleObserver;
        SwitchMapSingleObserver switchMapSingleObserver2 = this.inner.get();
        if (switchMapSingleObserver2 != null) {
            switchMapSingleObserver2.dispose();
        }
        try {
            Object apply = this.mapper.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The mapper returned a null SingleSource");
            SingleSource singleSource = (SingleSource) apply;
            SwitchMapSingleObserver switchMapSingleObserver3 = new SwitchMapSingleObserver(this);
            do {
                switchMapSingleObserver = this.inner.get();
                if (switchMapSingleObserver == INNER_DISPOSED) {
                    return;
                }
            } while (!this.inner.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
            singleSource.qw(switchMapSingleObserver3);
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            this.upstream.cancel();
            this.inner.getAndSet(INNER_DISPOSED);
            onError(th2);
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
        th.de.p039if.yj.qw.qw(this.requested, j);
        drain();
    }
}
