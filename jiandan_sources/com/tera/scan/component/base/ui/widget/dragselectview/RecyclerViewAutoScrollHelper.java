package com.tera.scan.component.base.ui.widget.dragselectview;

import androidx.core.widget.AutoScrollHelper;
import androidx.recyclerview.widget.RecyclerView;
import fe.mmm.qw.i.qw;

public class RecyclerViewAutoScrollHelper extends AutoScrollHelper {
    public static final String TAG = "RecyclerViewAutoScrollHelper";
    public AutoScrollListener mListener;
    public RecyclerView mTarget;

    public RecyclerViewAutoScrollHelper(RecyclerView recyclerView) {
        super(recyclerView);
        this.mTarget = recyclerView;
    }

    public boolean canTargetScrollHorizontally(int i2) {
        return this.mTarget.getLayoutManager().canScrollHorizontally();
    }

    public boolean canTargetScrollVertically(int i2) {
        return this.mTarget.getLayoutManager().canScrollVertically();
    }

    public void scrollTargetBy(int i2, int i3) {
        qw.ad(TAG, " deltaX:" + i2 + " deltaY:" + i3);
        this.mTarget.scrollBy(i2, i3);
        AutoScrollListener autoScrollListener = this.mListener;
        if (autoScrollListener != null) {
            autoScrollListener.onAutoScroll();
        }
    }

    public void setAutoScrollListener(AutoScrollListener autoScrollListener) {
        this.mListener = autoScrollListener;
    }
}
