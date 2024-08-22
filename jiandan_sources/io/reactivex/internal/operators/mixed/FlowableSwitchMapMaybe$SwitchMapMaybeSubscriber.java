package io.reactivex.internal.operators.mixed;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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

public final class FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final SwitchMapMaybeObserver<Object> INNER_DISPOSED = new SwitchMapMaybeObserver<>((FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber) null);
    public static final long serialVersionUID = -5402190102429853762L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final Subscriber<? super R> downstream;
    public long emitted;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    public final AtomicLong requested = new AtomicLong();
    public Subscription upstream;

    public static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
        public static final long serialVersionUID = 8042919737683345351L;
        public volatile R item;
        public final FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber<?, R> parent;

        public SwitchMapMaybeObserver(FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber<?, R> flowableSwitchMapMaybe$SwitchMapMaybeSubscriber) {
            this.parent = flowableSwitchMapMaybe$SwitchMapMaybeSubscriber;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            this.parent.innerComplete(this);
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

    public FlowableSwitchMapMaybe$SwitchMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
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
        SwitchMapMaybeObserver<Object> andSet = this.inner.getAndSet(INNER_DISPOSED);
        if (andSet != null && andSet != INNER_DISPOSED) {
            andSet.dispose();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            Subscriber<? super R> subscriber = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            AtomicLong atomicLong = this.requested;
            long j = this.emitted;
            int i2 = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() == null || this.delayErrors) {
                    boolean z = this.done;
                    SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                    boolean z2 = switchMapMaybeObserver == null;
                    if (z && z2) {
                        Throwable terminate = atomicThrowable.terminate();
                        if (terminate != null) {
                            subscriber.onError(terminate);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    } else if (z2 || switchMapMaybeObserver.item == null || j == atomicLong.get()) {
                        this.emitted = j;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.compareAndSet(switchMapMaybeObserver, (Object) null);
                        subscriber.onNext(switchMapMaybeObserver.item);
                        j++;
                    }
                } else {
                    subscriber.onError(atomicThrowable.terminate());
                    return;
                }
            }
        }
    }

    public void innerComplete(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
        if (this.inner.compareAndSet(switchMapMaybeObserver, (Object) null)) {
            drain();
        }
    }

    public void innerError(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th2) {
        if (!this.inner.compareAndSet(switchMapMaybeObserver, (Object) null) || !this.errors.addThrowable(th2)) {
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
        SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
        SwitchMapMaybeObserver switchMapMaybeObserver2 = this.inner.get();
        if (switchMapMaybeObserver2 != null) {
            switchMapMaybeObserver2.dispose();
        }
        try {
            Object apply = this.mapper.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The mapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
            do {
                switchMapMaybeObserver = this.inner.get();
                if (switchMapMaybeObserver == INNER_DISPOSED) {
                    return;
                }
            } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
            maybeSource.qw(switchMapMaybeObserver3);
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
