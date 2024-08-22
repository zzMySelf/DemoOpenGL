package com.baidu.searchbox.video.feedflow.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/utils/ViewLayoutDetector;", "", "height", "", "top", "(II)V", "getHeight", "()I", "setHeight", "(I)V", "getTop", "setTop", "clear", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "isChanged", "newHeight", "newTop", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewLayoutDetector.kt */
public final class ViewLayoutDetector {
    private int height;
    private int top;

    public ViewLayoutDetector() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ViewLayoutDetector copy$default(ViewLayoutDetector viewLayoutDetector, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = viewLayoutDetector.height;
        }
        if ((i4 & 2) != 0) {
            i3 = viewLayoutDetector.top;
        }
        return viewLayoutDetector.copy(i2, i3);
    }

    public final int component1() {
        return this.height;
    }

    public final int component2() {
        return this.top;
    }

    public final ViewLayoutDetector copy(int i2, int i3) {
        return new ViewLayoutDetector(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewLayoutDetector)) {
            return false;
        }
        ViewLayoutDetector viewLayoutDetector = (ViewLayoutDetector) obj;
        return this.height == viewLayoutDetector.height && this.top == viewLayoutDetector.top;
    }

    public int hashCode() {
        return (Integer.hashCode(this.height) * 31) + Integer.hashCode(this.top);
    }

    public String toString() {
        return "ViewLayoutDetector(height=" + this.height + ", top=" + this.top + ')';
    }

    public ViewLayoutDetector(int height2, int top2) {
        this.height = height2;
        this.top = top2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewLayoutDetector(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i2, (i4 & 2) != 0 ? -1 : i3);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getTop() {
        return this.top;
    }

    public final void setHeight(int i2) {
        this.height = i2;
    }

    public final void setTop(int i2) {
        this.top = i2;
    }

    public static /* synthetic */ boolean isChanged$default(ViewLayoutDetector viewLayoutDetector, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        return viewLayoutDetector.isChanged(i2, i3);
    }

    public final boolean isChanged(int newHeight, int newTop) {
        if (newHeight == this.height && newTop == this.top) {
            return false;
        }
        this.height = newHeight;
        this.top = newTop;
        return true;
    }

    public final void clear() {
        this.height = -1;
        this.top = -1;
    }
}
