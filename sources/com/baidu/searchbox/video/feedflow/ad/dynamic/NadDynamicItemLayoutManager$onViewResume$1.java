package com.baidu.searchbox.video.feedflow.ad.dynamic;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.video.feedflow.detail.moveup.PanelMoveUpListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/video/feedflow/ad/dynamic/NadDynamicItemLayoutManager$onViewResume$1", "Lcom/baidu/searchbox/video/feedflow/detail/moveup/PanelMoveUpListener;", "onPanelHidden", "", "onPanelHiddenAnimatorEnd", "onPanelMoveUpProgressChanged", "progress", "", "onPanelShown", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadDynamicItemLayoutManager.kt */
public final class NadDynamicItemLayoutManager$onViewResume$1 implements PanelMoveUpListener {
    final /* synthetic */ NadDynamicItemLayoutManager this$0;

    NadDynamicItemLayoutManager$onViewResume$1(NadDynamicItemLayoutManager $receiver) {
        this.this$0 = $receiver;
    }

    public void onPanelAnimatorEnd() {
        PanelMoveUpListener.DefaultImpls.onPanelAnimatorEnd(this);
    }

    public void onPanelAnimatorStart() {
        PanelMoveUpListener.DefaultImpls.onPanelAnimatorStart(this);
    }

    public void onPanelShown() {
        this.this$0.setUpShowing(true);
        this.this$0.onTransitionToTopStart();
    }

    public void onPanelMoveUpProgressChanged(float progress) {
        this.this$0.updatePercentTransitionToTop(progress);
    }

    public void onPanelHidden() {
        this.this$0.setUpShowing(false);
    }

    public void onPanelHiddenAnimatorEnd() {
        PanelMoveUpListener.DefaultImpls.onPanelHiddenAnimatorEnd(this);
        View access$getCarouselPicView$p = this.this$0.carouselPicView;
        ViewGroup.LayoutParams layoutParams = access$getCarouselPicView$p != null ? access$getCarouselPicView$p.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        View access$getCarouselPicView$p2 = this.this$0.carouselPicView;
        if (access$getCarouselPicView$p2 != null) {
            access$getCarouselPicView$p2.requestLayout();
        }
    }
}
