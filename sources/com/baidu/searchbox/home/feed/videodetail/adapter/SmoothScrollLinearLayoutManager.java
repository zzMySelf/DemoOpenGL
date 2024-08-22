package com.baidu.searchbox.home.feed.videodetail.adapter;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtil;

public class SmoothScrollLinearLayoutManager extends LinearLayoutManager {
    private static final float MILLISECONDS_PER_INCH = 0.05f;
    /* access modifiers changed from: private */
    public final Context mContext;

    public SmoothScrollLinearLayoutManager(Context context) {
        super(context);
        this.mContext = context;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e2) {
            e2.printStackTrace();
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
            return SmoothScrollLinearLayoutManager.this.computeScrollVectorForPosition(targetPosition);
        }

        /* access modifiers changed from: protected */
        public int getVerticalSnapPreference() {
            return -1;
        }

        /* access modifiers changed from: protected */
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return SmoothScrollLinearLayoutManager.getMillisecondsPerInch(SmoothScrollLinearLayoutManager.this.mContext);
        }
    }

    /* access modifiers changed from: private */
    public static float getMillisecondsPerInch(Context context) {
        return DeviceUtil.ScreenInfo.getDensity(context) * 0.05f;
    }
}
