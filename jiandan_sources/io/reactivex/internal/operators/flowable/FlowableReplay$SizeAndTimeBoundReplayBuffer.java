package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;
import th.de.th;
import th.de.vvv.ad;

public final class FlowableReplay$SizeAndTimeBoundReplayBuffer<T> extends FlowableReplay$BoundedReplayBuffer<T> {
    public static final long serialVersionUID = 3457957419649567404L;
    public final int limit;
    public final long maxAge;
    public final th scheduler;
    public final TimeUnit unit;

    public FlowableReplay$SizeAndTimeBoundReplayBuffer(int i2, long j, TimeUnit timeUnit, th thVar) {
        this.scheduler = thVar;
        this.limit = i2;
        this.maxAge = j;
        this.unit = timeUnit;
    }

    public Object enterTransform(Object obj) {
        return new ad(obj, this.scheduler.ad(this.unit), this.unit);
    }

    public FlowableReplay$Node getHead() {
        FlowableReplay$Node flowableReplay$Node;
        long ad2 = this.scheduler.ad(this.unit) - this.maxAge;
        FlowableReplay$Node flowableReplay$Node2 = (FlowableReplay$Node) get();
        Object obj = flowableReplay$Node2.get();
        while (true) {
            FlowableReplay$Node flowableReplay$Node3 = (FlowableReplay$Node) obj;
            flowableReplay$Node = flowableReplay$Node2;
            flowableReplay$Node2 = flowableReplay$Node3;
            if (flowableReplay$Node2 != null) {
                ad adVar = (ad) flowableReplay$Node2.value;
                if (NotificationLite.isComplete(adVar.ad()) || NotificationLite.isError(adVar.ad()) || adVar.qw() > ad2) {
                    break;
                }
                obj = flowableReplay$Node2.get();
            } else {
                break;
            }
        }
        return flowableReplay$Node;
    }

    public Object leaveTransform(Object obj) {
        return ((ad) obj).ad();
    }

    public void truncate() {
        FlowableReplay$Node flowableReplay$Node;
        long ad2 = this.scheduler.ad(this.unit) - this.maxAge;
        FlowableReplay$Node flowableReplay$Node2 = (FlowableReplay$Node) get();
        FlowableReplay$Node flowableReplay$Node3 = (FlowableReplay$Node) flowableReplay$Node2.get();
        int i2 = 0;
        while (true) {
            FlowableReplay$Node flowableReplay$Node4 = flowableReplay$Node3;
            flowableReplay$Node = flowableReplay$Node2;
            flowableReplay$Node2 = flowableReplay$Node4;
            if (flowableReplay$Node2 != null) {
                int i3 = this.size;
                if (i3 <= this.limit) {
                    if (((ad) flowableReplay$Node2.value).qw() > ad2) {
                        break;
                    }
                    i2++;
                    this.size--;
                    flowableReplay$Node3 = (FlowableReplay$Node) flowableReplay$Node2.get();
                } else {
                    i2++;
                    this.size = i3 - 1;
                    flowableReplay$Node3 = (FlowableReplay$Node) flowableReplay$Node2.get();
                }
            } else {
                break;
            }
        }
        if (i2 != 0) {
            setFirst(flowableReplay$Node);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void truncateFinal() {
        /*
            r10 = this;
            th.de.th r0 = r10.scheduler
            java.util.concurrent.TimeUnit r1 = r10.unit
            long r0 = r0.ad(r1)
            long r2 = r10.maxAge
            long r0 = r0 - r2
            java.lang.Object r2 = r10.get()
            io.reactivex.internal.operators.flowable.FlowableReplay$Node r2 = (io.reactivex.internal.operators.flowable.FlowableReplay$Node) r2
            java.lang.Object r3 = r2.get()
            io.reactivex.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.internal.operators.flowable.FlowableReplay$Node) r3
            r4 = 0
        L_0x0018:
            r9 = r3
            r3 = r2
            r2 = r9
            if (r2 == 0) goto L_0x003c
            int r5 = r10.size
            r6 = 1
            if (r5 <= r6) goto L_0x003c
            java.lang.Object r5 = r2.value
            th.de.vvv.ad r5 = (th.de.vvv.ad) r5
            long r7 = r5.qw()
            int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r5 > 0) goto L_0x003c
            int r4 = r4 + 1
            int r3 = r10.size
            int r3 = r3 - r6
            r10.size = r3
            java.lang.Object r3 = r2.get()
            io.reactivex.internal.operators.flowable.FlowableReplay$Node r3 = (io.reactivex.internal.operators.flowable.FlowableReplay$Node) r3
            goto L_0x0018
        L_0x003c:
            if (r4 == 0) goto L_0x0041
            r10.setFirst(r3)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableReplay$SizeAndTimeBoundReplayBuffer.truncateFinal():void");
    }
}
