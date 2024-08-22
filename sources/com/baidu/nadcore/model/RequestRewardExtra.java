package com.baidu.nadcore.model;

import com.baidu.searchbox.account.im.GroupMemberAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/nadcore/model/RequestRewardExtra;", "", "sessionCount", "", "rewardCount", "(II)V", "getRewardCount", "()I", "getSessionCount", "component1", "component2", "copy", "equals", "", "other", "getSessionInfo", "", "hashCode", "toString", "nadcore-lib-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdRewardVideoLpModel.kt */
public final class RequestRewardExtra {
    private final int rewardCount;
    private final int sessionCount;

    public static /* synthetic */ RequestRewardExtra copy$default(RequestRewardExtra requestRewardExtra, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = requestRewardExtra.sessionCount;
        }
        if ((i4 & 2) != 0) {
            i3 = requestRewardExtra.rewardCount;
        }
        return requestRewardExtra.copy(i2, i3);
    }

    public final int component1() {
        return this.sessionCount;
    }

    public final int component2() {
        return this.rewardCount;
    }

    public final RequestRewardExtra copy(int i2, int i3) {
        return new RequestRewardExtra(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestRewardExtra)) {
            return false;
        }
        RequestRewardExtra requestRewardExtra = (RequestRewardExtra) obj;
        return this.sessionCount == requestRewardExtra.sessionCount && this.rewardCount == requestRewardExtra.rewardCount;
    }

    public int hashCode() {
        return (Integer.hashCode(this.sessionCount) * 31) + Integer.hashCode(this.rewardCount);
    }

    public String toString() {
        return "RequestRewardExtra(sessionCount=" + this.sessionCount + ", rewardCount=" + this.rewardCount + ')';
    }

    public RequestRewardExtra(int sessionCount2, int rewardCount2) {
        this.sessionCount = sessionCount2;
        this.rewardCount = rewardCount2;
    }

    public final int getRewardCount() {
        return this.rewardCount;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }

    public final String getSessionInfo() {
        String sb = new StringBuilder().append(this.sessionCount).append(GroupMemberAdapter.MANAGER_CHAR).append(this.rewardCount).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().append(s…d(rewardCount).toString()");
        return sb;
    }
}
