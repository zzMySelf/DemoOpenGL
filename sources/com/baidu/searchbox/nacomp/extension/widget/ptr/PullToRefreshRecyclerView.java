package com.baidu.searchbox.nacomp.extension.widget.ptr;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.extension.fontsize.IFontSize;
import com.baidu.searchbox.nacomp.extension.nightmode.INightMode;
import com.baidu.searchbox.nacomp.extension.util.RecyclerViewHelper;
import com.baidu.searchbox.nacomp.extension.widget.ptr.BaseFooterView;
import com.baidu.searchbox.nacomp.recycler.delegate.DelegatorAdapter;

public class PullToRefreshRecyclerView extends FrameLayout implements INightMode, IFontSize {
    private boolean attachFooterWithNoMoreUpdate;
    private final FooterView footerView;
    private boolean hasMore;
    private PtrAdapter ptrAdapter;
    private RecyclerView recyclerView;
    private OnRefreshListener refreshListener;
    private int thresholdToTrigPreload;

    public interface OnRefreshListener {
        void onPullUpToRefresh(PullToRefreshRecyclerView pullToRefreshRecyclerView);
    }

    public PullToRefreshRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.hasMore = true;
        this.attachFooterWithNoMoreUpdate = true;
        this.thresholdToTrigPreload = -1;
        this.footerView = new FooterView(getContext());
        RecyclerView recyclerView2 = new RecyclerView(context);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!PullToRefreshRecyclerView.this.isEnablePreload()) {
                    if (RecyclerViewHelper.isLastItemCompletelyVisible(recyclerView)) {
                        PullToRefreshRecyclerView.this.loadMore();
                    }
                } else if (PullToRefreshRecyclerView.this.isTriggerPreload()) {
                    PullToRefreshRecyclerView.this.loadMore();
                }
            }
        });
        addView(this.recyclerView, new FrameLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: private */
    public boolean isEnablePreload() {
        return this.thresholdToTrigPreload > 0;
    }

    /* access modifiers changed from: private */
    public boolean isTriggerPreload() {
        return RecyclerViewHelper.getRcyLastVisiblePosition(this.recyclerView) >= (RecyclerViewHelper.getItemCount(this.recyclerView) - this.thresholdToTrigPreload) - 1;
    }

    public void setDelAdapter(DelegatorAdapter delAdapter) {
        if (this.ptrAdapter == null) {
            this.ptrAdapter = new PtrAdapter(delAdapter);
        }
        this.recyclerView.setAdapter(this.ptrAdapter);
    }

    public PtrAdapter getPtrAdapter() {
        return this.ptrAdapter;
    }

    public void setTextBuilder(StateTextBuilder textBuilder) {
        this.footerView.setStateTextBuilder(textBuilder);
    }

    private void buildFooterView() {
        PtrAdapter ptrAdapter2 = this.ptrAdapter;
        if (ptrAdapter2 != null && ptrAdapter2.setFooterView(this.footerView)) {
            this.footerView.setFooterClickListener(new BaseFooterView.OnFooterClickListener() {
                public void onFooterClick(FooterView footerView) {
                    PullToRefreshRecyclerView.this.loadMore();
                }
            });
        }
    }

    public void loadMore() {
        if (isOnErrorState() || (this.hasMore && !isLoading())) {
            updateState(FooterState.LOADING);
            OnRefreshListener onRefreshListener = this.refreshListener;
            if (onRefreshListener != null) {
                onRefreshListener.onPullUpToRefresh(this);
            }
        }
    }

    public void setHasMore(boolean hasMore2) {
        this.hasMore = hasMore2;
        updateState(hasMore2 ? FooterState.NORMAL : FooterState.NO_MORE);
        if (!hasMore2 && !this.attachFooterWithNoMoreUpdate) {
            this.ptrAdapter.removeFooterView(this.footerView);
        }
    }

    public void setThresholdToTrigPreload(int thresholdToTrigPreload2) {
        this.thresholdToTrigPreload = thresholdToTrigPreload2;
    }

    public void setAttachFooterWithNoMoreUpdate(boolean isAttach) {
        this.attachFooterWithNoMoreUpdate = isAttach;
    }

    private boolean isOnErrorState() {
        return FooterState.ERROR == this.footerView.getState();
    }

    public void scrollToTopPosition() {
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        if (layoutManager != null && adapter != null && adapter.getItemCount() > 0) {
            layoutManager.scrollToPosition(0);
        }
    }

    public boolean isLoading() {
        return FooterState.LOADING.equals(this.footerView.getState());
    }

    private void updateState(FooterState footerState) {
        buildFooterView();
        this.footerView.updateFooterState(footerState);
    }

    public void notifyDataSetChanged() {
        PtrAdapter ptrAdapter2 = this.ptrAdapter;
        if (ptrAdapter2 != null) {
            ptrAdapter2.notifyDataSetChanged();
        }
    }

    public void onLoadMoreError() {
        updateState(FooterState.ERROR);
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public void setOnRefreshListener(OnRefreshListener refreshListener2) {
        this.refreshListener = refreshListener2;
    }

    public void onPullLoadComplete() {
        updateState(FooterState.NORMAL);
    }

    public void onNightModeChange(boolean isNightMode) {
        this.footerView.onNightModeChange(isNightMode);
    }

    public void onFontSizeChange(FontSizeInfo info) {
        this.footerView.onFontSizeChange(info);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.footerView.release();
    }
}
