package com.baidu.searchbox.download.center.ui.fusion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

public class GesturesRecyclerView extends RecyclerView {
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mScrollPointerId;
    private int mTouchSlop;

    public GesturesRecyclerView(Context context) {
        super(context);
        init();
    }

    public GesturesRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GesturesRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void setScrollingTouchSlop(int slopConstant) {
        ViewConfiguration vc = ViewConfiguration.get(getContext());
        switch (slopConstant) {
            case 0:
                this.mTouchSlop = vc.getScaledTouchSlop();
                break;
            case 1:
                this.mTouchSlop = vc.getScaledPagingTouchSlop();
                break;
        }
        super.setScrollingTouchSlop(slopConstant);
    }

    public boolean onInterceptTouchEvent(MotionEvent e2) {
        MotionEvent motionEvent = e2;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        boolean canScrollHorizontally = false;
        boolean canScrollVertically = false;
        if (layoutManager != null) {
            canScrollHorizontally = layoutManager.canScrollHorizontally();
            canScrollVertically = getLayoutManager().canScrollVertically();
        }
        int action = e2.getActionMasked();
        int actionIndex = e2.getActionIndex();
        switch (action) {
            case 0:
                this.mScrollPointerId = motionEvent.getPointerId(0);
                this.mInitialTouchX = (int) (e2.getX() + 0.5f);
                this.mInitialTouchY = (int) (e2.getY() + 0.5f);
                return super.onInterceptTouchEvent(e2);
            case 2:
                int index = motionEvent.findPointerIndex(this.mScrollPointerId);
                if (index < 0) {
                    return false;
                }
                int x = (int) (motionEvent.getX(index) + 0.5f);
                int y = (int) (motionEvent.getY(index) + 0.5f);
                if (getScrollState() == 1) {
                    return super.onInterceptTouchEvent(e2);
                }
                int dx = x - this.mInitialTouchX;
                int dy = y - this.mInitialTouchY;
                boolean startScroll = false;
                if (canScrollHorizontally && Math.abs(dx) > this.mTouchSlop && Math.abs(dx) > Math.abs(dy)) {
                    startScroll = true;
                }
                if (!canScrollVertically || Math.abs(dy) <= this.mTouchSlop) {
                } else if (Math.abs(dx) != 0) {
                    int i2 = y;
                    if (((double) (((float) Math.abs(dy)) / ((float) Math.abs(dx)))) > 1.5d) {
                        startScroll = true;
                    }
                }
                return startScroll && super.onInterceptTouchEvent(e2);
            case 5:
                this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                this.mInitialTouchX = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.mInitialTouchY = (int) (motionEvent.getY(actionIndex) + 0.5f);
                return super.onInterceptTouchEvent(e2);
            default:
                return super.onInterceptTouchEvent(e2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isChildrenDrawingOrderEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int childCount, int i2) {
        if (childCount < 2) {
            return super.getChildDrawingOrder(childCount, i2);
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 0;
        }
        return super.getChildDrawingOrder(childCount, i2);
    }
}
