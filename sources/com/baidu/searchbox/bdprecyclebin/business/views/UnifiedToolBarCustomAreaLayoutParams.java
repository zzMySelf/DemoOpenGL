package com.baidu.searchbox.bdprecyclebin.business.views;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/bdprecyclebin/business/views/UnifiedToolBarCustomAreaLayoutParams;", "", "marginLeft", "", "marginBottom", "heightOfViewport", "(III)V", "getHeightOfViewport", "()I", "getMarginBottom", "getMarginLeft", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-bdprecyclebin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnifiedFloatBackButtonUtils.kt */
public final class UnifiedToolBarCustomAreaLayoutParams {
    private final int heightOfViewport;
    private final int marginBottom;
    private final int marginLeft;

    public static /* synthetic */ UnifiedToolBarCustomAreaLayoutParams copy$default(UnifiedToolBarCustomAreaLayoutParams unifiedToolBarCustomAreaLayoutParams, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = unifiedToolBarCustomAreaLayoutParams.marginLeft;
        }
        if ((i5 & 2) != 0) {
            i3 = unifiedToolBarCustomAreaLayoutParams.marginBottom;
        }
        if ((i5 & 4) != 0) {
            i4 = unifiedToolBarCustomAreaLayoutParams.heightOfViewport;
        }
        return unifiedToolBarCustomAreaLayoutParams.copy(i2, i3, i4);
    }

    public final int component1() {
        return this.marginLeft;
    }

    public final int component2() {
        return this.marginBottom;
    }

    public final int component3() {
        return this.heightOfViewport;
    }

    public final UnifiedToolBarCustomAreaLayoutParams copy(int i2, int i3, int i4) {
        return new UnifiedToolBarCustomAreaLayoutParams(i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnifiedToolBarCustomAreaLayoutParams)) {
            return false;
        }
        UnifiedToolBarCustomAreaLayoutParams unifiedToolBarCustomAreaLayoutParams = (UnifiedToolBarCustomAreaLayoutParams) obj;
        return this.marginLeft == unifiedToolBarCustomAreaLayoutParams.marginLeft && this.marginBottom == unifiedToolBarCustomAreaLayoutParams.marginBottom && this.heightOfViewport == unifiedToolBarCustomAreaLayoutParams.heightOfViewport;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.marginLeft) * 31) + Integer.hashCode(this.marginBottom)) * 31) + Integer.hashCode(this.heightOfViewport);
    }

    public String toString() {
        return "UnifiedToolBarCustomAreaLayoutParams(marginLeft=" + this.marginLeft + ", marginBottom=" + this.marginBottom + ", heightOfViewport=" + this.heightOfViewport + ')';
    }

    public UnifiedToolBarCustomAreaLayoutParams(int marginLeft2, int marginBottom2, int heightOfViewport2) {
        this.marginLeft = marginLeft2;
        this.marginBottom = marginBottom2;
        this.heightOfViewport = heightOfViewport2;
    }

    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getHeightOfViewport() {
        return this.heightOfViewport;
    }
}
