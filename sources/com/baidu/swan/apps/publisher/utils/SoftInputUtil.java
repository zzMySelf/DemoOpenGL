package com.baidu.swan.apps.publisher.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.InputMethodController;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import com.baidu.swan.apps.R;
import com.baidu.swan.apps.publisher.emoji.SoftInputSharedPreferences;
import com.baidu.swan.apps.publisher.view.IPanelHeightTarget;

public class SoftInputUtil {
    private static boolean get = false;
    private static int sLastSaveSoftInputHeight = 0;
    private static int sMaxPanelHeight = 0;
    private static int sMaxSoftInputHeight = 0;
    private static int sMinPanelHeight = 0;
    private static int sMinSoftInputHeight = 0;
    private static int sStatusBarHeight = 0;

    public interface OnSoftInputShowingListener {
        void onSoftInputShowing(boolean z);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.ViewTreeObserver.OnGlobalLayoutListener attach(android.app.Activity r2, android.view.ViewGroup r3, com.baidu.swan.apps.publisher.view.IPanelHeightTarget r4, com.baidu.swan.apps.publisher.utils.SoftInputUtil.OnSoftInputShowingListener r5) {
        /*
            if (r3 != 0) goto L_0x000c
            r0 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r2.findViewById(r0)
            r3 = r0
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
        L_0x000c:
            com.baidu.swan.apps.publisher.utils.SoftInputUtil$SoftInputStatusListener r0 = new com.baidu.swan.apps.publisher.utils.SoftInputUtil$SoftInputStatusListener
            r0.<init>(r2, r3, r4, r5)
            android.view.ViewTreeObserver r1 = r3.getViewTreeObserver()
            r1.addOnGlobalLayoutListener(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.publisher.utils.SoftInputUtil.attach(android.app.Activity, android.view.ViewGroup, com.baidu.swan.apps.publisher.view.IPanelHeightTarget, com.baidu.swan.apps.publisher.utils.SoftInputUtil$OnSoftInputShowingListener):android.view.ViewTreeObserver$OnGlobalLayoutListener");
    }

    public static void detach(Activity activity, ViewTreeObserver.OnGlobalLayoutListener listener) {
        ((ViewGroup) activity.findViewById(16908290)).getViewTreeObserver().removeOnGlobalLayoutListener(listener);
    }

    static void showSoftInput(View focusView) {
        focusView.requestFocus();
        InputMethodManager imm = (InputMethodManager) focusView.getContext().getSystemService(InputMethodController.BUTTON_INPUT_METHOD);
        if (imm != null) {
            imm.showSoftInput(focusView, 0);
        }
    }

    public static void showSoftInputDelay(final View focusView, long millis) {
        focusView.postDelayed(new Runnable() {
            public void run() {
                SoftInputUtil.showSoftInput(focusView);
            }
        }, millis);
    }

    public static void hideSoftInput(View view2) {
        InputMethodManager imm = (InputMethodManager) view2.getContext().getSystemService(InputMethodController.BUTTON_INPUT_METHOD);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view2.getWindowToken(), 0);
        }
    }

    public static int getMinSoftInputHeight(Context context) {
        if (sMinSoftInputHeight == 0) {
            sMinSoftInputHeight = context.getResources().getDimensionPixelSize(R.dimen.aiapps_min_softinput_height);
        }
        return sMinSoftInputHeight;
    }

    public static int getMaxSoftInputHeight(Context context) {
        if (sMaxSoftInputHeight == 0) {
            sMaxSoftInputHeight = context.getResources().getDimensionPixelSize(R.dimen.aiapps_max_softinput_height);
        }
        return sMaxSoftInputHeight;
    }

    private static int getMinPanelHeight(Resources res) {
        if (sMinPanelHeight == 0) {
            sMinPanelHeight = res.getDimensionPixelSize(R.dimen.aiapps_min_panel_height);
        }
        return sMinPanelHeight;
    }

    private static int getMaxPanelHeight(Resources res) {
        if (sMaxPanelHeight == 0) {
            sMaxPanelHeight = res.getDimensionPixelSize(R.dimen.aiapps_max_panel_height);
        }
        return sMaxPanelHeight;
    }

    private static int getSoftInputHeight(Context context) {
        if (sLastSaveSoftInputHeight == 0) {
            sLastSaveSoftInputHeight = SoftInputSharedPreferences.get(context, getMinPanelHeight(context.getResources()));
        }
        return sLastSaveSoftInputHeight;
    }

    /* access modifiers changed from: private */
    public static boolean saveSoftInputHeight(Context context, int softInputHeight) {
        if (sLastSaveSoftInputHeight == softInputHeight || softInputHeight < 0) {
            return false;
        }
        sLastSaveSoftInputHeight = softInputHeight;
        return SoftInputSharedPreferences.save(context, softInputHeight);
    }

    /* access modifiers changed from: private */
    public static int getValidPanelHeight(Context context) {
        return Math.min(getMaxPanelHeight(context.getResources()), Math.max(getMinPanelHeight(context.getResources()), getSoftInputHeight(context)));
    }

    private static class SoftInputStatusListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final Activity mActivity;
        private final ViewGroup mContentView;
        private boolean mLastSoftInputShowing;
        private final IPanelHeightTarget mPanelHeightTarget;
        private int mPreviousDisplayHeight = 0;
        private final OnSoftInputShowingListener mSoftInputShowingListener;
        private int maxOverlayLayoutHeight;

        SoftInputStatusListener(Activity activity, ViewGroup contentView, IPanelHeightTarget panelHeightTarget, OnSoftInputShowingListener listener) {
            this.mActivity = activity;
            this.mSoftInputShowingListener = listener;
            this.mContentView = contentView;
            this.mPanelHeightTarget = panelHeightTarget;
        }

        public void onGlobalLayout() {
            int displayHeight;
            View userRootView = this.mContentView.getChildAt(0);
            Rect r = new Rect();
            if (userRootView == null) {
                displayHeight = -1;
            } else if (EmojiInputSwitchUtil.isHandleByPlaceholder(this.mContentView.getContext()) || (ViewUtil.isSystemUILayoutFullScreen(this.mActivity) && ViewUtil.isFitsSystemWindows(this.mActivity))) {
                userRootView.getWindowVisibleDisplayFrame(r);
                displayHeight = r.bottom - r.top;
            } else {
                displayHeight = userRootView.getHeight();
            }
            if (displayHeight != -1) {
                calculateSoftInputHeight(displayHeight);
                calculateSoftInputShowing(displayHeight);
            }
        }

        private void calculateSoftInputShowing(int displayHeight) {
            boolean isSoftInputShowing;
            View actionBarOverlayLayout = (View) this.mContentView.getParent();
            int actionBarOverlayLayoutHeight = actionBarOverlayLayout.getHeight() - actionBarOverlayLayout.getPaddingTop();
            boolean z = true;
            if (EmojiInputSwitchUtil.isHandleByPlaceholder(this.mContentView.getContext())) {
                if (actionBarOverlayLayoutHeight <= displayHeight) {
                    z = false;
                }
                isSoftInputShowing = z;
            } else {
                int i2 = this.maxOverlayLayoutHeight;
                if (i2 == 0) {
                    isSoftInputShowing = this.mLastSoftInputShowing;
                } else {
                    if (displayHeight >= i2 - SoftInputUtil.getMinSoftInputHeight(getContext())) {
                        z = false;
                    }
                    isSoftInputShowing = z;
                }
                this.maxOverlayLayoutHeight = Math.max(this.maxOverlayLayoutHeight, actionBarOverlayLayoutHeight);
            }
            if (this.mLastSoftInputShowing != isSoftInputShowing) {
                this.mPanelHeightTarget.onSoftInputShowing(isSoftInputShowing);
                OnSoftInputShowingListener onSoftInputShowingListener = this.mSoftInputShowingListener;
                if (onSoftInputShowingListener != null) {
                    onSoftInputShowingListener.onSoftInputShowing(isSoftInputShowing);
                }
            }
            this.mLastSoftInputShowing = isSoftInputShowing;
        }

        private void calculateSoftInputHeight(int displayHeight) {
            int softInputHeight;
            int validPanelHeight;
            if (this.mPreviousDisplayHeight == 0) {
                this.mPreviousDisplayHeight = displayHeight;
                this.mPanelHeightTarget.refreshHeight(SoftInputUtil.getValidPanelHeight(getContext()));
            }
            if (EmojiInputSwitchUtil.isHandleByPlaceholder(this.mContentView.getContext())) {
                softInputHeight = ((View) this.mContentView.getParent()).getHeight() - displayHeight;
            } else {
                softInputHeight = Math.abs(displayHeight - this.mPreviousDisplayHeight);
            }
            if (softInputHeight <= SoftInputUtil.getMinSoftInputHeight(getContext())) {
                if (Math.abs(softInputHeight) == SoftInputUtil.getStatusBarHeight(this.mContentView.getContext())) {
                    this.mPreviousDisplayHeight -= softInputHeight;
                }
            } else if (SoftInputUtil.saveSoftInputHeight(getContext(), softInputHeight) && this.mPanelHeightTarget.getHeight() != (validPanelHeight = SoftInputUtil.getValidPanelHeight(getContext()))) {
                this.mPanelHeightTarget.refreshHeight(validPanelHeight);
            }
        }

        private Context getContext() {
            return this.mContentView.getContext();
        }
    }

    public static synchronized int getStatusBarHeight(Context context) {
        int resourceId;
        int resourceId2;
        synchronized (SoftInputUtil.class) {
            if (!get && (resourceId2 = context.getResources().getIdentifier("status_bar_height", ResUtils.DIMEN, "android")) > 0) {
                sStatusBarHeight = context.getResources().getDimensionPixelSize(resourceId2);
                get = true;
            }
            resourceId = sStatusBarHeight;
        }
        return resourceId;
    }
}
