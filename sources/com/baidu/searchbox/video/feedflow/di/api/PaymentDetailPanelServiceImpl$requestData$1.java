package com.baidu.searchbox.video.feedflow.di.api;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.paymentpanel.api.PaymentDetailPanelBean;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, d2 = {"com/baidu/searchbox/video/feedflow/di/api/PaymentDetailPanelServiceImpl$requestData$1", "Lcom/baidu/searchbox/http/callback/StatResponseCallback;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/paymentpanel/api/PaymentDetailPanelBean;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "p1", "", "parseResponse", "response", "Lokhttp3/Response;", "state", "statRecord", "Lcom/baidu/searchbox/http/statistics/NetworkStatRecord;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentDetailPanelServiceImpl.kt */
public final class PaymentDetailPanelServiceImpl$requestData$1 implements StatResponseCallback<Result<PaymentDetailPanelBean>> {
    final /* synthetic */ OnDataLoaded<Result<PaymentDetailPanelBean>> $callback;

    PaymentDetailPanelServiceImpl$requestData$1(OnDataLoaded<Result<PaymentDetailPanelBean>> $callback2) {
        this.$callback = $callback2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r1 = r6.body();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.ext.common.Result<com.baidu.searchbox.flowvideo.paymentpanel.api.PaymentDetailPanelBean> parseResponse(okhttp3.Response r6, int r7, com.baidu.searchbox.http.statistics.NetworkStatRecord r8) {
        /*
            r5 = this;
            r0 = 200(0xc8, float:2.8E-43)
            if (r7 != r0) goto L_0x003e
            r0 = 0
            if (r6 == 0) goto L_0x0012
            okhttp3.ResponseBody r1 = r6.body()
            if (r1 == 0) goto L_0x0012
            java.lang.String r1 = r1.string()
            goto L_0x0013
        L_0x0012:
            r1 = r0
        L_0x0013:
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0022
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            r4 = r4 ^ r3
            if (r4 != r3) goto L_0x0022
            r2 = r3
        L_0x0022:
            if (r2 == 0) goto L_0x003e
            com.google.gson.Gson r2 = com.baidu.searchbox.video.detail.utils.gson.VideoGsonFactory.build()
            java.lang.Class<com.baidu.searchbox.flowvideo.paymentpanel.api.PaymentDetailPanelBean> r3 = com.baidu.searchbox.flowvideo.paymentpanel.api.PaymentDetailPanelBean.class
            java.lang.Object r2 = com.baidu.searchbox.video.detail.utils.gson.VideoGsonFactoryKt.safeFromJson((com.google.gson.Gson) r2, (java.lang.String) r1, r3)
            com.baidu.searchbox.flowvideo.paymentpanel.api.PaymentDetailPanelBean r2 = (com.baidu.searchbox.flowvideo.paymentpanel.api.PaymentDetailPanelBean) r2
            if (r2 == 0) goto L_0x003b
            r0 = r2
            r3 = 0
            com.baidu.searchbox.feed.detail.ext.common.Result$Success r4 = new com.baidu.searchbox.feed.detail.ext.common.Result$Success
            r4.<init>(r0)
            r0 = r4
        L_0x003b:
            com.baidu.searchbox.feed.detail.ext.common.Result r0 = (com.baidu.searchbox.feed.detail.ext.common.Result) r0
            return r0
        L_0x003e:
            com.baidu.searchbox.feed.detail.ext.common.Result$Failure r0 = new com.baidu.searchbox.feed.detail.ext.common.Result$Failure
            java.lang.Throwable r1 = new java.lang.Throwable
            java.lang.String r2 = "PaymentDetailPanelServiceImpl: response body is null"
            r1.<init>(r2)
            r0.<init>(r1)
            com.baidu.searchbox.feed.detail.ext.common.Result r0 = (com.baidu.searchbox.feed.detail.ext.common.Result) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.di.api.PaymentDetailPanelServiceImpl$requestData$1.parseResponse(okhttp3.Response, int, com.baidu.searchbox.http.statistics.NetworkStatRecord):com.baidu.searchbox.feed.detail.ext.common.Result");
    }

    public void onFail(Exception e2) {
        OnDataLoaded<Result<PaymentDetailPanelBean>> onDataLoaded = this.$callback;
        if (onDataLoaded != null) {
            onDataLoaded.onDataLoaded(new Result.Failure(new Throwable("PaymentDetailPanelServiceImpl: " + (e2 != null ? e2.getMessage() : null))));
        }
    }

    public void onSuccess(Result<PaymentDetailPanelBean> result, int p1) {
        if (result != null) {
            OnDataLoaded<Result<PaymentDetailPanelBean>> onDataLoaded = this.$callback;
            Result resultSuccess = result;
            if (onDataLoaded != null) {
                onDataLoaded.onDataLoaded(resultSuccess);
            }
        }
    }
}
