package com.baidu.searchbox.dynamicpublisher.bottombar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class BottomHorizontalScrollView extends HorizontalScrollView {
    private boolean canScroll = true;

    public BottomHorizontalScrollView(Context context) {
        super(context);
    }

    public BottomHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BottomHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (this.canScroll) {
            return super.onTouchEvent(ev);
        }
        return true;
    }

    public void setCanScroll(boolean canScroll2) {
        this.canScroll = canScroll2;
    }
}
