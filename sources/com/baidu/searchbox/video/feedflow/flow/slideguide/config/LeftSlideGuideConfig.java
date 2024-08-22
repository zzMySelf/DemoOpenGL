package com.baidu.searchbox.video.feedflow.flow.slideguide.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/slideguide/config/LeftSlideGuideConfig;", "", "playTime", "", "playPercentage", "", "photoClickNoSlideCount", "(IFI)V", "getPhotoClickNoSlideCount", "()I", "getPlayPercentage", "()F", "getPlayTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeftSlideGuideConfig.kt */
public final class LeftSlideGuideConfig {
    private final int photoClickNoSlideCount;
    private final float playPercentage;
    private final int playTime;

    public LeftSlideGuideConfig() {
        this(0, 0.0f, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LeftSlideGuideConfig copy$default(LeftSlideGuideConfig leftSlideGuideConfig, int i2, float f2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = leftSlideGuideConfig.playTime;
        }
        if ((i4 & 2) != 0) {
            f2 = leftSlideGuideConfig.playPercentage;
        }
        if ((i4 & 4) != 0) {
            i3 = leftSlideGuideConfig.photoClickNoSlideCount;
        }
        return leftSlideGuideConfig.copy(i2, f2, i3);
    }

    public final int component1() {
        return this.playTime;
    }

    public final float component2() {
        return this.playPercentage;
    }

    public final int component3() {
        return this.photoClickNoSlideCount;
    }

    public final LeftSlideGuideConfig copy(int i2, float f2, int i3) {
        return new LeftSlideGuideConfig(i2, f2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LeftSlideGuideConfig)) {
            return false;
        }
        LeftSlideGuideConfig leftSlideGuideConfig = (LeftSlideGuideConfig) obj;
        return this.playTime == leftSlideGuideConfig.playTime && Intrinsics.areEqual((Object) Float.valueOf(this.playPercentage), (Object) Float.valueOf(leftSlideGuideConfig.playPercentage)) && this.photoClickNoSlideCount == leftSlideGuideConfig.photoClickNoSlideCount;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.playTime) * 31) + Float.hashCode(this.playPercentage)) * 31) + Integer.hashCode(this.photoClickNoSlideCount);
    }

    public String toString() {
        return "LeftSlideGuideConfig(playTime=" + this.playTime + ", playPercentage=" + this.playPercentage + ", photoClickNoSlideCount=" + this.photoClickNoSlideCount + ')';
    }

    public LeftSlideGuideConfig(int playTime2, float playPercentage2, int photoClickNoSlideCount2) {
        this.playTime = playTime2;
        this.playPercentage = playPercentage2;
        this.photoClickNoSlideCount = photoClickNoSlideCount2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LeftSlideGuideConfig(int i2, float f2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0.0f : f2, (i4 & 4) != 0 ? 2 : i3);
    }

    public final int getPlayTime() {
        return this.playTime;
    }

    public final float getPlayPercentage() {
        return this.playPercentage;
    }

    public final int getPhotoClickNoSlideCount() {
        return this.photoClickNoSlideCount;
    }
}
