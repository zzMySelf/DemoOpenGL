package com.baidu.searchbox.feed.payment.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/feed/payment/utils/SimpleUiHelperKt$makeDialog$dialog$1", "Landroid/app/Dialog;", "onStart", "", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleUiHelper.kt */
public final class SimpleUiHelperKt$makeDialog$dialog$1 extends Dialog {
    final /* synthetic */ int $anim;
    final /* synthetic */ View $mainView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleUiHelperKt$makeDialog$dialog$1(Context $context, View $mainView2, int $anim2) {
        super($context);
        this.$mainView = $mainView2;
        this.$anim = $anim2;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Window $this$onStart_u24lambda_u2d1 = getWindow();
        if ($this$onStart_u24lambda_u2d1 != null) {
            View view2 = this.$mainView;
            int i2 = this.$anim;
            $this$onStart_u24lambda_u2d1.getDecorView().setPadding(0, 0, 0, 0);
            $this$onStart_u24lambda_u2d1.getDecorView().setBackground(new ColorDrawable(0));
            $this$onStart_u24lambda_u2d1.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = $this$onStart_u24lambda_u2d1.getAttributes();
            WindowManager.LayoutParams $this$onStart_u24lambda_u2d1_u24lambda_u2d0 = attributes;
            $this$onStart_u24lambda_u2d1_u24lambda_u2d0.width = -1;
            $this$onStart_u24lambda_u2d1_u24lambda_u2d0.height = -2;
            $this$onStart_u24lambda_u2d1_u24lambda_u2d0.gravity = 80;
            $this$onStart_u24lambda_u2d1_u24lambda_u2d0.horizontalMargin = 0.0f;
            $this$onStart_u24lambda_u2d1_u24lambda_u2d0.verticalMargin = 0.0f;
            $this$onStart_u24lambda_u2d1_u24lambda_u2d0.windowAnimations = i2;
            $this$onStart_u24lambda_u2d1.setAttributes(attributes);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            } else {
                Intrinsics.checkNotNullExpressionValue(layoutParams, "mainView.layoutParams ?:…ayoutParams.WRAP_CONTENT)");
            }
            $this$onStart_u24lambda_u2d1.setContentView(view2, layoutParams);
        }
    }
}
