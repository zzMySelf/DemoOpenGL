package com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall;

import com.baidu.searchbox.feed.detail.arch.ext.ForeverAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/shortplay/autounlockall/ShortPlayAutoUnlockAllAction;", "Lcom/baidu/searchbox/feed/detail/arch/ext/ForeverAction;", "isUnlockAllSuccess", "", "collId", "", "(ZLjava/lang/String;)V", "getCollId", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayAutoUnlockAllActionManifest.kt */
public final class ShortPlayAutoUnlockAllAction implements ForeverAction {
    private final String collId;
    private final boolean isUnlockAllSuccess;

    public static /* synthetic */ ShortPlayAutoUnlockAllAction copy$default(ShortPlayAutoUnlockAllAction shortPlayAutoUnlockAllAction, boolean z, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = shortPlayAutoUnlockAllAction.isUnlockAllSuccess;
        }
        if ((i2 & 2) != 0) {
            str = shortPlayAutoUnlockAllAction.collId;
        }
        return shortPlayAutoUnlockAllAction.copy(z, str);
    }

    public final boolean component1() {
        return this.isUnlockAllSuccess;
    }

    public final String component2() {
        return this.collId;
    }

    public final ShortPlayAutoUnlockAllAction copy(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "collId");
        return new ShortPlayAutoUnlockAllAction(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShortPlayAutoUnlockAllAction)) {
            return false;
        }
        ShortPlayAutoUnlockAllAction shortPlayAutoUnlockAllAction = (ShortPlayAutoUnlockAllAction) obj;
        return this.isUnlockAllSuccess == shortPlayAutoUnlockAllAction.isUnlockAllSuccess && Intrinsics.areEqual((Object) this.collId, (Object) shortPlayAutoUnlockAllAction.collId);
    }

    public int hashCode() {
        boolean z = this.isUnlockAllSuccess;
        if (z) {
            z = true;
        }
        return ((z ? 1 : 0) * true) + this.collId.hashCode();
    }

    public String toString() {
        return "ShortPlayAutoUnlockAllAction(isUnlockAllSuccess=" + this.isUnlockAllSuccess + ", collId=" + this.collId + ')';
    }

    public ShortPlayAutoUnlockAllAction(boolean isUnlockAllSuccess2, String collId2) {
        Intrinsics.checkNotNullParameter(collId2, "collId");
        this.isUnlockAllSuccess = isUnlockAllSuccess2;
        this.collId = collId2;
    }

    public final boolean isUnlockAllSuccess() {
        return this.isUnlockAllSuccess;
    }

    public final String getCollId() {
        return this.collId;
    }
}
