package com.tera.scan.component.base.ui.widget.dragselectview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.AutoScrollHelper;
import androidx.viewpager.widget.ViewPager;
import com.tera.scan.widget.customrecyclerview.PullWidgetRecyclerView;
import fe.mmm.qw.p030switch.th.de.ad.qw;
import fe.mmm.qw.th.qw.rg.fe.ad.ad;

public class DragSelectRecyclerView extends PullWidgetRecyclerView implements IDragSelectView, AutoScrollListener {
    public ad mDragSelectViewHelper;
    public int mSelectItemWidth = 0;

    public DragSelectRecyclerView(Context context) {
        super(context);
    }

    private void init() {
        this.mDragSelectViewHelper = new ad(this);
        this.mSelectItemWidth = qw.rg() / 4;
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
        View findChildViewUnder = findChildViewUnder(f, f2);
        if (findChildViewUnder != null) {
            return findChildViewUnder;
        }
        float f3 = (float) this.mSelectItemWidth;
        while (true) {
            f -= f3;
            if (findChildViewUnder == null && f > 0.0f) {
                findChildViewUnder = findChildViewUnder(f, f2);
            }
        }
        if (findChildViewUnder != null) {
            Object tag = findChildViewUnder.getTag();
            int i2 = -1;
            if (tag != null && (tag instanceof Integer)) {
                i2 = ((Integer) tag).intValue();
            }
            findChildViewUnder.setTag(new fe.mmm.qw.th.qw.rg.fe.ad.qw(i2, true));
            return findChildViewUnder;
        }
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt == null) {
            return null;
        }
        if (f2 > ((float) childAt.getBottom()) + ViewCompat.getTranslationY(childAt)) {
            return childAt;
        }
        return null;
    }

    public ViewGroup getParentDragView() {
        View view = (View) getParent();
        while (view != null) {
            if (view instanceof ViewPager) {
                return (ViewPager) view;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return null;
    }

    public AutoScrollHelper initAutoScrollHelper() {
        RecyclerViewAutoScrollHelper recyclerViewAutoScrollHelper = new RecyclerViewAutoScrollHelper(this);
        recyclerViewAutoScrollHelper.setAutoScrollListener(this);
        recyclerViewAutoScrollHelper.setEnabled(true);
        recyclerViewAutoScrollHelper.setRelativeVelocity(0.2f, 0.2f);
        recyclerViewAutoScrollHelper.setRampUpDuration(100);
        recyclerViewAutoScrollHelper.setRampDownDuration(100);
        return recyclerViewAutoScrollHelper;
    }

    public void onAutoScroll() {
        this.mDragSelectViewHelper.de();
    }

    public void setDragSelectListener(IDragSelectListener iDragSelectListener) {
        this.mDragSelectViewHelper.th(iDragSelectListener);
    }

    public void setSelectItemViewSize(int i2) {
        this.mSelectItemWidth = i2;
    }

    public DragSelectRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DragSelectRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
