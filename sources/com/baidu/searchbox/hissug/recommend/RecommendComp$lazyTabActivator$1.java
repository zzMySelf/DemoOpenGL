package com.baidu.searchbox.hissug.recommend;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/hissug/recommend/RecommendComp$lazyTabActivator$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "lib_hissug_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendComp.kt */
public final class RecommendComp$lazyTabActivator$1 extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ RecommendComp this$0;

    RecommendComp$lazyTabActivator$1(RecommendComp $receiver) {
        this.this$0 = $receiver;
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.this$0.pagerAdapter.onPageScrolled(position, positionOffset, positionOffsetPixels);
    }
}
