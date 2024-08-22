package com.baidu.searchbox.mall.comp.sug.event;

import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/mall/comp/sug/event/InputSugEvent;", "", "query", "", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Ljava/lang/String;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "getQuery", "()Ljava/lang/String;", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputSugEvent.kt */
public final class InputSugEvent {
    private final String query;
    private final UniqueId token;

    public static /* synthetic */ InputSugEvent copy$default(InputSugEvent inputSugEvent, String str, UniqueId uniqueId, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = inputSugEvent.query;
        }
        if ((i2 & 2) != 0) {
            uniqueId = inputSugEvent.token;
        }
        return inputSugEvent.copy(str, uniqueId);
    }

    public final String component1() {
        return this.query;
    }

    public final UniqueId component2() {
        return this.token;
    }

    public final InputSugEvent copy(String str, UniqueId uniqueId) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(uniqueId, "token");
        return new InputSugEvent(str, uniqueId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputSugEvent)) {
            return false;
        }
        InputSugEvent inputSugEvent = (InputSugEvent) obj;
        return Intrinsics.areEqual((Object) this.query, (Object) inputSugEvent.query) && Intrinsics.areEqual((Object) this.token, (Object) inputSugEvent.token);
    }

    public int hashCode() {
        return (this.query.hashCode() * 31) + this.token.hashCode();
    }

    public String toString() {
        return "InputSugEvent(query=" + this.query + ", token=" + this.token + ')';
    }

    public InputSugEvent(String query2, UniqueId token2) {
        Intrinsics.checkNotNullParameter(query2, "query");
        Intrinsics.checkNotNullParameter(token2, "token");
        this.query = query2;
        this.token = token2;
    }

    public final String getQuery() {
        return this.query;
    }

    public final UniqueId getToken() {
        return this.token;
    }
}
