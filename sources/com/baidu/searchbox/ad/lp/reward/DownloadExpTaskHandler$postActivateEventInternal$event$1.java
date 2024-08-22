package com.baidu.searchbox.ad.lp.reward;

import com.baidu.searchbox.ad.reward.SimpleAppStatusChangeListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/ad/lp/reward/DownloadExpTaskHandler$postActivateEventInternal$event$1", "Lcom/baidu/searchbox/ad/reward/SimpleAppStatusChangeListener;", "onInstallComplete", "", "lib-ad-lp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadExpTaskHandler.kt */
public final class DownloadExpTaskHandler$postActivateEventInternal$event$1 extends SimpleAppStatusChangeListener {
    final /* synthetic */ DownloadExpTaskHandler this$0;

    DownloadExpTaskHandler$postActivateEventInternal$event$1(DownloadExpTaskHandler $receiver) {
        this.this$0 = $receiver;
    }

    public void onInstallComplete() {
        if (this.this$0.downloadExpActivated && !this.this$0.downloadExpComplete) {
            this.this$0.rootView.postDelayed(this.this$0.downloadExpTask, this.this$0.cmdData.getDownloadExpDuration());
        }
    }
}
