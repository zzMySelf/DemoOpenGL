package com.baidu.swan.apps.res.widget.floatlayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.swan.game.ad.interfaces.IAdView;

public class FloatLayer {
    private final int mDefaultMarginTop;
    private boolean mHookBack = false;
    private boolean mIsRewardVideoAdLayer;
    private IAdView.OnBackClickListener mListener;
    private int mMarginTop;
    private boolean mResumeDismiss = true;
    private final ViewGroup mTarget;

    public interface Holder {
        FloatLayer getFloatLayer();
    }

    public FloatLayer(ViewGroup target, int marginTop) {
        this.mTarget = target;
        this.mMarginTop = marginTop;
        this.mDefaultMarginTop = marginTop;
    }

    public void setMask(boolean mask) {
        Container container = findContainer();
        if (container != null) {
            container.setClickable(mask);
        }
    }

    public void setMarginTop(int marginTop) {
        if (findContainer() != null) {
            resetContainer(false);
        }
        this.mMarginTop = marginTop;
    }

    public void setHookBack(boolean hookBack) {
        this.mHookBack = hookBack;
    }

    public boolean hookBack() {
        return this.mHookBack;
    }

    public void setResumeDismiss(boolean resumeDismiss) {
        this.mResumeDismiss = resumeDismiss;
    }

    public boolean resumeDismiss() {
        return this.mResumeDismiss;
    }

    public void setRewardVideoAdLayer(boolean isAdLayer) {
        this.mIsRewardVideoAdLayer = isAdLayer;
        this.mMarginTop = 0;
    }

    public boolean getRewardVideoAdLayer() {
        return this.mIsRewardVideoAdLayer;
    }

    private Context getContext() {
        return this.mTarget.getContext();
    }

    private Container findContainer() {
        synchronized (this.mTarget) {
            for (int i2 = 0; i2 < this.mTarget.getChildCount(); i2++) {
                View v = this.mTarget.getChildAt(i2);
                if (v instanceof Container) {
                    Container container = (Container) v;
                    return container;
                }
            }
            return null;
        }
    }

    private Container getContainer() {
        Container container;
        int topMargin;
        synchronized (this.mTarget) {
            container = findContainer();
            if (container == null) {
                container = new Container(getContext());
                int height = this.mTarget.getHeight();
                int i2 = this.mMarginTop;
                int layoutHeight = height - i2;
                ViewGroup viewGroup = this.mTarget;
                if (viewGroup instanceof LinearLayout) {
                    topMargin = -layoutHeight;
                } else {
                    topMargin = i2;
                }
                if (layoutHeight <= 0) {
                    layoutHeight = -1;
                    topMargin = 0;
                }
                if (!(viewGroup instanceof LinearLayout) && i2 == 0) {
                    layoutHeight = -1;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, layoutHeight);
                layoutParams.setMargins(0, topMargin, 0, 0);
                container.setLayoutParams(layoutParams);
                this.mTarget.addView(container);
            }
        }
        return container;
    }

    public void reset() {
        resetContainer(false);
        resetFlags();
    }

    private void resetFlags() {
        this.mResumeDismiss = true;
        this.mHookBack = false;
        this.mMarginTop = this.mDefaultMarginTop;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void resetContainer(boolean r4) {
        /*
            r3 = this;
            android.view.ViewGroup r0 = r3.mTarget
            monitor-enter(r0)
            com.baidu.swan.apps.res.widget.floatlayer.Container r1 = r3.findContainer()     // Catch:{ all -> 0x001c }
            if (r4 == 0) goto L_0x0013
            if (r1 == 0) goto L_0x0013
            int r2 = r1.getChildCount()     // Catch:{ all -> 0x001c }
            if (r2 <= 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            return
        L_0x0013:
            if (r1 == 0) goto L_0x001a
            android.view.ViewGroup r2 = r3.mTarget     // Catch:{ all -> 0x001c }
            r2.removeView(r1)     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.res.widget.floatlayer.FloatLayer.resetContainer(boolean):void");
    }

    public View getView() {
        Container container = findContainer();
        if (container != null && container.getChildCount() > 0) {
            return container.getChildAt(0);
        }
        return null;
    }

    public void show(View view2) {
        if (view2 != getView()) {
            resetContainer(false);
            getContainer().addView(view2);
        }
    }

    public void show(View view2, int width, int height) {
        if (view2 != getView()) {
            resetContainer(false);
            getContainer().addView(view2, width, height);
        }
    }

    public void show(View view2, ViewGroup.LayoutParams params) {
        if (view2 != getView()) {
            resetContainer(false);
            getContainer().addView(view2, params);
        }
    }

    public boolean isShowingView() {
        Container container = findContainer();
        if (container == null) {
            return false;
        }
        int count = container.getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View view2 = container.getChildAt(i2);
            if (view2 != null && view2.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void handleBackPressed() {
        IAdView.OnBackClickListener onBackClickListener = this.mListener;
        if (onBackClickListener != null) {
            onBackClickListener.onBackPressed();
        }
    }

    public void setOnBackListener(IAdView.OnBackClickListener listener) {
        this.mListener = listener;
    }
}
