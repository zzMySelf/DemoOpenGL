package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import th.de.p039if.fe.ad.o;

public class FlowableReplay$BoundedReplayBuffer<T> extends AtomicReference<FlowableReplay$Node> implements o<T> {
    public static final long serialVersionUID = 2346567790059478686L;
    public long index;
    public int size;
    public FlowableReplay$Node tail;

    public FlowableReplay$BoundedReplayBuffer() {
        FlowableReplay$Node flowableReplay$Node = new FlowableReplay$Node((Object) null, 0);
        this.tail = flowableReplay$Node;
        set(flowableReplay$Node);
    }

    public final void addLast(FlowableReplay$Node flowableReplay$Node) {
        this.tail.set(flowableReplay$Node);
        this.tail = flowableReplay$Node;
        this.size++;
    }

    public final void collect(Collection<? super T> collection) {
        FlowableReplay$Node head = getHead();
        while (true) {
            head = (FlowableReplay$Node) head.get();
            if (head != null) {
                Object leaveTransform = leaveTransform(head.value);
                if (!NotificationLite.isComplete(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                    collection.add(NotificationLite.getValue(leaveTransform));
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void complete() {
        Object enterTransform = enterTransform(NotificationLite.complete());
        long j = this.index + 1;
        this.index = j;
        addLast(new FlowableReplay$Node(enterTransform, j));
        truncateFinal();
    }

    public Object enterTransform(Object obj) {
        return obj;
    }

    public final void error(Throwable th2) {
        Object enterTransform = enterTransform(NotificationLite.error(th2));
        long j = this.index + 1;
        this.index = j;
        addLast(new FlowableReplay$Node(enterTransform, j));
        truncateFinal();
    }

    public FlowableReplay$Node getHead() {
        return (FlowableReplay$Node) get();
    }

    public boolean hasCompleted() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isComplete(leaveTransform(obj));
    }

    public boolean hasError() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isError(leaveTransform(obj));
    }

    public Object leaveTransform(Object obj) {
        return obj;
    }

    public final void next(T t) {
        Object enterTransform = enterTransform(NotificationLite.next(t));
        long j = this.index + 1;
        this.index = j;
        addLast(new FlowableReplay$Node(enterTransform, j));
        truncate();
    }

    public final void removeFirst() {
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node) ((FlowableReplay$Node) get()).get();
        if (flowableReplay$Node != null) {
            this.size--;
            setFirst(flowableReplay$Node);
            return;
        }
        throw new IllegalStateException("Empty list!");
    }

    public final void removeSome(int i2) {
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node) get();
        while (i2 > 0) {
            flowableReplay$Node = (FlowableReplay$Node) flowableReplay$Node.get();
            i2--;
            this.size--;
        }
        setFirst(flowableReplay$Node);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        if (r15.isDisposed() == false) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        r15.index = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r3 = r15.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (r3 != Long.MAX_VALUE) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
        r6 = (io.reactivex.internal.operators.flowable.FlowableReplay$Node) r15.index();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r6 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        r6 = getHead();
        r15.index = r6;
        th.de.p039if.yj.qw.qw(r15.totalRequested, r6.index);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0042, code lost:
        if (r3 == 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        r11 = (io.reactivex.internal.operators.flowable.FlowableReplay$Node) r6.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r11 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        r6 = leaveTransform(r11.value);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (io.reactivex.internal.util.NotificationLite.accept(r6, r15.child) == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        r15.index = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005d, code lost:
        r9 = r9 + 1;
        r3 = r3 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0065, code lost:
        if (r15.isDisposed() == false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0067, code lost:
        r15.index = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0069, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006a, code lost:
        r6 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006d, code lost:
        th.de.o.qw.ad(r0);
        r15.index = null;
        r15.dispose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0079, code lost:
        if (io.reactivex.internal.util.NotificationLite.isError(r6) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0081, code lost:
        r15.child.onError(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0089, code lost:
        if (r9 == 0) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
        r15.index = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008d, code lost:
        if (r5 != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008f, code lost:
        r15.produced(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0092, code lost:
        monitor-enter(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0095, code lost:
        if (r15.missed != false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0097, code lost:
        r15.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0099, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009b, code lost:
        r15.missed = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009d, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription<T> r15) {
        /*
            r14 = this;
            monitor-enter(r15)
            boolean r0 = r15.emitting     // Catch:{ all -> 0x00a3 }
            r1 = 1
            if (r0 == 0) goto L_0x000a
            r15.missed = r1     // Catch:{ all -> 0x00a3 }
            monitor-exit(r15)     // Catch:{ all -> 0x00a3 }
            return
        L_0x000a:
            r15.emitting = r1     // Catch:{ all -> 0x00a3 }
            monitor-exit(r15)     // Catch:{ all -> 0x00a3 }
        L_0x000d:
            boolean r0 = r15.isDisposed()
            r2 = 0
            if (r0 == 0) goto L_0x0017
            r15.index = r2
            return
        L_0x0017:
            long r3 = r15.get()
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r0 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0027
            r5 = 1
            goto L_0x0028
        L_0x0027:
            r5 = 0
        L_0x0028:
            java.lang.Object r6 = r15.index()
            io.reactivex.internal.operators.flowable.FlowableReplay$Node r6 = (io.reactivex.internal.operators.flowable.FlowableReplay$Node) r6
            r7 = 0
            if (r6 != 0) goto L_0x003f
            io.reactivex.internal.operators.flowable.FlowableReplay$Node r6 = r14.getHead()
            r15.index = r6
            java.util.concurrent.atomic.AtomicLong r9 = r15.totalRequested
            long r10 = r6.index
            th.de.p039if.yj.qw.qw(r9, r10)
        L_0x003f:
            r9 = r7
        L_0x0040:
            int r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x0087
            java.lang.Object r11 = r6.get()
            io.reactivex.internal.operators.flowable.FlowableReplay$Node r11 = (io.reactivex.internal.operators.flowable.FlowableReplay$Node) r11
            if (r11 == 0) goto L_0x0087
            java.lang.Object r6 = r11.value
            java.lang.Object r6 = r14.leaveTransform(r6)
            org.reactivestreams.Subscriber<? super T> r12 = r15.child     // Catch:{ all -> 0x006c }
            boolean r12 = io.reactivex.internal.util.NotificationLite.accept((java.lang.Object) r6, r12)     // Catch:{ all -> 0x006c }
            if (r12 == 0) goto L_0x005d
            r15.index = r2     // Catch:{ all -> 0x006c }
            return
        L_0x005d:
            r12 = 1
            long r9 = r9 + r12
            long r3 = r3 - r12
            boolean r6 = r15.isDisposed()
            if (r6 == 0) goto L_0x006a
            r15.index = r2
            return
        L_0x006a:
            r6 = r11
            goto L_0x0040
        L_0x006c:
            r0 = move-exception
            th.de.o.qw.ad(r0)
            r15.index = r2
            r15.dispose()
            boolean r1 = io.reactivex.internal.util.NotificationLite.isError(r6)
            if (r1 != 0) goto L_0x0086
            boolean r1 = io.reactivex.internal.util.NotificationLite.isComplete(r6)
            if (r1 != 0) goto L_0x0086
            org.reactivestreams.Subscriber<? super T> r15 = r15.child
            r15.onError(r0)
        L_0x0086:
            return
        L_0x0087:
            int r2 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x0092
            r15.index = r6
            if (r5 != 0) goto L_0x0092
            r15.produced(r9)
        L_0x0092:
            monitor-enter(r15)
            boolean r2 = r15.missed     // Catch:{ all -> 0x00a0 }
            if (r2 != 0) goto L_0x009b
            r15.emitting = r0     // Catch:{ all -> 0x00a0 }
            monitor-exit(r15)     // Catch:{ all -> 0x00a0 }
            return
        L_0x009b:
            r15.missed = r0     // Catch:{ all -> 0x00a0 }
            monitor-exit(r15)     // Catch:{ all -> 0x00a0 }
            goto L_0x000d
        L_0x00a0:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x00a0 }
            throw r0
        L_0x00a3:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x00a3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer.replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
    }

    public final void setFirst(FlowableReplay$Node flowableReplay$Node) {
        set(flowableReplay$Node);
    }

    public final void trimHead() {
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node) get();
        if (flowableReplay$Node.value != null) {
            FlowableReplay$Node flowableReplay$Node2 = new FlowableReplay$Node((Object) null, 0);
            flowableReplay$Node2.lazySet(flowableReplay$Node.get());
            set(flowableReplay$Node2);
        }
    }

    public void truncate() {
    }

    public void truncateFinal() {
        trimHead();
    }
}
