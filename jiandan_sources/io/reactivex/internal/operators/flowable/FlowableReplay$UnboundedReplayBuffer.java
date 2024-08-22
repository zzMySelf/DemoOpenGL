package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import th.de.p039if.fe.ad.o;

public final class FlowableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements o<T> {
    public static final long serialVersionUID = 7063189396499112664L;
    public volatile int size;

    public FlowableReplay$UnboundedReplayBuffer(int i2) {
        super(i2);
    }

    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    public void error(Throwable th2) {
        add(NotificationLite.error(th2));
        this.size++;
    }

    public void next(T t) {
        add(NotificationLite.next(t));
        this.size++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r15.isDisposed() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        r1 = r14.size;
        r2 = (java.lang.Integer) r15.index();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        if (r2 == null) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        r2 = r2.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        r4 = r15.get();
        r8 = r4;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r8 == 0) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r2 >= r1) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        r12 = get(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        if (io.reactivex.internal.util.NotificationLite.accept(r12, r0) == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        if (r15.isDisposed() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        r2 = r2 + 1;
        r8 = r8 - 1;
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        th.de.o.qw.ad(r1);
        r15.dispose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
        if (io.reactivex.internal.util.NotificationLite.isError(r12) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0061, code lost:
        r0.onError(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0067, code lost:
        if (r10 == 0) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0069, code lost:
        r15.index = java.lang.Integer.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        if (r4 == Long.MAX_VALUE) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
        r15.produced(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007b, code lost:
        monitor-enter(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007e, code lost:
        if (r15.missed != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0080, code lost:
        r15.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0083, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0084, code lost:
        r15.missed = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0086, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        r0 = r15.child;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription<T> r15) {
        /*
            r14 = this;
            monitor-enter(r15)
            boolean r0 = r15.emitting     // Catch:{ all -> 0x008b }
            r1 = 1
            if (r0 == 0) goto L_0x000a
            r15.missed = r1     // Catch:{ all -> 0x008b }
            monitor-exit(r15)     // Catch:{ all -> 0x008b }
            return
        L_0x000a:
            r15.emitting = r1     // Catch:{ all -> 0x008b }
            monitor-exit(r15)     // Catch:{ all -> 0x008b }
            org.reactivestreams.Subscriber<? super T> r0 = r15.child
        L_0x000f:
            boolean r1 = r15.isDisposed()
            if (r1 == 0) goto L_0x0016
            return
        L_0x0016:
            int r1 = r14.size
            java.lang.Object r2 = r15.index()
            java.lang.Integer r2 = (java.lang.Integer) r2
            r3 = 0
            if (r2 == 0) goto L_0x0026
            int r2 = r2.intValue()
            goto L_0x0027
        L_0x0026:
            r2 = 0
        L_0x0027:
            long r4 = r15.get()
            r6 = 0
            r8 = r4
            r10 = r6
        L_0x002f:
            int r12 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0065
            if (r2 >= r1) goto L_0x0065
            java.lang.Object r12 = r14.get(r2)
            boolean r12 = io.reactivex.internal.util.NotificationLite.accept((java.lang.Object) r12, r0)     // Catch:{ all -> 0x004e }
            if (r12 == 0) goto L_0x0040
            return
        L_0x0040:
            boolean r12 = r15.isDisposed()
            if (r12 == 0) goto L_0x0047
            return
        L_0x0047:
            int r2 = r2 + 1
            r12 = 1
            long r8 = r8 - r12
            long r10 = r10 + r12
            goto L_0x002f
        L_0x004e:
            r1 = move-exception
            th.de.o.qw.ad(r1)
            r15.dispose()
            boolean r15 = io.reactivex.internal.util.NotificationLite.isError(r12)
            if (r15 != 0) goto L_0x0064
            boolean r15 = io.reactivex.internal.util.NotificationLite.isComplete(r12)
            if (r15 != 0) goto L_0x0064
            r0.onError(r1)
        L_0x0064:
            return
        L_0x0065:
            int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x007b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r15.index = r1
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x007b
            r15.produced(r10)
        L_0x007b:
            monitor-enter(r15)
            boolean r1 = r15.missed     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x0084
            r15.emitting = r3     // Catch:{ all -> 0x0088 }
            monitor-exit(r15)     // Catch:{ all -> 0x0088 }
            return
        L_0x0084:
            r15.missed = r3     // Catch:{ all -> 0x0088 }
            monitor-exit(r15)     // Catch:{ all -> 0x0088 }
            goto L_0x000f
        L_0x0088:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0088 }
            throw r0
        L_0x008b:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x008b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay$UnboundedReplayBuffer.replay(io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription):void");
    }
}
