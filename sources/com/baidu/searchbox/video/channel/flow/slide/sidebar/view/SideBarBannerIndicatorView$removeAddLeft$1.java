package com.baidu.searchbox.video.channel.flow.slide.sidebar.view;

import com.baidu.searchbox.video.channel.flow.slide.sidebar.view.Dot;
import com.baidu.searchbox.video.channel.flow.slide.sidebar.view.SideBarBannerIndicatorView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/video/channel/flow/slide/sidebar/view/SideBarBannerIndicatorView$removeAddLeft$1", "Lcom/baidu/searchbox/video/channel/flow/slide/sidebar/view/SideBarBannerIndicatorView$TranslationAnimationListener;", "onAnimationEnd", "", "video-channel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SideBarBannerIndicatorView.kt */
public final class SideBarBannerIndicatorView$removeAddLeft$1 implements SideBarBannerIndicatorView.TranslationAnimationListener {
    final /* synthetic */ int $position;
    final /* synthetic */ SideBarBannerIndicatorView this$0;

    SideBarBannerIndicatorView$removeAddLeft$1(SideBarBannerIndicatorView $receiver, int $position2) {
        this.this$0 = $receiver;
        this.$position = $position2;
    }

    public void onAnimationEnd() {
        this.this$0.dotsList.set(this.this$0.dotsList.size() - 1, Dot.SMALL.INSTANCE);
        this.this$0.dotsList.add(this.$position, Dot.ACTIVE.INSTANCE);
        SideBarBannerIndicatorView sideBarBannerIndicatorView = this.this$0;
        sideBarBannerIndicatorView.setStartPosX(sideBarBannerIndicatorView.firstIndicatorPos - this.this$0.dotMargin);
        if (this.this$0.currentPage - 1 == 0) {
            this.this$0.dotsList.set(0, Dot.INACTIVE.INSTANCE);
        }
        this.this$0.invalidate();
    }
}
