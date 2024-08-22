package com.tera.scan.ui.view.widget.viewpager.indicator;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/tera/scan/ui/view/widget/viewpager/indicator/UILineIndicator$onPageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "onPageScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UILineIndicator$onPageChangeListener$1 extends ViewPager.SimpleOnPageChangeListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ UILineIndicator f7404ad;

    public UILineIndicator$onPageChangeListener$1(UILineIndicator uILineIndicator) {
        this.f7404ad = uILineIndicator;
    }

    public void onPageScrolled(int i2, float f, int i3) {
        super.onPageScrolled(i2, f, i3);
        UILineIndicator uILineIndicator = this.f7404ad;
        uILineIndicator.curPos = uILineIndicator.getCurPos(i2);
        this.f7404ad.curPosOffset = f;
        this.f7404ad.postInvalidate();
    }

    public void onPageSelected(int i2) {
        super.onPageSelected(i2);
        UILineIndicator uILineIndicator = this.f7404ad;
        uILineIndicator.curPos = uILineIndicator.getCurPos(i2);
        this.f7404ad.curPosOffset = 0.0f;
        this.f7404ad.postInvalidate();
    }
}
