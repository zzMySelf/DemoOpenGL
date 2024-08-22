package com.baidu.searchbox.appframework.ext;

import android.view.ViewTreeObserver;
import com.baidu.searchbox.toolbar.CommonToolBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/appframework/ext/ToolBarExt;", "", "()V", "hasCloseBar", "", "getHasCloseBar", "()Z", "setHasCloseBar", "(Z)V", "toolBar", "Lcom/baidu/searchbox/toolbar/CommonToolBar;", "getToolBar", "()Lcom/baidu/searchbox/toolbar/CommonToolBar;", "setToolBar", "(Lcom/baidu/searchbox/toolbar/CommonToolBar;)V", "toolBarBackListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "getToolBarBackListener", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "setToolBarBackListener", "(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "lib-appframework-toolbarext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToolBarExt.kt */
public final class ToolBarExt {
    private boolean hasCloseBar;
    private CommonToolBar toolBar;
    private ViewTreeObserver.OnGlobalLayoutListener toolBarBackListener;

    public final CommonToolBar getToolBar() {
        return this.toolBar;
    }

    public final void setToolBar(CommonToolBar commonToolBar) {
        this.toolBar = commonToolBar;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener getToolBarBackListener() {
        return this.toolBarBackListener;
    }

    public final void setToolBarBackListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.toolBarBackListener = onGlobalLayoutListener;
    }

    public final boolean getHasCloseBar() {
        return this.hasCloseBar;
    }

    public final void setHasCloseBar(boolean z) {
        this.hasCloseBar = z;
    }
}
