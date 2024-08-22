package com.baidu.searchbox.video.feedflow.ad.moveup;

import com.baidu.searchbox.video.feedflow.detail.moveup.IPanelMoveUpService;
import com.baidu.searchbox.video.feedflow.detail.moveup.PanelMoveUpListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/moveup/NadPanelMoveUpService;", "Lcom/baidu/searchbox/video/feedflow/detail/moveup/IPanelMoveUpService;", "plugin", "Lcom/baidu/searchbox/video/feedflow/ad/moveup/NadMoveUpAnimationPlugin;", "(Lcom/baidu/searchbox/video/feedflow/ad/moveup/NadMoveUpAnimationPlugin;)V", "getPlugin", "()Lcom/baidu/searchbox/video/feedflow/ad/moveup/NadMoveUpAnimationPlugin;", "addMoveUplListener", "", "listener", "Lcom/baidu/searchbox/video/feedflow/detail/moveup/PanelMoveUpListener;", "changePanelVisible", "isShow", "", "isPanelShowing", "removeMoveUpListener", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadPanelMoveUpService.kt */
public final class NadPanelMoveUpService implements IPanelMoveUpService {
    private final NadMoveUpAnimationPlugin plugin;

    public NadPanelMoveUpService(NadMoveUpAnimationPlugin plugin2) {
        Intrinsics.checkNotNullParameter(plugin2, "plugin");
        this.plugin = plugin2;
    }

    public final NadMoveUpAnimationPlugin getPlugin() {
        return this.plugin;
    }

    public void addMoveUplListener(PanelMoveUpListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.plugin.addMoveUplListener(listener);
    }

    public void removeMoveUpListener(PanelMoveUpListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.plugin.removeMoveUpListener(listener);
    }

    public void changePanelVisible(boolean isShow) {
    }

    public boolean isPanelShowing() {
        return this.plugin.isPanelShowing();
    }
}
