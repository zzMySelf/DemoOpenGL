package com.baidu.searchbox.flowvideo.dynamic.repos;

import com.baidu.searchbox.feed.detail.ext.common.RequestParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicDetailParam;", "Lcom/baidu/searchbox/feed/detail/ext/common/RequestParam;", "nid", "", "pd", "row", "", "useCacheDisable", "", "refreshTimestampMs", "(Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;)V", "getNid", "()Ljava/lang/String;", "getPd", "getRefreshTimestampMs", "getRow", "()I", "getUseCacheDisable", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDetailParam.kt */
public final class DynamicDetailParam extends RequestParam {
    private final String nid;
    private final String pd;
    private final String refreshTimestampMs;
    private final int row;
    private final boolean useCacheDisable;

    public static /* synthetic */ DynamicDetailParam copy$default(DynamicDetailParam dynamicDetailParam, String str, String str2, int i2, boolean z, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = dynamicDetailParam.nid;
        }
        if ((i3 & 2) != 0) {
            str2 = dynamicDetailParam.pd;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            i2 = dynamicDetailParam.row;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            z = dynamicDetailParam.useCacheDisable;
        }
        boolean z2 = z;
        if ((i3 & 16) != 0) {
            str3 = dynamicDetailParam.refreshTimestampMs;
        }
        return dynamicDetailParam.copy(str, str4, i4, z2, str3);
    }

    public final String component1() {
        return this.nid;
    }

    public final String component2() {
        return this.pd;
    }

    public final int component3() {
        return this.row;
    }

    public final boolean component4() {
        return this.useCacheDisable;
    }

    public final String component5() {
        return this.refreshTimestampMs;
    }

    public final DynamicDetailParam copy(String str, String str2, int i2, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "nid");
        Intrinsics.checkNotNullParameter(str2, "pd");
        Intrinsics.checkNotNullParameter(str3, "refreshTimestampMs");
        return new DynamicDetailParam(str, str2, i2, z, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DynamicDetailParam)) {
            return false;
        }
        DynamicDetailParam dynamicDetailParam = (DynamicDetailParam) obj;
        return Intrinsics.areEqual((Object) this.nid, (Object) dynamicDetailParam.nid) && Intrinsics.areEqual((Object) this.pd, (Object) dynamicDetailParam.pd) && this.row == dynamicDetailParam.row && this.useCacheDisable == dynamicDetailParam.useCacheDisable && Intrinsics.areEqual((Object) this.refreshTimestampMs, (Object) dynamicDetailParam.refreshTimestampMs);
    }

    public int hashCode() {
        int hashCode = ((((this.nid.hashCode() * 31) + this.pd.hashCode()) * 31) + Integer.hashCode(this.row)) * 31;
        boolean z = this.useCacheDisable;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.refreshTimestampMs.hashCode();
    }

    public String toString() {
        return "DynamicDetailParam(nid=" + this.nid + ", pd=" + this.pd + ", row=" + this.row + ", useCacheDisable=" + this.useCacheDisable + ", refreshTimestampMs=" + this.refreshTimestampMs + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DynamicDetailParam(java.lang.String r7, java.lang.String r8, int r9, boolean r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r12 = r12 & 8
            if (r12 == 0) goto L_0x0007
            r10 = 0
            r4 = r10
            goto L_0x0008
        L_0x0007:
            r4 = r10
        L_0x0008:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailParam.<init>(java.lang.String, java.lang.String, int, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getNid() {
        return this.nid;
    }

    public final String getPd() {
        return this.pd;
    }

    public final int getRow() {
        return this.row;
    }

    public final boolean getUseCacheDisable() {
        return this.useCacheDisable;
    }

    public DynamicDetailParam(String nid2, String pd2, int row2, boolean useCacheDisable2, String refreshTimestampMs2) {
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(pd2, "pd");
        Intrinsics.checkNotNullParameter(refreshTimestampMs2, "refreshTimestampMs");
        this.nid = nid2;
        this.pd = pd2;
        this.row = row2;
        this.useCacheDisable = useCacheDisable2;
        this.refreshTimestampMs = refreshTimestampMs2;
    }

    public final String getRefreshTimestampMs() {
        return this.refreshTimestampMs;
    }

    public JSONObject toJson() {
        addExtParams("nid", this.nid);
        addExtParams("pd", this.pd);
        addExtParams("row", String.valueOf(this.row));
        addExtParams("refresh_timestamp_ms", this.refreshTimestampMs);
        return super.toJson();
    }
}
