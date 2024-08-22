package com.baidu.searchbox.ui.swipe;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import com.baidu.searchbox.ui.pullrefresh.FooterLoadingLayout;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
import com.baidu.searchbox.ui.pullrefresh.LoadingLayout;
import com.baidu.searchbox.ui.pullrefresh.PullToRefreshBase;

public class PullRefreshSwipeListView extends PullToRefreshBase<SwipeMenuListView> {
    private SwipeMenuListView mListView;
    private LoadingLayout mLoadMoreFooterLayout;
    private AbsListView.OnScrollListener mScrollListener;

    public PullRefreshSwipeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullRefreshSwipeListView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public SwipeMenuListView createRefreshableView(Context context, AttributeSet attrs) {
        SwipeMenuListView listView = new SwipeMenuListView(context);
        setRefreshableView(listView);
        return listView;
    }

    /* access modifiers changed from: protected */
    public void setRefreshableView(SwipeMenuListView refreshableView) {
        this.mListView = refreshableView;
    }

    public void setHasMoreData(boolean hasMoreData) {
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(hasMoreData ? ILoadingLayout.State.RESET : ILoadingLayout.State.NO_MORE_DATA);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(hasMoreData ? ILoadingLayout.State.RESET : ILoadingLayout.State.NO_MORE_DATA);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener l) {
        this.mScrollListener = l;
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullUp() {
        return isLastItemVisible();
    }

    /* access modifiers changed from: protected */
    public boolean isReadyForPullDown() {
        return isFirstItemVisible();
    }

    /* access modifiers changed from: protected */
    public void startLoading() {
        super.startLoading();
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout.State.REFRESHING);
        }
    }

    public void onPullUpRefreshComplete() {
        super.onPullUpRefreshComplete();
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout.State.RESET);
        }
    }

    public void setScrollLoadEnabled(boolean scrollLoadEnabled) {
        if (isScrollLoadEnabled() != scrollLoadEnabled) {
            super.setScrollLoadEnabled(scrollLoadEnabled);
            if (scrollLoadEnabled) {
                if (this.mLoadMoreFooterLayout == null) {
                    FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                    this.mLoadMoreFooterLayout = footerLoadingLayout;
                    this.mListView.addFooterView(footerLoadingLayout, (Object) null, false);
                }
                this.mLoadMoreFooterLayout.show(true);
                return;
            }
            LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
            if (loadingLayout != null) {
                loadingLayout.show(false);
            }
        }
    }

    public void dismissListViewDivider() {
        SwipeMenuListView swipeMenuListView = this.mListView;
        if (swipeMenuListView != null) {
            swipeMenuListView.setDivider((Drawable) null);
        }
    }

    public LoadingLayout getFooterLoadingLayout() {
        if (isScrollLoadEnabled()) {
            return this.mLoadMoreFooterLayout;
        }
        return super.getFooterLoadingLayout();
    }

    private boolean hasMoreData() {
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout == null || loadingLayout.getState() != ILoadingLayout.State.NO_MORE_DATA) {
            return true;
        }
        return false;
    }

    private boolean isFirstItemVisible() {
        Adapter adapter = this.mListView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        if ((this.mListView.getChildCount() > 0 ? this.mListView.getChildAt(0).getTop() : 0) < 0 || this.mListView.getFirstVisiblePosition() != 0) {
            return false;
        }
        return true;
    }

    private boolean isLastItemVisible() {
        View lastVisibleChild;
        Adapter adapter = this.mListView.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = this.mListView.getLastVisiblePosition();
        if (lastVisiblePosition < (adapter.getCount() - 1) - 1 || (lastVisibleChild = this.mListView.getChildAt(Math.min(lastVisiblePosition - this.mListView.getFirstVisiblePosition(), this.mListView.getChildCount() - 1))) == null) {
            return false;
        }
        if (lastVisibleChild.getBottom() <= this.mListView.getBottom()) {
            return true;
        }
        return false;
    }

    public final boolean onInterceptTouchEvent(MotionEvent event) {
        SwipeMenuListView swipeMenuListView = this.mListView;
        if (swipeMenuListView == null || swipeMenuListView.canInterceptInPullRefreshView()) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }
}
