package com.tera.scan.ui.view.widget.viewpager;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import fe.mmm.qw.f.ad.de.qw;

public abstract class UIPageTransformer implements ViewPager.PageTransformer {
    public UIPagerAdapter qw;

    public UIPageTransformer(@NonNull UIPagerAdapter uIPagerAdapter) {
        this.qw = uIPagerAdapter;
    }

    public final float qw(ViewPager viewPager, View view) {
        return ((float) ((view.getLeft() - viewPager.getScrollX()) - viewPager.getPaddingLeft())) / ((float) ((viewPager.getMeasuredWidth() - viewPager.getPaddingLeft()) - viewPager.getPaddingRight()));
    }

    public void transformPage(@NonNull View view, float f) {
        float f2;
        if (view.getParent() instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) view.getParent();
            if (this.qw.isDataSetChanging() || viewPager.isLayoutRequested()) {
                int currentItem = viewPager.getCurrentItem();
                int pageViewPosition = this.qw.getPageViewPosition(view);
                qw qwVar = qw.qw;
                qwVar.qw("UIPageTransformer", "transformPage() requirePagePosition: currentItem = [" + currentItem + "], pageViewIndex = [" + pageViewPosition + "]");
                f2 = currentItem == pageViewPosition ? 0.0f : (float) (pageViewPosition - currentItem);
            } else {
                f2 = qw(viewPager, view);
            }
            qw qwVar2 = qw.qw;
            qwVar2.qw("UIPageTransformer", "transformPage() called with: page = [" + view + "], position = [" + f2 + "]");
            transformPageWithCorrectPosition(view, f2);
        }
    }

    public abstract void transformPageWithCorrectPosition(@NonNull View view, float f);
}
