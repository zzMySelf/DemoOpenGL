package com.tera.scan.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import fe.mmm.qw.yj.de;

public class TeraScanWebView extends WebView {
    public BaseWebViewFragment mBaseWebViewFragment;
    public final ViewGroup mScrollableParent = null;

    public TeraScanWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }

    @TargetApi(19)
    private void init() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        if (de.ppp().fe("fe_web_view_debug_switch", false) && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public BaseWebViewFragment getWebViewFragment() {
        return this.mBaseWebViewFragment;
    }

    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.onOverScrolled(i2, i3, z, z2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setWebViewFragment(@Nullable BaseWebViewFragment baseWebViewFragment) {
        this.mBaseWebViewFragment = baseWebViewFragment;
    }

    public TeraScanWebView(Context context) {
        super(context);
        init();
    }

    public TeraScanWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @TargetApi(11)
    public TeraScanWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(context, attributeSet, i2, z);
        init();
    }

    @TargetApi(21)
    public TeraScanWebView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        init();
    }
}
