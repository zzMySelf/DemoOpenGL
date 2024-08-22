package com.baidu.searchbox.feed.payment.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\nH\u0016J\u0006\u0010\r\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/feed/payment/utils/SoftKeyboardHelper;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "()V", "listener", "Lcom/baidu/searchbox/feed/payment/utils/OnSoftKeyboardStateUpdate;", "view", "Landroid/view/View;", "viewHeight", "", "addSoftKeyboardListener", "", "rootView", "onGlobalLayout", "release", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SoftKeyboardHelper.kt */
public final class SoftKeyboardHelper implements ViewTreeObserver.OnGlobalLayoutListener {
    private OnSoftKeyboardStateUpdate listener;

    /* renamed from: view  reason: collision with root package name */
    private View f18654view;
    private int viewHeight;

    public final void addSoftKeyboardListener(View rootView, OnSoftKeyboardStateUpdate listener2) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(listener2, "listener");
        this.f18654view = rootView;
        this.listener = listener2;
        Rect rect = new Rect();
        rootView.getGlobalVisibleRect(rect);
        this.viewHeight = rect.height();
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    public final void release() {
        ViewTreeObserver viewTreeObserver;
        View view2 = this.f18654view;
        if (!(view2 == null || (viewTreeObserver = view2.getViewTreeObserver()) == null)) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
        this.f18654view = null;
        this.listener = null;
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        View view2 = this.f18654view;
        if (view2 != null) {
            view2.getGlobalVisibleRect(rect);
        }
        int height = rect.height();
        int i2 = this.viewHeight;
        if (i2 == 0) {
            this.viewHeight = height;
        } else if (i2 - height > 200) {
            OnSoftKeyboardStateUpdate onSoftKeyboardStateUpdate = this.listener;
            if (onSoftKeyboardStateUpdate != null) {
                onSoftKeyboardStateUpdate.onStateUpdate(true);
            }
            this.viewHeight = height;
        } else if (height - i2 > 200) {
            OnSoftKeyboardStateUpdate onSoftKeyboardStateUpdate2 = this.listener;
            if (onSoftKeyboardStateUpdate2 != null) {
                onSoftKeyboardStateUpdate2.onStateUpdate(false);
            }
            this.viewHeight = height;
        }
    }
}
