package com.baidu.searchbox.video.feedflow.detail.favor;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.ext.common.NetCheckAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/favor/FavorIconClickAction;", "Lcom/baidu/searchbox/feed/detail/ext/common/NetCheckAction;", "isFromLongClick", "", "(Z)V", "()Z", "setFromLongClick", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: FavorActionManifest.kt */
public final class FavorIconClickAction implements NetCheckAction {
    private boolean isFromLongClick;

    public FavorIconClickAction() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FavorIconClickAction copy$default(FavorIconClickAction favorIconClickAction, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = favorIconClickAction.isFromLongClick;
        }
        return favorIconClickAction.copy(z);
    }

    public final boolean component1() {
        return this.isFromLongClick;
    }

    public final FavorIconClickAction copy(boolean z) {
        return new FavorIconClickAction(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FavorIconClickAction) && this.isFromLongClick == ((FavorIconClickAction) obj).isFromLongClick;
    }

    public int hashCode() {
        boolean z = this.isFromLongClick;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "FavorIconClickAction(isFromLongClick=" + this.isFromLongClick + ')';
    }

    public FavorIconClickAction(boolean isFromLongClick2) {
        this.isFromLongClick = isFromLongClick2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FavorIconClickAction(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z);
    }

    public final boolean isFromLongClick() {
        return this.isFromLongClick;
    }

    public final void setFromLongClick(boolean z) {
        this.isFromLongClick = z;
    }
}
