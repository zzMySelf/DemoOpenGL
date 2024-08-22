package com.tera.scan.component.base.ui.widget.dragselectview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper;
import androidx.viewpager.widget.ViewPager;
import com.tera.scan.component.base.ui.widget.GridViewEx;
import fe.mmm.qw.th.qw.rg.fe.ad.ad;

public class DragSelectGridView extends GridViewEx implements IDragSelectView, AutoScrollListener {
    public ad mDragSelectViewHelper;

    public DragSelectGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.mDragSelectViewHelper = new ad(this);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mDragSelectViewHelper.qw(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void dragToStartSelect(boolean z, int i2) {
        this.mDragSelectViewHelper.rg(z, i2);
    }

    public View findChildViewUnder(ViewGroup viewGroup, float f, float f2) {
        int childCount = getChildCount() - 1;
        View childAt = getChildAt(childCount);
        float translationX = ViewCompat.getTranslationX(childAt);
        float translationY = ViewCompat.getTranslationY(childAt);
        if ((f >= ((float) childAt.getRight()) + translationX && f2 >= ((float) childAt.getTop()) + translationY) || f2 > ((float) childAt.getBottom()) + translationY) {
            return childAt;
        }
        while (childCount >= 0) {
            View childAt2 = getChildAt(childCount);
            float translationX2 = ViewCompat.getTranslationX(childAt2);
            float translationY2 = ViewCompat.getTranslationY(childAt2);
            if (f >= ((float) childAt2.getLeft()) + translationX2 && f <= ((float) childAt2.getRight()) + translationX2 && f2 >= ((float) childAt2.getTop()) + translationY2 && f2 <= ((float) childAt2.getBottom()) + translationY2) {
                return childAt2;
            }
            childCount--;
        }
        return null;
    }

    public ViewGroup getParentDragView() {
        for (View view = (View) getParent(); view != null; view = view.getParent() instanceof View ? (View) view.getParent() : null) {
            if (view instanceof ViewPager) {
                return (ViewPager) view;
            }
        }
        return null;
    }

    public AutoScrollHelper initAutoScrollHelper() {
        GridViewAutoScrollHelper gridViewAutoScrollHelper = new GridViewAutoScrollHelper(this);
        gridViewAutoScrollHelper.setAutoScrollListener(this);
        gridViewAutoScrollHelper.setEnabled(true);
        gridViewAutoScrollHelper.setRelativeVelocity(0.2f, 0.2f);
        gridViewAutoScrollHelper.setRampUpDuration(100);
        gridViewAutoScrollHelper.setRampDownDuration(100);
        return gridViewAutoScrollHelper;
    }

    public void onAutoScroll() {
        this.mDragSelectViewHelper.de();
    }

    public void setDragSelectListener(IDragSelectListener iDragSelectListener) {
        this.mDragSelectViewHelper.th(iDragSelectListener);
    }

    public DragSelectGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
