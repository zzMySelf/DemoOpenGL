package com.baidu.searchbox.aisearch.comps.input.text.inputmethod;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.baidu.android.util.devices.DeviceUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0007J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0007J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/input/text/inputmethod/InputMethodObservable;", "", "context", "Landroid/content/Context;", "rootView", "Landroid/view/View;", "hasStatusBar", "", "(Landroid/content/Context;Landroid/view/View;Z)V", "bottomNavHeight", "", "curInputMethodHeight", "isFirstGlobalLayout", "<set-?>", "isShowingInputMethod", "()Z", "observers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/baidu/searchbox/aisearch/comps/input/text/inputmethod/InputMethodObserver;", "onListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "addObserver", "", "observer", "notifyHideInputMethod", "inputMethodHeight", "notifyShowInputMethod", "release", "removeObserver", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputMethodObservable.kt */
public final class InputMethodObservable {
    private int bottomNavHeight;
    private int curInputMethodHeight;
    private boolean isFirstGlobalLayout = true;
    private boolean isShowingInputMethod;
    private final CopyOnWriteArrayList<InputMethodObserver> observers = new CopyOnWriteArrayList<>();
    private ViewTreeObserver.OnGlobalLayoutListener onListener;
    private final View rootView;

    public InputMethodObservable(Context context, View rootView2, boolean hasStatusBar) {
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(context, "context");
        this.rootView = rootView2;
        ViewTreeObserver.OnGlobalLayoutListener $this$_init__u24lambda_u2d1 = new InputMethodObservable$$ExternalSyntheticLambda0(this, hasStatusBar, context);
        this.onListener = $this$_init__u24lambda_u2d1;
        if (rootView2 != null && (viewTreeObserver = rootView2.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener($this$_init__u24lambda_u2d1);
        }
    }

    public final boolean isShowingInputMethod() {
        return this.isShowingInputMethod;
    }

    /* access modifiers changed from: private */
    /* renamed from: onListener$lambda-0  reason: not valid java name */
    public static final void m15761onListener$lambda0(InputMethodObservable this$0, boolean $hasStatusBar, Context $context) {
        int statusBarHeight;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($context, "$context");
        Rect r = new Rect();
        View view2 = this$0.rootView;
        if (view2 != null) {
            view2.getWindowVisibleDisplayFrame(r);
        }
        int usableHeightNow = r.bottom - r.top;
        if ($hasStatusBar) {
            statusBarHeight = DeviceUtils.ScreenInfo.getStatusBarHeight();
        } else {
            statusBarHeight = 0;
        }
        int screenRealHeight = DeviceUtils.ScreenInfo.getRealScreenHeight($context);
        if (this$0.isFirstGlobalLayout) {
            this$0.isFirstGlobalLayout = false;
            int i2 = (screenRealHeight - usableHeightNow) - statusBarHeight;
            this$0.bottomNavHeight = i2;
            if (i2 < 0) {
                this$0.bottomNavHeight = 0;
            }
        }
        int inputMethodHeight = ((screenRealHeight - usableHeightNow) - statusBarHeight) - this$0.bottomNavHeight;
        int i3 = this$0.curInputMethodHeight;
        if (inputMethodHeight != i3) {
            if (inputMethodHeight > screenRealHeight / 4) {
                this$0.notifyShowInputMethod(inputMethodHeight);
                this$0.curInputMethodHeight = inputMethodHeight;
            } else if (i3 - inputMethodHeight > screenRealHeight / 4) {
                this$0.notifyHideInputMethod(inputMethodHeight);
                this$0.curInputMethodHeight = inputMethodHeight;
            }
        }
    }

    private final void notifyHideInputMethod(int inputMethodHeight) {
        this.isShowingInputMethod = false;
        Iterator<InputMethodObserver> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().onHide(inputMethodHeight);
        }
    }

    private final void notifyShowInputMethod(int inputMethodHeight) {
        this.isShowingInputMethod = true;
        Iterator<InputMethodObserver> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().onShow(inputMethodHeight);
        }
    }

    public final void addObserver(InputMethodObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }

    public final void removeObserver(InputMethodObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
    }

    public final void release() {
        View view2;
        ViewTreeObserver viewTreeObserver;
        this.observers.clear();
        ViewTreeObserver.OnGlobalLayoutListener $this$release_u24lambda_u2d2 = this.onListener;
        if (!($this$release_u24lambda_u2d2 == null || (view2 = this.rootView) == null || (viewTreeObserver = view2.getViewTreeObserver()) == null)) {
            viewTreeObserver.removeOnGlobalLayoutListener($this$release_u24lambda_u2d2);
        }
        this.onListener = null;
    }
}
