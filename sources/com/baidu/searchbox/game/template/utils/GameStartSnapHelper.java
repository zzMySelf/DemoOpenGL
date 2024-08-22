package com.baidu.searchbox.game.template.utils;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

public class GameStartSnapHelper extends LinearSnapHelper {
    private OrientationHelper mHorizontalHelper;
    /* access modifiers changed from: private */
    public int mLastPosition = 0;
    /* access modifiers changed from: private */
    public OnPageChangeListener mListener;
    private RecyclerView mRecyclerView;
    private OrientationHelper mVerticalHelper;

    public interface OnPageChangeListener {
        void onPageChanged(int i2, int i3);
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int position = GameStartSnapHelper.this.getCurrentItem();
                if (GameStartSnapHelper.this.mListener != null) {
                    GameStartSnapHelper.this.mListener.onPageChanged(GameStartSnapHelper.this.mLastPosition, position);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View targetView) {
        int[] out = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            out[0] = distanceToStart(targetView, getHorizontalHelper(layoutManager));
        } else {
            out[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            out[1] = distanceToStart(targetView, getVerticalHelper(layoutManager));
        } else {
            out[1] = 0;
        }
        return out;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return super.findSnapView(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return getStartView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return getStartView(layoutManager, getVerticalHelper(layoutManager));
    }

    private int distanceToStart(View targetView, OrientationHelper helper) {
        return helper.getDecoratedStart(targetView) - helper.getStartAfterPadding();
    }

    private View getStartView(RecyclerView.LayoutManager layoutManager, OrientationHelper helper) {
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return super.findSnapView(layoutManager);
        }
        int firstChild = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        if (firstChild == -1) {
            return null;
        }
        View child = layoutManager.findViewByPosition(firstChild);
        if (helper.getDecoratedEnd(child) >= helper.getDecoratedMeasurement(child) / 2 && helper.getDecoratedEnd(child) > 0) {
            return child;
        }
        if (((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1) {
            return null;
        }
        return layoutManager.findViewByPosition(firstChild + 1);
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        int i2;
        int position = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
        if (position >= 0 && position != (i2 = this.mLastPosition)) {
            OnPageChangeListener onPageChangeListener = this.mListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageChanged(i2, position);
            }
            this.mLastPosition = position;
        }
        return position;
    }

    public void setOnPageChangeListener(OnPageChangeListener listener) {
        this.mListener = listener;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.mVerticalHelper == null) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.mHorizontalHelper == null) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    public int getCurrentItem() {
        View view2 = findSnapView(this.mRecyclerView.getLayoutManager());
        if (view2 != null) {
            return this.mRecyclerView.getLayoutManager().getPosition(view2);
        }
        return 0;
    }
}
