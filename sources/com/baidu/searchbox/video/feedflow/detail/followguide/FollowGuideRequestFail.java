package com.baidu.searchbox.video.feedflow.detail.followguide;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/followguide/FollowGuideRequestFail;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "useLastPlan", "", "(Z)V", "getUseLastPlan", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: FollowBtnActionManifest.kt */
public final class FollowGuideRequestFail implements Action {
    private final boolean useLastPlan;

    public FollowGuideRequestFail() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FollowGuideRequestFail copy$default(FollowGuideRequestFail followGuideRequestFail, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = followGuideRequestFail.useLastPlan;
        }
        return followGuideRequestFail.copy(z);
    }

    public final boolean component1() {
        return this.useLastPlan;
    }

    public final FollowGuideRequestFail copy(boolean z) {
        return new FollowGuideRequestFail(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FollowGuideRequestFail) && this.useLastPlan == ((FollowGuideRequestFail) obj).useLastPlan;
    }

    public int hashCode() {
        boolean z = this.useLastPlan;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "FollowGuideRequestFail(useLastPlan=" + this.useLastPlan + ')';
    }

    public FollowGuideRequestFail(boolean useLastPlan2) {
        this.useLastPlan = useLastPlan2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FollowGuideRequestFail(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z);
    }

    public final boolean getUseLastPlan() {
        return this.useLastPlan;
    }
}
