package com.baidu.searchbox.discovery.picture.widget.elements;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/discovery/picture/widget/elements/UgcBottomStateIconItem$initBadgeViewInBottomBar$badgeView$1$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "lib-atlas_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UgcBottomStateIconItem.kt */
public final class UgcBottomStateIconItem$initBadgeViewInBottomBar$badgeView$1$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ FrameLayout $parentView;
    final /* synthetic */ UgcBottomStateIconItem this$0;

    UgcBottomStateIconItem$initBadgeViewInBottomBar$badgeView$1$1(UgcBottomStateIconItem $receiver, FrameLayout $parentView2) {
        this.this$0 = $receiver;
        this.$parentView = $parentView2;
    }

    public void onGlobalLayout() {
        Rect offsetViewBounds = new Rect();
        this.this$0.icon.getDrawingRect(offsetViewBounds);
        this.$parentView.offsetDescendantRectToMyCoords(this.this$0.icon, offsetViewBounds);
        if (this.this$0.iconRight != offsetViewBounds.right || this.this$0.iconTop != offsetViewBounds.top) {
            this.this$0.iconRight = offsetViewBounds.right;
            this.this$0.iconTop = offsetViewBounds.top;
            UgcBottomStateIconItem ugcBottomStateIconItem = this.this$0;
            ugcBottomStateIconItem.updateBadgePosition(ugcBottomStateIconItem.getBadgeView());
        }
    }
}
