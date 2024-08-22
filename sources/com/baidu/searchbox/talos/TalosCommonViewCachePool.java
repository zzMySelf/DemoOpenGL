package com.baidu.searchbox.talos;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.baidu.android.common.ui.R;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.feed.widget.feedflow.FeedEmptyView;
import com.baidu.searchbox.reactnative.debug.OverflowDebugUtil;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.ui.DrawableCenterTextView;
import com.baidu.talos.TalosAppRuntimeInit;
import com.baidu.talos.util.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class TalosCommonViewCachePool {
    private static final boolean DEBUG = LogUtils.isDebug;
    private static final int DEFAULT_CACHE_SIZE = 5;
    private static final String TAG = "TalosCommonViewPool";
    private List<View> mDebugIndicatorViewList;
    private List<View> mErrorViewList;
    private List<BdShimmerView> mLoadingViewList;

    private static final class Holder {
        /* access modifiers changed from: private */
        public static final TalosCommonViewCachePool INSTANCE = new TalosCommonViewCachePool();

        private Holder() {
        }
    }

    public static TalosCommonViewCachePool getInstance() {
        return Holder.INSTANCE;
    }

    private TalosCommonViewCachePool() {
        this.mErrorViewList = new ArrayList(5);
        this.mLoadingViewList = new ArrayList(5);
        this.mDebugIndicatorViewList = new ArrayList(5);
    }

    public View obtainErrorView(View.OnClickListener retryClicklistener) {
        View errorView = getCachedViewFromList(this.mErrorViewList);
        if (errorView == null) {
            errorView = new FeedEmptyView(TalosAppRuntimeInit.getAppContext());
            ((TextView) errorView.findViewById(R.id.emptyview_btn)).setClickable(false);
            FrameLayout.LayoutParams errorParams = new FrameLayout.LayoutParams(-1, -1);
            errorParams.gravity = 17;
            errorView.setLayoutParams(errorParams);
            errorView.setBackgroundColor(-1);
        }
        if (errorView instanceof FeedEmptyView) {
            FeedEmptyView feedEmptyView = (FeedEmptyView) errorView;
            TextView reloadBtn = (TextView) feedEmptyView.findViewById(R.id.emptyview_btn);
            if (retryClicklistener != null) {
                if (reloadBtn != null) {
                    reloadBtn.setClickable(true);
                }
            } else if (reloadBtn != null) {
                reloadBtn.setClickable(false);
            }
            feedEmptyView.setRetryListener(retryClicklistener);
        }
        return errorView;
    }

    public BdShimmerView obtainLoadingView() {
        BdShimmerView loadingView = (BdShimmerView) getCachedViewFromList(this.mLoadingViewList);
        if (loadingView != null) {
            return loadingView;
        }
        BdShimmerView loadingView2 = new BdShimmerView(TalosAppRuntimeInit.getAppContext());
        loadingView2.setType(1);
        FrameLayout.LayoutParams loadingParams = new FrameLayout.LayoutParams(-2, -2);
        loadingParams.gravity = 17;
        loadingView2.setLayoutParams(loadingParams);
        return loadingView2;
    }

    public View obtainDebugIndicatorView(String logoText) {
        DrawableCenterTextView debugIndicator = (DrawableCenterTextView) getCachedViewFromList(this.mDebugIndicatorViewList);
        if (debugIndicator == null) {
            Context context = TalosAppRuntimeInit.getAppContext();
            debugIndicator = new DrawableCenterTextView(context);
            String text = context.getString(R.string.debug_indicator_text);
            if (!TextUtils.isEmpty(logoText)) {
                text = logoText;
            }
            debugIndicator.setText(text);
            debugIndicator.setVisibility(0);
            debugIndicator.setTextSize(1, 14.0f);
            debugIndicator.setTextColor(SupportMenu.CATEGORY_MASK);
            debugIndicator.setBackgroundColor(-16777216);
            debugIndicator.setCompoundDrawablePadding(DeviceUtil.ScreenInfo.dp2px(context, 8.0f));
            debugIndicator.setPadding(DeviceUtil.ScreenInfo.dp2px(context, 4.0f), DeviceUtil.ScreenInfo.dp2px(context, 4.0f), DeviceUtil.ScreenInfo.dp2px(context, 4.0f), DeviceUtil.ScreenInfo.dp2px(context, 4.0f));
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
            params.gravity = 49;
            final DrawableCenterTextView finalDebugIndicator = debugIndicator;
            debugIndicator.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (OverflowDebugUtil.isViewTreeGrabEnable()) {
                        OverflowDebugUtil.printRootViewTree(v);
                    } else {
                        finalDebugIndicator.setVisibility(8);
                    }
                }
            });
            debugIndicator.setLayoutParams(params);
        } else if (!TextUtils.isEmpty(logoText)) {
            debugIndicator.setText(logoText);
        }
        return debugIndicator;
    }

    private View getCachedViewFromList(List<? extends View> cacheList) {
        if (cacheList.isEmpty()) {
            return null;
        }
        for (View view2 : cacheList) {
            if (view2.getParent() == null) {
                cacheList.remove(view2);
                return view2;
            }
        }
        return null;
    }

    public void recycleCommonViews(View debugIndicator, View errorView, View loadingView) {
        removeParent(debugIndicator);
        removeParent(errorView);
        removeParent(loadingView);
        if (!this.mDebugIndicatorViewList.contains(debugIndicator)) {
            this.mDebugIndicatorViewList.add(debugIndicator);
        }
        if (!this.mErrorViewList.contains(errorView)) {
            this.mErrorViewList.add(errorView);
        }
        if (!this.mLoadingViewList.contains(loadingView) && (loadingView instanceof BdShimmerView)) {
            this.mLoadingViewList.add((BdShimmerView) loadingView);
        }
    }

    private void removeParent(View view2) {
        if (view2 != null && view2.getParent() != null) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
    }
}
