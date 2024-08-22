package com.baidu.searchbox.video.hotflow.player;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayConfigKt;
import com.baidu.searchbox.video.feedflow.detail.player.player.plugin.VideoFlowAutoplaySwitchPlugin;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/baidu/searchbox/video/hotflow/player/HotPlayerComponent$initFlowPlayer$1", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/plugin/VideoFlowAutoplaySwitchPlugin$ObtainAutoplaySwitchListener;", "obtainAutoplaySwitch", "", "obtainAutoplayTipSwitch", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotPlayerComponent.kt */
public final class HotPlayerComponent$initFlowPlayer$1 implements VideoFlowAutoplaySwitchPlugin.ObtainAutoplaySwitchListener {
    final /* synthetic */ HotPlayerComponent this$0;

    HotPlayerComponent$initFlowPlayer$1(HotPlayerComponent $receiver) {
        this.this$0 = $receiver;
    }

    public boolean obtainAutoplaySwitch() {
        return AutoplayConfigKt.findAutoplaySwitch((Store<?>) this.this$0.getStore());
    }

    public boolean obtainAutoplayTipSwitch() {
        return DIFactory.INSTANCE.getConfig().getAutoplayNewTip();
    }
}
