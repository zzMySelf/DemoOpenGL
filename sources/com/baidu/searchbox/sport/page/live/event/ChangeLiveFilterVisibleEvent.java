package com.baidu.searchbox.sport.page.live.event;

import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/sport/page/live/event/ChangeLiveFilterVisibleEvent;", "", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "enableForceStatus", "", "getEnableForceStatus", "()Z", "setEnableForceStatus", "(Z)V", "forceVisibleState", "getForceVisibleState", "setForceVisibleState", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveFilterEvent.kt */
public final class ChangeLiveFilterVisibleEvent {
    private boolean enableForceStatus;
    private boolean forceVisibleState;
    private final UniqueId token;

    public static /* synthetic */ ChangeLiveFilterVisibleEvent copy$default(ChangeLiveFilterVisibleEvent changeLiveFilterVisibleEvent, UniqueId uniqueId, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uniqueId = changeLiveFilterVisibleEvent.token;
        }
        return changeLiveFilterVisibleEvent.copy(uniqueId);
    }

    public final UniqueId component1() {
        return this.token;
    }

    public final ChangeLiveFilterVisibleEvent copy(UniqueId uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "token");
        return new ChangeLiveFilterVisibleEvent(uniqueId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChangeLiveFilterVisibleEvent) && Intrinsics.areEqual((Object) this.token, (Object) ((ChangeLiveFilterVisibleEvent) obj).token);
    }

    public int hashCode() {
        return this.token.hashCode();
    }

    public String toString() {
        return "ChangeLiveFilterVisibleEvent(token=" + this.token + ')';
    }

    public ChangeLiveFilterVisibleEvent(UniqueId token2) {
        Intrinsics.checkNotNullParameter(token2, "token");
        this.token = token2;
    }

    public final UniqueId getToken() {
        return this.token;
    }

    public final boolean getEnableForceStatus() {
        return this.enableForceStatus;
    }

    public final void setEnableForceStatus(boolean z) {
        this.enableForceStatus = z;
    }

    public final boolean getForceVisibleState() {
        return this.forceVisibleState;
    }

    public final void setForceVisibleState(boolean z) {
        this.forceVisibleState = z;
    }
}
