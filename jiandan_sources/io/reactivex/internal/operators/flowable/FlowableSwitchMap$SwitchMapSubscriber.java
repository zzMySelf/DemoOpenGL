package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Function;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowableSwitchMap$SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    public static final FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> CANCELLED;
    public static final long serialVersionUID = -3491074160481096299L;
    public final AtomicReference<FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<>();
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final Subscriber<? super R> downstream;
    public final AtomicThrowable error;
    public final Function<? super T, ? extends Publisher<? extends R>> mapper;
    public final AtomicLong requested = new AtomicLong();
    public volatile long unique;
    public Subscription upstream;

    static {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber = new FlowableSwitchMap$SwitchMapInnerSubscriber<>((FlowableSwitchMap$SwitchMapSubscriber) null, -1, 1);
        CANCELLED = flowableSwitchMap$SwitchMapInnerSubscriber;
        flowableSwitchMap$SwitchMapInnerSubscriber.cancel();
    }

    public FlowableSwitchMap$SwitchMapSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        this.downstream = subscriber;
        this.mapper = function;
        this.bufferSize = i2;
        this.delayErrors = z;
        this.error = new AtomicThrowable();
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            disposeInner();
        }
    }

    public void disposeInner() {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> andSet;
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber = this.active.get();
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber2 = CANCELLED;
        if (flowableSwitchMap$SwitchMapInnerSubscriber != flowableSwitchMap$SwitchMapInnerSubscriber2 && (andSet = this.active.getAndSet(flowableSwitchMap$SwitchMapInnerSubscriber2)) != CANCELLED && andSet != null) {
            andSet.cancel();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e5, code lost:
        r14 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain() {
        /*
            r17 = this;
            r1 = r17
            int r0 = r17.getAndIncrement()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            org.reactivestreams.Subscriber<? super R> r2 = r1.downstream
            r4 = 1
        L_0x000c:
            boolean r0 = r1.cancelled
            r5 = 0
            if (r0 == 0) goto L_0x0017
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            r0.lazySet(r5)
            return
        L_0x0017:
            boolean r0 = r1.done
            if (r0 == 0) goto L_0x0062
            boolean r0 = r1.delayErrors
            if (r0 == 0) goto L_0x003f
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0062
            io.reactivex.internal.util.AtomicThrowable r0 = r1.error
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == 0) goto L_0x003b
            io.reactivex.internal.util.AtomicThrowable r0 = r1.error
            java.lang.Throwable r0 = r0.terminate()
            r2.onError(r0)
            goto L_0x003e
        L_0x003b:
            r2.onComplete()
        L_0x003e:
            return
        L_0x003f:
            io.reactivex.internal.util.AtomicThrowable r0 = r1.error
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == 0) goto L_0x0056
            r17.disposeInner()
            io.reactivex.internal.util.AtomicThrowable r0 = r1.error
            java.lang.Throwable r0 = r0.terminate()
            r2.onError(r0)
            return
        L_0x0056:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0062
            r2.onComplete()
            return
        L_0x0062:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            java.lang.Object r0 = r0.get()
            r6 = r0
            io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber r6 = (io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber) r6
            if (r6 == 0) goto L_0x0071
            io.reactivex.internal.fuseable.SimpleQueue<R> r0 = r6.queue
            r7 = r0
            goto L_0x0072
        L_0x0071:
            r7 = r5
        L_0x0072:
            if (r7 == 0) goto L_0x013f
            boolean r0 = r6.done
            if (r0 == 0) goto L_0x00ad
            boolean r0 = r1.delayErrors
            if (r0 != 0) goto L_0x00a0
            io.reactivex.internal.util.AtomicThrowable r0 = r1.error
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == 0) goto L_0x0093
            r17.disposeInner()
            io.reactivex.internal.util.AtomicThrowable r0 = r1.error
            java.lang.Throwable r0 = r0.terminate()
            r2.onError(r0)
            return
        L_0x0093:
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x00ad
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            r0.compareAndSet(r6, r5)
            goto L_0x000c
        L_0x00a0:
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x00ad
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            r0.compareAndSet(r6, r5)
            goto L_0x000c
        L_0x00ad:
            java.util.concurrent.atomic.AtomicLong r0 = r1.requested
            long r8 = r0.get()
            r10 = 0
            r12 = r10
        L_0x00b6:
            r14 = 0
            int r0 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x011b
            boolean r0 = r1.cancelled
            if (r0 == 0) goto L_0x00c0
            return
        L_0x00c0:
            boolean r0 = r6.done
            java.lang.Object r15 = r7.poll()     // Catch:{ all -> 0x00c7 }
            goto L_0x00d6
        L_0x00c7:
            r0 = move-exception
            r15 = r0
            th.de.o.qw.ad(r15)
            r6.cancel()
            io.reactivex.internal.util.AtomicThrowable r0 = r1.error
            r0.addThrowable(r15)
            r15 = r5
            r0 = 1
        L_0x00d6:
            if (r15 != 0) goto L_0x00db
            r16 = 1
            goto L_0x00dd
        L_0x00db:
            r16 = 0
        L_0x00dd:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r3 = r1.active
            java.lang.Object r3 = r3.get()
            if (r6 == r3) goto L_0x00e7
        L_0x00e5:
            r14 = 1
            goto L_0x011b
        L_0x00e7:
            if (r0 == 0) goto L_0x0111
            boolean r0 = r1.delayErrors
            if (r0 != 0) goto L_0x0109
            io.reactivex.internal.util.AtomicThrowable r0 = r1.error
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == 0) goto L_0x0101
            io.reactivex.internal.util.AtomicThrowable r0 = r1.error
            java.lang.Throwable r0 = r0.terminate()
            r2.onError(r0)
            return
        L_0x0101:
            if (r16 == 0) goto L_0x0111
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            r0.compareAndSet(r6, r5)
            goto L_0x00e5
        L_0x0109:
            if (r16 == 0) goto L_0x0111
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber<T, R>> r0 = r1.active
            r0.compareAndSet(r6, r5)
            goto L_0x00e5
        L_0x0111:
            if (r16 == 0) goto L_0x0114
            goto L_0x011b
        L_0x0114:
            r2.onNext(r15)
            r14 = 1
            long r12 = r12 + r14
            goto L_0x00b6
        L_0x011b:
            int r0 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x013b
            boolean r0 = r1.cancelled
            if (r0 != 0) goto L_0x013b
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x0132
            java.util.concurrent.atomic.AtomicLong r0 = r1.requested
            long r7 = -r12
            r0.addAndGet(r7)
        L_0x0132:
            java.lang.Object r0 = r6.get()
            org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
            r0.request(r12)
        L_0x013b:
            if (r14 == 0) goto L_0x013f
            goto L_0x000c
        L_0x013f:
            int r0 = -r4
            int r4 = r1.addAndGet(r0)
            if (r4 != 0) goto L_0x000c
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapSubscriber.drain():void");
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            drain();
        }
    }

    public void onError(Throwable th2) {
        if (this.done || !this.error.addThrowable(th2)) {
            qw.ddd(th2);
            return;
        }
        if (!this.delayErrors) {
            disposeInner();
        }
        this.done = true;
        drain();
    }

    public void onNext(T t) {
        FlowableSwitchMap$SwitchMapInnerSubscriber<Object, Object> flowableSwitchMap$SwitchMapInnerSubscriber;
        if (!this.done) {
            long j = this.unique + 1;
            this.unique = j;
            FlowableSwitchMap$SwitchMapInnerSubscriber flowableSwitchMap$SwitchMapInnerSubscriber2 = this.active.get();
            if (flowableSwitchMap$SwitchMapInnerSubscriber2 != null) {
                flowableSwitchMap$SwitchMapInnerSubscriber2.cancel();
            }
            try {
                Object apply = this.mapper.apply(t);
                th.de.p039if.ad.qw.rg(apply, "The publisher returned is null");
                Publisher publisher = (Publisher) apply;
                FlowableSwitchMap$SwitchMapInnerSubscriber flowableSwitchMap$SwitchMapInnerSubscriber3 = new FlowableSwitchMap$SwitchMapInnerSubscriber(this, j, this.bufferSize);
                do {
                    flowableSwitchMap$SwitchMapInnerSubscriber = this.active.get();
                    if (flowableSwitchMap$SwitchMapInnerSubscriber == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, flowableSwitchMap$SwitchMapInnerSubscriber3));
                publisher.subscribe(flowableSwitchMap$SwitchMapInnerSubscriber3);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.upstream, subscription)) {
            this.upstream = subscription;
            this.downstream.onSubscribe(this);
        }
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            th.de.p039if.yj.qw.qw(this.requested, j);
            if (this.unique == 0) {
                this.upstream.request(Long.MAX_VALUE);
            } else {
                drain();
            }
        }
    }
}
