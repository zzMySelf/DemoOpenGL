package com.baidu.searchbox.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class PagerRecyclerView extends RecyclerView {
    private CanScrollListener listener;
    private int mInitMotionX;
    private int mInitMotionY;
    private boolean mIsCanSwitchPage = true;
    private View.OnTouchListener mTouchListener;

    public interface CanScrollListener {
        boolean isCanScrollable(MotionEvent motionEvent);
    }

    public PagerRecyclerView(Context context) {
        super(context);
    }

    public PagerRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PagerRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layout) {
        super.setLayoutManager(layout);
        if (layout instanceof View.OnTouchListener) {
            this.mTouchListener = (View.OnTouchListener) layout;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent e2) {
        if (!isCanScrollable(e2)) {
            return false;
        }
        boolean result = false;
        switch (e2.getAction()) {
            case 0:
                this.mIsCanSwitchPage = true;
                this.mInitMotionY = (int) e2.getY();
                this.mInitMotionX = (int) e2.getX();
                return super.onInterceptTouchEvent(e2);
            case 2:
                result = ((float) Math.abs(((int) e2.getY()) - this.mInitMotionY)) * 0.5f > ((float) Math.abs(((int) e2.getX()) - this.mInitMotionX));
                break;
        }
        if (!result || !super.onInterceptTouchEvent(e2)) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent e2) {
        switch (e2.getAction()) {
            case 0:
                this.mIsCanSwitchPage = true;
                break;
            case 1:
                if (!this.mIsCanSwitchPage) {
                    View.OnTouchListener onTouchListener = this.mTouchListener;
                    if (onTouchListener instanceof PagerLayoutManager) {
                        smoothScrollToPosition(((PagerLayoutManager) onTouchListener).getPosition());
                        return true;
                    }
                }
                break;
        }
        if (!isCanScrollable(e2)) {
            this.mIsCanSwitchPage = false;
            return false;
        }
        View.OnTouchListener onTouchListener2 = this.mTouchListener;
        if (onTouchListener2 != null) {
            onTouchListener2.onTouch(this, e2);
        }
        return super.onTouchEvent(e2);
    }

    public boolean isCanScrollable(MotionEvent ev) {
        CanScrollListener canScrollListener = this.listener;
        if (canScrollListener != null) {
            return canScrollListener.isCanScrollable(ev);
        }
        return true;
    }

    public void setCanScrollListener(CanScrollListener listener2) {
        this.listener = listener2;
    }
}
