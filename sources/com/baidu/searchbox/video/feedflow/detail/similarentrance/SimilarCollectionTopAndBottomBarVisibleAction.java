package com.baidu.searchbox.video.feedflow.detail.similarentrance;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/similarentrance/SimilarCollectionTopAndBottomBarVisibleAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "isVisible", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: SimilarCollectionManifest.kt */
public final class SimilarCollectionTopAndBottomBarVisibleAction implements Action {
    private final boolean isVisible;

    public static /* synthetic */ SimilarCollectionTopAndBottomBarVisibleAction copy$default(SimilarCollectionTopAndBottomBarVisibleAction similarCollectionTopAndBottomBarVisibleAction, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = similarCollectionTopAndBottomBarVisibleAction.isVisible;
        }
        return similarCollectionTopAndBottomBarVisibleAction.copy(z);
    }

    public final boolean component1() {
        return this.isVisible;
    }

    public final SimilarCollectionTopAndBottomBarVisibleAction copy(boolean z) {
        return new SimilarCollectionTopAndBottomBarVisibleAction(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SimilarCollectionTopAndBottomBarVisibleAction) && this.isVisible == ((SimilarCollectionTopAndBottomBarVisibleAction) obj).isVisible;
    }

    public int hashCode() {
        boolean z = this.isVisible;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "SimilarCollectionTopAndBottomBarVisibleAction(isVisible=" + this.isVisible + ')';
    }

    public SimilarCollectionTopAndBottomBarVisibleAction(boolean isVisible2) {
        this.isVisible = isVisible2;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }
}
