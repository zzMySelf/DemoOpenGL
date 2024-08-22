package com.baidu.searchbox.feed.dynamicdetail.net;

import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/net/DynamicResponse;", "", "response", "Lokhttp3/Response;", "code", "", "stateRecord", "Lcom/baidu/searchbox/http/statistics/NetworkStatRecord;", "(Lokhttp3/Response;ILcom/baidu/searchbox/http/statistics/NetworkStatRecord;)V", "getCode", "()I", "setCode", "(I)V", "getResponse", "()Lokhttp3/Response;", "setResponse", "(Lokhttp3/Response;)V", "getStateRecord", "()Lcom/baidu/searchbox/http/statistics/NetworkStatRecord;", "setStateRecord", "(Lcom/baidu/searchbox/http/statistics/NetworkStatRecord;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicResponse.kt */
public final class DynamicResponse {
    private int code;
    private Response response;
    private NetworkStatRecord stateRecord;

    public static /* synthetic */ DynamicResponse copy$default(DynamicResponse dynamicResponse, Response response2, int i2, NetworkStatRecord networkStatRecord, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            response2 = dynamicResponse.response;
        }
        if ((i3 & 2) != 0) {
            i2 = dynamicResponse.code;
        }
        if ((i3 & 4) != 0) {
            networkStatRecord = dynamicResponse.stateRecord;
        }
        return dynamicResponse.copy(response2, i2, networkStatRecord);
    }

    public final Response component1() {
        return this.response;
    }

    public final int component2() {
        return this.code;
    }

    public final NetworkStatRecord component3() {
        return this.stateRecord;
    }

    public final DynamicResponse copy(Response response2, int i2, NetworkStatRecord networkStatRecord) {
        return new DynamicResponse(response2, i2, networkStatRecord);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicResponse)) {
            return false;
        }
        DynamicResponse dynamicResponse = (DynamicResponse) obj;
        return Intrinsics.areEqual((Object) this.response, (Object) dynamicResponse.response) && this.code == dynamicResponse.code && Intrinsics.areEqual((Object) this.stateRecord, (Object) dynamicResponse.stateRecord);
    }

    public int hashCode() {
        Response response2 = this.response;
        int i2 = 0;
        int hashCode = (((response2 == null ? 0 : response2.hashCode()) * 31) + Integer.hashCode(this.code)) * 31;
        NetworkStatRecord networkStatRecord = this.stateRecord;
        if (networkStatRecord != null) {
            i2 = networkStatRecord.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "DynamicResponse(response=" + this.response + ", code=" + this.code + ", stateRecord=" + this.stateRecord + ')';
    }

    public DynamicResponse(Response response2, int code2, NetworkStatRecord stateRecord2) {
        this.response = response2;
        this.code = code2;
        this.stateRecord = stateRecord2;
    }

    public final int getCode() {
        return this.code;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final NetworkStatRecord getStateRecord() {
        return this.stateRecord;
    }

    public final void setCode(int i2) {
        this.code = i2;
    }

    public final void setResponse(Response response2) {
        this.response = response2;
    }

    public final void setStateRecord(NetworkStatRecord networkStatRecord) {
        this.stateRecord = networkStatRecord;
    }
}
