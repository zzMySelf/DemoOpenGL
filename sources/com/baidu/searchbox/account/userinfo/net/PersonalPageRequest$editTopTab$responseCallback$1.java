package com.baidu.searchbox.account.userinfo.net;

import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001f\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/account/userinfo/net/PersonalPageRequest$editTopTab$responseCallback$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "statusCode", "", "parseResponse", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;I)Ljava/lang/Boolean;", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageNetRequest.kt */
public final class PersonalPageRequest$editTopTab$responseCallback$1 extends ResponseCallback<Boolean> {
    final /* synthetic */ Function1<Boolean, Unit> $callBack;

    PersonalPageRequest$editTopTab$responseCallback$1(Function1<? super Boolean, Unit> $callBack2) {
        this.$callBack = $callBack2;
    }

    public /* bridge */ /* synthetic */ void onSuccess(Object response, int statusCode) {
        onSuccess(((Boolean) response).booleanValue(), statusCode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[SYNTHETIC, Splitter:B:20:0x0030] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean parseResponse(okhttp3.Response r9, int r10) {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L_0x000c
            boolean r2 = r9.isSuccessful()
            if (r2 != r0) goto L_0x000c
            r2 = r0
            goto L_0x000d
        L_0x000c:
            r2 = r1
        L_0x000d:
            if (r2 == 0) goto L_0x005a
            okhttp3.ResponseBody r2 = r9.body()
            if (r2 == 0) goto L_0x001a
            java.lang.String r2 = r2.string()
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            if (r2 == 0) goto L_0x002d
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0028
            r3 = r0
            goto L_0x0029
        L_0x0028:
            r3 = r1
        L_0x0029:
            if (r3 != r0) goto L_0x002d
            r3 = r0
            goto L_0x002e
        L_0x002d:
            r3 = r1
        L_0x002e:
            if (r3 == 0) goto L_0x005a
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x0050 }
            r3 = r8
            com.baidu.searchbox.account.userinfo.net.PersonalPageRequest$editTopTab$responseCallback$1 r3 = (com.baidu.searchbox.account.userinfo.net.PersonalPageRequest$editTopTab$responseCallback$1) r3     // Catch:{ all -> 0x0050 }
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0050 }
            r5.<init>(r2)     // Catch:{ all -> 0x0050 }
            java.lang.String r6 = "errno"
            r7 = -1
            int r5 = r5.optInt(r6, r7)     // Catch:{ all -> 0x0050 }
            if (r5 != 0) goto L_0x0049
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0050 }
            return r0
        L_0x0049:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0050 }
            kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x0050 }
            goto L_0x005a
        L_0x0050:
            r0 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
        L_0x005a:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.account.userinfo.net.PersonalPageRequest$editTopTab$responseCallback$1.parseResponse(okhttp3.Response, int):java.lang.Boolean");
    }

    public void onSuccess(boolean result, int statusCode) {
        this.$callBack.invoke(Boolean.valueOf(result));
    }

    public void onFail(Exception e2) {
        this.$callBack.invoke(false);
    }
}
