package com.baidu.searchbox.hotdiscussion.toptip;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/hotdiscussion/toptip/TopTipData;", "", "tipList", "", "Lcom/baidu/searchbox/hotdiscussion/toptip/TopTipStr;", "(Ljava/util/List;)V", "getTipList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "lib_search_hotdiscussion_tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TopTipData.kt */
public final class TopTipData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<TopTipStr> tipList;

    public static /* synthetic */ TopTipData copy$default(TopTipData topTipData, List<TopTipStr> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = topTipData.tipList;
        }
        return topTipData.copy(list);
    }

    public final List<TopTipStr> component1() {
        return this.tipList;
    }

    public final TopTipData copy(List<TopTipStr> list) {
        Intrinsics.checkNotNullParameter(list, "tipList");
        return new TopTipData(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TopTipData) && Intrinsics.areEqual((Object) this.tipList, (Object) ((TopTipData) obj).tipList);
    }

    public int hashCode() {
        return this.tipList.hashCode();
    }

    public String toString() {
        return "TopTipData(tipList=" + this.tipList + ')';
    }

    public TopTipData(List<TopTipStr> tipList2) {
        Intrinsics.checkNotNullParameter(tipList2, "tipList");
        this.tipList = tipList2;
    }

    public final List<TopTipStr> getTipList() {
        return this.tipList;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/hotdiscussion/toptip/TopTipData$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/hotdiscussion/toptip/TopTipData;", "responseJson", "Lorg/json/JSONObject;", "fromJsonStr", "responseStr", "", "lib_search_hotdiscussion_tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TopTipData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TopTipData fromJsonStr(String responseStr) {
            Object obj;
            CharSequence charSequence = responseStr;
            TopTipData topTipData = null;
            if (charSequence == null || charSequence.length() == 0) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m8971constructorimpl(fromJson(new JSONObject(responseStr)));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m8977isFailureimpl(obj)) {
                topTipData = obj;
            }
            return topTipData;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
            r4 = (r4 = r4.optJSONObject("itemlist")).optJSONObject("pageConfig");
         */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00a3  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00a5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.baidu.searchbox.hotdiscussion.toptip.TopTipData fromJson(org.json.JSONObject r18) {
            /*
                r17 = this;
                r1 = r18
                r2 = 0
                if (r1 != 0) goto L_0x0006
                return r2
            L_0x0006:
                kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0091 }
                r0 = r17
                com.baidu.searchbox.hotdiscussion.toptip.TopTipData$Companion r0 = (com.baidu.searchbox.hotdiscussion.toptip.TopTipData.Companion) r0     // Catch:{ all -> 0x0091 }
                r3 = 0
                java.lang.String r4 = "data"
                org.json.JSONObject r4 = r1.optJSONObject(r4)     // Catch:{ all -> 0x0091 }
                if (r4 == 0) goto L_0x0031
                java.lang.String r5 = "itemlist"
                org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch:{ all -> 0x0091 }
                if (r4 == 0) goto L_0x0031
                java.lang.String r5 = "pageConfig"
                org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch:{ all -> 0x0091 }
                if (r4 == 0) goto L_0x0031
                java.lang.String r5 = "topFilterContainer"
                org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch:{ all -> 0x0091 }
                goto L_0x0032
            L_0x0031:
                r4 = r2
            L_0x0032:
                if (r4 != 0) goto L_0x0035
                return r2
            L_0x0035:
                java.lang.String r5 = "tipInfo"
                org.json.JSONArray r5 = r4.optJSONArray(r5)     // Catch:{ all -> 0x0091 }
                if (r5 != 0) goto L_0x003f
                return r2
            L_0x003f:
                java.lang.String r6 = "topTipRoot.optJSONArray(\"tipInfo\") ?: return null"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x0091 }
                r6 = r5
                r7 = 0
                java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0091 }
                r8.<init>()     // Catch:{ all -> 0x0091 }
                r9 = r6
                r10 = 0
                r11 = 0
                int r12 = r9.length()     // Catch:{ all -> 0x0091 }
            L_0x0053:
                if (r11 >= r12) goto L_0x006f
                org.json.JSONObject r13 = r9.optJSONObject(r11)     // Catch:{ all -> 0x0091 }
                r14 = 0
                r15 = r13
                r16 = 0
                com.baidu.searchbox.hotdiscussion.toptip.TopTipStr$Companion r2 = com.baidu.searchbox.hotdiscussion.toptip.TopTipStr.Companion     // Catch:{ all -> 0x008e }
                com.baidu.searchbox.hotdiscussion.toptip.TopTipStr r2 = r2.fromJson(r15)     // Catch:{ all -> 0x008e }
                if (r2 == 0) goto L_0x006a
                r15 = 0
                r8.add(r2)     // Catch:{ all -> 0x008e }
                goto L_0x006b
            L_0x006a:
            L_0x006b:
                int r11 = r11 + 1
                r2 = 0
                goto L_0x0053
            L_0x006f:
                r2 = r8
                java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x008e }
                boolean r6 = r2.isEmpty()     // Catch:{ all -> 0x008e }
                if (r6 == 0) goto L_0x0080
                r6 = 0
                r7 = r6
                com.baidu.searchbox.hotdiscussion.toptip.TopTipData r7 = (com.baidu.searchbox.hotdiscussion.toptip.TopTipData) r7     // Catch:{ all -> 0x008c }
                r7 = r6
                goto L_0x0086
            L_0x0080:
                r6 = 0
                com.baidu.searchbox.hotdiscussion.toptip.TopTipData r7 = new com.baidu.searchbox.hotdiscussion.toptip.TopTipData     // Catch:{ all -> 0x008c }
                r7.<init>(r2)     // Catch:{ all -> 0x008c }
            L_0x0086:
                java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r7)     // Catch:{ all -> 0x008c }
                goto L_0x009d
            L_0x008c:
                r0 = move-exception
                goto L_0x0093
            L_0x008e:
                r0 = move-exception
                r6 = 0
                goto L_0x0093
            L_0x0091:
                r0 = move-exception
                r6 = r2
            L_0x0093:
                kotlin.Result$Companion r2 = kotlin.Result.Companion
                java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
                java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
            L_0x009d:
                boolean r2 = kotlin.Result.m8977isFailureimpl(r0)
                if (r2 == 0) goto L_0x00a5
                r2 = r6
                goto L_0x00a6
            L_0x00a5:
                r2 = r0
            L_0x00a6:
                com.baidu.searchbox.hotdiscussion.toptip.TopTipData r2 = (com.baidu.searchbox.hotdiscussion.toptip.TopTipData) r2
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.hotdiscussion.toptip.TopTipData.Companion.fromJson(org.json.JSONObject):com.baidu.searchbox.hotdiscussion.toptip.TopTipData");
        }
    }
}
