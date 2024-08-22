package com.baidu.growthsystem.wealth.video.component.status.running;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/growthsystem/wealth/video/component/status/running/ProcessData;", "", "rate", "", "total", "", "(FJ)V", "getRate", "()F", "getTotal", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubRunningData.kt */
public final class ProcessData {
    private final float rate;
    private final long total;

    public static /* synthetic */ ProcessData copy$default(ProcessData processData, float f2, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = processData.rate;
        }
        if ((i2 & 2) != 0) {
            j2 = processData.total;
        }
        return processData.copy(f2, j2);
    }

    public final float component1() {
        return this.rate;
    }

    public final long component2() {
        return this.total;
    }

    public final ProcessData copy(float f2, long j2) {
        return new ProcessData(f2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProcessData)) {
            return false;
        }
        ProcessData processData = (ProcessData) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.rate), (Object) Float.valueOf(processData.rate)) && this.total == processData.total;
    }

    public int hashCode() {
        return (Float.hashCode(this.rate) * 31) + Long.hashCode(this.total);
    }

    public String toString() {
        return "ProcessData(rate=" + this.rate + ", total=" + this.total + ')';
    }

    public ProcessData(float rate2, long total2) {
        this.rate = rate2;
        this.total = total2;
    }

    public final float getRate() {
        return this.rate;
    }

    public final long getTotal() {
        return this.total;
    }
}
