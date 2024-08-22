package com.baidu.swan.apps.api.module.keyboard;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.baidu.growthsystem.wealth.common.constant.WealthVideoYalogConstantKt;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.util.SwanAppUtils;

public class KeyboardWatcher extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "KeyboardWatcher";
    /* access modifiers changed from: private */
    public final Activity mActivity;
    private View mActivityContentView;
    /* access modifiers changed from: private */
    public boolean mIsInHidden = false;
    /* access modifiers changed from: private */
    public boolean mIsInShowing = false;
    private int mKeyboardHeight;
    private final OnKeyboardListener mListener;
    private View mRootView;

    public interface OnKeyboardListener {
        void onChanged(boolean z, int i2);
    }

    private KeyboardWatcher(Activity activity, OnKeyboardListener listener) {
        super(activity);
        this.mActivity = activity;
        this.mListener = listener;
    }

    public static KeyboardWatcher create(Activity activity, OnKeyboardListener listener) {
        return new KeyboardWatcher(activity, listener);
    }

    public KeyboardWatcher prepare() {
        if (this.mRootView == null) {
            if (DEBUG) {
                Log.d(TAG, "real prepare");
            }
            View view2 = new View(this.mActivity);
            this.mRootView = view2;
            setContentView(view2);
            this.mActivityContentView = this.mActivity.findViewById(16908290);
            setBackgroundDrawable(new ColorDrawable(0));
            setFocusable(false);
            setTouchable(false);
            setOutsideTouchable(false);
            setWidth(0);
            setHeight(-1);
            setSoftInputMode(16);
            setInputMethodMode(1);
        }
        return this;
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.mRootView.getWindowVisibleDisplayFrame(rect);
        View view2 = this.mActivityContentView;
        boolean z = false;
        int contentViewHeight = view2 != null ? view2.getHeight() : 0;
        int height = Math.max(0, contentViewHeight - rect.bottom);
        if (DEBUG) {
            Log.d(TAG, "onGlobalLayout: window height = " + contentViewHeight);
            Log.d(TAG, "onGlobalLayout: current keyboard height = " + height);
            Log.d(TAG, "onGlobalLayout: last keyboard height = " + this.mKeyboardHeight);
        }
        if (this.mKeyboardHeight != height) {
            this.mKeyboardHeight = height;
            OnKeyboardListener onKeyboardListener = this.mListener;
            if (onKeyboardListener != null) {
                if (height > 0) {
                    z = true;
                }
                onKeyboardListener.onChanged(z, height);
            }
        }
    }

    public void startWatcher() {
        if (this.mRootView != null && !this.mIsInShowing && !isShowing()) {
            this.mIsInShowing = true;
            this.mKeyboardHeight = 0;
            this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
            if (DEBUG) {
                Log.d(TAG, "real startWatcher");
            }
            final View view2 = this.mActivity.getWindow().getDecorView();
            SwanAppUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (KeyboardWatcher.this.mActivity.isFinishing() || KeyboardWatcher.this.mActivity.isDestroyed() || !view2.isAttachedToWindow() || view2.getWindowToken() == null) {
                        boolean unused = KeyboardWatcher.this.mIsInShowing = false;
                        if (KeyboardWatcher.DEBUG) {
                            Log.d(KeyboardWatcher.TAG, "activity is destroyed or view is not attached");
                            return;
                        }
                        return;
                    }
                    KeyboardWatcher.this.showAtLocation(view2, 0, 0, 0);
                    boolean unused2 = KeyboardWatcher.this.mIsInShowing = false;
                }
            });
        }
    }

    public void stopWatcher() {
        if (this.mRootView != null && !this.mIsInHidden && isShowing()) {
            this.mIsInHidden = true;
            this.mRootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (DEBUG) {
                Log.d(TAG, "real stopWatcher");
            }
            SwanAppUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (KeyboardWatcher.this.mActivity.isFinishing() || KeyboardWatcher.this.mActivity.isDestroyed()) {
                        boolean unused = KeyboardWatcher.this.mIsInHidden = false;
                        if (KeyboardWatcher.DEBUG) {
                            Log.d(KeyboardWatcher.TAG, WealthVideoYalogConstantKt.YALOG_VALUE_ERROR_MSG_ACTIVITY_DESTROYED);
                            return;
                        }
                        return;
                    }
                    KeyboardWatcher.this.dismiss();
                    boolean unused2 = KeyboardWatcher.this.mIsInHidden = false;
                }
            });
        }
    }
}
