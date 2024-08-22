package com.baidu.searchbox.video.feedflow.cache;

import com.baidu.searchbox.player.utils.SimpleCyberInstallListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/video/feedflow/cache/FlowVideoMediaDownloader$download$1", "Lcom/baidu/searchbox/player/utils/SimpleCyberInstallListener;", "onInstallSuccess", "", "installType", "", "coreVer", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoMediaDownloader.kt */
public final class FlowVideoMediaDownloader$download$1 extends SimpleCyberInstallListener {
    final /* synthetic */ String $nid;
    final /* synthetic */ String $url;
    final /* synthetic */ FlowVideoMediaDownloader this$0;

    FlowVideoMediaDownloader$download$1(FlowVideoMediaDownloader $receiver, String $nid2, String $url2) {
        this.this$0 = $receiver;
        this.$nid = $nid2;
        this.$url = $url2;
    }

    public void onInstallSuccess(int installType, String coreVer) {
        this.this$0.startDownload(this.$nid, this.$url);
    }
}
