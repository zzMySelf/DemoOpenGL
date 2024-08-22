package com.baidu.searchbox.player.control.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/player/control/model/FollowInfo;", "", "isFollow", "", "fansNum", "", "followExtInfo", "Lcom/baidu/searchbox/player/control/model/FollowExtInfo;", "(ZILcom/baidu/searchbox/player/control/model/FollowExtInfo;)V", "getFansNum", "()I", "setFansNum", "(I)V", "getFollowExtInfo", "()Lcom/baidu/searchbox/player/control/model/FollowExtInfo;", "setFollowExtInfo", "(Lcom/baidu/searchbox/player/control/model/FollowExtInfo;)V", "()Z", "setFollow", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanControlConfig.kt */
public final class FollowInfo {
    private int fansNum;
    private FollowExtInfo followExtInfo;
    private boolean isFollow;

    public FollowInfo() {
        this(false, 0, (FollowExtInfo) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FollowInfo copy$default(FollowInfo followInfo, boolean z, int i2, FollowExtInfo followExtInfo2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = followInfo.isFollow;
        }
        if ((i3 & 2) != 0) {
            i2 = followInfo.fansNum;
        }
        if ((i3 & 4) != 0) {
            followExtInfo2 = followInfo.followExtInfo;
        }
        return followInfo.copy(z, i2, followExtInfo2);
    }

    public final boolean component1() {
        return this.isFollow;
    }

    public final int component2() {
        return this.fansNum;
    }

    public final FollowExtInfo component3() {
        return this.followExtInfo;
    }

    public final FollowInfo copy(boolean z, int i2, FollowExtInfo followExtInfo2) {
        return new FollowInfo(z, i2, followExtInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FollowInfo)) {
            return false;
        }
        FollowInfo followInfo = (FollowInfo) obj;
        return this.isFollow == followInfo.isFollow && this.fansNum == followInfo.fansNum && Intrinsics.areEqual((Object) this.followExtInfo, (Object) followInfo.followExtInfo);
    }

    public int hashCode() {
        boolean z = this.isFollow;
        if (z) {
            z = true;
        }
        int hashCode = (((z ? 1 : 0) * true) + Integer.hashCode(this.fansNum)) * 31;
        FollowExtInfo followExtInfo2 = this.followExtInfo;
        return hashCode + (followExtInfo2 == null ? 0 : followExtInfo2.hashCode());
    }

    public String toString() {
        return "FollowInfo(isFollow=" + this.isFollow + ", fansNum=" + this.fansNum + ", followExtInfo=" + this.followExtInfo + ')';
    }

    public FollowInfo(boolean isFollow2, int fansNum2, FollowExtInfo followExtInfo2) {
        this.isFollow = isFollow2;
        this.fansNum = fansNum2;
        this.followExtInfo = followExtInfo2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FollowInfo(boolean z, int i2, FollowExtInfo followExtInfo2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : followExtInfo2);
    }

    public final boolean isFollow() {
        return this.isFollow;
    }

    public final void setFollow(boolean z) {
        this.isFollow = z;
    }

    public final int getFansNum() {
        return this.fansNum;
    }

    public final void setFansNum(int i2) {
        this.fansNum = i2;
    }

    public final FollowExtInfo getFollowExtInfo() {
        return this.followExtInfo;
    }

    public final void setFollowExtInfo(FollowExtInfo followExtInfo2) {
        this.followExtInfo = followExtInfo2;
    }
}
