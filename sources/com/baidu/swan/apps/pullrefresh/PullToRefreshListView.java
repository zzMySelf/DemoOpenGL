package com.baidu.swan.apps.pullrefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ListView;
import com.baidu.swan.apps.pullrefresh.ILoadingLayout;

public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    private ListView mListView;
    private LoadingLayout mLoadMoreFooterLayout;
    private AbsListView.OnScrollListener mScrollListener;

    public PullToRefreshListView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PullToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPullLoadEnabled(false);
    }

    /* access modifiers changed from: protected */
    public ListView createRefreshableView(Context context, AttributeSet attrs) {
        ListView listView = new ListView(context);
        listView.setOnScrollListener(this);
        setRefreshableView(listView);
        return listView;
    }

    /* access modifiers changed from: protected */
    public void setRefreshableView(ListView refreshableView) {
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
    public boolean isReadyForPullDown(MotionEvent event) {
        return isFirstItemVisible();
    }

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
        ListView listView = this.mListView;
        if (listView != null) {
            listView.setDivider((Drawable) null);
        }
    }

    public LoadingLayout getFooterLoadingLayout() {
        if (isScrollLoadEnabled()) {
            return this.mLoadMoreFooterLayout;
        }
        return super.getFooterLoadingLayout();
    }

    public void onScrollStateChanged(AbsListView view2, int scrollState) {
        if (isScrollLoadEnabled() && hasMoreData() && ((scrollState == 0 || scrollState == 2) && isReadyForPullUp())) {
            startLoading();
        }
        AbsListView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(view2, scrollState);
        }
    }

    public void onScroll(AbsListView view2, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        AbsListView.OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(view2, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }

    private boolean hasMoreData() {
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        return loadingLayout == null || loadingLayout.getState() != ILoadingLayout.State.NO_MORE_DATA;
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
}
