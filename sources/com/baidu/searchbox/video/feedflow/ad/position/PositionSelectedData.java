package com.baidu.searchbox.video.feedflow.ad.position;

import com.baidu.searchbox.ad.position.strategy.IAdPosStrategyTrigger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/position/PositionSelectedData;", "", "position", "", "isUp", "", "triggerCase", "Lcom/baidu/searchbox/ad/position/strategy/IAdPosStrategyTrigger;", "(IZLcom/baidu/searchbox/ad/position/strategy/IAdPosStrategyTrigger;)V", "()Z", "getPosition", "()I", "getTriggerCase", "()Lcom/baidu/searchbox/ad/position/strategy/IAdPosStrategyTrigger;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdPositionActionManifest.kt */
public final class PositionSelectedData {
    private final boolean isUp;
    private final int position;
    private final IAdPosStrategyTrigger triggerCase;

    public static /* synthetic */ PositionSelectedData copy$default(PositionSelectedData positionSelectedData, int i2, boolean z, IAdPosStrategyTrigger iAdPosStrategyTrigger, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = positionSelectedData.position;
        }
        if ((i3 & 2) != 0) {
            z = positionSelectedData.isUp;
        }
        if ((i3 & 4) != 0) {
            iAdPosStrategyTrigger = positionSelectedData.triggerCase;
        }
        return positionSelectedData.copy(i2, z, iAdPosStrategyTrigger);
    }

    public final int component1() {
        return this.position;
    }

    public final boolean component2() {
        return this.isUp;
    }

    public final IAdPosStrategyTrigger component3() {
        return this.triggerCase;
    }

    public final PositionSelectedData copy(int i2, boolean z, IAdPosStrategyTrigger iAdPosStrategyTrigger) {
        Intrinsics.checkNotNullParameter(iAdPosStrategyTrigger, "triggerCase");
        return new PositionSelectedData(i2, z, iAdPosStrategyTrigger);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PositionSelectedData)) {
            return false;
        }
        PositionSelectedData positionSelectedData = (PositionSelectedData) obj;
        return this.position == positionSelectedData.position && this.isUp == positionSelectedData.isUp && Intrinsics.areEqual((Object) this.triggerCase, (Object) positionSelectedData.triggerCase);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.position) * 31;
        boolean z = this.isUp;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.triggerCase.hashCode();
    }

    public String toString() {
        return "PositionSelectedData(position=" + this.position + ", isUp=" + this.isUp + ", triggerCase=" + this.triggerCase + ')';
    }

    public PositionSelectedData(int position2, boolean isUp2, IAdPosStrategyTrigger triggerCase2) {
        Intrinsics.checkNotNullParameter(triggerCase2, "triggerCase");
        this.position = position2;
        this.isUp = isUp2;
        this.triggerCase = triggerCase2;
    }

    public final int getPosition() {
        return this.position;
    }

    public final IAdPosStrategyTrigger getTriggerCase() {
        return this.triggerCase;
    }

    public final boolean isUp() {
        return this.isUp;
    }
}
