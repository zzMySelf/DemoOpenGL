package com.baidu.searchbox.sport.page.chatroom.comp;

import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/sport/page/chatroom/comp/StartScrollEvent;", "", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StartScrollEvent.kt */
public final class StartScrollEvent {
    private final UniqueId token;

    public static /* synthetic */ StartScrollEvent copy$default(StartScrollEvent startScrollEvent, UniqueId uniqueId, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uniqueId = startScrollEvent.token;
        }
        return startScrollEvent.copy(uniqueId);
    }

    public final UniqueId component1() {
        return this.token;
    }

    public final StartScrollEvent copy(UniqueId uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "token");
        return new StartScrollEvent(uniqueId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StartScrollEvent) && Intrinsics.areEqual((Object) this.token, (Object) ((StartScrollEvent) obj).token);
    }

    public int hashCode() {
        return this.token.hashCode();
    }

    public String toString() {
        return "StartScrollEvent(token=" + this.token + ')';
    }

    public StartScrollEvent(UniqueId token2) {
        Intrinsics.checkNotNullParameter(token2, "token");
        this.token = token2;
    }

    public final UniqueId getToken() {
        return this.token;
    }
}
