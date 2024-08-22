package com.baidu.searchbox.video.feedflow.di.api;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.flow.api.FlowListBean;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.video.feedflow.detail.batch.BatchCardParamsFor350Manager;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, d2 = {"com/baidu/searchbox/video/feedflow/di/api/FlowServiceImpl$requestData$1", "Lcom/baidu/searchbox/http/callback/StatResponseCallback;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/flow/api/FlowListBean;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "p1", "", "parseResponse", "response", "Lokhttp3/Response;", "state", "statRecord", "Lcom/baidu/searchbox/http/statistics/NetworkStatRecord;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowServiceImpl.kt */
public final class FlowServiceImpl$requestData$1 implements StatResponseCallback<Result<FlowListBean>> {
    final /* synthetic */ OnDataLoaded<Result<FlowListBean>> $callback;
    final /* synthetic */ Map<String, String> $post;
    final /* synthetic */ long $requestStart;

    FlowServiceImpl$requestData$1(long $requestStart2, Map<String, String> $post2, OnDataLoaded<Result<FlowListBean>> $callback2) {
        this.$requestStart = $requestStart2;
        this.$post = $post2;
        this.$callback = $callback2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0047, code lost:
        r8 = kotlin.text.StringsKt.toLongOrNull((r8 = r1.header("X-SERVER-COST")));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.ext.common.Result<com.baidu.searchbox.flowvideo.flow.api.FlowListBean> parseResponse(okhttp3.Response r26, int r27, com.baidu.searchbox.http.statistics.NetworkStatRecord r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = 200(0xc8, float:2.8E-43)
            r3 = r27
            if (r3 != r2) goto L_0x0157
            com.baidu.searchbox.common.RequestRecordStat r2 = new com.baidu.searchbox.common.RequestRecordStat
            r4 = r2
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 511(0x1ff, float:7.16E-43)
            r24 = 0
            r4.<init>(r5, r7, r9, r11, r13, r15, r17, r19, r21, r23, r24)
            if (r28 == 0) goto L_0x0086
            long r4 = r0.$requestStart
            r6 = r28
            r7 = 0
            long r8 = r6.dnsEndTs
            long r10 = r6.dnsStartTs
            long r8 = r8 - r10
            r2.setDnsCost(r8)
            long r8 = r6.connTs
            long r10 = r6.startTs
            long r8 = r8 - r10
            r2.setConnectCost(r8)
            if (r1 == 0) goto L_0x0052
            java.lang.String r8 = "X-SERVER-COST"
            java.lang.String r8 = r1.header(r8)
            if (r8 == 0) goto L_0x0052
            java.lang.Long r8 = kotlin.text.StringsKt.toLongOrNull(r8)
            if (r8 == 0) goto L_0x0052
            long r8 = r8.longValue()
            goto L_0x0054
        L_0x0052:
            r8 = 0
        L_0x0054:
            r2.setServerCost(r8)
            long r8 = r6.finishTs
            long r10 = r6.startTs
            long r8 = r8 - r10
            r2.setNetTotalCost(r8)
            long r8 = r2.getNetTotalCost()
            long r10 = r2.getConnectCost()
            long r8 = r8 - r10
            long r10 = r2.getServerCost()
            long r8 = r8 - r10
            r2.setResponseNetDelayCost(r8)
            long r8 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r4
            r2.setOkHttpCost(r8)
            long r4 = r2.getOkHttpCost()
            long r8 = r2.getNetTotalCost()
            long r4 = r4 - r8
            r2.setThreadSwitchCost(r4)
        L_0x0086:
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r0.$requestStart
            long r4 = r4 - r6
            r2.setRequestTotalCost(r4)
            r4 = 0
            if (r1 == 0) goto L_0x009e
            okhttp3.ResponseBody r5 = r26.body()
            if (r5 == 0) goto L_0x009e
            java.lang.String r5 = r5.string()
            goto L_0x009f
        L_0x009e:
            r5 = r4
        L_0x009f:
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x00ae
            r8 = r5
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)
            r8 = r8 ^ r7
            if (r8 != r7) goto L_0x00ae
            r6 = r7
        L_0x00ae:
            if (r6 == 0) goto L_0x0157
            long r8 = java.lang.System.currentTimeMillis()
            com.baidu.searchbox.video.feedflow.di.api.FlowServiceImpl$requestData$1$parseResponse$type$1 r6 = new com.baidu.searchbox.video.feedflow.di.api.FlowServiceImpl$requestData$1$parseResponse$type$1
            r6.<init>()
            java.lang.reflect.Type r6 = r6.getType()
            com.google.gson.Gson r10 = com.baidu.searchbox.video.detail.utils.gson.VideoGsonFactory.build()
            java.lang.String r11 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r11)
            java.lang.Object r10 = com.baidu.searchbox.video.detail.utils.gson.VideoGsonFactoryKt.safeFromJson((com.google.gson.Gson) r10, (java.lang.String) r5, (java.lang.reflect.Type) r6)
            com.baidu.searchbox.common.FlowBean r10 = (com.baidu.searchbox.common.FlowBean) r10
            if (r10 == 0) goto L_0x0154
            java.lang.Object r11 = r10.getRealData()
            com.baidu.searchbox.flowvideo.flow.api.FlowListBean r11 = (com.baidu.searchbox.flowvideo.flow.api.FlowListBean) r11
            if (r11 == 0) goto L_0x0154
            java.util.Map<java.lang.String, java.lang.String> r4 = r0.$post
            r12 = 0
            com.baidu.searchbox.flowvideo.flow.repos.FlowListParam$Companion r13 = com.baidu.searchbox.flowvideo.flow.repos.FlowListParam.Companion
            com.baidu.searchbox.flowvideo.flow.repos.FlowListParam r4 = r13.toModel(r4)
            long r13 = java.lang.System.currentTimeMillis()
            long r13 = r13 - r8
            r2.setParseModelCost(r13)
            java.lang.String r13 = "request_extend_record_stat"
            r11.putExtData(r13, r2)
            java.lang.String r13 = r4.getPn()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            boolean r13 = kotlin.text.StringsKt.isBlank(r13)
            r7 = r7 ^ r13
            if (r7 == 0) goto L_0x00ff
            java.lang.String r7 = r4.getPn()
            goto L_0x0101
        L_0x00ff:
            java.lang.String r7 = "1"
        L_0x0101:
            r11.setPn(r7)
            r11.setOriginData(r5)
            java.lang.String r7 = r4.getRefreshState()
            java.lang.String r13 = "request_extend_refresh_state"
            r11.putExtData(r13, r7)
            java.util.List r7 = r11.getItems()
            if (r7 != 0) goto L_0x011a
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x011a:
            java.util.Iterator r13 = r7.iterator()
        L_0x011e:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x014e
            java.lang.Object r14 = r13.next()
            com.baidu.searchbox.flowvideo.flow.api.ListItemBean r14 = (com.baidu.searchbox.flowvideo.flow.api.ListItemBean) r14
            com.baidu.searchbox.flowvideo.flow.api.ListItemDataBean r15 = r14.getData()
            if (r15 == 0) goto L_0x0149
            java.lang.String r15 = r15.getVideoInfo()
            if (r15 != 0) goto L_0x0137
            goto L_0x0149
        L_0x0137:
            com.baidu.searchbox.flowvideo.flow.api.ListItemDataBean r0 = r14.getData()
            if (r0 == 0) goto L_0x0144
            com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries r1 = com.baidu.searchbox.video.detail.utils.VideoInfoParserABUtilsKt.parseVideoInfoAbTest(r15)
            com.baidu.searchbox.flowvideo.flow.api.FlowListBeanKt.putBdVideoSeries(r0, r1)
        L_0x0144:
            r0 = r25
            r1 = r26
            goto L_0x011e
        L_0x0149:
            r0 = r25
            r1 = r26
            goto L_0x011e
        L_0x014e:
            com.baidu.searchbox.feed.detail.ext.common.Result$Success r0 = new com.baidu.searchbox.feed.detail.ext.common.Result$Success
            r0.<init>(r11)
            r4 = r0
        L_0x0154:
            com.baidu.searchbox.feed.detail.ext.common.Result r4 = (com.baidu.searchbox.feed.detail.ext.common.Result) r4
            return r4
        L_0x0157:
            com.baidu.searchbox.feed.detail.ext.common.Result$Failure r0 = new com.baidu.searchbox.feed.detail.ext.common.Result$Failure
            java.lang.Throwable r1 = new java.lang.Throwable
            java.lang.String r2 = "FlowListServiceImpl: response body is null"
            r1.<init>(r2)
            r0.<init>(r1)
            com.baidu.searchbox.feed.detail.ext.common.Result r0 = (com.baidu.searchbox.feed.detail.ext.common.Result) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.di.api.FlowServiceImpl$requestData$1.parseResponse(okhttp3.Response, int, com.baidu.searchbox.http.statistics.NetworkStatRecord):com.baidu.searchbox.feed.detail.ext.common.Result");
    }

    public void onSuccess(Result<FlowListBean> result, int p1) {
        if (result != null) {
            OnDataLoaded<Result<FlowListBean>> onDataLoaded = this.$callback;
            Result resultSuccess = result;
            if (onDataLoaded != null) {
                onDataLoaded.onDataLoaded(resultSuccess);
            }
            BatchCardParamsFor350Manager.INSTANCE.reset();
        }
    }

    public void onFail(Exception e2) {
        OnDataLoaded<Result<FlowListBean>> onDataLoaded = this.$callback;
        if (onDataLoaded != null) {
            onDataLoaded.onDataLoaded(new Result.Failure(new Throwable("FlowListServiceImpl: " + (e2 != null ? e2.getMessage() : null))));
        }
    }
}
