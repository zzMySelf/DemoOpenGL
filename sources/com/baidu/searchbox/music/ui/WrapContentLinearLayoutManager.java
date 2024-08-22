package com.baidu.searchbox.music.ui;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtil;

public class WrapContentLinearLayoutManager extends LinearLayoutManager {
    static final float MILLISECONDS_PER_INCH = 0.05f;
    /* access modifiers changed from: private */
    public final Context mContext;

    public WrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.mContext = context;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e2) {
            Log.e("onLayoutChildren", "'meet a IndexOutOfBoundsException in RecyclerView.'");
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        RecyclerView.SmoothScroller smoothScroller = new TopSnappedSmoothScroller(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    private class TopSnappedSmoothScroller extends LinearSmoothScroller {
        TopSnappedSmoothScroller(Context context) {
            super(context);
        }

        public PointF computeScrollVectorForPosition(int targetPosition) {
            return WrapContentLinearLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }

        /* access modifiers changed from: protected */
        public int getVerticalSnapPreference() {
            return -1;
        }

        /* access modifiers changed from: protected */
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return WrapContentLinearLayoutManager.getMillisecondsPerInch(WrapContentLinearLayoutManager.this.mContext);
        }
    }

    /* access modifiers changed from: private */
    public static float getMillisecondsPerInch(Context context) {
        return DeviceUtil.ScreenInfo.getDensity(context) * 0.05f;
    }

    public static long getScrollToTopDuration(Context context) {
        return 500 + ((long) (getMillisecondsPerInch(context) * ((float) DeviceUtil.ScreenInfo.getDisplayHeight(context))));
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
