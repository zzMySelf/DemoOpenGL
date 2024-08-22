package com.baidu.searchbox.video.feedflow.detail.bottomdiversion;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/bottomdiversion/BottomDiversionTransitionModel;", "", "style", "", "duration", "delay", "(III)V", "getDelay", "()I", "getDuration", "getStyle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomDiversionModel.kt */
public final class BottomDiversionTransitionModel {
    private final int delay;
    private final int duration;
    private final int style;

    public BottomDiversionTransitionModel() {
        this(0, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BottomDiversionTransitionModel copy$default(BottomDiversionTransitionModel bottomDiversionTransitionModel, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = bottomDiversionTransitionModel.style;
        }
        if ((i5 & 2) != 0) {
            i3 = bottomDiversionTransitionModel.duration;
        }
        if ((i5 & 4) != 0) {
            i4 = bottomDiversionTransitionModel.delay;
        }
        return bottomDiversionTransitionModel.copy(i2, i3, i4);
    }

    public final int component1() {
        return this.style;
    }

    public final int component2() {
        return this.duration;
    }

    public final int component3() {
        return this.delay;
    }

    public final BottomDiversionTransitionModel copy(int i2, int i3, int i4) {
        return new BottomDiversionTransitionModel(i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomDiversionTransitionModel)) {
            return false;
        }
        BottomDiversionTransitionModel bottomDiversionTransitionModel = (BottomDiversionTransitionModel) obj;
        return this.style == bottomDiversionTransitionModel.style && this.duration == bottomDiversionTransitionModel.duration && this.delay == bottomDiversionTransitionModel.delay;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.style) * 31) + Integer.hashCode(this.duration)) * 31) + Integer.hashCode(this.delay);
    }

    public String toString() {
        return "BottomDiversionTransitionModel(style=" + this.style + ", duration=" + this.duration + ", delay=" + this.delay + ')';
    }

    public BottomDiversionTransitionModel(int style2, int duration2, int delay2) {
        this.style = style2;
        this.duration = duration2;
        this.delay = delay2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomDiversionTransitionModel(int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i2, (i5 & 2) != 0 ? 0 : i3, (i5 & 4) != 0 ? 0 : i4);
    }

    public final int getStyle() {
        return this.style;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getDelay() {
        return this.delay;
    }
}
