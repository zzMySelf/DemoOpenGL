package com.baidu.searchbox.feed.biserial.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/biserial/event/BiseiralAutoStartRefreshEvent;", "", "channelId", "", "(Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiseiralAutoStartRefreshEvent.kt */
public final class BiseiralAutoStartRefreshEvent {
    private final String channelId;

    public static /* synthetic */ BiseiralAutoStartRefreshEvent copy$default(BiseiralAutoStartRefreshEvent biseiralAutoStartRefreshEvent, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = biseiralAutoStartRefreshEvent.channelId;
        }
        return biseiralAutoStartRefreshEvent.copy(str);
    }

    public final String component1() {
        return this.channelId;
    }

    public final BiseiralAutoStartRefreshEvent copy(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        return new BiseiralAutoStartRefreshEvent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BiseiralAutoStartRefreshEvent) && Intrinsics.areEqual((Object) this.channelId, (Object) ((BiseiralAutoStartRefreshEvent) obj).channelId);
    }

    public int hashCode() {
        return this.channelId.hashCode();
    }

    public String toString() {
        return "BiseiralAutoStartRefreshEvent(channelId=" + this.channelId + ')';
    }

    public BiseiralAutoStartRefreshEvent(String channelId2) {
        Intrinsics.checkNotNullParameter(channelId2, "channelId");
        this.channelId = channelId2;
    }

    public final String getChannelId() {
        return this.channelId;
    }
}
