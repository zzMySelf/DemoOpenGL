package com.baidu.searchbox.video.feedflow.detail.listpanel;

import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/listpanel/ListPanelPlugin$dragListener$1", "Lcom/baidu/searchbox/video/feedflow/detail/listpanel/IDragListener;", "onHorizontalDrag", "", "distance", "", "width", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListPanelPlugin.kt */
public final class ListPanelPlugin$dragListener$1 implements IDragListener {
    final /* synthetic */ ListPanelPlugin this$0;

    ListPanelPlugin$dragListener$1(ListPanelPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onHorizontalDrag(int distance, int width) {
        IPlayerComponentService access$getPlayerService = this.this$0.getPlayerService();
        if (access$getPlayerService != null) {
            access$getPlayerService.updatePlayerScale(Math.abs(((float) distance) / ((float) width)));
        }
    }
}
