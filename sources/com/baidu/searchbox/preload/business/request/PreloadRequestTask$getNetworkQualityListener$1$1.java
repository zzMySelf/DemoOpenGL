package com.baidu.searchbox.preload.business.request;

import com.baidu.searchbox.http.NetworkQuality;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/preload/business/request/PreloadRequestTask$getNetworkQualityListener$1$1", "Lcom/baidu/searchbox/http/NetworkQuality$NetworkQualityListener;", "onNetworkQualityChanged", "", "quality", "", "lib-preload-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreloadRequestTask.kt */
public final class PreloadRequestTask$getNetworkQualityListener$1$1 extends NetworkQuality.NetworkQualityListener {
    final /* synthetic */ int $mReqNetworkQuality;
    final /* synthetic */ PreloadRequestTask this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreloadRequestTask$getNetworkQualityListener$1$1(int $mReqNetworkQuality2, PreloadRequestTask $receiver, ExecutorService $super_call_param$1) {
        super($super_call_param$1);
        this.$mReqNetworkQuality = $mReqNetworkQuality2;
        this.this$0 = $receiver;
    }

    public void onNetworkQualityChanged(int quality) {
        if (quality > this.$mReqNetworkQuality) {
            this.this$0.asyncRequest(false, "preloadNetQualityBatterRetry");
            this.this$0.mNetworkQualityListener = null;
            NetworkQuality.removeNetworkQualityListener(this);
        }
    }
}
