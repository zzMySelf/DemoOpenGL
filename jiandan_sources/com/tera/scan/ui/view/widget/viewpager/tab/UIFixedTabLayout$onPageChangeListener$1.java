package com.tera.scan.ui.view.widget.viewpager.tab;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/tera/scan/ui/view/widget/viewpager/tab/UIFixedTabLayout$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFixedTabLayout$onPageChangeListener$1 implements ViewPager.OnPageChangeListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ UIFixedTabLayout f7405ad;

    public UIFixedTabLayout$onPageChangeListener$1(UIFixedTabLayout uIFixedTabLayout) {
        this.f7405ad = uIFixedTabLayout;
    }

    public void onPageScrollStateChanged(int i2) {
    }

    public void onPageScrolled(int i2, float f, int i3) {
        this.f7405ad.scrollPos = i2;
        this.f7405ad.scrollOffset = f;
        this.f7405ad.refreshSelectBg();
    }

    public void onPageSelected(int i2) {
        this.f7405ad.refreshTab();
    }
}
