package com.baidu.searchbox.account.userinfo.net;

import com.baidu.searchbox.account.userinfo.data.TalosIMPopupEntity;
import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/account/userinfo/net/PersonalPagePopupRequest$reqNeedShowUpdateReminderGuidePopup$responseCallback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "statusCode", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPagePopupRequest.kt */
public final class PersonalPagePopupRequest$reqNeedShowUpdateReminderGuidePopup$responseCallback$1 extends ResponseCallback<String> {
    final /* synthetic */ Function2<Boolean, TalosIMPopupEntity, Unit> $callBack;

    PersonalPagePopupRequest$reqNeedShowUpdateReminderGuidePopup$responseCallback$1(Function2<? super Boolean, ? super TalosIMPopupEntity, Unit> $callBack2) {
        this.$callBack = $callBack2;
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

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018 A[SYNTHETIC, Splitter:B:10:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(java.lang.String r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            if (r11 == 0) goto L_0x0015
            r3 = r11
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0010
            r3 = r1
            goto L_0x0011
        L_0x0010:
            r3 = r2
        L_0x0011:
            if (r3 != r1) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r2
        L_0x0016:
            if (r3 == 0) goto L_0x0053
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x0049 }
            r3 = r10
            com.baidu.searchbox.account.userinfo.net.PersonalPagePopupRequest$reqNeedShowUpdateReminderGuidePopup$responseCallback$1 r3 = (com.baidu.searchbox.account.userinfo.net.PersonalPagePopupRequest$reqNeedShowUpdateReminderGuidePopup$responseCallback$1) r3     // Catch:{ all -> 0x0049 }
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0049 }
            r5.<init>(r11)     // Catch:{ all -> 0x0049 }
            java.lang.String r6 = "errno"
            r7 = -1
            int r6 = r5.optInt(r6, r7)     // Catch:{ all -> 0x0049 }
            if (r6 != 0) goto L_0x0042
            java.lang.String r7 = "data"
            org.json.JSONObject r7 = r5.optJSONObject(r7)     // Catch:{ all -> 0x0049 }
            if (r7 == 0) goto L_0x0042
            java.lang.String r8 = "optJSONObject(\"data\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch:{ all -> 0x0049 }
            r8 = 0
            com.baidu.searchbox.account.userinfo.data.TalosIMPopupEntity r9 = new com.baidu.searchbox.account.userinfo.data.TalosIMPopupEntity     // Catch:{ all -> 0x0049 }
            r9.<init>(r7)     // Catch:{ all -> 0x0049 }
            r0 = r9
        L_0x0042:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0049 }
            kotlin.Result.m8971constructorimpl(r3)     // Catch:{ all -> 0x0049 }
            goto L_0x0053
        L_0x0049:
            r3 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            kotlin.Result.m8971constructorimpl(r3)
        L_0x0053:
            kotlin.jvm.functions.Function2<java.lang.Boolean, com.baidu.searchbox.account.userinfo.data.TalosIMPopupEntity, kotlin.Unit> r3 = r10.$callBack
            if (r0 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r1 = r2
        L_0x0059:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r3.invoke(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.net.PersonalPagePopupRequest$reqNeedShowUpdateReminderGuidePopup$responseCallback$1.onSuccess(java.lang.String, int):void");
    }

    public void onFail(Exception e2) {
        this.$callBack.invoke(false, null);
    }
}
