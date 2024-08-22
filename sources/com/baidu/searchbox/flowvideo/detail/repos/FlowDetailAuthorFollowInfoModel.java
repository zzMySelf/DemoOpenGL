package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ugc.model.UgcConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0002\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u000fJ\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailAuthorFollowInfoModel;", "Lcom/baidu/searchbox/NoProGuard;", "isFollow", "", "follow", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailAuthorFollowInfoExtModel;", "(Ljava/lang/String;Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailAuthorFollowInfoExtModel;)V", "getFollow", "()Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailAuthorFollowInfoExtModel;", "setFollow", "(Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailAuthorFollowInfoExtModel;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "notifyFollowStatus", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class FlowDetailAuthorFollowInfoModel implements NoProGuard {
    private FlowDetailAuthorFollowInfoExtModel follow;
    private String isFollow;

    public FlowDetailAuthorFollowInfoModel() {
        this((String) null, (FlowDetailAuthorFollowInfoExtModel) null, 3, (DefaultConstructorMarker) null);
    }

    private final String component1() {
        return this.isFollow;
    }

    public static /* synthetic */ FlowDetailAuthorFollowInfoModel copy$default(FlowDetailAuthorFollowInfoModel flowDetailAuthorFollowInfoModel, String str, FlowDetailAuthorFollowInfoExtModel flowDetailAuthorFollowInfoExtModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = flowDetailAuthorFollowInfoModel.isFollow;
        }
        if ((i2 & 2) != 0) {
            flowDetailAuthorFollowInfoExtModel = flowDetailAuthorFollowInfoModel.follow;
        }
        return flowDetailAuthorFollowInfoModel.copy(str, flowDetailAuthorFollowInfoExtModel);
    }

    public final FlowDetailAuthorFollowInfoExtModel component2() {
        return this.follow;
    }

    public final FlowDetailAuthorFollowInfoModel copy(String str, FlowDetailAuthorFollowInfoExtModel flowDetailAuthorFollowInfoExtModel) {
        Intrinsics.checkNotNullParameter(str, UgcConstant.UGC_CAPTURE_FOLLOW);
        return new FlowDetailAuthorFollowInfoModel(str, flowDetailAuthorFollowInfoExtModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowDetailAuthorFollowInfoModel)) {
            return false;
        }
        FlowDetailAuthorFollowInfoModel flowDetailAuthorFollowInfoModel = (FlowDetailAuthorFollowInfoModel) obj;
        return Intrinsics.areEqual((Object) this.isFollow, (Object) flowDetailAuthorFollowInfoModel.isFollow) && Intrinsics.areEqual((Object) this.follow, (Object) flowDetailAuthorFollowInfoModel.follow);
    }

    public int hashCode() {
        int hashCode = this.isFollow.hashCode() * 31;
        FlowDetailAuthorFollowInfoExtModel flowDetailAuthorFollowInfoExtModel = this.follow;
        return hashCode + (flowDetailAuthorFollowInfoExtModel == null ? 0 : flowDetailAuthorFollowInfoExtModel.hashCode());
    }

    public String toString() {
        return "FlowDetailAuthorFollowInfoModel(isFollow=" + this.isFollow + ", follow=" + this.follow + ')';
    }

    public FlowDetailAuthorFollowInfoModel(String isFollow2, FlowDetailAuthorFollowInfoExtModel follow2) {
        Intrinsics.checkNotNullParameter(isFollow2, UgcConstant.UGC_CAPTURE_FOLLOW);
        this.isFollow = isFollow2;
        this.follow = follow2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowDetailAuthorFollowInfoModel(String str, FlowDetailAuthorFollowInfoExtModel flowDetailAuthorFollowInfoExtModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : flowDetailAuthorFollowInfoExtModel);
    }

    public final FlowDetailAuthorFollowInfoExtModel getFollow() {
        return this.follow;
    }

    public final void setFollow(FlowDetailAuthorFollowInfoExtModel flowDetailAuthorFollowInfoExtModel) {
        this.follow = flowDetailAuthorFollowInfoExtModel;
    }

    public final boolean isFollow() {
        return Intrinsics.areEqual((Object) this.isFollow, (Object) "1");
    }

    public final void notifyFollowStatus(boolean isFollow2) {
        this.isFollow = isFollow2 ? "1" : "0";
    }
}
