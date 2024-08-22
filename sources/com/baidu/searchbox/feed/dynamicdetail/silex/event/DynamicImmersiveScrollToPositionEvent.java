package com.baidu.searchbox.feed.dynamicdetail.silex.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/silex/event/DynamicImmersiveScrollToPositionEvent;", "", "position", "", "isSmooth", "", "(IZ)V", "()Z", "getPosition", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersiveScrollToPositionEvent.kt */
public final class DynamicImmersiveScrollToPositionEvent {
    private final boolean isSmooth;
    private final int position;

    public static /* synthetic */ DynamicImmersiveScrollToPositionEvent copy$default(DynamicImmersiveScrollToPositionEvent dynamicImmersiveScrollToPositionEvent, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = dynamicImmersiveScrollToPositionEvent.position;
        }
        if ((i3 & 2) != 0) {
            z = dynamicImmersiveScrollToPositionEvent.isSmooth;
        }
        return dynamicImmersiveScrollToPositionEvent.copy(i2, z);
    }

    public final int component1() {
        return this.position;
    }

    public final boolean component2() {
        return this.isSmooth;
    }

    public final DynamicImmersiveScrollToPositionEvent copy(int i2, boolean z) {
        return new DynamicImmersiveScrollToPositionEvent(i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicImmersiveScrollToPositionEvent)) {
            return false;
        }
        DynamicImmersiveScrollToPositionEvent dynamicImmersiveScrollToPositionEvent = (DynamicImmersiveScrollToPositionEvent) obj;
        return this.position == dynamicImmersiveScrollToPositionEvent.position && this.isSmooth == dynamicImmersiveScrollToPositionEvent.isSmooth;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.position) * 31;
        boolean z = this.isSmooth;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "DynamicImmersiveScrollToPositionEvent(position=" + this.position + ", isSmooth=" + this.isSmooth + ')';
    }

    public DynamicImmersiveScrollToPositionEvent(int position2, boolean isSmooth2) {
        this.position = position2;
        this.isSmooth = isSmooth2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DynamicImmersiveScrollToPositionEvent(int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? true : z);
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean isSmooth() {
        return this.isSmooth;
    }
}
