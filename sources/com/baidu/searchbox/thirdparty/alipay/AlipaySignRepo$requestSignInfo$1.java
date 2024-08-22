package com.baidu.searchbox.thirdparty.alipay;

import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/thirdparty/alipay/AlipaySignRepo$requestSignInfo$1", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lcom/baidu/searchbox/thirdparty/alipay/SignData;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "responseData", "errorNo", "", "parseResponse", "response", "Lokhttp3/Response;", "lib-openid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlipaySignRepo.kt */
public final class AlipaySignRepo$requestSignInfo$1 extends ResponseCallback<SignData> {
    final /* synthetic */ Function2<Integer, String, Unit> $fail;
    final /* synthetic */ Function1<String, Unit> $succeed;

    AlipaySignRepo$requestSignInfo$1(Function1<? super String, Unit> $succeed2, Function2<? super Integer, ? super String, Unit> $fail2) {
        this.$succeed = $succeed2;
        this.$fail = $fail2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r3.body();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.thirdparty.alipay.SignData parseResponse(okhttp3.Response r3, int r4) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x000e
            okhttp3.ResponseBody r1 = r3.body()
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.string()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            if (r1 != 0) goto L_0x0012
            return r0
        L_0x0012:
            r0 = r1
            com.baidu.searchbox.thirdparty.alipay.SignData$Companion r1 = com.baidu.searchbox.thirdparty.alipay.SignData.Companion
            com.baidu.searchbox.thirdparty.alipay.SignData r1 = r1.withResponseJsonData(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.thirdparty.alipay.AlipaySignRepo$requestSignInfo$1.parseResponse(okhttp3.Response, int):com.baidu.searchbox.thirdparty.alipay.SignData");
    }

    public void onSuccess(SignData responseData, int errorNo) {
        if (responseData == null || !responseData.isSucceed()) {
            if (responseData != null) {
                this.$fail.invoke(Integer.valueOf(responseData.getErrno()), responseData.getErrmsg());
            } else {
                this.$fail.invoke(100000, "其它异常");
            }
        } else if (!TextUtils.isEmpty(responseData.getAuthInfoStr())) {
            this.$succeed.invoke(responseData.getAuthInfoStr());
        } else {
            this.$fail.invoke(100000, "其它异常");
        }
    }

    public void onFail(Exception e2) {
        this.$fail.invoke(100001, "网络请求失败");
    }
}
