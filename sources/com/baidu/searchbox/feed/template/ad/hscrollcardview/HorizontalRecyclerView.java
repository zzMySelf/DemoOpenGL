package com.baidu.searchbox.feed.template.ad.hscrollcardview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalRecyclerView extends RecyclerView {
    private int mDownX;
    private int mDownY;

    public HorizontalRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HorizontalRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case 0:
                this.mDownX = x;
                this.mDownY = y;
                break;
            case 2:
                if (!(getLayoutManager() instanceof LinearLayoutManager)) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                    break;
                } else {
                    int fp = ((LinearLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                    if ((fp != 0 || x - this.mDownX <= 0) && (fp != getAdapter().getItemCount() - 1 || x - this.mDownX >= 0)) {
                        if (Math.abs(x - this.mDownX) > Math.abs(y - this.mDownY)) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            break;
                        }
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
