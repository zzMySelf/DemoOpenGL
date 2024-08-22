package com.baidu.searchbox.video.feedflow.flow.liverealroom;

import com.baidu.searchbox.live.host2live.video.IVideoInsertLiveService;
import com.baidu.searchbox.live.host2live.video.LiveType;
import com.baidu.searchbox.video.feedflow.detail.livereal.LiveAtcData;
import com.baidu.searchbox.video.feedflow.detail.livereal.LiveCheckStatus;
import com.baidu.searchbox.video.feedflow.detail.livereal.MediaAndYYController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/liverealroom/LiveRealCheckLoadPlugin$loadLivePluginCallback$1", "Lcom/baidu/searchbox/live/host2live/video/IVideoInsertLiveService$LoadResultCallback;", "onEvent", "", "result", "", "code", "", "onResult", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveRealCheckLoadPlugin.kt */
public final class LiveRealCheckLoadPlugin$loadLivePluginCallback$1 implements IVideoInsertLiveService.LoadResultCallback {
    final /* synthetic */ LiveType $type;
    final /* synthetic */ LiveRealCheckLoadPlugin this$0;

    LiveRealCheckLoadPlugin$loadLivePluginCallback$1(LiveRealCheckLoadPlugin $receiver, LiveType $type2) {
        this.this$0 = $receiver;
        this.$type = $type2;
    }

    public void onEvent(boolean result, int code) {
    }

    public void onResult(boolean result) {
        if (result) {
            LiveAtcData liveAct = MediaAndYYController.INSTANCE.getLiveAct(this.this$0.getContext().hashCode(), this.$type);
            if (liveAct != null) {
                liveAct.setCheckStatus(LiveCheckStatus.SUPPORT);
            }
            this.this$0.checkNextYYRealLive(this.$type);
            return;
        }
        LiveAtcData liveAct2 = MediaAndYYController.INSTANCE.getLiveAct(this.this$0.getContext().hashCode(), this.$type);
        if (liveAct2 != null) {
            liveAct2.setCheckStatus(LiveCheckStatus.UN_SUPPORT);
        }
    }
}
