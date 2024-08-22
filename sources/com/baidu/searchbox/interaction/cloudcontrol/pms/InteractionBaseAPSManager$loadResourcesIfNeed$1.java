package com.baidu.searchbox.interaction.cloudcontrol.pms;

import com.baidu.searchbox.feed.pms.FeedPmsStatisticHelper;
import com.baidu.searchbox.feed.util.LogEx;
import com.baidu.searchbox.interaction.cloudcontrol.pms.InteractionBaseAPSManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/interaction/cloudcontrol/pms/InteractionBaseAPSManager$loadResourcesIfNeed$1", "Lcom/baidu/searchbox/interaction/cloudcontrol/pms/InteractionLoadResultCallback;", "onFail", "", "log", "", "onSuccess", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractionBaseAPSManager.kt */
public final class InteractionBaseAPSManager$loadResourcesIfNeed$1 implements InteractionLoadResultCallback {
    final /* synthetic */ InteractionBaseAPSManager<T> this$0;

    InteractionBaseAPSManager$loadResourcesIfNeed$1(InteractionBaseAPSManager<T> $receiver) {
        this.this$0 = $receiver;
    }

    public void onSuccess() {
        this.this$0.isLoaded = true;
        InteractionBaseAPSManager.Companion companion = InteractionBaseAPSManager.Companion;
        LogEx.d(InteractionBaseAPSManager.getTAG(), "[loadResourcesIfNeed] load success: " + this.this$0.getPackageName());
        FeedPmsStatisticHelper.INSTANCE.notifyStateSuccess("240", this.this$0.getPackageName(), true);
    }

    public void onFail(String log) {
        this.this$0.triggerAPSRetryIfNeed(log);
    }
}
