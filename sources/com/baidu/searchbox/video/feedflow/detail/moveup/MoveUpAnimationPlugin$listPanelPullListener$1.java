package com.baidu.searchbox.video.feedflow.detail.moveup;

import com.baidu.searchbox.video.feedflow.detail.listpanel.service.IListPanelPullListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/moveup/MoveUpAnimationPlugin$listPanelPullListener$1", "Lcom/baidu/searchbox/video/feedflow/detail/listpanel/service/IListPanelPullListener;", "onVerticalPullProgressChanged", "", "progress", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MoveUpAnimationPlugin.kt */
public final class MoveUpAnimationPlugin$listPanelPullListener$1 implements IListPanelPullListener {
    final /* synthetic */ MoveUpAnimationPlugin this$0;

    MoveUpAnimationPlugin$listPanelPullListener$1(MoveUpAnimationPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onVerticalPullProgressChanged(float progress) {
        this.this$0.onProgressChanged(((float) 1) - progress);
    }
}
