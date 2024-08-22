package com.baidu.android.ext.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/android/ext/widget/BdContentPopupWindow$caculateLocationAndUpdate$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "lib-bd-popupwindow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BdContentPopupWindow.kt */
public final class BdContentPopupWindow$caculateLocationAndUpdate$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ int $dx;
    final /* synthetic */ BdContentPopupWindow this$0;

    BdContentPopupWindow$caculateLocationAndUpdate$1(BdContentPopupWindow $receiver, int $dx2) {
        this.this$0 = $receiver;
        this.$dx = $dx2;
    }

    public boolean onPreDraw() {
        this.this$0.getRootView().getViewTreeObserver().removeOnPreDrawListener(this);
        if (!this.this$0.needUpdate) {
            return true;
        }
        if (this.this$0.anchorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorView");
        }
        BdContentPopupWindow bdContentPopupWindow = this.this$0;
        bdContentPopupWindow.setWidth(bdContentPopupWindow.getRootView().getWidth());
        BdContentPopupWindow bdContentPopupWindow2 = this.this$0;
        bdContentPopupWindow2.setHeight(bdContentPopupWindow2.getRootView().getHeight());
        this.this$0.onChildPreDraw();
        BdContentPopupWindow bdContentPopupWindow3 = this.this$0;
        View access$getAnchorView$p = bdContentPopupWindow3.anchorView;
        if (access$getAnchorView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorView");
            access$getAnchorView$p = null;
        }
        bdContentPopupWindow3.updateShowAtAnchorView(access$getAnchorView$p, this.$dx);
        return true;
    }
}
