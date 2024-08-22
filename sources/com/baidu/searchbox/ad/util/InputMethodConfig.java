package com.baidu.searchbox.ad.util;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/ad/util/InputMethodConfig;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "mIsResuming", "mLastVisibleHeight", "", "mViewRef", "Ljava/lang/ref/WeakReference;", "onGlobalLayout", "", "lib-ad_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputMethodConfig.kt */
public final class InputMethodConfig implements ViewTreeObserver.OnGlobalLayoutListener {
    private boolean isFullScreen;
    /* access modifiers changed from: private */
    public boolean mIsResuming;
    private int mLastVisibleHeight = -1;
    private WeakReference<View> mViewRef;

    public InputMethodConfig(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mViewRef = new WeakReference<>(rootView);
        Context application = AdRuntimeHolder.getAdRuntime().context();
        if (application instanceof Application) {
            ((Application) application).registerActivityLifecycleCallbacks(new InputMethodConfig$1$1(rootView, this, application));
        }
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final void setFullScreen(boolean z) {
        this.isFullScreen = z;
    }

    public void onGlobalLayout() {
        int windowHeight;
        int top;
        View rootView = (View) this.mViewRef.get();
        if (rootView != null) {
            if (this.mLastVisibleHeight < ((int) (((float) DeviceUtil.ScreenInfo.getRealScreenHeight(rootView.getContext())) * 0.85f)) || this.mIsResuming) {
                if (ViewCompat.isAttachedToWindow(rootView)) {
                    Rect r = new Rect();
                    rootView.getWindowVisibleDisplayFrame(r);
                    int top2 = r.top;
                    if (this.isFullScreen) {
                        top = 0;
                    } else {
                        top = top2 == 0 ? DeviceUtil.ScreenInfo.getStatusBarHeight() : top2;
                    }
                    windowHeight = r.bottom - top;
                } else {
                    windowHeight = rootView.getMeasuredHeight();
                }
                if (this.mLastVisibleHeight != windowHeight && windowHeight > 0) {
                    this.mLastVisibleHeight = windowHeight;
                    rootView.getLayoutParams().height = windowHeight;
                    rootView.requestLayout();
                }
            }
        }
    }
}
