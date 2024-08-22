package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.p039if.rg.qw;

public final class FlowableBufferBoundary$BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final long serialVersionUID = -8466418554264089604L;
    public final Function<? super Open, ? extends Publisher<? extends Close>> bufferClose;
    public final Publisher<? extends Open> bufferOpen;
    public final Callable<C> bufferSupplier;
    public Map<Long, C> buffers = new LinkedHashMap();
    public volatile boolean cancelled;
    public volatile boolean done;
    public final Subscriber<? super C> downstream;
    public long emitted;
    public final AtomicThrowable errors = new AtomicThrowable();
    public long index;
    public final qw<C> queue = new qw<>(ad.qw());
    public final AtomicLong requested = new AtomicLong();
    public final th.de.i.qw subscribers = new th.de.i.qw();
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
        public static final long serialVersionUID = -8498650778633225126L;
        public final FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> parent;

        public BufferOpenSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber<?, ?, Open, ?> flowableBufferBoundary$BufferBoundarySubscriber) {
            this.parent = flowableBufferBoundary$BufferBoundarySubscriber;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        public void onComplete() {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.openComplete(this);
        }

        public void onError(Throwable th2) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.boundaryError(this, th2);
        }

        public void onNext(Open open) {
            this.parent.open(open);
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    public FlowableBufferBoundary$BufferBoundarySubscriber(Subscriber<? super C> subscriber, Publisher<? extends Open> publisher, Function<? super Open, ? extends Publisher<? extends Close>> function, Callable<C> callable) {
        this.downstream = subscriber;
        this.bufferSupplier = callable;
        this.bufferOpen = publisher;
        this.bufferClose = function;
    }

    public void boundaryError(Disposable disposable, Throwable th2) {
        SubscriptionHelper.cancel(this.upstream);
        this.subscribers.de(disposable);
        onError(th2);
    }

    public void cancel() {
        if (SubscriptionHelper.cancel(this.upstream)) {
            this.cancelled = true;
            this.subscribers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            if (getAndIncrement() != 0) {
                this.queue.clear();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (r4 == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r3.done = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        drain();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close(io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber<T, C> r4, long r5) {
        /*
            r3 = this;
            th.de.i.qw r0 = r3.subscribers
            r0.de(r4)
            th.de.i.qw r4 = r3.subscribers
            int r4 = r4.rg()
            r0 = 1
            if (r4 != 0) goto L_0x0015
            java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r4 = r3.upstream
            io.reactivex.internal.subscriptions.SubscriptionHelper.cancel(r4)
            r4 = 1
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            monitor-enter(r3)
            java.util.Map<java.lang.Long, C> r1 = r3.buffers     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x001d
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            return
        L_0x001d:
            th.de.if.rg.qw<C> r1 = r3.queue     // Catch:{ all -> 0x0035 }
            java.util.Map<java.lang.Long, C> r2 = r3.buffers     // Catch:{ all -> 0x0035 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0035 }
            java.lang.Object r5 = r2.remove(r5)     // Catch:{ all -> 0x0035 }
            r1.offer(r5)     // Catch:{ all -> 0x0035 }
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x0031
            r3.done = r0
        L_0x0031:
            r3.drain()
            return
        L_0x0035:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber.close(io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferCloseSubscriber, long):void");
    }

    public void drain() {
        int i2;
        if (getAndIncrement() == 0) {
            long j = this.emitted;
            Subscriber<? super C> subscriber = this.downstream;
            qw<C> qwVar = this.queue;
            int i3 = 1;
            do {
                long j2 = this.requested.get();
                while (true) {
                    i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.cancelled) {
                        qwVar.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        if (!z || this.errors.get() == null) {
                            Collection collection = (Collection) qwVar.poll();
                            boolean z2 = collection == null;
                            if (z && z2) {
                                subscriber.onComplete();
                                return;
                            } else if (z2) {
                                break;
                            } else {
                                subscriber.onNext(collection);
                                j++;
                            }
                        } else {
                            qwVar.clear();
                            subscriber.onError(this.errors.terminate());
                            return;
                        }
                    }
                }
                if (i2 == 0) {
                    if (this.cancelled) {
                        qwVar.clear();
                        return;
                    } else if (this.done) {
                        if (this.errors.get() != null) {
                            qwVar.clear();
                            subscriber.onError(this.errors.terminate());
                            return;
                        } else if (qwVar.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.emitted = j;
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }
    }

    public void onComplete() {
        this.subscribers.dispose();
        synchronized (this) {
            Map<Long, C> map = this.buffers;
            if (map != null) {
                for (C offer : map.values()) {
                    this.queue.offer(offer);
                }
                this.buffers = null;
                this.done = true;
                drain();
            }
        }
    }

    public void onError(Throwable th2) {
        if (this.errors.addThrowable(th2)) {
            this.subscribers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            drain();
            return;
        }
        th.de.ppp.qw.ddd(th2);
    }

    public void onNext(T t) {
        synchronized (this) {
            Map<Long, C> map = this.buffers;
            if (map != null) {
                for (C add : map.values()) {
                    add.add(t);
                }
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
            BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
            this.subscribers.ad(bufferOpenSubscriber);
            this.bufferOpen.subscribe(bufferOpenSubscriber);
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void open(Open open) {
        try {
            C call = this.bufferSupplier.call();
            th.de.p039if.ad.qw.rg(call, "The bufferSupplier returned a null Collection");
            Collection collection = (Collection) call;
            Object apply = this.bufferClose.apply(open);
            th.de.p039if.ad.qw.rg(apply, "The bufferClose returned a null Publisher");
            Publisher publisher = (Publisher) apply;
            long j = this.index;
            this.index = 1 + j;
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    map.put(Long.valueOf(j), collection);
                    FlowableBufferBoundary$BufferCloseSubscriber flowableBufferBoundary$BufferCloseSubscriber = new FlowableBufferBoundary$BufferCloseSubscriber(this, j);
                    this.subscribers.ad(flowableBufferBoundary$BufferCloseSubscriber);
                    publisher.subscribe(flowableBufferBoundary$BufferCloseSubscriber);
                }
            }
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            SubscriptionHelper.cancel(this.upstream);
            onError(th2);
        }
    }

    public void openComplete(BufferOpenSubscriber<Open> bufferOpenSubscriber) {
        this.subscribers.de(bufferOpenSubscriber);
        if (this.subscribers.rg() == 0) {
            SubscriptionHelper.cancel(this.upstream);
            this.done = true;
            drain();
        }
    }

    public void request(long j) {
        th.de.p039if.yj.qw.qw(this.requested, j);
        drain();
    }
}
