package com.baidu.searchbox.ugc.category.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/ugc/category/model/LabelPoint;", "", "labelGroupIndex", "", "labelItemIndex", "(II)V", "getLabelGroupIndex", "()I", "setLabelGroupIndex", "(I)V", "getLabelItemIndex", "setLabelItemIndex", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CategoryModel.kt */
public final class LabelPoint {
    private int labelGroupIndex;
    private int labelItemIndex;

    public LabelPoint() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LabelPoint copy$default(LabelPoint labelPoint, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = labelPoint.labelGroupIndex;
        }
        if ((i4 & 2) != 0) {
            i3 = labelPoint.labelItemIndex;
        }
        return labelPoint.copy(i2, i3);
    }

    public final int component1() {
        return this.labelGroupIndex;
    }

    public final int component2() {
        return this.labelItemIndex;
    }

    public final LabelPoint copy(int i2, int i3) {
        return new LabelPoint(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LabelPoint)) {
            return false;
        }
        LabelPoint labelPoint = (LabelPoint) obj;
        return this.labelGroupIndex == labelPoint.labelGroupIndex && this.labelItemIndex == labelPoint.labelItemIndex;
    }

    public int hashCode() {
        return (Integer.hashCode(this.labelGroupIndex) * 31) + Integer.hashCode(this.labelItemIndex);
    }

    public String toString() {
        return "LabelPoint(labelGroupIndex=" + this.labelGroupIndex + ", labelItemIndex=" + this.labelItemIndex + ')';
    }

    public LabelPoint(int labelGroupIndex2, int labelItemIndex2) {
        this.labelGroupIndex = labelGroupIndex2;
        this.labelItemIndex = labelItemIndex2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LabelPoint(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? -1 : i2, (i4 & 2) != 0 ? -1 : i3);
    }

    public final int getLabelGroupIndex() {
        return this.labelGroupIndex;
    }

    public final void setLabelGroupIndex(int i2) {
        this.labelGroupIndex = i2;
    }

    public final int getLabelItemIndex() {
        return this.labelItemIndex;
    }

    public final void setLabelItemIndex(int i2) {
        this.labelItemIndex = i2;
    }
}
