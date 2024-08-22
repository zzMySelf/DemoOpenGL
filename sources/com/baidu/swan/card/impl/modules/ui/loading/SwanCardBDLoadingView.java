package com.baidu.swan.card.impl.modules.ui.loading;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.ioc.SwanUIRuntime;
import com.baidu.swan.card.impl.R;
import com.baidu.swan.card.ioc.SwanCardRuntime;
import com.baidu.swan.card.res.SwanAppNightModeChangeListener;
import com.baidu.swan.card.res.loading.BdShimmerView;
import com.baidu.swan.card.utils.SwanCardImmersionHelper;

public class SwanCardBDLoadingView extends RelativeLayout {
    private boolean mCurrentNightModeState;
    private boolean mImmersion;
    private BdShimmerView mLoadingShimmerView;

    public SwanCardBDLoadingView(Context context, boolean immersion) {
        this(context, (AttributeSet) null, immersion);
    }

    public SwanCardBDLoadingView(Context context, AttributeSet attrs, boolean immersion) {
        this(context, attrs, 0, immersion);
    }

    public SwanCardBDLoadingView(Context context, AttributeSet attrs, int defStyleAttr, boolean immersion) {
        super(context, attrs, defStyleAttr);
        this.mImmersion = immersion;
        setClickable(true);
        BdShimmerView bdShimmerView = new BdShimmerView(context, attrs, defStyleAttr);
        this.mLoadingShimmerView = bdShimmerView;
        bdShimmerView.setType(1);
        FrameLayout.LayoutParams defaultLoadingParams = new FrameLayout.LayoutParams(-2, -2);
        defaultLoadingParams.gravity = 17;
        this.mLoadingShimmerView.setLayoutParams(defaultLoadingParams);
        RelativeLayout.LayoutParams loadingParams = new RelativeLayout.LayoutParams(-2, -2);
        loadingParams.addRule(13);
        addView(this.mLoadingShimmerView, loadingParams);
        boolean nightModeSwitcherState = SwanUIRuntime.getSwanUIContext().getNightModeSwitcherState();
        this.mCurrentNightModeState = nightModeSwitcherState;
        updateView(nightModeSwitcherState);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SwanCardRuntime.getSwanCardContext().subscribeNightModeChangeEvent(this, new SwanAppNightModeChangeListener() {
            public void onNightModeChanged(boolean isNightMode) {
                SwanCardBDLoadingView.this.updateView(isNightMode);
            }
        });
        boolean nightMode = SwanUIRuntime.getSwanUIContext().getNightModeSwitcherState();
        if (this.mCurrentNightModeState != nightMode) {
            this.mCurrentNightModeState = nightMode;
            updateView(nightMode);
        }
        BdShimmerView bdShimmerView = this.mLoadingShimmerView;
        if (bdShimmerView != null) {
            bdShimmerView.startShimmerAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SwanCardRuntime.getSwanCardContext().unsubscribeNightModeChangedEvent(this);
        BdShimmerView bdShimmerView = this.mLoadingShimmerView;
        if (bdShimmerView != null) {
            bdShimmerView.stopShimmerAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void updateView(boolean nightMode) {
        setBackgroundColor(AppRuntime.getAppContext().getResources().getColor(R.color.card_loading_bg_color));
        this.mLoadingShimmerView.setType(nightMode ^ true ? 1 : 0);
        Window window = null;
        if (getContext() instanceof Activity) {
            window = ((Activity) getContext()).getWindow();
        }
        if (this.mImmersion) {
            SwanCardImmersionHelper.setStatusBarLightMode(window, !nightMode);
        }
    }
}
