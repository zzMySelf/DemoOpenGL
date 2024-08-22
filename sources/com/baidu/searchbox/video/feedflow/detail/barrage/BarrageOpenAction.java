package com.baidu.searchbox.video.feedflow.detail.barrage;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollInterceptAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/barrage/BarrageOpenAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "Lcom/baidu/searchbox/video/feedflow/flow/list/ScrollInterceptAction;", "open", "", "(Z)V", "getOpen", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: BarrageActionManifest.kt */
public final class BarrageOpenAction implements Action, ScrollInterceptAction {
    private final boolean open;

    public BarrageOpenAction() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BarrageOpenAction copy$default(BarrageOpenAction barrageOpenAction, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = barrageOpenAction.open;
        }
        return barrageOpenAction.copy(z);
    }

    public final boolean component1() {
        return this.open;
    }

    public final BarrageOpenAction copy(boolean z) {
        return new BarrageOpenAction(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BarrageOpenAction) && this.open == ((BarrageOpenAction) obj).open;
    }

    public int hashCode() {
        boolean z = this.open;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "BarrageOpenAction(open=" + this.open + ')';
    }

    public BarrageOpenAction(boolean open2) {
        this.open = open2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BarrageOpenAction(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z);
    }

    public final boolean getOpen() {
        return this.open;
    }
}
