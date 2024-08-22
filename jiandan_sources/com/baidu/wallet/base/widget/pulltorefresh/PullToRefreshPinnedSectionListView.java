package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;

public class PullToRefreshPinnedSectionListView extends PullToRefreshBase<PinnedSectionListView> implements AbsListView.OnScrollListener {
    public ListView b;
    public LoadingLayout c;
    public AbsListView.OnScrollListener d;

    public PullToRefreshPinnedSectionListView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean a() {
        LoadingLayout loadingLayout = this.c;
        return loadingLayout == null || loadingLayout.getState() != LoadingLayout.State.NO_MORE_DATA;
    }

    private boolean b() {
        ListAdapter adapter = this.b.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        if ((this.b.getChildCount() > 0 ? this.b.getChildAt(0).getTop() : 0) >= 0) {
            return true;
        }
        return false;
    }

    private boolean c() {
        View childAt;
        ListAdapter adapter = this.b.getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = this.b.getLastVisiblePosition();
        if (lastVisiblePosition < (adapter.getCount() - 1) - 1 || (childAt = this.b.getChildAt(Math.min(lastVisiblePosition - this.b.getFirstVisiblePosition(), this.b.getChildCount() - 1))) == null || childAt.getBottom() > this.b.getBottom()) {
            return false;
        }
        return true;
    }

    public LoadingLayout getFooterLoadingLayout() {
        if (isScrollLoadEnabled()) {
            return this.c;
        }
        return super.getFooterLoadingLayout();
    }

    public boolean isReadyForPullDown() {
        return b();
    }

    public boolean isReadyForPullUp() {
        return c();
    }

    public void onPullUpRefreshComplete() {
        super.onPullUpRefreshComplete();
        LoadingLayout loadingLayout = this.c;
        if (loadingLayout != null) {
            loadingLayout.setState(LoadingLayout.State.RESET);
        }
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener = this.d;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (isScrollLoadEnabled() && a() && ((i2 == 0 || i2 == 2) && isReadyForPullUp())) {
            startLoading();
        }
        AbsListView.OnScrollListener onScrollListener = this.d;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
    }

    public void setHasMoreData(boolean z) {
        LoadingLayout loadingLayout = this.c;
        if (loadingLayout != null) {
            loadingLayout.setState(z ? LoadingLayout.State.RESET : LoadingLayout.State.NO_MORE_DATA);
        }
        LoadingLayout footerLoadingLayout = getFooterLoadingLayout();
        if (footerLoadingLayout != null) {
            footerLoadingLayout.setState(z ? LoadingLayout.State.RESET : LoadingLayout.State.NO_MORE_DATA);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.d = onScrollListener;
    }

    public void setRefreshingText(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (getHeaderLoadingLayout() != null) {
                getHeaderLoadingLayout().setRefreshingLabel(str);
            }
            if (getFooterLoadingLayout() != null) {
                getFooterLoadingLayout().setRefreshingLabel(str);
            }
        }
    }

    public void setScrollLoadEnabled(boolean z) {
        if (isScrollLoadEnabled() != z) {
            super.setScrollLoadEnabled(z);
            if (z) {
                if (this.c == null) {
                    FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                    this.c = footerLoadingLayout;
                    this.b.addFooterView(footerLoadingLayout, (Object) null, false);
                }
                this.c.show(true);
                return;
            }
            LoadingLayout loadingLayout = this.c;
            if (loadingLayout != null) {
                loadingLayout.show(false);
            }
        }
    }

    public void startLoading() {
        super.startLoading();
        LoadingLayout loadingLayout = this.c;
        if (loadingLayout != null) {
            loadingLayout.setState(LoadingLayout.State.REFRESHING);
            this.c.setVisibility(0);
        }
    }

    public PullToRefreshPinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPullLoadEnabled(false);
    }

    public PinnedSectionListView createRefreshableView(Context context, AttributeSet attributeSet) {
        PinnedSectionListView pinnedSectionListView = new PinnedSectionListView(context);
        this.b = pinnedSectionListView;
        pinnedSectionListView.setOnScrollListener(this);
        return pinnedSectionListView;
    }
}
