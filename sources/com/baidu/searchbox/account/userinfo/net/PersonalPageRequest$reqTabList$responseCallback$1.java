package com.baidu.searchbox.account.userinfo.net;

import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/account/userinfo/net/PersonalPageRequest$reqTabList$responseCallback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "statusCode", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNetRequest.kt */
public final class PersonalPageRequest$reqTabList$responseCallback$1 extends ResponseCallback<String> {
    final /* synthetic */ Function3<Boolean, JSONArray, JSONArray, Unit> $dragCallBack;
    final /* synthetic */ boolean $isTabEditTypeDrag;
    final /* synthetic */ Function2<Boolean, JSONArray, Unit> $topCallBack;

    PersonalPageRequest$reqTabList$responseCallback$1(boolean $isTabEditTypeDrag2, Function2<? super Boolean, ? super JSONArray, Unit> $topCallBack2, Function3<? super Boolean, ? super JSONArray, ? super JSONArray, Unit> $dragCallBack2) {
        this.$isTabEditTypeDrag = $isTabEditTypeDrag2;
        this.$topCallBack = $topCallBack2;
        this.$dragCallBack = $dragCallBack2;
    }

    public String parseResponse(Response response, int statusCode) {
        boolean z = true;
        if (response == null || !response.isSuccessful()) {
            z = false;
        }
        if (!z) {
            return "";
        }
        ResponseBody body = response.body();
        if (body != null) {
            return body.string();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[SYNTHETIC, Splitter:B:10:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(java.lang.String r12, int r13) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            r3 = 0
            if (r12 == 0) goto L_0x0016
            r4 = r12
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0011
            r4 = r2
            goto L_0x0012
        L_0x0011:
            r4 = r3
        L_0x0012:
            if (r4 != r2) goto L_0x0016
            r4 = r2
            goto L_0x0017
        L_0x0016:
            r4 = r3
        L_0x0017:
            if (r4 == 0) goto L_0x005e
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0054 }
            r4 = r11
            com.baidu.searchbox.account.userinfo.net.PersonalPageRequest$reqTabList$responseCallback$1 r4 = (com.baidu.searchbox.account.userinfo.net.PersonalPageRequest$reqTabList$responseCallback$1) r4     // Catch:{ all -> 0x0054 }
            r5 = 0
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0054 }
            r6.<init>(r12)     // Catch:{ all -> 0x0054 }
            java.lang.String r7 = "errno"
            r8 = -1
            int r7 = r6.optInt(r7, r8)     // Catch:{ all -> 0x0054 }
            if (r7 != 0) goto L_0x004d
            java.lang.String r8 = "data"
            org.json.JSONObject r8 = r6.optJSONObject(r8)     // Catch:{ all -> 0x0054 }
            if (r8 == 0) goto L_0x004d
            java.lang.String r9 = "optJSONObject(\"data\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ all -> 0x0054 }
            r9 = 0
            java.lang.String r10 = "tabs"
            org.json.JSONArray r10 = r8.optJSONArray(r10)     // Catch:{ all -> 0x0054 }
            r0 = r10
            java.lang.String r10 = "hidden_tab"
            org.json.JSONArray r10 = r8.optJSONArray(r10)     // Catch:{ all -> 0x0054 }
            r1 = r10
        L_0x004d:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0054 }
            kotlin.Result.m8971constructorimpl(r4)     // Catch:{ all -> 0x0054 }
            goto L_0x005e
        L_0x0054:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            kotlin.Result.m8971constructorimpl(r4)
        L_0x005e:
            boolean r4 = r11.$isTabEditTypeDrag
            if (r4 != 0) goto L_0x0072
            kotlin.jvm.functions.Function2<java.lang.Boolean, org.json.JSONArray, kotlin.Unit> r4 = r11.$topCallBack
            if (r4 == 0) goto L_0x0081
            if (r0 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r2 = r3
        L_0x006a:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4.invoke(r2, r0)
            goto L_0x0081
        L_0x0072:
            kotlin.jvm.functions.Function3<java.lang.Boolean, org.json.JSONArray, org.json.JSONArray, kotlin.Unit> r4 = r11.$dragCallBack
            if (r4 == 0) goto L_0x0081
            if (r0 == 0) goto L_0x0079
            goto L_0x007a
        L_0x0079:
            r2 = r3
        L_0x007a:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4.invoke(r2, r0, r1)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.net.PersonalPageRequest$reqTabList$responseCallback$1.onSuccess(java.lang.String, int):void");
    }

    public void onFail(Exception e2) {
        Function2<Boolean, JSONArray, Unit> function2 = this.$topCallBack;
        if (function2 != null) {
            function2.invoke(false, null);
        }
        Function3<Boolean, JSONArray, JSONArray, Unit> function3 = this.$dragCallBack;
        if (function3 != null) {
            function3.invoke(false, null, null);
        }
    }
}
