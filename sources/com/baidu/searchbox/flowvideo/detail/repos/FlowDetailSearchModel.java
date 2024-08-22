package com.baidu.searchbox.flowvideo.detail.repos;

import com.baidu.searchbox.NoProGuard;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÂ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Je\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\u0006\u0010)\u001a\u00020$J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailSearchModel;", "Lcom/baidu/searchbox/NoProGuard;", "switch", "", "scheme", "topQuerys", "", "topQueryMap", "", "Lcom/baidu/searchbox/flowvideo/detail/repos/TopQueryWrapper;", "query", "sBoxScheme", "ext", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getQuery", "getSBoxScheme", "setSBoxScheme", "getScheme", "setScheme", "getTopQueryMap", "()Ljava/util/Map;", "getTopQuerys", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "isShowIcon", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailModel.kt */
public final class FlowDetailSearchModel implements NoProGuard {
    private String ext;
    private final String query;
    private String sBoxScheme;
    private String scheme;

    /* renamed from: switch  reason: not valid java name */
    private String f1137switch;
    private final Map<String, TopQueryWrapper> topQueryMap;
    private final List<String> topQuerys;

    public FlowDetailSearchModel() {
        this((String) null, (String) null, (List) null, (Map) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    private final String component1() {
        return this.f1137switch;
    }

    public static /* synthetic */ FlowDetailSearchModel copy$default(FlowDetailSearchModel flowDetailSearchModel, String str, String str2, List<String> list, Map<String, TopQueryWrapper> map, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = flowDetailSearchModel.f1137switch;
        }
        if ((i2 & 2) != 0) {
            str2 = flowDetailSearchModel.scheme;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            list = flowDetailSearchModel.topQuerys;
        }
        List<String> list2 = list;
        if ((i2 & 8) != 0) {
            map = flowDetailSearchModel.topQueryMap;
        }
        Map<String, TopQueryWrapper> map2 = map;
        if ((i2 & 16) != 0) {
            str3 = flowDetailSearchModel.query;
        }
        String str7 = str3;
        if ((i2 & 32) != 0) {
            str4 = flowDetailSearchModel.sBoxScheme;
        }
        String str8 = str4;
        if ((i2 & 64) != 0) {
            str5 = flowDetailSearchModel.ext;
        }
        return flowDetailSearchModel.copy(str, str6, list2, map2, str7, str8, str5);
    }

    public final String component2() {
        return this.scheme;
    }

    public final List<String> component3() {
        return this.topQuerys;
    }

    public final Map<String, TopQueryWrapper> component4() {
        return this.topQueryMap;
    }

    public final String component5() {
        return this.query;
    }

    public final String component6() {
        return this.sBoxScheme;
    }

    public final String component7() {
        return this.ext;
    }

    public final FlowDetailSearchModel copy(String str, String str2, List<String> list, Map<String, TopQueryWrapper> map, String str3, String str4, String str5) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str, "switch");
        Intrinsics.checkNotNullParameter(str2, "scheme");
        Intrinsics.checkNotNullParameter(str3, "query");
        Intrinsics.checkNotNullParameter(str4, "sBoxScheme");
        Intrinsics.checkNotNullParameter(str5, "ext");
        return new FlowDetailSearchModel(str, str2, list, map, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowDetailSearchModel)) {
            return false;
        }
        FlowDetailSearchModel flowDetailSearchModel = (FlowDetailSearchModel) obj;
        return Intrinsics.areEqual((Object) this.f1137switch, (Object) flowDetailSearchModel.f1137switch) && Intrinsics.areEqual((Object) this.scheme, (Object) flowDetailSearchModel.scheme) && Intrinsics.areEqual((Object) this.topQuerys, (Object) flowDetailSearchModel.topQuerys) && Intrinsics.areEqual((Object) this.topQueryMap, (Object) flowDetailSearchModel.topQueryMap) && Intrinsics.areEqual((Object) this.query, (Object) flowDetailSearchModel.query) && Intrinsics.areEqual((Object) this.sBoxScheme, (Object) flowDetailSearchModel.sBoxScheme) && Intrinsics.areEqual((Object) this.ext, (Object) flowDetailSearchModel.ext);
    }

    public int hashCode() {
        int hashCode = ((this.f1137switch.hashCode() * 31) + this.scheme.hashCode()) * 31;
        List<String> list = this.topQuerys;
        int i2 = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, TopQueryWrapper> map = this.topQueryMap;
        if (map != null) {
            i2 = map.hashCode();
        }
        return ((((((hashCode2 + i2) * 31) + this.query.hashCode()) * 31) + this.sBoxScheme.hashCode()) * 31) + this.ext.hashCode();
    }

    public String toString() {
        return "FlowDetailSearchModel(switch=" + this.f1137switch + ", scheme=" + this.scheme + ", topQuerys=" + this.topQuerys + ", topQueryMap=" + this.topQueryMap + ", query=" + this.query + ", sBoxScheme=" + this.sBoxScheme + ", ext=" + this.ext + ')';
    }

    public FlowDetailSearchModel(String str, String scheme2, List<String> topQuerys2, Map<String, TopQueryWrapper> topQueryMap2, String query2, String sBoxScheme2, String ext2) {
        Intrinsics.checkNotNullParameter(str, "switch");
        Intrinsics.checkNotNullParameter(scheme2, "scheme");
        Intrinsics.checkNotNullParameter(query2, "query");
        Intrinsics.checkNotNullParameter(sBoxScheme2, "sBoxScheme");
        Intrinsics.checkNotNullParameter(ext2, "ext");
        this.f1137switch = str;
        this.scheme = scheme2;
        this.topQuerys = topQuerys2;
        this.topQueryMap = topQueryMap2;
        this.query = query2;
        this.sBoxScheme = sBoxScheme2;
        this.ext = ext2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FlowDetailSearchModel(java.lang.String r6, java.lang.String r7, java.util.List r8, java.util.Map r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0006
            java.lang.String r6 = "0"
        L_0x0006:
            r14 = r13 & 2
            java.lang.String r0 = ""
            if (r14 == 0) goto L_0x000e
            r14 = r0
            goto L_0x000f
        L_0x000e:
            r14 = r7
        L_0x000f:
            r7 = r13 & 4
            r1 = 0
            if (r7 == 0) goto L_0x0016
            r2 = r1
            goto L_0x0017
        L_0x0016:
            r2 = r8
        L_0x0017:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r9
        L_0x001d:
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0023
            r3 = r0
            goto L_0x0024
        L_0x0023:
            r3 = r10
        L_0x0024:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x002a
            r4 = r0
            goto L_0x002b
        L_0x002a:
            r4 = r11
        L_0x002b:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r0 = r12
        L_0x0031:
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r2
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.flowvideo.detail.repos.FlowDetailSearchModel.<init>(java.lang.String, java.lang.String, java.util.List, java.util.Map, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final void setScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scheme = str;
    }

    public final List<String> getTopQuerys() {
        return this.topQuerys;
    }

    public final Map<String, TopQueryWrapper> getTopQueryMap() {
        return this.topQueryMap;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getSBoxScheme() {
        return this.sBoxScheme;
    }

    public final void setSBoxScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sBoxScheme = str;
    }

    public final String getExt() {
        return this.ext;
    }

    public final void setExt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext = str;
    }

    public final boolean isShowIcon() {
        return Intrinsics.areEqual((Object) this.f1137switch, (Object) "1");
    }
}
