package com.tera.scan.component.base.ui.widget.dragselectview;

import android.widget.GridView;
import androidx.core.widget.AutoScrollHelper;
import fe.mmm.qw.i.qw;

public class GridViewAutoScrollHelper extends AutoScrollHelper {
    public static final String TAG = "GridViewAutoScrollHelper";
    public AutoScrollListener mListener;
    public GridView mTarget;

    public GridViewAutoScrollHelper(GridView gridView) {
        super(gridView);
        this.mTarget = gridView;
    }

    public boolean canTargetScrollHorizontally(int i2) {
        return this.mTarget.canScrollHorizontally(i2);
    }

    public boolean canTargetScrollVertically(int i2) {
        return this.mTarget.canScrollVertically(i2);
    }

    public void scrollTargetBy(int i2, int i3) {
        qw.ad(TAG, "deltaY:" + i3);
        if (i3 > 1) {
            i3 = 1;
        } else if (i3 < -1) {
            i3 = -1;
        }
        this.mTarget.smoothScrollByOffset(i3);
        AutoScrollListener autoScrollListener = this.mListener;
        if (autoScrollListener != null) {
            autoScrollListener.onAutoScroll();
        }
    }

    public void setAutoScrollListener(AutoScrollListener autoScrollListener) {
        this.mListener = autoScrollListener;
    }
}
