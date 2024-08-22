package com.baidu.searchbox.video.feedflow.detail.speed;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isOpen", "", "curSpeed", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedPanelPlugin.kt */
final class SpeedPanelPlugin$initSpeedOptionPanel$1$1$2 extends Lambda implements Function2<Boolean, Float, Unit> {
    final /* synthetic */ SpeedPanelPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpeedPanelPlugin$initSpeedOptionPanel$1$1$2(SpeedPanelPlugin speedPanelPlugin) {
        super(2);
        this.this$0 = speedPanelPlugin;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Number) p2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isOpen, float curSpeed) {
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) this.this$0.getManager().getService(IPlayerComponentService.class);
        int currentHash = iPlayerComponentService != null ? iPlayerComponentService.getPlayerHashCode() : 0;
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new SpeedPanelOnlyCurVideoSwitchAction(isOpen, curSpeed, currentHash));
        }
    }
}
