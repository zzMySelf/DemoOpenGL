package io.reactivex.internal.operators.flowable;

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
import th.de.ad;
import th.de.p039if.rg.qw;

public final class FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = 8600231336733376951L;
    public final AtomicInteger active = new AtomicInteger(1);
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final Subscriber<? super R> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    public final int maxConcurrency;
    public final AtomicReference<qw<R>> queue = new AtomicReference<>();
    public final AtomicLong requested = new AtomicLong();
    public final th.de.i.qw set = new th.de.i.qw();
    public Subscription upstream;

    public final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
        public static final long serialVersionUID = -502562646270949838L;

        public InnerObserver() {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onComplete() {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerComplete(this);
        }

        public void onError(Throwable th2) {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerError(this, th2);
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onSuccess(R r) {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerSuccess(this, r);
        }
    }

    public FlowableFlatMapMaybe$FlatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
        this.downstream = subscriber;
        this.mapper = function;
        this.delayErrors = z;
        this.maxConcurrency = i2;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.set.dispose();
    }

    public void clear() {
        qw qwVar = this.queue.get();
        if (qwVar != null) {
            qwVar.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        boolean z;
        int i2;
        Subscriber<? super R> subscriber = this.downstream;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<qw<R>> atomicReference = this.queue;
        int i3 = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                z = false;
                i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    clear();
                    return;
                } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                    boolean z2 = atomicInteger.get() == 0;
                    qw qwVar = atomicReference.get();
                    Object poll = qwVar != null ? qwVar.poll() : null;
                    boolean z3 = poll == null;
                    if (z2 && z3) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            subscriber.onError(terminate);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    } else if (z3) {
                        break;
                    } else {
                        subscriber.onNext(poll);
                        j2++;
                    }
                } else {
                    Throwable terminate2 = this.errors.terminate();
                    clear();
                    subscriber.onError(terminate2);
                    return;
                }
            }
            if (i2 == 0) {
                if (this.cancelled) {
                    clear();
                    return;
                } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                    boolean z4 = atomicInteger.get() == 0;
                    qw qwVar2 = atomicReference.get();
                    if (qwVar2 == null || qwVar2.isEmpty()) {
                        z = true;
                    }
                    if (z4 && z) {
                        Throwable terminate3 = this.errors.terminate();
                        if (terminate3 != null) {
                            subscriber.onError(terminate3);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                } else {
                    Throwable terminate4 = this.errors.terminate();
                    clear();
                    subscriber.onError(terminate4);
                    return;
                }
            }
            if (j2 != 0) {
                th.de.p039if.yj.qw.rg(this.requested, j2);
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(j2);
                }
            }
            i3 = addAndGet(-i3);
        } while (i3 != 0);
    }

    public qw<R> getOrCreateQueue() {
        qw<R> qwVar;
        do {
            qw<R> qwVar2 = this.queue.get();
            if (qwVar2 != null) {
                return qwVar2;
            }
            qwVar = new qw<>(ad.qw());
        } while (!this.queue.compareAndSet((Object) null, qwVar));
        return qwVar;
    }

    public void innerComplete(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
        this.set.de(innerObserver);
        if (get() == 0) {
            boolean z = false;
            if (compareAndSet(0, 1)) {
                if (this.active.decrementAndGet() == 0) {
                    z = true;
                }
                qw qwVar = this.queue.get();
                if (!z || (qwVar != null && !qwVar.isEmpty())) {
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1);
                    }
                    if (decrementAndGet() != 0) {
                        drainLoop();
                        return;
                    }
                    return;
                }
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.downstream.onError(terminate);
                    return;
                } else {
                    this.downstream.onComplete();
                    return;
                }
            }
        }
        this.active.decrementAndGet();
        if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.upstream.request(1);
        }
        drain();
    }

    public void innerError(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th2) {
        this.set.de(innerObserver);
        if (this.errors.addThrowable(th2)) {
            if (!this.delayErrors) {
                this.upstream.cancel();
                this.set.dispose();
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1);
            }
            this.active.decrementAndGet();
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void innerSuccess(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r) {
        this.set.de(innerObserver);
        if (get() == 0) {
            boolean z = false;
            if (compareAndSet(0, 1)) {
                if (this.active.decrementAndGet() == 0) {
                    z = true;
                }
                if (this.requested.get() != 0) {
                    this.downstream.onNext(r);
                    qw qwVar = this.queue.get();
                    if (!z || (qwVar != null && !qwVar.isEmpty())) {
                        th.de.p039if.yj.qw.rg(this.requested, 1);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.upstream.request(1);
                        }
                    } else {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.downstream.onError(terminate);
                            return;
                        } else {
                            this.downstream.onComplete();
                            return;
                        }
                    }
                } else {
                    qw orCreateQueue = getOrCreateQueue();
                    synchronized (orCreateQueue) {
                        orCreateQueue.offer(r);
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
                drainLoop();
            }
        }
        qw orCreateQueue2 = getOrCreateQueue();
        synchronized (orCreateQueue2) {
            orCreateQueue2.offer(r);
        }
        this.active.decrementAndGet();
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    public void onError(Throwable th2) {
        this.active.decrementAndGet();
        if (this.errors.addThrowable(th2)) {
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void onNext(T t) {
        try {
            Object apply = this.mapper.apply(t);
            th.de.p039if.ad.qw.rg(apply, "The mapper returned a null MaybeSource");
            MaybeSource maybeSource = (MaybeSource) apply;
            this.active.getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (!this.cancelled && this.set.ad(innerObserver)) {
                maybeSource.qw(innerObserver);
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

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            drain();
        }
    }
}
