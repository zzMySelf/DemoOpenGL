package com.baidu.searchbox.video.feedflow.di.api;

import com.baidu.searchbox.feed.detail.ext.common.OnDataLoaded;
import com.baidu.searchbox.feed.detail.ext.common.Result;
import com.baidu.searchbox.flowvideo.collection.api.VideoCollectionQueryBean;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"com/baidu/searchbox/video/feedflow/di/api/VideoCollectionQueryServiceImpl$requestData$1", "Lcom/baidu/searchbox/http/callback/StatResponseCallback;", "Lcom/baidu/searchbox/feed/detail/ext/common/Result;", "Lcom/baidu/searchbox/flowvideo/collection/api/VideoCollectionQueryBean;", "onFail", "", "e", "Ljava/lang/Exception;", "onSuccess", "result", "code", "", "parseResponse", "response", "Lokhttp3/Response;", "state", "statRecord", "Lcom/baidu/searchbox/http/statistics/NetworkStatRecord;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCollectionQueryServiceImpl.kt */
public final class VideoCollectionQueryServiceImpl$requestData$1 implements StatResponseCallback<Result<VideoCollectionQueryBean>> {
    final /* synthetic */ OnDataLoaded<Result<VideoCollectionQueryBean>> $callback;

    VideoCollectionQueryServiceImpl$requestData$1(OnDataLoaded<Result<VideoCollectionQueryBean>> $callback2) {
        this.$callback = $callback2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r4.body();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.ext.common.Result<com.baidu.searchbox.flowvideo.collection.api.VideoCollectionQueryBean> parseResponse(okhttp3.Response r4, int r5, com.baidu.searchbox.http.statistics.NetworkStatRecord r6) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x000d
            okhttp3.ResponseBody r0 = r4.body()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.string()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            com.baidu.searchbox.flowvideo.collection.api.VideoCollectionQueryBean r1 = new com.baidu.searchbox.flowvideo.collection.api.VideoCollectionQueryBean
            if (r0 != 0) goto L_0x0015
            java.lang.String r2 = ""
            goto L_0x0016
        L_0x0015:
            r2 = r0
        L_0x0016:
            r1.<init>(r5, r2)
            com.baidu.searchbox.feed.detail.ext.common.Result$Success r2 = new com.baidu.searchbox.feed.detail.ext.common.Result$Success
            r2.<init>(r1)
            com.baidu.searchbox.feed.detail.ext.common.Result r2 = (com.baidu.searchbox.feed.detail.ext.common.Result) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.di.api.VideoCollectionQueryServiceImpl$requestData$1.parseResponse(okhttp3.Response, int, com.baidu.searchbox.http.statistics.NetworkStatRecord):com.baidu.searchbox.feed.detail.ext.common.Result");
    }

    public void onSuccess(Result<VideoCollectionQueryBean> result, int code) {
        if (result != null) {
            OnDataLoaded<Result<VideoCollectionQueryBean>> onDataLoaded = this.$callback;
            Result resultSuccess = result;
            if (onDataLoaded != null) {
                onDataLoaded.onDataLoaded(resultSuccess);
            }
        }
    }

    public void onFail(Exception e2) {
        OnDataLoaded<Result<VideoCollectionQueryBean>> onDataLoaded = this.$callback;
        if (onDataLoaded != null) {
            String message = e2 != null ? e2.getMessage() : null;
            if (message == null) {
                message = "";
            }
            onDataLoaded.onDataLoaded(new Result.Failure(new Throwable(message)));
        }
    }
}
