package com.baidu.browser.explore.safeguard.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/baidu/browser/explore/safeguard/view/PromptListParams;", "", "space", "", "lrEdge", "itemParams", "Lcom/baidu/browser/explore/safeguard/view/PromptItemParams;", "(FFLcom/baidu/browser/explore/safeguard/view/PromptItemParams;)V", "getItemParams", "()Lcom/baidu/browser/explore/safeguard/view/PromptItemParams;", "getLrEdge", "()F", "getSpace", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PromptListView.kt */
public final class PromptListParams {
    private final PromptItemParams itemParams;
    private final float lrEdge;
    private final float space;

    public static /* synthetic */ PromptListParams copy$default(PromptListParams promptListParams, float f2, float f3, PromptItemParams promptItemParams, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = promptListParams.space;
        }
        if ((i2 & 2) != 0) {
            f3 = promptListParams.lrEdge;
        }
        if ((i2 & 4) != 0) {
            promptItemParams = promptListParams.itemParams;
        }
        return promptListParams.copy(f2, f3, promptItemParams);
    }

    public final float component1() {
        return this.space;
    }

    public final float component2() {
        return this.lrEdge;
    }

    public final PromptItemParams component3() {
        return this.itemParams;
    }

    public final PromptListParams copy(float f2, float f3, PromptItemParams promptItemParams) {
        Intrinsics.checkNotNullParameter(promptItemParams, "itemParams");
        return new PromptListParams(f2, f3, promptItemParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromptListParams)) {
            return false;
        }
        PromptListParams promptListParams = (PromptListParams) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.space), (Object) Float.valueOf(promptListParams.space)) && Intrinsics.areEqual((Object) Float.valueOf(this.lrEdge), (Object) Float.valueOf(promptListParams.lrEdge)) && Intrinsics.areEqual((Object) this.itemParams, (Object) promptListParams.itemParams);
    }

    public int hashCode() {
        return (((Float.hashCode(this.space) * 31) + Float.hashCode(this.lrEdge)) * 31) + this.itemParams.hashCode();
    }

    public String toString() {
        return "PromptListParams(space=" + this.space + ", lrEdge=" + this.lrEdge + ", itemParams=" + this.itemParams + ')';
    }

    public PromptListParams(float space2, float lrEdge2, PromptItemParams itemParams2) {
        Intrinsics.checkNotNullParameter(itemParams2, "itemParams");
        this.space = space2;
        this.lrEdge = lrEdge2;
        this.itemParams = itemParams2;
    }

    public final float getSpace() {
        return this.space;
    }

    public final float getLrEdge() {
        return this.lrEdge;
    }

    public final PromptItemParams getItemParams() {
        return this.itemParams;
    }
}
