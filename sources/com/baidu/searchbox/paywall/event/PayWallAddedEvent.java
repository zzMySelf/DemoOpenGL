package com.baidu.searchbox.paywall.event;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.noveladapter.ubc.NovelUBCRetrievalStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/paywall/event/PayWallAddedEvent;", "", "bookId", "", "(Ljava/lang/String;)V", "getBookId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-paywall-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PayWallAddedEvent.kt */
public final class PayWallAddedEvent {
    private final String bookId;

    public PayWallAddedEvent() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PayWallAddedEvent copy$default(PayWallAddedEvent payWallAddedEvent, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = payWallAddedEvent.bookId;
        }
        return payWallAddedEvent.copy(str);
    }

    public final String component1() {
        return this.bookId;
    }

    public final PayWallAddedEvent copy(String str) {
        Intrinsics.checkNotNullParameter(str, NovelUBCRetrievalStat.ACTION_TYPE_BOOKID);
        return new PayWallAddedEvent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PayWallAddedEvent) && Intrinsics.areEqual((Object) this.bookId, (Object) ((PayWallAddedEvent) obj).bookId);
    }

    public int hashCode() {
        return this.bookId.hashCode();
    }

    public String toString() {
        return "PayWallAddedEvent(bookId=" + this.bookId + ')';
    }

    public PayWallAddedEvent(String bookId2) {
        Intrinsics.checkNotNullParameter(bookId2, NovelUBCRetrievalStat.ACTION_TYPE_BOOKID);
        this.bookId = bookId2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayWallAddedEvent(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str);
    }

    public final String getBookId() {
        return this.bookId;
    }
}
