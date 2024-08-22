package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.ListPopupWindow;
import androidx.annotation.Nullable;
import com.baidu.sapi2.views.SmsLoginView;

public class InputAwareWebView extends WebView {
    public static final String LOG_TAG = "InputAwareWebView";
    @Nullable
    public View containerView;
    public ThreadedInputConnectionProxyAdapterView proxyAdapterView;
    public View threadedInputConnectionProxyView;
    public boolean useHybridComposition;

    public InputAwareWebView(Context context) {
        super(context);
        this.useHybridComposition = false;
        this.containerView = null;
    }

    public InputAwareWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.useHybridComposition = false;
        this.containerView = null;
    }

    public InputAwareWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.useHybridComposition = false;
        this.containerView = null;
    }

    public InputAwareWebView(Context context, @Nullable View view, Boolean bool) {
        super(context);
        boolean z = false;
        this.useHybridComposition = false;
        this.containerView = view;
        this.useHybridComposition = bool != null ? bool.booleanValue() : z;
    }

    private boolean isCalledFromListPopupWindowShow() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName().equals(ListPopupWindow.class.getCanonicalName()) && stackTraceElement.getMethodName().equals(SmsLoginView.f.b)) {
                return true;
            }
        }
        return false;
    }

    private void resetInputConnection() {
        View view;
        if (this.proxyAdapterView != null && (view = this.containerView) != null) {
            setInputConnectionTarget(view);
        }
    }

    private void setInputConnectionTarget(final View view) {
        if (this.containerView != null) {
            view.requestFocus();
            this.containerView.post(new Runnable() {
                public void run() {
                    InputAwareWebView inputAwareWebView = InputAwareWebView.this;
                    if (inputAwareWebView.containerView != null) {
                        InputMethodManager inputMethodManager = (InputMethodManager) inputAwareWebView.getContext().getSystemService("input_method");
                        view.onWindowFocusChanged(true);
                        if (Build.VERSION.SDK_INT < 29) {
                            inputMethodManager.isActive(InputAwareWebView.this.containerView);
                        }
                    }
                }
            });
        }
    }

    public boolean checkInputConnectionProxy(View view) {
        if (this.useHybridComposition) {
            return super.checkInputConnectionProxy(view);
        }
        View view2 = this.threadedInputConnectionProxyView;
        this.threadedInputConnectionProxyView = view;
        if (view2 == view) {
            return super.checkInputConnectionProxy(view);
        }
        View view3 = this.containerView;
        if (view3 == null) {
            return super.checkInputConnectionProxy(view);
        }
        ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView = new ThreadedInputConnectionProxyAdapterView(view3, view, view.getHandler());
        this.proxyAdapterView = threadedInputConnectionProxyAdapterView;
        setInputConnectionTarget(threadedInputConnectionProxyAdapterView);
        return super.checkInputConnectionProxy(view);
    }

    public void clearFocus() {
        super.clearFocus();
        if (!this.useHybridComposition) {
            resetInputConnection();
        }
    }

    public void dispose() {
        if (!this.useHybridComposition) {
            resetInputConnection();
        }
    }

    public void lockInputConnection() {
        ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView = this.proxyAdapterView;
        if (threadedInputConnectionProxyAdapterView != null) {
            threadedInputConnectionProxyAdapterView.setLocked(true);
        }
    }

    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (this.useHybridComposition) {
            super.onFocusChanged(z, i2, rect);
        } else if (Build.VERSION.SDK_INT >= 28 || !isCalledFromListPopupWindowShow() || z) {
            super.onFocusChanged(z, i2, rect);
        }
    }

    public void setContainerView(View view) {
        this.containerView = view;
        if (this.proxyAdapterView != null && view != null) {
            setInputConnectionTarget(this.proxyAdapterView);
        }
    }

    public void unlockInputConnection() {
        ThreadedInputConnectionProxyAdapterView threadedInputConnectionProxyAdapterView = this.proxyAdapterView;
        if (threadedInputConnectionProxyAdapterView != null) {
            threadedInputConnectionProxyAdapterView.setLocked(false);
        }
    }
}
