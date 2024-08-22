package com.baidu.searchbox.video.component.reward;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/component/reward/RewardCompleteAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "toast", "", "amount", "", "rewardCount", "(Ljava/lang/String;JLjava/lang/String;)V", "getAmount", "()J", "getRewardCount", "()Ljava/lang/String;", "getToast", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-video-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UnicastAction
/* compiled from: RewardActonManifest.kt */
public final class RewardCompleteAction implements Action {
    private final long amount;
    private final String rewardCount;
    private final String toast;

    public static /* synthetic */ RewardCompleteAction copy$default(RewardCompleteAction rewardCompleteAction, String str, long j2, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rewardCompleteAction.toast;
        }
        if ((i2 & 2) != 0) {
            j2 = rewardCompleteAction.amount;
        }
        if ((i2 & 4) != 0) {
            str2 = rewardCompleteAction.rewardCount;
        }
        return rewardCompleteAction.copy(str, j2, str2);
    }

    public final String component1() {
        return this.toast;
    }

    public final long component2() {
        return this.amount;
    }

    public final String component3() {
        return this.rewardCount;
    }

    public final RewardCompleteAction copy(String str, long j2, String str2) {
        Intrinsics.checkNotNullParameter(str, "toast");
        return new RewardCompleteAction(str, j2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardCompleteAction)) {
            return false;
        }
        RewardCompleteAction rewardCompleteAction = (RewardCompleteAction) obj;
        return Intrinsics.areEqual((Object) this.toast, (Object) rewardCompleteAction.toast) && this.amount == rewardCompleteAction.amount && Intrinsics.areEqual((Object) this.rewardCount, (Object) rewardCompleteAction.rewardCount);
    }

    public int hashCode() {
        int hashCode = ((this.toast.hashCode() * 31) + Long.hashCode(this.amount)) * 31;
        String str = this.rewardCount;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RewardCompleteAction(toast=" + this.toast + ", amount=" + this.amount + ", rewardCount=" + this.rewardCount + ')';
    }

    public RewardCompleteAction(String toast2, long amount2, String rewardCount2) {
        Intrinsics.checkNotNullParameter(toast2, "toast");
        this.toast = toast2;
        this.amount = amount2;
        this.rewardCount = rewardCount2;
    }

    public final long getAmount() {
        return this.amount;
    }

    public final String getRewardCount() {
        return this.rewardCount;
    }

    public final String getToast() {
        return this.toast;
    }
}
