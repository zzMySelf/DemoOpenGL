package com.baidu.searchbox.lightbrowser.component.groupguide;

import android.view.View;
import com.baidu.searchbox.lightbrowser.component.statistic.ComponentStatisticConstants;
import com.baidu.searchbox.lightbrowser.component.statistic.ComponentStatisticHelper;
import com.baidu.searchbox.widget.SlidingPaneLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/lightbrowser/component/groupguide/GroupPageGuideComponent$groupPageShow$2", "Lcom/baidu/searchbox/widget/SlidingPaneLayout$PanelSlideListener;", "onPanelClosed", "", "panel", "Landroid/view/View;", "onPanelOpened", "onPanelSlide", "slideOffset", "", "lib-lightbrowser-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupPageGuideComponent.kt */
public final class GroupPageGuideComponent$groupPageShow$2 implements SlidingPaneLayout.PanelSlideListener {
    final /* synthetic */ String $groupId;
    final /* synthetic */ GroupPageGuideComponent this$0;

    GroupPageGuideComponent$groupPageShow$2(GroupPageGuideComponent $receiver, String $groupId2) {
        this.this$0 = $receiver;
        this.$groupId = $groupId2;
    }

    public void onPanelSlide(View panel, float slideOffset) {
        if (!this.this$0.isInPageSlide) {
            this.this$0.isInPageSlide = true;
            if (this.this$0.isCanShowRetainGuide()) {
                this.this$0.showRetainGuide();
            }
        }
        this.this$0.updateRetainGuideAlpha(slideOffset);
    }

    public void onPanelOpened(View panel) {
        this.this$0.isInPageSlide = false;
        this.this$0.hideRetainGuide();
    }

    public void onPanelClosed(View panel) {
        this.this$0.isInPageSlide = false;
        this.this$0.hideRetainGuide();
        ComponentStatisticHelper.INSTANCE.ubcGroupPageGuide(ComponentStatisticConstants.UBC_GROUP_PAGE_RETAIN_GUIDE_STAY_TYPE, this.$groupId);
    }
}
