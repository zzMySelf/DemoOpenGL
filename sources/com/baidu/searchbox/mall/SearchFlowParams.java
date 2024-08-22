package com.baidu.searchbox.mall;

import com.baidu.searchbox.NoProGuard;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B=\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/mall/SearchFlowParams;", "Ljava/io/Serializable;", "Lcom/baidu/searchbox/NoProGuard;", "hint", "", "hintSa", "hintCanSearch", "", "query", "entrance", "Lcom/baidu/searchbox/mall/SearchEntrance;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/baidu/searchbox/mall/SearchEntrance;)V", "getEntrance", "()Lcom/baidu/searchbox/mall/SearchEntrance;", "getHint", "()Ljava/lang/String;", "getHintCanSearch", "()Z", "getHintSa", "getQuery", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "lib-mall-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchFlowParams.kt */
public final class SearchFlowParams implements Serializable, NoProGuard {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ENTRANCE_HOME = "i";
    private final SearchEntrance entrance;
    private final String hint;
    private final boolean hintCanSearch;
    private final String hintSa;
    private final String query;

    public SearchFlowParams() {
        this((String) null, (String) null, false, (String) null, (SearchEntrance) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SearchFlowParams copy$default(SearchFlowParams searchFlowParams, String str, String str2, boolean z, String str3, SearchEntrance searchEntrance, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = searchFlowParams.hint;
        }
        if ((i2 & 2) != 0) {
            str2 = searchFlowParams.hintSa;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            z = searchFlowParams.hintCanSearch;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str3 = searchFlowParams.query;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            searchEntrance = searchFlowParams.entrance;
        }
        return searchFlowParams.copy(str, str4, z2, str5, searchEntrance);
    }

    public final String component1() {
        return this.hint;
    }

    public final String component2() {
        return this.hintSa;
    }

    public final boolean component3() {
        return this.hintCanSearch;
    }

    public final String component4() {
        return this.query;
    }

    public final SearchEntrance component5() {
        return this.entrance;
    }

    public final SearchFlowParams copy(String str, String str2, boolean z, String str3, SearchEntrance searchEntrance) {
        Intrinsics.checkNotNullParameter(searchEntrance, "entrance");
        return new SearchFlowParams(str, str2, z, str3, searchEntrance);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchFlowParams)) {
            return false;
        }
        SearchFlowParams searchFlowParams = (SearchFlowParams) obj;
        return Intrinsics.areEqual((Object) this.hint, (Object) searchFlowParams.hint) && Intrinsics.areEqual((Object) this.hintSa, (Object) searchFlowParams.hintSa) && this.hintCanSearch == searchFlowParams.hintCanSearch && Intrinsics.areEqual((Object) this.query, (Object) searchFlowParams.query) && Intrinsics.areEqual((Object) this.entrance, (Object) searchFlowParams.entrance);
    }

    public int hashCode() {
        String str = this.hint;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hintSa;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.hintCanSearch;
        if (z) {
            z = true;
        }
        int i3 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str3 = this.query;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((i3 + i2) * 31) + this.entrance.hashCode();
    }

    public String toString() {
        return "SearchFlowParams(hint=" + this.hint + ", hintSa=" + this.hintSa + ", hintCanSearch=" + this.hintCanSearch + ", query=" + this.query + ", entrance=" + this.entrance + ')';
    }

    public SearchFlowParams(String hint2, String hintSa2, boolean hintCanSearch2, String query2, SearchEntrance entrance2) {
        Intrinsics.checkNotNullParameter(entrance2, "entrance");
        this.hint = hint2;
        this.hintSa = hintSa2;
        this.hintCanSearch = hintCanSearch2;
        this.query = query2;
        this.entrance = entrance2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchFlowParams(String str, String str2, boolean z, String str3, SearchEntrance searchEntrance, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? SearchEntrance.Companion.getOther() : searchEntrance);
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getHintSa() {
        return this.hintSa;
    }

    public final boolean getHintCanSearch() {
        return this.hintCanSearch;
    }

    public final String getQuery() {
        return this.query;
    }

    public final SearchEntrance getEntrance() {
        return this.entrance;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/mall/SearchFlowParams$Companion;", "", "()V", "ENTRANCE_HOME", "", "lib-mall-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SearchFlowParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
