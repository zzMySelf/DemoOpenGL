package com.baidu.searchbox.feed.biserialdetail.net.phoenixnestad;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/net/phoenixnestad/PNAdModelParser;", "", "()V", "parse", "Lcom/baidu/searchbox/feed/biserialdetail/model/phoenixnestad/PNAdModel;", "responseString", "", "parseMts", "", "mtsJsonArr", "Lorg/json/JSONArray;", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PNAdModelParser.kt */
public final class PNAdModelParser {
    public static final PNAdModelParser INSTANCE = new PNAdModelParser();

    private PNAdModelParser() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        r3 = r3.optJSONObject(com.baidu.searchbox.feed.biserialdetail.content.ad.DynamicDetailBannerAdManagerKt.DYNAMIC_DETAIL_BANNER_AD_CMD);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.PNAdModel parse(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r18
            java.lang.String r0 = "responseString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r2 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00ef }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r3 = "data"
            org.json.JSONObject r3 = r0.optJSONObject(r3)     // Catch:{ JSONException -> 0x00ef }
            if (r3 == 0) goto L_0x0026
            java.lang.String r4 = "341"
            org.json.JSONObject r3 = r3.optJSONObject(r4)     // Catch:{ JSONException -> 0x00ef }
            if (r3 == 0) goto L_0x0026
            java.lang.String r4 = "aspList"
            org.json.JSONArray r3 = r3.optJSONArray(r4)     // Catch:{ JSONException -> 0x00ef }
            goto L_0x0027
        L_0x0026:
            r3 = r2
        L_0x0027:
            if (r3 == 0) goto L_0x00ec
            r4 = r3
            r5 = 0
            int r6 = r3.length()     // Catch:{ JSONException -> 0x00ef }
            if (r6 > 0) goto L_0x0032
            return r2
        L_0x0032:
            com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.PNAdModel r6 = new com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.PNAdModel     // Catch:{ JSONException -> 0x00ef }
            r6.<init>()     // Catch:{ JSONException -> 0x00ef }
            r7 = 0
            org.json.JSONObject r8 = r3.getJSONObject(r7)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r9 = "ads"
            org.json.JSONArray r9 = r8.optJSONArray(r9)     // Catch:{ JSONException -> 0x00ef }
            if (r9 == 0) goto L_0x0049
            org.json.JSONObject r7 = r9.optJSONObject(r7)     // Catch:{ JSONException -> 0x00ef }
            goto L_0x004a
        L_0x0049:
            r7 = r2
        L_0x004a:
            if (r7 != 0) goto L_0x004d
            return r2
        L_0x004d:
            java.lang.String r10 = "adJsonArr?.optJSONObject(0)?: return null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r10)     // Catch:{ JSONException -> 0x00ef }
            com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.PNAdItem r10 = new com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.PNAdItem     // Catch:{ JSONException -> 0x00ef }
            r10.<init>()     // Catch:{ JSONException -> 0x00ef }
            r11 = r10
            r12 = 0
            r13 = r7
            r14 = 0
            java.lang.String r15 = "adSkipUrl"
            java.lang.String r15 = r13.optString(r15)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r2 = "optString(\"adSkipUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r2)     // Catch:{ JSONException -> 0x00ef }
            r11.setAdSkipUrl(r15)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r2 = "title"
            java.lang.String r2 = r13.optString(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r15 = "optString(\"title\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ JSONException -> 0x00ef }
            r11.setTitle(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r2 = "desc"
            java.lang.String r2 = r13.optString(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r15 = "optString(\"desc\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ JSONException -> 0x00ef }
            r11.setDesc(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r2 = "fclickUrl"
            java.lang.String r2 = r13.optString(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r15 = "optString(\"fclickUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ JSONException -> 0x00ef }
            r11.setFclickUrl(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r2 = "intentText"
            java.lang.String r2 = r13.optString(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r15 = "optString(\"intentText\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ JSONException -> 0x00ef }
            r11.setIntentText(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r2 = "style"
            java.lang.String r2 = r13.optString(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r15 = "optString(\"style\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ JSONException -> 0x00ef }
            r11.setStyle(r2)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r2 = "mts"
            org.json.JSONArray r2 = r13.optJSONArray(r2)     // Catch:{ JSONException -> 0x00ef }
            com.baidu.searchbox.feed.biserialdetail.net.phoenixnestad.PNAdModelParser r15 = INSTANCE     // Catch:{ JSONException -> 0x00ef }
            java.util.List r15 = r15.parseMts(r2)     // Catch:{ JSONException -> 0x00ef }
            r11.setMts(r15)     // Catch:{ JSONException -> 0x00ef }
            java.lang.String r15 = "showUrl"
            java.lang.String r15 = r13.optString(r15)     // Catch:{ JSONException -> 0x00ef }
            r16 = r0
            java.lang.String r0 = "optString(\"showUrl\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r0)     // Catch:{ JSONException -> 0x00ef }
            r11.setShowUrl(r15)     // Catch:{ JSONException -> 0x00ef }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ JSONException -> 0x00ef }
            r0.<init>()     // Catch:{ JSONException -> 0x00ef }
            r0.add(r10)     // Catch:{ JSONException -> 0x00ef }
            r2 = r0
            java.util.List r2 = (java.util.List) r2     // Catch:{ JSONException -> 0x00ef }
            r6.setAds(r2)     // Catch:{ JSONException -> 0x00ef }
            return r6
        L_0x00ec:
            r16 = r0
            goto L_0x00f3
        L_0x00ef:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00f3:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.biserialdetail.net.phoenixnestad.PNAdModelParser.parse(java.lang.String):com.baidu.searchbox.feed.biserialdetail.model.phoenixnestad.PNAdModel");
    }

    private final List<String> parseMts(JSONArray mtsJsonArr) {
        if (mtsJsonArr == null) {
            return null;
        }
        JSONArray jSONArray = mtsJsonArr;
        ArrayList mts = new ArrayList();
        int length = mtsJsonArr.length();
        for (int i2 = 0; i2 < length; i2++) {
            mts.add(mtsJsonArr.optString(i2));
        }
        return null;
    }
}
