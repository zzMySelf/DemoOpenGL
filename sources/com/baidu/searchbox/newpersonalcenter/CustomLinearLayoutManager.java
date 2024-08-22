package com.baidu.searchbox.newpersonalcenter;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.newpersonalcenter.guide.PersonalScrollGuideManager;

public class CustomLinearLayoutManager extends LinearLayoutManager {
    private static final String TAG = "CustomLinearManager";

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CustomLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "CustomLinearLayoutManager onLayoutChildren exception" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        Context context;
        if (position != -1 && (context = recyclerView.getContext()) != null) {
            RecyclerView.SmoothScroller smoothScroller = new CenterSmoothScroller(context);
            smoothScroller.setTargetPosition(position);
            startSmoothScroll(smoothScroller);
        }
    }

    public void scrollToOftenUsedCard(RecyclerView recyclerView, int position, long duration) {
        if (position != -1) {
            Context context = recyclerView.getContext();
            if (context == null) {
                PersonalScrollGuideManager.INSTANCE.stopGuideAnimation();
                return;
            }
            BottomSmoothScroller smoothScroller = new BottomSmoothScroller(context);
            smoothScroller.setDuration((int) duration);
            smoothScroller.setTargetPosition(position);
            startSmoothScroll(smoothScroller);
        }
    }

    private static class CenterSmoothScroller extends LinearSmoothScroller {
        CenterSmoothScroller(Context context) {
            super(context);
        }

        public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
            return (((boxEnd - boxStart) / 2) + boxStart) - (((viewEnd - viewStart) / 2) + viewStart);
        }
    }

    public static class BottomSmoothScroller extends LinearSmoothScroller {
        AccelerateDecelerateInterpolator mAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        private int mDuration = 0;

        BottomSmoothScroller(Context context) {
            super(context);
        }

        public void setDuration(int duration) {
            this.mDuration = duration;
        }

        public int getVerticalSnapPreference() {
            return 1;
        }

        /* access modifiers changed from: protected */
        public int calculateTimeForDeceleration(int dx) {
            int i2 = this.mDuration;
            if (i2 == 0) {
                return super.calculateTimeForDeceleration(dx);
            }
            return i2;
        }

        /* access modifiers changed from: protected */
        public void onTargetFound(View targetView, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int dx = calculateDxToMakeVisible(targetView, getHorizontalSnapPreference());
            int dy = calculateDyToMakeVisible(targetView, getVerticalSnapPreference());
            int time = calculateTimeForDeceleration((int) Math.sqrt((double) ((dx * dx) + (dy * dy))));
            if (time > 0) {
                action.update(-dx, -dy, time, this.mAccelerateDecelerateInterpolator);
            }
        }
    }
}
