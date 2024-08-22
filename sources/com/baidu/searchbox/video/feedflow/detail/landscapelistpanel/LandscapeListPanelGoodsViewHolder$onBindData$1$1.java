package com.baidu.searchbox.video.feedflow.detail.landscapelistpanel;

import android.text.Layout;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/landscapelistpanel/LandscapeListPanelGoodsViewHolder$onBindData$1$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandscapeListPanelGoodsViewHolder.kt */
public final class LandscapeListPanelGoodsViewHolder$onBindData$1$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ LandscapeListPanelGoodsViewHolder this$0;

    LandscapeListPanelGoodsViewHolder$onBindData$1$1(LandscapeListPanelGoodsViewHolder $receiver) {
        this.this$0 = $receiver;
    }

    public void onGlobalLayout() {
        Layout layout = this.this$0.tvDiscount.getLayout();
        int i2 = -1;
        if ((layout != null ? layout.getEllipsisCount(0) : -1) > 0) {
            Layout layout2 = this.this$0.tvDiscount.getLayout();
            if (layout2 != null) {
                i2 = layout2.getEllipsisStart(0);
            }
            if (i2 == 0) {
                this.this$0.tvDiscount.setVisibility(8);
                this.this$0.tvDiscount.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
        this.this$0.tvDiscount.setVisibility(0);
        this.this$0.tvDiscount.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
