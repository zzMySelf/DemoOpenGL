package com.baidu.live.business.refresh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.business.refresh.BdSwipeRefreshLayout;

public abstract class BdIListPullView implements BdSwipeRefreshLayout.IProgressView {
    private boolean isPausing = false;
    private Context mContext = null;
    private View mView = null;

    public abstract View createView();

    public abstract void done(boolean z);

    public abstract void onCompletePullRefresh();

    public abstract void onRefresh(boolean z);

    public abstract void pullToRefresh(boolean z);

    public abstract void refreshing();

    public abstract void releaseToRefresh();

    public BdIListPullView(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public final View getView() {
        if (this.mView == null) {
            View createView = createView();
            this.mView = createView;
            measureView(createView);
        }
        return this.mView;
    }

    /* access modifiers changed from: protected */
    public boolean isPausing() {
        return this.isPausing;
    }

    private void measureView(View child) {
        int childHeightSpec;
        ViewGroup.LayoutParams p = child.getLayoutParams();
        if (p == null) {
            p = new ViewGroup.LayoutParams(-1, -2);
        }
        int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0, p.width);
        int lpHeight = p.height;
        if (lpHeight > 0) {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight, 1073741824);
        } else {
            childHeightSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    public void onPullToRefresh() {
        if (!this.isPausing) {
            pullToRefresh(false);
        }
    }

    public void onReleaseToRefresh() {
        if (!this.isPausing) {
            releaseToRefresh();
        }
    }

    public void onRefreshing() {
        if (!this.isPausing) {
            refreshing();
            onRefresh(true);
        }
    }

    public void onCompleteRefresh() {
        if (!this.isPausing) {
            onCompletePullRefresh();
        }
    }

    public void onFinish() {
        if (!this.isPausing) {
            done(true);
        }
    }

    public void onPullPercentChange(float percent, float tensionPercent) {
    }

    public long getCompleteAnimTime() {
        return 0;
    }
}
