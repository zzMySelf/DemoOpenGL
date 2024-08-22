package com.baidu.searchbox.video.feedflow.flow.list.flowview;

import com.baidu.searchbox.video.widget.viewpager2.OnScrollChangedListener;
import com.baidu.searchbox.video.widget.viewpager2.PrettyViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/list/flowview/ViewPager2FlowView$initViewPager2$1$1", "Lcom/baidu/searchbox/video/widget/viewpager2/OnScrollChangedListener;", "onScrollStateChanged", "", "state", "", "direction", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewPager2FlowView.kt */
public final class ViewPager2FlowView$initViewPager2$1$1 implements OnScrollChangedListener {
    final /* synthetic */ PrettyViewPager2 $this_apply;

    ViewPager2FlowView$initViewPager2$1$1(PrettyViewPager2 $receiver) {
        this.$this_apply = $receiver;
    }

    public void onItemScrolled(int position, float positionOffset, int positionOffsetPixels) {
        OnScrollChangedListener.DefaultImpls.onItemScrolled(this, position, positionOffset, positionOffsetPixels);
    }

    public void onPageScrolled(int state, int dx, int dy) {
        OnScrollChangedListener.DefaultImpls.onPageScrolled(this, state, dx, dy);
    }

    public void onScrollStateChanged(int state, String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        OnScrollChangedListener.DefaultImpls.onScrollStateChanged(this, state, direction);
        if (state == 1) {
            this.$this_apply.setOffscreenPageEnable(true);
        }
    }
}
