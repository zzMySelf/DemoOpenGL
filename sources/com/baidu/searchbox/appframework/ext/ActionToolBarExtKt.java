package com.baidu.searchbox.appframework.ext;

import android.view.ViewTreeObserver;
import com.baidu.searchbox.toolbar.CommonToolBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002¨\u0006\u0007"}, d2 = {"addActionToolBar", "Landroid/view/View;", "Lcom/baidu/searchbox/appframework/ext/IActionToolBarExt;", "contentView", "initActionToolBar", "", "removeToolBarBackListener", "lib-appframework-actiontoolbar_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionToolBarExt.kt */
public final class ActionToolBarExtKt {
    public static final void initActionToolBar(IActionToolBarExt $this$initActionToolBar) {
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter($this$initActionToolBar, "<this>");
        ActionBarExtKt.initActionBar($this$initActionToolBar);
        ToolBarExtKt.initToolBar($this$initActionToolBar);
        ToolBarExtKt.setToolBarBackListener($this$initActionToolBar, new ActionToolBarExtKt$initActionToolBar$1($this$initActionToolBar));
        CommonToolBar toolBar = ToolBarExtKt.getToolBar($this$initActionToolBar);
        if (toolBar != null && (viewTreeObserver = toolBar.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(ToolBarExtKt.getToolBarBackListener($this$initActionToolBar));
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.view.View addActionToolBar(com.baidu.searchbox.appframework.ext.IActionToolBarExt r8, android.view.View r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "contentView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            android.widget.LinearLayout r0 = new android.widget.LinearLayout
            android.content.Context r1 = r8.getExtContext()
            r0.<init>(r1)
            r1 = r0
            r2 = 0
            r3 = 1
            r1.setOrientation(r3)
            android.content.res.Resources r3 = r1.getResources()
            int r4 = com.baidu.searchbox.appframework.actiontoolbar.R.color.white
            r5 = 0
            int r3 = androidx.core.content.res.ResourcesCompat.getColor(r3, r4, r5)
            r1.setBackgroundColor(r3)
            r1 = r8
            com.baidu.searchbox.appframework.ext.IActionBarExt r1 = (com.baidu.searchbox.appframework.ext.IActionBarExt) r1
            android.widget.FrameLayout r1 = com.baidu.searchbox.appframework.ext.ActionBarExtKt.getActionBarContainer(r1)
            r2 = -1
            if (r1 == 0) goto L_0x0059
            r3 = 0
            android.view.ViewParent r4 = r1.getParent()
            boolean r6 = r4 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x003f
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            goto L_0x0040
        L_0x003f:
            r4 = r5
        L_0x0040:
            if (r4 == 0) goto L_0x0048
            r6 = r1
            android.view.View r6 = (android.view.View) r6
            r4.removeView(r6)
        L_0x0048:
            android.widget.LinearLayout$LayoutParams r4 = new android.widget.LinearLayout$LayoutParams
            r6 = -2
            r4.<init>(r2, r6)
            r6 = r1
            android.view.View r6 = (android.view.View) r6
            r7 = r4
            android.view.ViewGroup$LayoutParams r7 = (android.view.ViewGroup.LayoutParams) r7
            r0.addView(r6, r7)
        L_0x0059:
            android.view.ViewParent r1 = r9.getParent()
            boolean r3 = r1 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x0064
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            goto L_0x0065
        L_0x0064:
            r1 = r5
        L_0x0065:
            if (r1 == 0) goto L_0x006a
            r1.removeView(r9)
        L_0x006a:
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
            r1.<init>(r2, r2)
            r3 = 1065353216(0x3f800000, float:1.0)
            r1.weight = r3
            r3 = r1
            android.view.ViewGroup$LayoutParams r3 = (android.view.ViewGroup.LayoutParams) r3
            r0.addView(r9, r3)
            r3 = r8
            com.baidu.searchbox.appframework.ext.IToolBarExt r3 = (com.baidu.searchbox.appframework.ext.IToolBarExt) r3
            com.baidu.searchbox.toolbar.CommonToolBar r3 = com.baidu.searchbox.appframework.ext.ToolBarExtKt.getToolBar(r3)
            if (r3 == 0) goto L_0x00b7
            r4 = 0
            android.view.ViewParent r6 = r3.getParent()
            boolean r7 = r6 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x008f
            r5 = r6
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
        L_0x008f:
            if (r5 == 0) goto L_0x0097
            r6 = r3
            android.view.View r6 = (android.view.View) r6
            r5.removeView(r6)
        L_0x0097:
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            android.content.res.Resources r6 = r3.getResources()
            r7 = r3
            com.baidu.searchbox.toolbar.BaseToolBar r7 = (com.baidu.searchbox.toolbar.BaseToolBar) r7
            int r7 = com.baidu.searchbox.toolbar.BaseToolBarExtKt.getBarHeightDimen(r7)
            int r6 = r6.getDimensionPixelOffset(r7)
            r5.<init>(r2, r6)
            r2 = r5
            r5 = r3
            android.view.View r5 = (android.view.View) r5
            r6 = r2
            android.view.ViewGroup$LayoutParams r6 = (android.view.ViewGroup.LayoutParams) r6
            r0.addView(r5, r6)
        L_0x00b7:
            r2 = r0
            android.view.View r2 = (android.view.View) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.appframework.ext.ActionToolBarExtKt.addActionToolBar(com.baidu.searchbox.appframework.ext.IActionToolBarExt, android.view.View):android.view.View");
    }

    public static final void removeToolBarBackListener(IActionToolBarExt $this$removeToolBarBackListener) {
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter($this$removeToolBarBackListener, "<this>");
        CommonToolBar toolBar = ToolBarExtKt.getToolBar($this$removeToolBarBackListener);
        if (toolBar != null && (viewTreeObserver = toolBar.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(ToolBarExtKt.getToolBarBackListener($this$removeToolBarBackListener));
        }
    }
}
