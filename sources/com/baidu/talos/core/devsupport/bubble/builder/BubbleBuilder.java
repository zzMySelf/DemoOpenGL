package com.baidu.talos.core.devsupport.bubble.builder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.talos.core.devsupport.bubble.BubbleManager;
import com.baidu.talos.core.devsupport.bubble.BubblePosition;
import com.baidu.talos.core.devsupport.bubble.manager.BubbleBaseManager;
import com.baidu.talos.core.devsupport.bubble.views.BubbleBaseView;

public abstract class BubbleBuilder<T> {
    protected BubbleBaseManager mBaseManager;
    protected BubbleBaseView mBaseViews;

    public BubbleBuilder(BubbleBaseManager manager) {
        this.mBaseViews = manager.getViews();
        this.mBaseManager = manager;
    }

    public BubbleBaseView getViews() {
        return this.mBaseViews;
    }

    public BubbleBaseManager build() {
        return this.mBaseManager;
    }

    public BubbleBuilder<T> setBackgroundColor(int dayColor, int nightColor) {
        if (dayColor != -1000) {
            try {
                this.mBaseViews.setDayModeBackground(dayColor);
            } catch (Exception e2) {
                this.mBaseViews.setDayModeBackground(-1000);
                return this;
            }
        }
        if (nightColor != -1000) {
            try {
                this.mBaseViews.setNightModeBackground(nightColor);
            } catch (Exception e3) {
                this.mBaseViews.setNightModeBackground(-1000);
                return this;
            }
        }
        return this;
    }

    public BubbleBuilder<T> setBackgroundColor(String dayColor, String nightColor) {
        if (!TextUtils.isEmpty(dayColor)) {
            try {
                this.mBaseViews.setDayModeBackground(Color.parseColor(dayColor));
            } catch (Exception e2) {
                this.mBaseViews.setDayModeBackground(-1000);
                return this;
            }
        }
        if (!TextUtils.isEmpty(nightColor)) {
            try {
                this.mBaseViews.setNightModeBackground(Color.parseColor(nightColor));
            } catch (Exception e3) {
                this.mBaseViews.setNightModeBackground(-1000);
                return this;
            }
        }
        return this;
    }

    public BubbleBuilder<T> setShadowIsDeviate(boolean isDeviate) {
        this.mBaseViews.setIsShadowDeviate(isDeviate);
        return this;
    }

    public BubbleBuilder<T> setShadowDayColor(int dayColor) {
        if (dayColor != -1000) {
            try {
                this.mBaseViews.setDayModeShadowColor(dayColor);
            } catch (Exception e2) {
                this.mBaseViews.setDayModeShadowColor(-1000);
                return this;
            }
        }
        return this;
    }

    public BubbleBuilder<T> setAnchorView(View anchor) {
        this.mBaseViews.setAnchor(anchor);
        return this;
    }

    public BubbleBuilder<T> setAnchorAndRootView(View anchor, ViewGroup rootView) {
        this.mBaseViews.setAnchorAndRootView(anchor, rootView);
        return this;
    }

    public BubbleBuilder<T> setAutoDismiss(boolean autoDismiss) {
        this.mBaseManager.setAutoDismiss(autoDismiss);
        return this;
    }

    public BubbleBuilder<T> setAutoDismissInterval(int intervalInMs) {
        this.mBaseManager.setAutoDismissInterval(intervalInMs);
        return this;
    }

    public BubbleBuilder<T> setPaddingBetweenAnchor(float paddingInDp) {
        this.mBaseManager.getLocation().setPaddingBetweenAnchor(paddingInDp);
        return this;
    }

    public BubbleBuilder<T> setOnBubbleEventListener(BubbleManager.OnBubbleEventListener listener) {
        this.mBaseManager.setOnBubbleEventListener(listener);
        return this;
    }

    public BubbleBuilder<T> setOnAnchorClickListener(BubbleManager.OnAnchorClickListener listener) {
        this.mBaseManager.setOnAnchorEventListener(listener);
        return this;
    }

    public BubbleBuilder<T> enableBgClk(boolean enableBgClk) {
        this.mBaseManager.enableBgClk(enableBgClk);
        return this;
    }

    public BubbleBuilder<T> enableAnchorClk(boolean enableAnchorClk) {
        this.mBaseManager.enableAnchorClk(enableAnchorClk);
        return this;
    }

    public BubbleBuilder<T> enableAnimation(boolean enableAnimation) {
        this.mBaseManager.enableAnimation(enableAnimation);
        return this;
    }

    public BubbleBuilder<T> setOffsetOfArrow(float offsetOfArrow) {
        this.mBaseManager.setOffsetOfArrow(offsetOfArrow);
        return this;
    }

    public BubbleBuilder<T> enableClkDismiss(boolean enableClkDismiss) {
        this.mBaseManager.enableClkDismiss(enableClkDismiss);
        return this;
    }

    public BubbleBuilder<T> isAutoDetectShowPosition(boolean isAuto) {
        this.mBaseManager.getLocation().mIsAutoDetectShowPosition = isAuto;
        return this;
    }

    public BubbleBuilder<T> setForceShowPosition(BubblePosition position) {
        this.mBaseManager.getLocation().mIsAutoDetectShowPosition = false;
        this.mBaseManager.getLocation().mBubbleForceShowPosition = position;
        return this;
    }

    public BubbleBuilder<T> setForceShowLeftEndPoint() {
        this.mBaseManager.getLocation().isShowLeftEndPoint = true;
        return this;
    }
}
