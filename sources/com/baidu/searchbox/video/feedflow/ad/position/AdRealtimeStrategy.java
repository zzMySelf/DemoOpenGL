package com.baidu.searchbox.video.feedflow.ad.position;

import com.baidu.searchbox.video.feedflow.ad.realtime.AdRealTimeStrategyManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/position/AdRealtimeStrategy;", "Lcom/baidu/searchbox/video/feedflow/ad/position/AdPositionAction;", "strategy", "Lcom/baidu/searchbox/video/feedflow/ad/realtime/AdRealTimeStrategyManager$AdRealTimeStrategy;", "avgUgcTime", "", "avgAdTime", "avgUgcProgress", "commonDelayTime", "", "(Lcom/baidu/searchbox/video/feedflow/ad/realtime/AdRealTimeStrategyManager$AdRealTimeStrategy;FFFJ)V", "getAvgAdTime", "()F", "getAvgUgcProgress", "getAvgUgcTime", "getCommonDelayTime", "()J", "getStrategy", "()Lcom/baidu/searchbox/video/feedflow/ad/realtime/AdRealTimeStrategyManager$AdRealTimeStrategy;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdPositionActionManifest.kt */
public final class AdRealtimeStrategy extends AdPositionAction {
    private final float avgAdTime;
    private final float avgUgcProgress;
    private final float avgUgcTime;
    private final long commonDelayTime;
    private final AdRealTimeStrategyManager.AdRealTimeStrategy strategy;

    public static /* synthetic */ AdRealtimeStrategy copy$default(AdRealtimeStrategy adRealtimeStrategy, AdRealTimeStrategyManager.AdRealTimeStrategy adRealTimeStrategy, float f2, float f3, float f4, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            adRealTimeStrategy = adRealtimeStrategy.strategy;
        }
        if ((i2 & 2) != 0) {
            f2 = adRealtimeStrategy.avgUgcTime;
        }
        float f5 = f2;
        if ((i2 & 4) != 0) {
            f3 = adRealtimeStrategy.avgAdTime;
        }
        float f6 = f3;
        if ((i2 & 8) != 0) {
            f4 = adRealtimeStrategy.avgUgcProgress;
        }
        float f7 = f4;
        if ((i2 & 16) != 0) {
            j2 = adRealtimeStrategy.commonDelayTime;
        }
        return adRealtimeStrategy.copy(adRealTimeStrategy, f5, f6, f7, j2);
    }

    public final AdRealTimeStrategyManager.AdRealTimeStrategy component1() {
        return this.strategy;
    }

    public final float component2() {
        return this.avgUgcTime;
    }

    public final float component3() {
        return this.avgAdTime;
    }

    public final float component4() {
        return this.avgUgcProgress;
    }

    public final long component5() {
        return this.commonDelayTime;
    }

    public final AdRealtimeStrategy copy(AdRealTimeStrategyManager.AdRealTimeStrategy adRealTimeStrategy, float f2, float f3, float f4, long j2) {
        Intrinsics.checkNotNullParameter(adRealTimeStrategy, "strategy");
        return new AdRealtimeStrategy(adRealTimeStrategy, f2, f3, f4, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdRealtimeStrategy)) {
            return false;
        }
        AdRealtimeStrategy adRealtimeStrategy = (AdRealtimeStrategy) obj;
        return Intrinsics.areEqual((Object) this.strategy, (Object) adRealtimeStrategy.strategy) && Intrinsics.areEqual((Object) Float.valueOf(this.avgUgcTime), (Object) Float.valueOf(adRealtimeStrategy.avgUgcTime)) && Intrinsics.areEqual((Object) Float.valueOf(this.avgAdTime), (Object) Float.valueOf(adRealtimeStrategy.avgAdTime)) && Intrinsics.areEqual((Object) Float.valueOf(this.avgUgcProgress), (Object) Float.valueOf(adRealtimeStrategy.avgUgcProgress)) && this.commonDelayTime == adRealtimeStrategy.commonDelayTime;
    }

    public int hashCode() {
        return (((((((this.strategy.hashCode() * 31) + Float.hashCode(this.avgUgcTime)) * 31) + Float.hashCode(this.avgAdTime)) * 31) + Float.hashCode(this.avgUgcProgress)) * 31) + Long.hashCode(this.commonDelayTime);
    }

    public String toString() {
        return "AdRealtimeStrategy(strategy=" + this.strategy + ", avgUgcTime=" + this.avgUgcTime + ", avgAdTime=" + this.avgAdTime + ", avgUgcProgress=" + this.avgUgcProgress + ", commonDelayTime=" + this.commonDelayTime + ')';
    }

    public final AdRealTimeStrategyManager.AdRealTimeStrategy getStrategy() {
        return this.strategy;
    }

    public final float getAvgUgcTime() {
        return this.avgUgcTime;
    }

    public final float getAvgAdTime() {
        return this.avgAdTime;
    }

    public final float getAvgUgcProgress() {
        return this.avgUgcProgress;
    }

    public AdRealtimeStrategy(AdRealTimeStrategyManager.AdRealTimeStrategy strategy2, float avgUgcTime2, float avgAdTime2, float avgUgcProgress2, long commonDelayTime2) {
        Intrinsics.checkNotNullParameter(strategy2, "strategy");
        this.strategy = strategy2;
        this.avgUgcTime = avgUgcTime2;
        this.avgAdTime = avgAdTime2;
        this.avgUgcProgress = avgUgcProgress2;
        this.commonDelayTime = commonDelayTime2;
    }

    public final long getCommonDelayTime() {
        return this.commonDelayTime;
    }
}
