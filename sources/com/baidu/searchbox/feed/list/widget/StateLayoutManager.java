package com.baidu.searchbox.feed.list.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.errorview.view.NetworkErrorView;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.ui.CommonEmptyView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class StateLayoutManager {
    public static final int TYPE_CONTENT = 0;
    public static final int TYPE_EMPTY = 3;
    public static final int TYPE_ERROR = 1;
    public static final int TYPE_LOADING = 2;
    /* access modifiers changed from: private */
    public OnCommonClickListener mClickListener;
    private View mContentView;
    private View mEmptyView;
    private View mErrorView;
    private LayoutInflater mInflater;
    private View mLoadingView;
    private ViewGroup mRootView;
    private int mViewType = 0;

    public interface OnCommonClickListener {
        void onEmptyClick(View view2);

        void onErrorClick(View view2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StateType {
    }

    public StateLayoutManager(Context context) {
        this.mRootView = new FrameLayout(context);
        this.mInflater = LayoutInflater.from(context);
    }

    public void setLoadingView(View loadingView) {
        this.mLoadingView = loadingView;
    }

    public void setLoadingViewRes(int res) {
        this.mLoadingView = this.mInflater.inflate(res, (ViewGroup) null);
    }

    public void setEmptyView(View emptyView) {
        this.mEmptyView = emptyView;
        emptyView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                StateLayoutManager.this.mClickListener.onEmptyClick(v);
            }
        });
    }

    public void setEmptyView(int res) {
        setEmptyView(this.mInflater.inflate(res, (ViewGroup) null));
    }

    public void setEmptyView(int res, int refreshBtnId) {
        setEmptyView(this.mInflater.inflate(res, (ViewGroup) null), refreshBtnId);
    }

    public void setEmptyView(View emptyView, int refreshBtnId) {
        View view2;
        this.mEmptyView = emptyView;
        if (emptyView != null && (view2 = emptyView.findViewById(refreshBtnId)) != null) {
            view2.setClickable(true);
            view2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    StateLayoutManager.this.mClickListener.onEmptyClick(v);
                }
            });
        }
    }

    public void setErrorView(View errorView) {
        this.mErrorView = errorView;
    }

    public void setErrorView(int res) {
        this.mErrorView = this.mInflater.inflate(res, (ViewGroup) null);
    }

    public void setErrorView(int res, int refreshBtnId) {
        setErrorView(this.mInflater.inflate(res, (ViewGroup) null), refreshBtnId);
    }

    public void setErrorView(View emptyView, int refreshBtnId) {
        View view2;
        this.mErrorView = emptyView;
        if (emptyView != null && (view2 = emptyView.findViewById(refreshBtnId)) != null) {
            view2.setClickable(true);
            view2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    StateLayoutManager.this.mClickListener.onErrorClick(v);
                }
            });
        }
    }

    public View getContentView() {
        return this.mContentView;
    }

    public View getLoadingView() {
        return this.mLoadingView;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View getErrorView() {
        return this.mErrorView;
    }

    public void injectContent(int res) {
        this.mContentView = this.mInflater.inflate(res, (ViewGroup) null);
        changeView(0);
    }

    public void injectContent(View view2) {
        this.mContentView = view2;
        changeView(0);
    }

    public void setOnClickLister(OnCommonClickListener listener) {
        this.mClickListener = listener;
    }

    public int getShowType() {
        return this.mViewType;
    }

    public void showView(int viewType) {
        setupDefaultView();
        changeView(viewType);
    }

    private void changeView(int viewType) {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null) {
            return;
        }
        if (viewType != this.mViewType || viewGroup.getChildCount() <= 0) {
            if (this.mViewType == 2) {
                View view2 = this.mLoadingView;
                if (view2 instanceof BdShimmerView) {
                    ((BdShimmerView) view2).stopShimmerAnimation();
                }
            }
            FrameLayout.LayoutParams mLayoutParams = new FrameLayout.LayoutParams(-1, -1);
            hideDefaultView();
            this.mRootView.removeAllViews();
            this.mViewType = viewType;
            switch (viewType) {
                case 0:
                    this.mContentView.setVisibility(0);
                    this.mRootView.addView(this.mContentView, mLayoutParams);
                    return;
                case 1:
                    this.mErrorView.setVisibility(0);
                    this.mRootView.addView(this.mErrorView, mLayoutParams);
                    return;
                case 2:
                    if (this.mLoadingView instanceof BdShimmerView) {
                        mLayoutParams = new FrameLayout.LayoutParams(-2, -2);
                        mLayoutParams.gravity = 17;
                    }
                    this.mLoadingView.setVisibility(0);
                    this.mRootView.addView(this.mLoadingView, mLayoutParams);
                    return;
                case 3:
                    this.mEmptyView.setVisibility(0);
                    this.mRootView.addView(this.mEmptyView, mLayoutParams);
                    return;
                default:
                    return;
            }
        }
    }

    private void hideDefaultView() {
        View view2 = this.mEmptyView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mErrorView;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mLoadingView;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.mContentView;
        if (view5 != null) {
            view5.setVisibility(8);
        }
    }

    public View getCurrentView() {
        switch (this.mViewType) {
            case 0:
                return this.mContentView;
            case 1:
                return this.mErrorView;
            case 2:
                return this.mLoadingView;
            case 3:
                return this.mEmptyView;
            default:
                return null;
        }
    }

    private void setupDefaultView() {
        if (this.mEmptyView == null) {
            CommonEmptyView commonEmptyView = new CommonEmptyView(this.mRootView.getContext());
            this.mEmptyView = commonEmptyView;
            if (this.mClickListener != null) {
                commonEmptyView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        StateLayoutManager.this.mClickListener.onEmptyClick(v);
                    }
                });
            }
        }
        if (this.mLoadingView == null) {
            BdShimmerView bdShimmerView = new BdShimmerView(this.mRootView.getContext());
            this.mLoadingView = bdShimmerView;
            BdShimmerView bdShimmerView2 = bdShimmerView;
            bdShimmerView.setType(1);
        }
        if (this.mErrorView == null) {
            NetworkErrorView networkErrorView = new NetworkErrorView(this.mRootView.getContext());
            this.mErrorView = networkErrorView;
            if (this.mClickListener != null) {
                NetworkErrorView networkErrorView2 = networkErrorView;
                networkErrorView.setReloadClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        StateLayoutManager.this.mClickListener.onErrorClick(v);
                    }
                });
            }
        }
    }

    public void updateDefaultViewUI(boolean isNight) {
        View view2 = this.mEmptyView;
        if (view2 instanceof CommonEmptyView) {
            ((CommonEmptyView) view2).setPageResources();
        }
        View view3 = this.mLoadingView;
        if (view3 instanceof BdShimmerView) {
            ((BdShimmerView) view3).setPageResources();
        }
        View view4 = this.mErrorView;
        if (!(view4 instanceof NetworkErrorView)) {
            return;
        }
        if (isNight) {
            ((NetworkErrorView) view4).updateUI(2);
        } else {
            ((NetworkErrorView) view4).updateUI(0);
        }
    }

    public void showContent() {
        changeView(0);
    }

    public void showEmpty() {
        setupDefaultView();
        changeView(3);
    }

    public void showLoading() {
        setupDefaultView();
        changeView(2);
        View view2 = this.mLoadingView;
        if (view2 instanceof BdShimmerView) {
            ((BdShimmerView) view2).startShimmerAnimation();
        }
    }

    public void showError() {
        setupDefaultView();
        changeView(1);
    }
}
