package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.ui.CommonEmptyView;

public class ImmersiveVideoStateView extends FrameLayout {
    public static final int STATE_ERROR = 2;
    public static final int STATE_HIDE_ALL = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_NO_MORE = 3;
    public static final int STATE_OFFLINE = 4;
    private Context mContext;
    private CommonEmptyView mErrorView;
    private BdShimmerView mLoadingView;
    private TextView mNoMoreView;
    private OffLineView mOfflineView;
    /* access modifiers changed from: private */
    public View.OnClickListener mRetryListener;
    private int mState = 1;

    public ImmersiveVideoStateView(Context context) {
        super(context);
        this.mContext = context;
        updateUi();
    }

    public void updateUi() {
        setBackgroundColor(getResources().getColor(R.color.immersive_video_state_view_bg));
        CommonEmptyView commonEmptyView = this.mErrorView;
        if (commonEmptyView != null) {
            commonEmptyView.setBackgroundColor(getResources().getColor(R.color.immersive_video_state_view_bg));
        }
        TextView textView = this.mNoMoreView;
        if (textView != null) {
            textView.setTextColor(this.mContext.getResources().getColor(R.color.feed_time_line_text_color_classic));
        }
        BdShimmerView bdShimmerView = this.mLoadingView;
        if (bdShimmerView != null) {
            bdShimmerView.setBackgroundColor(getResources().getColor(R.color.immersive_video_state_view_bg));
        }
        OffLineView offLineView = this.mOfflineView;
        if (offLineView != null) {
            offLineView.setBackgroundColor(getResources().getColor(R.color.immersive_video_offline_bg));
        }
    }

    private void showLoadingView() {
        if (this.mLoadingView == null) {
            BdShimmerView bdShimmerView = new BdShimmerView(this.mContext);
            this.mLoadingView = bdShimmerView;
            bdShimmerView.setType(0);
            FrameLayout.LayoutParams loadingLp = new FrameLayout.LayoutParams(-2, -2);
            loadingLp.gravity = 17;
            addView(this.mLoadingView, loadingLp);
            this.mLoadingView.setBackgroundColor(getResources().getColor(R.color.immersive_video_state_view_bg));
        }
        this.mLoadingView.setVisibility(0);
        this.mLoadingView.startShimmerAnimation();
    }

    private void showErrorView() {
        if (this.mErrorView == null) {
            CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext);
            this.mErrorView = commonEmptyView;
            commonEmptyView.setTextButtonClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (ImmersiveVideoStateView.this.mRetryListener != null) {
                        ImmersiveVideoStateView.this.mRetryListener.onClick(v);
                    }
                }
            });
            this.mErrorView.setButtonText(R.string.feed_refresh_again);
            this.mErrorView.setButtonTextColor(getResources().getColorStateList(R.color.immersive_error_view_btn_text_color));
            FrameLayout.LayoutParams errorLp = new FrameLayout.LayoutParams(-2, -2);
            errorLp.gravity = 17;
            this.mErrorView.setVisibility(8);
            this.mErrorView.setBackgroundColor(getResources().getColor(R.color.immersive_video_state_view_bg));
            this.mErrorView.setIcon(this.mContext.getResources().getDrawable(com.baidu.android.common.ui.style.R.drawable.empty_icon_network));
            this.mErrorView.setTitle(this.mContext.getResources().getString(R.string.feed_update_toast_bad_net));
            this.mErrorView.setTitleColor(getResources().getColor(R.color.immersive_video_state_view_text));
            addView(this.mErrorView, errorLp);
        }
        this.mErrorView.setVisibility(0);
    }

    private void showNoMoreView() {
        if (this.mNoMoreView == null) {
            TextView textView = new TextView(this.mContext);
            this.mNoMoreView = textView;
            textView.setText(this.mContext.getResources().getString(R.string.feed_immersive_video_no_more_text));
            this.mNoMoreView.setTextColor(this.mContext.getResources().getColor(R.color.immersive_video_state_view_text));
            this.mNoMoreView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.immersive_video_state_no_more_text_size));
            FrameLayout.LayoutParams noMoreLp = new FrameLayout.LayoutParams(-2, -2);
            noMoreLp.gravity = 49;
            noMoreLp.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.dimens_10dp);
            addView(this.mNoMoreView, noMoreLp);
        }
        this.mNoMoreView.setVisibility(0);
    }

    private void showOfflineView() {
        if (this.mOfflineView == null) {
            OffLineView offLineView = new OffLineView(this.mContext);
            this.mOfflineView = offLineView;
            offLineView.setBackgroundColor(getResources().getColor(R.color.immersive_video_offline_bg));
            FrameLayout.LayoutParams offlineLp = new FrameLayout.LayoutParams(-1, -1);
            offlineLp.gravity = 17;
            addView(this.mOfflineView, offlineLp);
        }
        this.mOfflineView.setVisibility(0);
    }

    public void hideStateViews() {
        CommonEmptyView commonEmptyView = this.mErrorView;
        if (commonEmptyView != null) {
            commonEmptyView.setVisibility(8);
        }
        BdShimmerView bdShimmerView = this.mLoadingView;
        if (bdShimmerView != null) {
            bdShimmerView.setVisibility(8);
            this.mLoadingView.stopShimmerAnimation();
        }
        TextView textView = this.mNoMoreView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        OffLineView offLineView = this.mOfflineView;
        if (offLineView != null) {
            offLineView.setVisibility(8);
        }
    }

    public void setState(int state) {
        this.mState = state;
        show();
    }

    private void show() {
        hideStateViews();
        setVisibility(0);
        switch (this.mState) {
            case 0:
                setVisibility(8);
                return;
            case 1:
                showLoadingView();
                return;
            case 2:
                showErrorView();
                return;
            case 3:
                showNoMoreView();
                return;
            case 4:
                showOfflineView();
                return;
            default:
                return;
        }
    }

    public void setRetryListener(View.OnClickListener listener) {
        this.mRetryListener = listener;
    }

    public void setBackListener(View.OnClickListener listener) {
        OffLineView offLineView = this.mOfflineView;
        if (offLineView != null) {
            offLineView.setBackListener(listener);
        }
    }
}
