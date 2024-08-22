package com.baidu.browser.explore.network.prefetch;

import com.baidu.pyramid.annotation.tekes.StableApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\b¢\u0006\u0002\u0010\u000bJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J%\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010,\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bHÆ\u0003Jy\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bHÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R:\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR6\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00063"}, d2 = {"Lcom/baidu/browser/explore/network/prefetch/PrefetchParams;", "", "query", "", "type", "", "prefetchParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "searchSource", "params", "(Ljava/lang/String;ILjava/util/HashMap;Ljava/lang/String;Ljava/util/HashMap;)V", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "getPrefetchParams", "setPrefetchParams", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "getSearchSource", "setSearchSource", "startToLaunchTime", "", "getStartToLaunchTime", "()J", "setStartToLaunchTime", "(J)V", "startToPrepareTime", "getStartToPrepareTime", "setStartToPrepareTime", "startToSendTime", "getStartToSendTime", "setStartToSendTime", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "lib_search_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrefetchParams.kt */
public final class PrefetchParams {
    private HashMap<String, String> params;
    private HashMap<String, String> prefetchParams;
    private String query;
    private String searchSource;
    private long startToLaunchTime;
    private long startToPrepareTime;
    private long startToSendTime;
    private int type;

    public static /* synthetic */ PrefetchParams copy$default(PrefetchParams prefetchParams2, String str, int i2, HashMap<String, String> hashMap, String str2, HashMap<String, String> hashMap2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = prefetchParams2.query;
        }
        if ((i3 & 2) != 0) {
            i2 = prefetchParams2.type;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            hashMap = prefetchParams2.prefetchParams;
        }
        HashMap<String, String> hashMap3 = hashMap;
        if ((i3 & 8) != 0) {
            str2 = prefetchParams2.searchSource;
        }
        String str3 = str2;
        if ((i3 & 16) != 0) {
            hashMap2 = prefetchParams2.params;
        }
        return prefetchParams2.copy(str, i4, hashMap3, str3, hashMap2);
    }

    public final String component1() {
        return this.query;
    }

    public final int component2() {
        return this.type;
    }

    public final HashMap<String, String> component3() {
        return this.prefetchParams;
    }

    public final String component4() {
        return this.searchSource;
    }

    public final HashMap<String, String> component5() {
        return this.params;
    }

    public final PrefetchParams copy(String str, int i2, HashMap<String, String> hashMap, String str2, HashMap<String, String> hashMap2) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(hashMap, "prefetchParams");
        return new PrefetchParams(str, i2, hashMap, str2, hashMap2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrefetchParams)) {
            return false;
        }
        PrefetchParams prefetchParams2 = (PrefetchParams) obj;
        return Intrinsics.areEqual((Object) this.query, (Object) prefetchParams2.query) && this.type == prefetchParams2.type && Intrinsics.areEqual((Object) this.prefetchParams, (Object) prefetchParams2.prefetchParams) && Intrinsics.areEqual((Object) this.searchSource, (Object) prefetchParams2.searchSource) && Intrinsics.areEqual((Object) this.params, (Object) prefetchParams2.params);
    }

    public int hashCode() {
        int hashCode = ((((this.query.hashCode() * 31) + Integer.hashCode(this.type)) * 31) + this.prefetchParams.hashCode()) * 31;
        String str = this.searchSource;
        int i2 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        HashMap<String, String> hashMap = this.params;
        if (hashMap != null) {
            i2 = hashMap.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "PrefetchParams(query=" + this.query + ", type=" + this.type + ", prefetchParams=" + this.prefetchParams + ", searchSource=" + this.searchSource + ", params=" + this.params + ')';
    }

    public PrefetchParams(String query2, int type2, HashMap<String, String> prefetchParams2, String searchSource2, HashMap<String, String> params2) {
        Intrinsics.checkNotNullParameter(query2, "query");
        Intrinsics.checkNotNullParameter(prefetchParams2, "prefetchParams");
        this.query = query2;
        this.type = type2;
        this.prefetchParams = prefetchParams2;
        this.searchSource = searchSource2;
        this.params = params2;
    }

    public final HashMap<String, String> getPrefetchParams() {
        return this.prefetchParams;
    }

    public final String getQuery() {
        return this.query;
    }

    public final int getType() {
        return this.type;
    }

    public final void setPrefetchParams(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.prefetchParams = hashMap;
    }

    public final void setQuery(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.query = str;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    public final HashMap<String, String> getParams() {
        return this.params;
    }

    public final String getSearchSource() {
        return this.searchSource;
    }

    public final void setParams(HashMap<String, String> hashMap) {
        this.params = hashMap;
    }

    public final void setSearchSource(String str) {
        this.searchSource = str;
    }

    public final long getStartToPrepareTime() {
        return this.startToPrepareTime;
    }

    public final void setStartToPrepareTime(long j2) {
        this.startToPrepareTime = j2;
    }

    public final long getStartToLaunchTime() {
        return this.startToLaunchTime;
    }

    public final void setStartToLaunchTime(long j2) {
        this.startToLaunchTime = j2;
    }

    public final long getStartToSendTime() {
        return this.startToSendTime;
    }

    public final void setStartToSendTime(long j2) {
        this.startToSendTime = j2;
    }
}
