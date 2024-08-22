package com.baidu.searchbox.video.feedflow.utils;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/utils/WaterMarkClipParam;", "", "isWaterMark", "", "minWHRadio", "Lkotlin/Pair;", "", "clipMaxPercent", "", "(ZLkotlin/Pair;F)V", "getClipMaxPercent", "()F", "()Z", "getMinWHRadio", "()Lkotlin/Pair;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowPlayerClipStrategy.kt */
public final class WaterMarkClipParam {
    private final float clipMaxPercent;
    private final boolean isWaterMark;
    private final Pair<Integer, Integer> minWHRadio;

    public WaterMarkClipParam() {
        this(false, (Pair) null, 0.0f, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WaterMarkClipParam copy$default(WaterMarkClipParam waterMarkClipParam, boolean z, Pair<Integer, Integer> pair, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = waterMarkClipParam.isWaterMark;
        }
        if ((i2 & 2) != 0) {
            pair = waterMarkClipParam.minWHRadio;
        }
        if ((i2 & 4) != 0) {
            f2 = waterMarkClipParam.clipMaxPercent;
        }
        return waterMarkClipParam.copy(z, pair, f2);
    }

    public final boolean component1() {
        return this.isWaterMark;
    }

    public final Pair<Integer, Integer> component2() {
        return this.minWHRadio;
    }

    public final float component3() {
        return this.clipMaxPercent;
    }

    public final WaterMarkClipParam copy(boolean z, Pair<Integer, Integer> pair, float f2) {
        return new WaterMarkClipParam(z, pair, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WaterMarkClipParam)) {
            return false;
        }
        WaterMarkClipParam waterMarkClipParam = (WaterMarkClipParam) obj;
        return this.isWaterMark == waterMarkClipParam.isWaterMark && Intrinsics.areEqual((Object) this.minWHRadio, (Object) waterMarkClipParam.minWHRadio) && Intrinsics.areEqual((Object) Float.valueOf(this.clipMaxPercent), (Object) Float.valueOf(waterMarkClipParam.clipMaxPercent));
    }

    public int hashCode() {
        boolean z = this.isWaterMark;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        Pair<Integer, Integer> pair = this.minWHRadio;
        return ((i2 + (pair == null ? 0 : pair.hashCode())) * 31) + Float.hashCode(this.clipMaxPercent);
    }

    public String toString() {
        return "WaterMarkClipParam(isWaterMark=" + this.isWaterMark + ", minWHRadio=" + this.minWHRadio + ", clipMaxPercent=" + this.clipMaxPercent + ')';
    }

    public WaterMarkClipParam(boolean isWaterMark2, Pair<Integer, Integer> minWHRadio2, float clipMaxPercent2) {
        this.isWaterMark = isWaterMark2;
        this.minWHRadio = minWHRadio2;
        this.clipMaxPercent = clipMaxPercent2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WaterMarkClipParam(boolean z, Pair pair, float f2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? null : pair, (i2 & 4) != 0 ? 0.075f : f2);
    }

    public final boolean isWaterMark() {
        return this.isWaterMark;
    }

    public final Pair<Integer, Integer> getMinWHRadio() {
        return this.minWHRadio;
    }

    public final float getClipMaxPercent() {
        return this.clipMaxPercent;
    }
}
