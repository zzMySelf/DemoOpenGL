package com.baidu.searchbox.video.feedflow.di.api;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.videoauthentication.api.VideoAuthenticationBean;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"com/baidu/searchbox/video/feedflow/di/api/VideoAuthenticationFetchUrlServiceImpl$requestData$1", "Lcom/baidu/searchbox/http/callback/StatResponseCallback;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/videoauthentication/api/VideoAuthenticationBean;", "onFail", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "result", "state", "", "parseResponse", "response", "Lokhttp3/Response;", "statRecord", "Lcom/baidu/searchbox/http/statistics/NetworkStatRecord;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoAuthenticationFetchUrlServiceImpl.kt */
public final class VideoAuthenticationFetchUrlServiceImpl$requestData$1 implements StatResponseCallback<Result<VideoAuthenticationBean>> {
    final /* synthetic */ OnDataLoaded<Result<VideoAuthenticationBean>> $callback;

    VideoAuthenticationFetchUrlServiceImpl$requestData$1(OnDataLoaded<Result<VideoAuthenticationBean>> $callback2) {
        this.$callback = $callback2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = r8.body();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.ext.common.Result<com.baidu.searchbox.flowvideo.videoauthentication.api.VideoAuthenticationBean> parseResponse(okhttp3.Response r8, int r9, com.baidu.searchbox.http.statistics.NetworkStatRecord r10) {
        /*
            r7 = this;
            r0 = 200(0xc8, float:2.8E-43)
            if (r9 != r0) goto L_0x0057
            if (r8 == 0) goto L_0x0011
            okhttp3.ResponseBody r0 = r8.body()
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.string()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0021
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r3 = r3 ^ r2
            if (r3 != r2) goto L_0x0021
            r1 = r2
        L_0x0021:
            if (r1 == 0) goto L_0x0057
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x004b }
            r1.<init>(r0)     // Catch:{ Exception -> 0x004b }
            java.lang.String r2 = "data"
            org.json.JSONObject r1 = r1.optJSONObject(r2)     // Catch:{ Exception -> 0x004b }
            if (r1 == 0) goto L_0x0057
            r2 = 0
            com.baidu.searchbox.flowvideo.videoauthentication.api.VideoAuthenticationBean r3 = new com.baidu.searchbox.flowvideo.videoauthentication.api.VideoAuthenticationBean     // Catch:{ Exception -> 0x004b }
            java.lang.String r4 = "expire_at"
            long r4 = r1.optLong(r4)     // Catch:{ Exception -> 0x004b }
            java.lang.String r6 = "clarity_item"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ Exception -> 0x004b }
            r3.<init>(r4, r6)     // Catch:{ Exception -> 0x004b }
            com.baidu.searchbox.feed.detail.ext.common.Result$Success r4 = new com.baidu.searchbox.feed.detail.ext.common.Result$Success     // Catch:{ Exception -> 0x004b }
            r4.<init>(r3)     // Catch:{ Exception -> 0x004b }
            com.baidu.searchbox.feed.detail.ext.common.Result r4 = (com.baidu.searchbox.feed.detail.ext.common.Result) r4     // Catch:{ Exception -> 0x004b }
            return r4
        L_0x004b:
            r1 = move-exception
            com.baidu.searchbox.video.feedflow.di.DIFactory r2 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            boolean r2 = r2.isDebug()
            if (r2 == 0) goto L_0x0057
            r1.printStackTrace()
        L_0x0057:
            com.baidu.searchbox.feed.detail.ext.common.Result$Failure r0 = new com.baidu.searchbox.feed.detail.ext.common.Result$Failure
            java.lang.Throwable r1 = new java.lang.Throwable
            java.lang.String r2 = "VideoAuthenticationFetchUrlServiceImpl: response body is null"
            r1.<init>(r2)
            r0.<init>(r1)
            com.baidu.searchbox.feed.detail.ext.common.Result r0 = (com.baidu.searchbox.feed.detail.ext.common.Result) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.di.api.VideoAuthenticationFetchUrlServiceImpl$requestData$1.parseResponse(okhttp3.Response, int, com.baidu.searchbox.http.statistics.NetworkStatRecord):com.baidu.searchbox.feed.detail.ext.common.Result");
    }

    public void onSuccess(Result<VideoAuthenticationBean> result, int state) {
        if (result != null) {
            OnDataLoaded<Result<VideoAuthenticationBean>> onDataLoaded = this.$callback;
            Result resultSuccess = result;
            if (onDataLoaded != null) {
                onDataLoaded.onDataLoaded(resultSuccess);
            }
        }
    }

    public void onFail(Exception e2) {
        OnDataLoaded<Result<VideoAuthenticationBean>> onDataLoaded = this.$callback;
        if (onDataLoaded != null) {
            onDataLoaded.onDataLoaded(new Result.Failure(new Throwable("VideoAuthenticationFetchUrlServiceImpl: " + (e2 != null ? e2.getMessage() : null))));
        }
    }
}
