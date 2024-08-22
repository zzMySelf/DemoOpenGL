package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u000eJ\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/FollowArouseModel;", "Lcom/baidu/searchbox/NoProGuard;", "subscribeNum", "", "isAuthorFiltered", "", "(ILjava/lang/String;)V", "()Ljava/lang/String;", "getSubscribeNum", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "isAuthorDisallowShowFollowArous", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class FollowArouseModel implements NoProGuard {
    private final String isAuthorFiltered;
    private final int subscribeNum;

    public FollowArouseModel() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FollowArouseModel copy$default(FollowArouseModel followArouseModel, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = followArouseModel.subscribeNum;
        }
        if ((i3 & 2) != 0) {
            str = followArouseModel.isAuthorFiltered;
        }
        return followArouseModel.copy(i2, str);
    }

    public final int component1() {
        return this.subscribeNum;
    }

    public final String component2() {
        return this.isAuthorFiltered;
    }

    public final FollowArouseModel copy(int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "isAuthorFiltered");
        return new FollowArouseModel(i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowArouseModel)) {
            return false;
        }
        FollowArouseModel followArouseModel = (FollowArouseModel) obj;
        return this.subscribeNum == followArouseModel.subscribeNum && Intrinsics.areEqual((Object) this.isAuthorFiltered, (Object) followArouseModel.isAuthorFiltered);
    }

    public int hashCode() {
        return (Integer.hashCode(this.subscribeNum) * 31) + this.isAuthorFiltered.hashCode();
    }

    public String toString() {
        return "FollowArouseModel(subscribeNum=" + this.subscribeNum + ", isAuthorFiltered=" + this.isAuthorFiltered + ')';
    }

    public FollowArouseModel(int subscribeNum2, String isAuthorFiltered2) {
        Intrinsics.checkNotNullParameter(isAuthorFiltered2, "isAuthorFiltered");
        this.subscribeNum = subscribeNum2;
        this.isAuthorFiltered = isAuthorFiltered2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FollowArouseModel(int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? "" : str);
    }

    public final int getSubscribeNum() {
        return this.subscribeNum;
    }

    public final String isAuthorFiltered() {
        return this.isAuthorFiltered;
    }

    public final boolean isAuthorDisallowShowFollowArous() {
        return Intrinsics.areEqual((Object) this.isAuthorFiltered, (Object) "1");
    }
}
