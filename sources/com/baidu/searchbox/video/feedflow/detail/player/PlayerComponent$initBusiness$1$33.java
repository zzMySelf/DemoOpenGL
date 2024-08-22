package com.baidu.searchbox.video.feedflow.detail.player;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.floating.config.InvokeFloatingMode;
import com.baidu.searchbox.video.feedflow.detail.floating.model.FloatingStartModel;
import com.baidu.searchbox.video.feedflow.detail.player.player.IFloatingAppBackOrForegroundListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/player/PlayerComponent$initBusiness$1$33", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/IFloatingAppBackOrForegroundListener;", "onAutoSwitchToFloatingBefore", "", "onFloatingDestroy", "onRetainDialogVisibleChange", "show", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerComponent.kt */
public final class PlayerComponent$initBusiness$1$33 implements IFloatingAppBackOrForegroundListener {
    final /* synthetic */ PlayerComponent this$0;

    PlayerComponent$initBusiness$1$33(PlayerComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onAutoSwitchToFloatingBefore() {
        if (PlayerComponent.isNeedShowFloating$default(this.this$0, (FloatingStartModel) null, 1, (Object) null)) {
            this.this$0.setFloatingData(InvokeFloatingMode.AUTO_OUT_APP);
        }
    }

    public void onFloatingDestroy() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new OnFloatViewVisibleChangeAction(false));
        }
    }

    public void onRetainDialogVisibleChange(boolean show) {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new OnRetainDialogVisibleChangeAction(show));
        }
    }
}
