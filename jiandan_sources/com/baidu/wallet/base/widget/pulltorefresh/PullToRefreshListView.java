package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;

public class PullToRefreshListView extends PullToRefreshBase<ListView> implements AbsListView.OnScrollListener {
    public ListView b;
    public LoadingLayout c;
    public AbsListView.OnScrollListener d;
    public int e;

    public PullToRefreshListView(Context context) {
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
        if ((this.b.getChildCount() > 0 ? this.b.getChildAt(0).getTop() : 0) < 0 || this.e != 0) {
            return false;
        }
        return true;
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
        return c() && a();
    }

    public void onPullUpRefreshComplete() {
        super.onPullUpRefreshComplete();
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AbsListView.OnScrollListener onScrollListener = this.d;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
        PullToRefreshBase.OnScrollListener2 onScrollListener2 = this.a;
        if (onScrollListener2 != null) {
            onScrollListener2.onScroll(absListView, i2, i3, i4);
        }
        this.e = i2;
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (isScrollLoadEnabled() && a() && ((i2 == 0 || i2 == 2) && isReadyForPullUp())) {
            startLoading();
        }
        AbsListView.OnScrollListener onScrollListener = this.d;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
        PullToRefreshBase.OnScrollListener2 onScrollListener2 = this.a;
        if (onScrollListener2 != null) {
            onScrollListener2.onScrollStateChanged(absListView, i2);
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

    public void showOrHideFootView(int i2) {
        LoadingLayout loadingLayout = this.c;
        if (loadingLayout != null && loadingLayout.getVisibility() != i2) {
            this.c.show(i2 == 0);
        }
    }

    public void startLoading() {
        super.startLoading();
    }

    public PullToRefreshListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        setPullLoadEnabled(false);
    }

    public ListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ListView listView = new ListView(context);
        this.b = listView;
        listView.setOnScrollListener(this);
        return listView;
    }
}
