package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

public final class FlowablePublish$PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
    public static final FlowablePublish$InnerSubscriber[] EMPTY = new FlowablePublish$InnerSubscriber[0];
    public static final FlowablePublish$InnerSubscriber[] TERMINATED = new FlowablePublish$InnerSubscriber[0];
    public static final long serialVersionUID = -202316842419149694L;
    public final int bufferSize;
    public final AtomicReference<FlowablePublish$PublishSubscriber<T>> current;
    public volatile SimpleQueue<T> queue;
    public final AtomicBoolean shouldConnect;
    public int sourceMode;
    public final AtomicReference<FlowablePublish$InnerSubscriber<T>[]> subscribers = new AtomicReference<>(EMPTY);
    public volatile Object terminalEvent;
    public final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public FlowablePublish$PublishSubscriber(AtomicReference<FlowablePublish$PublishSubscriber<T>> atomicReference, int i2) {
        this.current = atomicReference;
        this.shouldConnect = new AtomicBoolean();
        this.bufferSize = i2;
    }

    public boolean add(FlowablePublish$InnerSubscriber<T> flowablePublish$InnerSubscriber) {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr;
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr2;
        do {
            flowablePublish$InnerSubscriberArr = (FlowablePublish$InnerSubscriber[]) this.subscribers.get();
            if (flowablePublish$InnerSubscriberArr == TERMINATED) {
                return false;
            }
            int length = flowablePublish$InnerSubscriberArr.length;
            flowablePublish$InnerSubscriberArr2 = new FlowablePublish$InnerSubscriber[(length + 1)];
            System.arraycopy(flowablePublish$InnerSubscriberArr, 0, flowablePublish$InnerSubscriberArr2, 0, length);
            flowablePublish$InnerSubscriberArr2[length] = flowablePublish$InnerSubscriber;
        } while (!this.subscribers.compareAndSet(flowablePublish$InnerSubscriberArr, flowablePublish$InnerSubscriberArr2));
        return true;
    }

    public boolean checkTerminated(Object obj, boolean z) {
        int i2 = 0;
        if (obj != null) {
            if (!NotificationLite.isComplete(obj)) {
                Throwable error = NotificationLite.getError(obj);
                this.current.compareAndSet(this, (Object) null);
                FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr = (FlowablePublish$InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                if (flowablePublish$InnerSubscriberArr.length != 0) {
                    int length = flowablePublish$InnerSubscriberArr.length;
                    while (i2 < length) {
                        flowablePublish$InnerSubscriberArr[i2].child.onError(error);
                        i2++;
                    }
                } else {
                    qw.ddd(error);
                }
                return true;
            } else if (z) {
                this.current.compareAndSet(this, (Object) null);
                FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr2 = (FlowablePublish$InnerSubscriber[]) this.subscribers.getAndSet(TERMINATED);
                int length2 = flowablePublish$InnerSubscriberArr2.length;
                while (i2 < length2) {
                    flowablePublish$InnerSubscriberArr2[i2].child.onComplete();
                    i2++;
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0136, code lost:
        if (r11 == 0) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0138, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013b, code lost:
        if (r1.sourceMode == 1) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x013d, code lost:
        r1.upstream.get().request(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0149, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x014e, code lost:
        if (r14 == 0) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0150, code lost:
        if (r8 != false) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0014, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatch() {
        /*
            r25 = this;
            r1 = r25
            int r0 = r25.getAndIncrement()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber<T>[]> r2 = r1.subscribers
            java.lang.Object r0 = r2.get()
            io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[] r0 = (io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[]) r0
            r3 = 1
            r4 = r0
            r5 = 1
        L_0x0014:
            java.lang.Object r0 = r1.terminalEvent
            io.reactivex.internal.fuseable.SimpleQueue<T> r6 = r1.queue
            if (r6 == 0) goto L_0x0023
            boolean r8 = r6.isEmpty()
            if (r8 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r8 = 0
            goto L_0x0024
        L_0x0023:
            r8 = 1
        L_0x0024:
            boolean r0 = r1.checkTerminated(r0, r8)
            if (r0 == 0) goto L_0x002b
            return
        L_0x002b:
            if (r8 != 0) goto L_0x0154
            int r0 = r4.length
            int r9 = r4.length
            r12 = 0
            r13 = 0
            r14 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x0036:
            r16 = -9223372036854775808
            if (r12 >= r9) goto L_0x0052
            r7 = r4[r12]
            long r18 = r7.get()
            int r20 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r20 == 0) goto L_0x004d
            long r10 = r7.emitted
            long r10 = r18 - r10
            long r14 = java.lang.Math.min(r14, r10)
            goto L_0x004f
        L_0x004d:
            int r13 = r13 + 1
        L_0x004f:
            int r12 = r12 + 1
            goto L_0x0036
        L_0x0052:
            r9 = 1
            if (r0 != r13) goto L_0x0090
            java.lang.Object r0 = r1.terminalEvent
            java.lang.Object r7 = r6.poll()     // Catch:{ all -> 0x005d }
            goto L_0x0074
        L_0x005d:
            r0 = move-exception
            r6 = r0
            th.de.o.qw.ad(r6)
            java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.upstream
            java.lang.Object r0 = r0.get()
            org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
            r0.cancel()
            java.lang.Object r0 = io.reactivex.internal.util.NotificationLite.error(r6)
            r1.terminalEvent = r0
            r7 = 0
        L_0x0074:
            if (r7 != 0) goto L_0x0078
            r7 = 1
            goto L_0x0079
        L_0x0078:
            r7 = 0
        L_0x0079:
            boolean r0 = r1.checkTerminated(r0, r7)
            if (r0 == 0) goto L_0x0080
            return
        L_0x0080:
            int r0 = r1.sourceMode
            if (r0 == r3) goto L_0x0014
            java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.upstream
            java.lang.Object r0 = r0.get()
            org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
            r0.request(r9)
            goto L_0x0014
        L_0x0090:
            r11 = 0
        L_0x0091:
            long r12 = (long) r11
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 >= 0) goto L_0x0136
            java.lang.Object r0 = r1.terminalEvent
            java.lang.Object r8 = r6.poll()     // Catch:{ all -> 0x009d }
            goto L_0x00b4
        L_0x009d:
            r0 = move-exception
            r8 = r0
            th.de.o.qw.ad(r8)
            java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.upstream
            java.lang.Object r0 = r0.get()
            org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
            r0.cancel()
            java.lang.Object r0 = io.reactivex.internal.util.NotificationLite.error(r8)
            r1.terminalEvent = r0
            r8 = 0
        L_0x00b4:
            if (r8 != 0) goto L_0x00b8
            r7 = 1
            goto L_0x00b9
        L_0x00b8:
            r7 = 0
        L_0x00b9:
            boolean r0 = r1.checkTerminated(r0, r7)
            if (r0 == 0) goto L_0x00c0
            return
        L_0x00c0:
            if (r7 == 0) goto L_0x00c5
            r8 = r7
            goto L_0x0136
        L_0x00c5:
            java.lang.Object r0 = io.reactivex.internal.util.NotificationLite.getValue(r8)
            int r8 = r4.length
            r12 = 0
            r13 = 0
        L_0x00cc:
            if (r12 >= r8) goto L_0x0102
            r3 = r4[r12]
            long r22 = r3.get()
            int r24 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
            if (r24 == 0) goto L_0x00f0
            r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r24 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
            r22 = r6
            r23 = r7
            if (r24 == 0) goto L_0x00ea
            long r6 = r3.emitted
            long r6 = r6 + r9
            r3.emitted = r6
        L_0x00ea:
            org.reactivestreams.Subscriber<? super T> r3 = r3.child
            r3.onNext(r0)
            goto L_0x00fa
        L_0x00f0:
            r22 = r6
            r23 = r7
            r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r13 = 1
        L_0x00fa:
            int r12 = r12 + 1
            r6 = r22
            r7 = r23
            r3 = 1
            goto L_0x00cc
        L_0x0102:
            r22 = r6
            r23 = r7
            r20 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r11 = r11 + 1
            java.lang.Object r0 = r2.get()
            io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[] r0 = (io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[]) r0
            if (r13 != 0) goto L_0x011f
            if (r0 == r4) goto L_0x0118
            goto L_0x011f
        L_0x0118:
            r6 = r22
            r8 = r23
            r3 = 1
            goto L_0x0091
        L_0x011f:
            if (r11 == 0) goto L_0x0132
            int r3 = r1.sourceMode
            r4 = 1
            if (r3 == r4) goto L_0x0132
            java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r3 = r1.upstream
            java.lang.Object r3 = r3.get()
            org.reactivestreams.Subscription r3 = (org.reactivestreams.Subscription) r3
            long r6 = (long) r11
            r3.request(r6)
        L_0x0132:
            r4 = r0
            r3 = 1
            goto L_0x0014
        L_0x0136:
            if (r11 == 0) goto L_0x0149
            int r0 = r1.sourceMode
            r3 = 1
            if (r0 == r3) goto L_0x014a
            java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.upstream
            java.lang.Object r0 = r0.get()
            org.reactivestreams.Subscription r0 = (org.reactivestreams.Subscription) r0
            r0.request(r12)
            goto L_0x014a
        L_0x0149:
            r3 = 1
        L_0x014a:
            r6 = 0
            int r0 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0154
            if (r8 != 0) goto L_0x0154
            goto L_0x0014
        L_0x0154:
            int r0 = -r5
            int r5 = r1.addAndGet(r0)
            if (r5 != 0) goto L_0x015c
            return
        L_0x015c:
            java.lang.Object r0 = r2.get()
            r4 = r0
            io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[] r4 = (io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber[]) r4
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber.dispatch():void");
    }

    public void dispose() {
        FlowablePublish$InnerSubscriber<T>[] flowablePublish$InnerSubscriberArr = this.subscribers.get();
        FlowablePublish$InnerSubscriber<T>[] flowablePublish$InnerSubscriberArr2 = TERMINATED;
        if (flowablePublish$InnerSubscriberArr != flowablePublish$InnerSubscriberArr2 && ((FlowablePublish$InnerSubscriber[]) this.subscribers.getAndSet(flowablePublish$InnerSubscriberArr2)) != TERMINATED) {
            this.current.compareAndSet(this, (Object) null);
            SubscriptionHelper.cancel(this.upstream);
        }
    }

    public boolean isDisposed() {
        return this.subscribers.get() == TERMINATED;
    }

    public void onComplete() {
        if (this.terminalEvent == null) {
            this.terminalEvent = NotificationLite.complete();
            dispatch();
        }
    }

    public void onError(Throwable th2) {
        if (this.terminalEvent == null) {
            this.terminalEvent = NotificationLite.error(th2);
            dispatch();
            return;
        }
        qw.ddd(th2);
    }

    public void onNext(T t) {
        if (this.sourceMode != 0 || this.queue.offer(t)) {
            dispatch();
        } else {
            onError(new MissingBackpressureException("Prefetch queue is full?!"));
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int requestFusion = queueSubscription.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = queueSubscription;
                    this.terminalEvent = NotificationLite.complete();
                    dispatch();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = queueSubscription;
                    subscription.request((long) this.bufferSize);
                    return;
                }
            }
            this.queue = new SpscArrayQueue(this.bufferSize);
            subscription.request((long) this.bufferSize);
        }
    }

    public void remove(FlowablePublish$InnerSubscriber<T> flowablePublish$InnerSubscriber) {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr;
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr2;
        do {
            flowablePublish$InnerSubscriberArr = (FlowablePublish$InnerSubscriber[]) this.subscribers.get();
            int length = flowablePublish$InnerSubscriberArr.length;
            if (length != 0) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (flowablePublish$InnerSubscriberArr[i3].equals(flowablePublish$InnerSubscriber)) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        flowablePublish$InnerSubscriberArr2 = EMPTY;
                    } else {
                        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArr3 = new FlowablePublish$InnerSubscriber[(length - 1)];
                        System.arraycopy(flowablePublish$InnerSubscriberArr, 0, flowablePublish$InnerSubscriberArr3, 0, i2);
                        System.arraycopy(flowablePublish$InnerSubscriberArr, i2 + 1, flowablePublish$InnerSubscriberArr3, i2, (length - i2) - 1);
                        flowablePublish$InnerSubscriberArr2 = flowablePublish$InnerSubscriberArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.subscribers.compareAndSet(flowablePublish$InnerSubscriberArr, flowablePublish$InnerSubscriberArr2));
    }
}
