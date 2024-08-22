package com.baidu.searchbox.video.feedflow.flow.comonlistpanel;

import com.baidu.searchbox.video.detail.utils.NumberUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionPanelPopupWindow;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionPanelView;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.service.ICommonListPanelPullListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/comonlistpanel/CommonListPanelPlugin$dragListener$1", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionPanelView$IDragListener;", "onHorizontalDrag", "", "distance", "", "width", "onVerticalDrag", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonListPanelPlugin.kt */
public final class CommonListPanelPlugin$dragListener$1 implements CollectionPanelView.IDragListener {
    final /* synthetic */ CommonListPanelPlugin this$0;

    CommonListPanelPlugin$dragListener$1(CommonListPanelPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onHorizontalDrag(int distance, int width) {
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) this.this$0.getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            iPlayerComponentService.updatePlayerScale(Math.abs(((float) distance) / ((float) width)));
        }
    }

    public void onVerticalDrag(int distance) {
        float f2;
        CollectionPanelPopupWindow access$getPopupWindow$p = this.this$0.popupWindow;
        int totalHeight = access$getPopupWindow$p != null ? access$getPopupWindow$p.getHeight() : 0;
        if (totalHeight != 0) {
            f2 = ((float) distance) / ((float) totalHeight);
        } else {
            f2 = 0.0f;
        }
        float percent = NumberUtilsKt.rangeLimit(f2, 0.0f, 1.0f);
        for (ICommonListPanelPullListener collectionListener : this.this$0.commonListPullListenerSet) {
            collectionListener.onVerticalPullProgressChanged(percent);
        }
    }
}
